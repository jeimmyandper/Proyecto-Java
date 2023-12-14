import java.sql.*;

public class GestionInventario {

    // Método para registrar un nuevo producto en el inventario
    public void registrarProducto(int idProducto, String nombre, int cantidad, String color, String tamaño, String tipo) {
        String url = "jdbc:mysql://localhost:3306/ventaspintupaipa";
        String usuario = "root";
        String contraseña = "Andrea3124312532*";

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {
            String query = "INSERT INTO tblinventario (id_producto, Nombre, Cantidad, Color, Tamaño, Tipo) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conexion.prepareStatement(query);

            statement.setInt(1, idProducto);
            statement.setString(2, nombre);
            statement.setInt(3, cantidad);
            statement.setString(4, color);
            statement.setString(5, tamaño);
            statement.setString(6, tipo);

            statement.executeUpdate();
            System.out.println("Producto registrado en inventario exitosamente.");
        } catch (SQLException e) {
            System.out.println("Error al registrar producto en inventario: " + e.getMessage());
        }
    }

    // Método para eliminar un producto del inventario
    public void eliminarProducto(int idProducto) {
    String url = "jdbc:mysql://localhost:3306/ventaspintupaipa";
    String usuario = "root";
    String contraseña = "Andrea3124312532*";

    try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {
        String query = "DELETE FROM tblinventario WHERE id_producto = ?";
        PreparedStatement statement = conexion.prepareStatement(query);

        statement.setInt(1, idProducto);

        int filasEliminadas = statement.executeUpdate();
        if (filasEliminadas > 0) {
            System.out.println("Producto eliminado del inventario exitosamente.");
        } else {
            System.out.println("No se encontró el producto con ID: " + idProducto);
        }
    } catch (SQLException e) {
        System.out.println("Error al eliminar producto del inventario: " + e.getMessage());
    }
}
    // Método para consultar un producto por ID
    public void consultarProducto(int idProducto) {
        String url = "jdbc:mysql://localhost:3306/ventaspintupaipa";
        String usuario = "root";
        String contraseña = "Andrea3124312532*";

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {
            String query = "SELECT * FROM tblinventario WHERE id_producto = ?";
            PreparedStatement statement = conexion.prepareStatement(query);

            statement.setInt(1, idProducto);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                System.out.println("ID Producto: " + resultSet.getInt("id_producto"));
                System.out.println("Nombre: " + resultSet.getString("Nombre"));
                System.out.println("Cantidad: " + resultSet.getInt("Cantidad"));
                System.out.println("Color: " + resultSet.getString("Color"));
                System.out.println("Tamaño: " + resultSet.getString("Tamaño"));
                System.out.println("Tipo: " + resultSet.getString("Tipo"));
            } else {
                System.out.println("No se encontró producto con ID: " + idProducto);
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar producto: " + e.getMessage());
        }
    }
}

