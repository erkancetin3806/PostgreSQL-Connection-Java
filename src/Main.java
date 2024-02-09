import java.sql.Connection;
import java.sql.SQLException;

public class Main {


    public static void main(String[] args) {
        // Veritabanına bağlantı oluştur
        DbFunctions db = new DbFunctions();
        Connection connection = db.connect_to_db();
        //db.createTable(connection,"cihaz");
        db.insert_row(connection,"cihaz","ÇETİN","Turkey");

/*        // Bağlantıyı kapat (işlem bittiğinde)
        try {
            if (dbConnection != null && !dbConnection.isClosed()) {
                dbConnection.close();
                System.out.println("Veritabanı bağlantısı kapatıldı.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } */
    }
 }

