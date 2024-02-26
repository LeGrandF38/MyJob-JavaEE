package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Offre implements IOffre{
    private int offreId;
    private int idRecruteur;
    private String datePublication;
    private String dateExpiration;
    private String contenu;
    private String type;

    //constructeur

    public Offre(int offreId, int idRecruteur, String datePublication, String dateExpiration, String contenu, String type) {
        this.offreId = offreId;
        this.idRecruteur = idRecruteur;
        this.datePublication = datePublication;
        this.dateExpiration = dateExpiration;
        this.contenu = contenu;
        this.type = type;
    }

    public Offre() {

    }



    // getteurs and setters


    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public int getOffreId() {
        return offreId;
    }

    public void setOffreId(int offreId) {
        this.offreId = offreId;
    }

    public int getIdRecruteur() {
        return idRecruteur;
    }

    public void setIdRecruteur(int idRecruteur) {
        this.idRecruteur = idRecruteur;
    }

    public String getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(String datePublication) {
        this.datePublication = datePublication;
    }

    public String getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(String dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int createOffre(Offre offre) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet generatedKeys = null;
        int newOffreId = -1; // Valeur par défaut si l'ID de l'offre n'est pas généré avec succès
        try {
            // Établir une connexion à la base de données
            connection = ConnexionDB.getConnection();
            // Préparer la requête SQL pour l'insertion d'une nouvelle offre
            String query = "INSERT INTO offre (recruteur_id, date_publication, date_expiration, contenu, type) VALUES (?, ?, ?, ?, ?)";
            statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, offre.getIdRecruteur());
            statement.setString(2, offre.getDatePublication());
            statement.setString(3, offre.getDateExpiration());
            statement.setString(4, offre.getContenu());
            statement.setString(5, offre.getType());
            // Exécuter la requête
            int rowsAffected = statement.executeUpdate();
            // Vérifier si l'insertion a réussi
            if (rowsAffected == 1) {
                // Récupérer l'ID généré pour l'offre créée
                generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    newOffreId = generatedKeys.getInt(1);
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
        return newOffreId;
    }

    @Override
    public void updateOffre(Offre newOffre) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            // Établir une connexion à la base de données
            connection = ConnexionDB.getConnection();
            // Préparer la requête SQL pour la mise à jour de l'offre
            String query = "UPDATE offre SET recruteur_id = ?, date_publication = ?, date_expiration = ?, contenu = ?, type = ? WHERE offre_id = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, newOffre.getIdRecruteur());
            statement.setString(2, newOffre.getDatePublication());
            statement.setString(3, newOffre.getDateExpiration());
            statement.setString(4, newOffre.getContenu());
            statement.setString(5, newOffre.getType());
            statement.setInt(6, newOffre.getOffreId());
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
    public void deleteOffre(int offreId) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            // Établir une connexion à la base de données
            connection = ConnexionDB.getConnection();
            // Préparer la requête SQL pour la suppression de l'offre
            String query = "DELETE FROM offre WHERE offre_id = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, offreId);
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
    public List<Offre> findAll() {
        List<Offre> offres = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            // Établir une connexion à la base de données
            connection = ConnexionDB.getConnection();
            // Préparer la requête SQL
            String query = "SELECT * FROM offre";
            statement = connection.prepareStatement(query);
            // Exécuter la requête
            resultSet = statement.executeQuery();
            // Parcourir les résultats et créer des objets Offre
            while (resultSet.next()) {
                int offreId = resultSet.getInt("offre_id");
                int idRecruteur = resultSet.getInt("recruteur_id");
                String datePublication = resultSet.getString("date_publication");
                String dateExpiration = resultSet.getString("date_expiration");
                String contenu = resultSet.getString("contenu");
                String type = resultSet.getString("type");
                // Créer un objet Offre avec les données récupérées
                Offre offre = new Offre(offreId, idRecruteur, datePublication, dateExpiration, contenu, type);
                // Ajouter l'offre à la liste
                offres.add(offre);
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

        return offres;
    }



}
