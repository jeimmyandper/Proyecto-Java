import java.sql.*;

public class RegistroClientes {

    // Método para registrar un nuevo cliente en la base de datos
    public void registrarCliente(int id_Cliente, String Nombre, String Cedula, String Correo, String Direccion, String Telefono) {
        String url = "jdbc:mysql://localhost:3306/ventaspintupaipa";
        String usuario = "root";
        String contraseña = "Andrea3124312532*";

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {
            String query = "INSERT INTO tblcliente (id_cliente, Nombre, Cedula, Correo, Direccion, Telefono) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conexion.prepareStatement(query);

            statement.setInt(1, id_Cliente);
            statement.setString(2, Nombre);
            statement.setString(3, Cedula);
            statement.setString(4, Correo);
            statement.setString(5, Direccion);
            statement.setString(6, Telefono);

            statement.executeUpdate();
            System.out.println("Cliente registrado exitosamente.");
        } catch (SQLException e) {
            System.out.println("Error al registrar cliente: " + e.getMessage());
        }
    }

    // Método para consultar un cliente por ID
    public void consultarCliente(int id_cliente) {
        String url = "jdbc:mysql://localhost:3306/ventaspintupaipa";
        String usuario = "root";
        String contraseña = "Andrea3124312532*";

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {
            String query = "SELECT * FROM tblcliente WHERE id_cliente = ?";
            PreparedStatement statement = conexion.prepareStatement(query);

            statement.setInt(1, id_cliente);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                System.out.println("ID Cliente: " + resultSet.getInt("id_cliente"));
                System.out.println("Nombre: " + resultSet.getString("Nombre"));
                System.out.println("Cédula: " + resultSet.getString("Cedula"));
                System.out.println("Correo: " + resultSet.getString("Correo"));
                System.out.println("Dirección: " + resultSet.getString("Direccion"));
                System.out.println("Teléfono: " + resultSet.getString("Telefono"));
            } else {
                System.out.println("No se encontró cliente con ID: " + id_cliente);
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar cliente: " + e.getMessage());
        }
    }
}
