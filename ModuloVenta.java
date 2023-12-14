import java.sql.*;

public class ModuloVenta {

    // Método para realizar una venta y generar una factura electrónica
    public void realizarVenta(int idVenta, String cedulaCliente, String producto, int cantidad, double total) {
        String url = "jdbc:mysql://localhost:3306/ventaspintupaipa";
        String usuario = "root";
        String contraseñaBD = "Andrea3124312532*";

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseñaBD)) {
            // Realizar la venta: insertar datos en la tabla de ventas
            String queryVenta = "INSERT INTO tblventa (id_venta, Cedula_cliente, Producto, Cantidad, Total) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statementVenta = conexion.prepareStatement(queryVenta);

            statementVenta.setInt(1, idVenta);
            statementVenta.setString(2, cedulaCliente);
            statementVenta.setString(3, producto);
            statementVenta.setInt(4, cantidad);
            statementVenta.setDouble(5, total);

            statementVenta.executeUpdate();
            System.out.println("Venta realizada exitosamente.");

            // Obtener datos del cliente para la factura electrónica
            String queryCliente = "SELECT * FROM tblcliente WHERE Cedula = ?";
            PreparedStatement statementCliente = conexion.prepareStatement(queryCliente);

            statementCliente.setString(1, cedulaCliente);
            ResultSet resultSetCliente = statementCliente.executeQuery();

            if (resultSetCliente.next()) {
                // Recuperar datos del cliente para la factura electrónica
                String nombreCliente = resultSetCliente.getString("Nombre");
                String direccionCliente = resultSetCliente.getString("Direccion");
                String correoCliente = resultSetCliente.getString("Correo");

                // Generar factura electrónica automáticamente
                generarFacturaElectronica(idVenta, nombreCliente, direccionCliente, correoCliente, producto, cantidad, total);
            } else {
                System.out.println("No se encontró cliente con la cédula: " + cedulaCliente);
            }
        } catch (SQLException e) {
            System.out.println("Error al realizar la venta: " + e.getMessage());
        }
    }

    // Método para generar factura electrónica
    private void generarFacturaElectronica(int idVenta, String nombreCliente, String direccionCliente, String correoCliente, String producto, int cantidad, double total) {
    
        System.out.println("Se generó la factura electrónica para la venta con ID: " + idVenta);
        System.out.println("Cliente: " + nombreCliente);
        System.out.println("Dirección: " + direccionCliente);
        System.out.println("Correo: " + correoCliente);
        System.out.println("Producto: " + producto);
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Total: " + total);
        
    }
}
