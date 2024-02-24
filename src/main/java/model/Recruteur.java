package model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Recruteur extends User implements IRecruteur{

    private int entrepriseId;

    // constructeur

    public Recruteur(int userId, String nom, String prenom, String type, String eMail, String motDePasse, String contact, int entrepriseId) {
        super(userId, nom, prenom, type, eMail, motDePasse, contact);
        this.entrepriseId = entrepriseId;
    }


    // getteurs and setteurs


    public int getEntrepriseId() {
        return entrepriseId;
    }

    public void setEntrepriseId(int entrepriseId) {
        this.entrepriseId = entrepriseId;
    }

    public int getentrepriseId() {
        return entrepriseId;
    }

    public void setentrepriseId(int entrepriseId) {
        this.entrepriseId = entrepriseId;
    }

    @Override

    public void createRecruteur(Recruteur recruteur) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet generatedKeys = null;
        try {
            // Établir une connexion à la base de données
            connection = ConnexionDB.getConnection();

            // Créer une nouvelle entreprise associée au recruteur
            Entreprise nouvelleEntreprise = new Entreprise(0, recruteur.getUserId(), "Nouvelle Entreprise", "", "");
            User nouvelUser = new User(0, getNom(),getPrenom(), getType(), geteMail(), getMotDePasse(), getContact());
            int nouvelleEntrepriseId = nouvelleEntreprise.createEntreprise();
            int nouvelUserid = nouvelUser.createUser(nouvelUser);
            // Préparer la requête SQL pour l'insertion d'un nouveau recruteur
            String query = "INSERT INTO recruteur (user_id, entreprise_id) VALUES (?, ?)";
            statement = connection.prepareStatement(query);
            statement.setInt(1, nouvelUserid);
            statement.setInt(2, nouvelleEntrepriseId);

            // Exécuter la requête
            statement.executeUpdate();

            // Affecter l'ID de l'entreprise au recruteur
            recruteur.setEntrepriseId(nouvelleEntrepriseId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Fermer les ressources (connexion, déclaration et ensemble de résultats)
            try {
                if (generatedKeys != null) generatedKeys.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void updateRecruteur(Recruteur newRecruteur) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            // Établir une connexion à la base de données
            connection = ConnexionDB.getConnection();
            // Préparer la requête SQL pour la mise à jour du recruteur
            String query = "UPDATE recruteur SET user_id = ?, entreprise_id = ? WHERE user_id = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, newRecruteur.getUserId());
            statement.setInt(2, newRecruteur.getEntrepriseId());
            statement.setInt(3, newRecruteur.getUserId());
            // Exécuter la requête
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Fermer les ressources (connexion et déclaration)
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void deleteRecruteur(int recruteurId) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            // Établir une connexion à la base de données
            connection = ConnexionDB.getConnection();

            // Supprimer l'entreprise associée au recruteur
            Entreprise entreprise = new Entreprise(recruteurId, 0, "", "", "");
            entreprise.deleteEntreprise(recruteurId);

            // Préparer la requête SQL pour la suppression du recruteur
            String query = "DELETE FROM recruteur WHERE user_id = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, recruteurId);

            // Exécuter la requête
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Fermer les ressources (connexion et déclaration)
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Recruteur> findAll() {
        List<Recruteur> recruteurs = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            // Établir une connexion à la base de données
            connection = ConnexionDB.getConnection();
            // Préparer la requête SQL
            String query = "SELECT * FROM recruteur";
            statement = connection.prepareStatement(query);
            // Exécuter la requête
            resultSet = statement.executeQuery();
            // Parcourir les résultats et créer des objets Recruteur
            while (resultSet.next()) {
                int userId = resultSet.getInt("user_id");
                int entrepriseId = resultSet.getInt("entreprise_id");
                // Créer un objet Recruteur avec les données récupérées
                Recruteur recruteur = new Recruteur(userId, "", "", "", "", "", "", entrepriseId);
                // Ajouter le recruteur à la liste
                recruteurs.add(recruteur);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Fermer les ressources (connexion, déclaration et ensemble de résultats)
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return recruteurs;
    }

    @Override
    public User user() {
        User user = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            // Établir une connexion à la base de données
            connection = ConnexionDB.getConnection();
            // Préparer la requête SQL
            String query = "SELECT * FROM user WHERE user_id = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, getUserId());
            // Exécuter la requête
            resultSet = statement.executeQuery();
            // Vérifier si un utilisateur a été trouvé
            if (resultSet.next()) {
                String nom = resultSet.getString("nom");
                String prenom = resultSet.getString("prenom");
                String type = resultSet.getString("type");
                String email = resultSet.getString("email");
                String motDePasse = resultSet.getString("mot_de_passe");
                String contact = resultSet.getString("contact");
                // Créer un objet User avec les données récupérées
                user = new User(getUserId(), nom, prenom, type, email, motDePasse, contact);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Fermer les ressources (connexion, déclaration et ensemble de résultats)
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return user;
    }
    @Override
    public Entreprise entreprise() {
        Entreprise entreprise = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            // Établir une connexion à la base de données
            connection = ConnexionDB.getConnection();
            // Préparer la requête SQL
            String query = "SELECT * FROM entreprise WHERE entreprise_id = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, getEntrepriseId());
            // Exécuter la requête
            resultSet = statement.executeQuery();
            // Vérifier si une entreprise a été trouvée
            if (resultSet.next()) {
                String nom = resultSet.getString("nom");
                String adresse = resultSet.getString("adresse");
                String contact = resultSet.getString("contact");
                // Créer un objet Entreprise avec les données récupérées
                entreprise = new Entreprise(getEntrepriseId(), 0, nom, adresse, contact);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Fermer les ressources (connexion, déclaration et ensemble de résultats)
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return entreprise;
    }

}
