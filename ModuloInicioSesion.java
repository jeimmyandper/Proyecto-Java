import java.sql.*;

public class ModuloInicioSesion {

    // Método para iniciar sesión de administrador
    public boolean iniciarSesionAdmin(int cedula, String contraseña) {
        String url = "jdbc:mysql://localhost:3306/ventaspintupaipa";
        String usuario = "root";
        String contraseñaBD = "Andrea3124312532*";

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseñaBD)) {
            String query = "SELECT * FROM tbladministrador WHERE id_administrador = ? AND Contraseña = ?";
            PreparedStatement statement = conexion.prepareStatement(query);

            statement.setInt(1, cedula);
            statement.setString(2, contraseña);

            ResultSet resultSet = statement.executeQuery();
            return resultSet.next(); // Retorna true si encuentra un administrador con esos datos
        } catch (SQLException e) {
            System.out.println("Error en inicio de sesión de administrador: " + e.getMessage());
            return false;
        }
    }

    // Método para iniciar sesión de vendedor/usuario
    public boolean iniciarSesionUsuario(String cedula, String contraseña) {
        String url = "jdbc:mysql://localhost:3306/ventaspintupaipa";
        String usuario = "root";
        String contraseñaBD = "Andrea3124312532*";

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseñaBD)) {
            String query = "SELECT * FROM tblregistrousuario WHERE Cedula = ? AND Contraseña = ?";
            PreparedStatement statement = conexion.prepareStatement(query);

            statement.setString(1, cedula);
            statement.setString(2, contraseña);

            ResultSet resultSet = statement.executeQuery();
            return resultSet.next(); // Retorna true si encuentra un usuario con esos datos
        } catch (SQLException e) {
            System.out.println("Error en inicio de sesión de usuario: " + e.getMessage());
            return false;
        }
    }
}
