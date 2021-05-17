import java.io.*;
import java.sql.*;
import java.util.Enumeration;

public class MySQL {
    static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/?user=root&password=12345678";
    static Connection connection = null;

    static {
        dbConnection();
        createDatabase();
    }

    public static void main(String[] args) {
//        Enumeration<Driver> drivers = DriverManager.getDrivers();
//        while (drivers.hasMoreElements()) {
//            System.out.println(drivers.nextElement());
//        }

        putPhoto("NumPy2.png", "/Users/Sergey/Programming/Шпаргалки/NumPy2.png");
    }

    public static void putPhoto(String name, String path) {
        File file = new File(path);
        if (!file.exists()) {
            System.out.println("File doesn't exist");
            return;
        }
        int size = (int) file.length();

        try {
            BufferedInputStream fileInputStream = new BufferedInputStream(new FileInputStream(file));
            String insertPhoto = "INSERT INTO photos (name, photo) Values(?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertPhoto);
            preparedStatement.setString(1, name);
            preparedStatement.setBlob(2, fileInputStream, size);
            preparedStatement.executeUpdate();
        } catch (FileNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private static void dbConnection() {
        try {
            Class.forName(DRIVER_NAME);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(CONNECTION_STRING);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createDatabase() {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS photoBase");
            statement.executeUpdate("USE photoBase");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS photos(" +
                    "photo_id INT AUTO_INCREMENT PRIMARY KEY," +
                    "name VARCHAR(64) NOT NULL," +
                    "photo MEDIUMBLOB NOT NULL)");
        } catch (SQLException e) {
            e.getMessage();
        }
    }
}
