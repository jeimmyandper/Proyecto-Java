import java.sql.*;

public class RegistroUsuario {

    // Método para registrar un nuevo usuario en la base de datos
    public void registrarUsuario(int idUsuario, String nombre, String cedula, String tipoUsuario, String contraseña) {
        String url = "jdbc:mysql://localhost:3306/ventaspintupaipa";
        String usuario = "root";
        String contraseñaBD = "Andrea3124312532*";

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseñaBD)) {
            String query = "INSERT INTO tblregistrousuario (id_usuario, Nombre, Cedula, Tipo_de_usuario, Contraseña) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = conexion.prepareStatement(query);

            statement.setInt(1, idUsuario);
            statement.setString(2, nombre);
            statement.setString(3, cedula);
            statement.setString(4, tipoUsuario);
            statement.setString(5, contraseña);

            statement.executeUpdate();
            System.out.println("Usuario registrado exitosamente.");
        } catch (SQLException e) {
            System.out.println("Error al registrar usuario: " + e.getMessage());
        }
    }

    // Método para consultar información de un usuario por ID
    public void consultarUsuario(int idUsuario) {
        String url = "jdbc:mysql://localhost:3306/ventaspintupaipa";
        String usuario = "root";
        String contraseñaBD = "Andrea3124312532*";

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseñaBD)) {
            String query = "SELECT * FROM tblregistrousuario WHERE id_usuario = ?";
            PreparedStatement statement = conexion.prepareStatement(query);

            statement.setInt(1, idUsuario);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                System.out.println("ID Usuario: " + resultSet.getInt("id_usuario"));
                System.out.println("Nombre: " + resultSet.getString("Nombre"));
                System.out.println("Cedula: " + resultSet.getString("Cedula"));
                System.out.println("Tipo de Usuario: " + resultSet.getString("Tipo_de_usuario"));
                // No se recomienda imprimir la contraseña en un sistema real por razones de seguridad
            } else {
                System.out.println("No se encontró usuario con ID: " + idUsuario);
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar usuario: " + e.getMessage());
        }
    }

    // Método para eliminar un usuario por ID
    public void eliminarUsuario(int idUsuario) {
        String url = "jdbc:mysql://localhost:3306/ventaspintupaipa";
        String usuario = "root";
        String contraseñaBD = "Andrea3124312532*";

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseñaBD)) {
            String query = "DELETE FROM tblregistrousuario WHERE id_usuario = ?";
            PreparedStatement statement = conexion.prepareStatement(query);

            statement.setInt(1, idUsuario);

            int filasEliminadas = statement.executeUpdate();
            if (filasEliminadas > 0) {
                System.out.println("Usuario eliminado exitosamente.");
            } else {
                System.out.println("No se encontró usuario con ID: " + idUsuario);
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar usuario: " + e.getMessage());
        }
    }

    // Método para actualizar información de un usuario por ID
    public void actualizarUsuario(int idUsuario, String nombre, String cedula, String tipoUsuario, String contraseña) {
        String url = "jdbc:mysql://localhost:3306/ventaspintupaipa";
        String usuario = "root";
        String contraseñaBD = "Andrea3124312532*";

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseñaBD)) {
            String query = "UPDATE tblregistrousuario SET Nombre = ?, Cedula = ?, Tipo_de_usuario = ?, Contraseña = ? WHERE id_usuario = ?";
            PreparedStatement statement = conexion.prepareStatement(query);

            statement.setString(1, nombre);
            statement.setString(2, cedula);
            statement.setString(3, tipoUsuario);
            statement.setString(4, contraseña);
            statement.setInt(5, idUsuario);

            int filasActualizadas = statement.executeUpdate();
            if (filasActualizadas > 0) {
                System.out.println("Usuario actualizado exitosamente.");
            } else {
                System.out.println("No se encontró usuario con ID: " + idUsuario);
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar usuario: " + e.getMessage());
        }
    }
}

