package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnexionDB {
    // Mettez à jour ces informations avec les détails de votre base de données
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost/my_job_jee";
    private static final String user = "root";
    private static final String password = "";
    private static Connection connection;

    // Cette méthode établit une connexion à la base de données et la retourne
    public static Connection getConnection() throws Exception {
        Class.forName(driver);
        return connection = DriverManager.getConnection(url, user, password);
    }

    public static void seDeconnecter() throws Exception {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}
