package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Entreprise implements IEntreprise{
    private int entrepriseId;
    private int recruteurId;
    private String nom;
    private String adresse;
    private String contact;

    // constructeur

    public Entreprise(int entrepriseId, int recruteurId, String nom, String adresse, String contact) {
        this.entrepriseId = entrepriseId;
        this.recruteurId = recruteurId;
        this.nom = nom;
        this.adresse = adresse;
        this.contact = contact;
    }


    // getters and setters

    public int getEntrepriseId() {
        return entrepriseId;
    }

    public void setEntrepriseId(int entrepriseId) {
        this.entrepriseId = entrepriseId;
    }

    public int getRecruteurId() {
        return recruteurId;
    }

    public void setRecruteurId(int recruteurId) {
        this.recruteurId = recruteurId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
    // methods


    @Override
    public int createEntreprise() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet generatedKeys = null;
        int newEntrepriseId = -1; // Valeur par défaut si l'ID de l'entreprise n'est pas généré avec succès
        try {
            // Établir une connexion à la base de données
            connection = ConnexionDB.getConnection();
            // Préparer la requête SQL pour l'insertion d'une nouvelle entreprise
            String query = "INSERT INTO entreprise (recruteur_id, nom, adresse, contact) VALUES (?, ?, ?, ?)";
            statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, recruteurId);
            statement.setString(2, nom);
            statement.setString(3, adresse);
            statement.setString(4, contact);
            // Exécuter la requête
            int rowsAffected = statement.executeUpdate();
            // Vérifier si l'insertion a réussi
            if (rowsAffected == 1) {
                // Récupérer l'ID généré pour l'entreprise créée
                generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    newEntrepriseId = generatedKeys.getInt(1);
                }
            }
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
        return newEntrepriseId;
    }


    @Override
    public void updateEntreprise() {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            // Établir une connexion à la base de données
            connection = ConnexionDB.getConnection();
            // Préparer la requête SQL pour la mise à jour de l'entreprise
            String query = "UPDATE entreprise SET recruteur_id = ?, nom = ?, adresse = ?, contact = ? WHERE entreprise_id = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, recruteurId);
            statement.setString(2, nom);
            statement.setString(3, adresse);
            statement.setString(4, contact);
            statement.setInt(5, entrepriseId);
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
    public void deleteEntreprise(int entrepriseIdToDelete) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            // Établir une connexion à la base de données
            connection = ConnexionDB.getConnection();
            // Préparer la requête SQL pour la suppression de l'entreprise
            String query = "DELETE FROM entreprise WHERE entreprise_id = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, entrepriseIdToDelete);
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
    public List<Entreprise> findAll() {
        List<Entreprise> entreprises = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            // Établir une connexion à la base de données
            connection = ConnexionDB.getConnection();
            // Préparer la requête SQL
            String query = "SELECT * FROM entreprise";
            statement = connection.prepareStatement(query);
            // Exécuter la requête
            resultSet = statement.executeQuery();
            // Parcourir les résultats et créer des objets Entreprise
            while (resultSet.next()) {
                int entrepriseId = resultSet.getInt("entreprise_id");
                int recruteurId = resultSet.getInt("recruteur_id");
                String nom = resultSet.getString("nom");
                String adresse = resultSet.getString("adresse");
                String contact = resultSet.getString("contact");
                // Créer un objet Entreprise avec les données récupérées
                Entreprise entreprise = new Entreprise(entrepriseId, recruteurId, nom, adresse, contact);
                // Ajouter l'entreprise à la liste
                entreprises.add(entreprise);
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

        return entreprises;
    }
}


    //


