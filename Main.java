import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            // Establecer la conexión
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ventaspintupaipa", "root", "Andrea3124312532*");
            if (connection != null) {
                System.out.println("Conexión exitosa a la base de datos");
                
            } else {
                System.out.println("No se pudo establecer la conexión");
            }
        } catch (SQLException e) {
            // Manejar la excepción de conexión aquí
            e.printStackTrace();
        } finally {
            // Cerrar la conexión
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

