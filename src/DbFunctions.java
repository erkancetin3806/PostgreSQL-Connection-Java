import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbFunctions {

    public static Connection connect_to_db() {

        Connection connection = null;

        try {
            // Veritabanı URL, kullanıcı adı ve şifresi
            String url = "jdbc:postgresql://localhost:5432/tutdb";
            String user = "postgres";
            String password = "admin";

            Class.forName("org.postgresql.Driver");               // JDBC sürücüsünü yükle

            connection = DriverManager.getConnection(url, user, password); // Veritabanına bağlantı oluştur

            if (connection != null) {
                System.out.println("Veritabanına başarıyla bağlandı.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }

    public void createTable(Connection connection, String table_name) {

        Statement statement;

       try {
           String query = "CREATE TABLE " + table_name + " (empid SERIAL, name varchar(200), address varchar(200), PRIMARY KEY(empid))";
           statement = connection.createStatement();
           statement.executeUpdate(query);
           System.out.println("Tablo Oluşturuldu..");

       } catch (Exception e) {
           e.printStackTrace();
       }
    }

    public void insert_row(Connection connection, String table_name, String name, String address) {

        Statement statement;

        try {
            String query = String.format("INSERT INTO %s (name, address) VALUES ('%s', '%s');", table_name, name, address);
            statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Satır Eklendi..");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

