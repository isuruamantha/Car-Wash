package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Database {

    Connection conn = null;

    public static Connection ConnecrDb() { // this will create method to connect
        // Db
//        System.out.println("This is working");

        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection(
					"jdbc:sqlite:C:\\CarWashData\\SanjeewaCarWashDatabase.sqlite");
//                    "jdbc:sqlite:C:\\Users\\user\\Google Drive\\java work space\\Car Wash - Billing System\\SanjeewaCarWashDatabase.sqlite");
//                    "jdbc:sqlite:F:\\Rapticon\\Car Wash\\Car Wash - Billing System\\Database.sqlite");
            return conn;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;

        }
    }
}
