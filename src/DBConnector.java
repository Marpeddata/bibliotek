import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnector {

    public static Connection getMarkConnection() {
        Connection connection = null;
        String url = "jdbc:mysql://localhost:3306/biblo?serverTimezone=CET&useSSL=false";
        String user = "root";
        String password = "Grycecilie0510";
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static Connection getMaleneConnection() {
        Connection connection = null;
        String url = "jdbc:mysql://localhost:3306/Bibliotek?serverTimezone=CET&useSSL=false";
        String user = "root";
        String password = "elvinha-17";
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
