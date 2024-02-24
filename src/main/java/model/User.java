package model;

import java.sql.*;

public class User implements IUser{
    private int userId;
    private String nom;
    private String prenom;
    private String type;
    private String eMail;
    private String MotDePasse;
    private String contact;

    //contructeur

    public User(int userId, String nom, String prenom, String type, String eMail, String motDePasse, String contact) {
        this.userId = userId;
        this.nom = nom;
        this.prenom = prenom;
        this.type = type;
        this.eMail = eMail;
        MotDePasse = motDePasse;
        this.contact = contact;
    }


    //getter et setters

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getMotDePasse() {
        return MotDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        MotDePasse = motDePasse;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public int createUser(User user) {
        String query = "INSERT INTO users (nom, prenom, type, email, mot_de_passe, contact) VALUES (?, ?, ?, ?, ?, ?)";
        int userId = -1; // Valeur par défaut si l'insertion échoue

        try (Connection conn = ConnexionDB.getConnection();
             PreparedStatement statement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            // Set parameters
            statement.setString(1, user.getNom());
            statement.setString(2, user.getPrenom());
            statement.setString(3, user.getType());
            statement.setString(4, user.geteMail());
            statement.setString(5, user.getMotDePasse());
            statement.setString(6, user.getContact());

            // Execute the query
            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                // Récupération de la clé générée
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    // Récupération de l'ID généré
                    userId = generatedKeys.getInt(1);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return userId;
    }


    @Override
    public void updateUser(User newUser) {
        String query = "UPDATE users SET nom=?, prenom=?, type=?, email=?, mot_de_passe=?, contact=? WHERE user_id=?";

        try (Connection conn = ConnexionDB.getConnection();
             PreparedStatement statement = conn.prepareStatement(query)) {

            statement.setString(1, newUser.getNom());
            statement.setString(2, newUser.getPrenom());
            statement.setString(3, newUser.getType());
            statement.setString(4, newUser.geteMail());
            statement.setString(5, newUser.getMotDePasse());
            statement.setString(6, newUser.getContact());
            statement.setInt(7, newUser.getUserId());

            statement.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteUser(int userId) {
        String query = "DELETE FROM users WHERE user_id=?";

        try (Connection conn = ConnexionDB.getConnection();
             PreparedStatement statement = conn.prepareStatement(query)) {

            statement.setInt(1, userId);
            statement.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    // Les methodes add, update et delete
}
