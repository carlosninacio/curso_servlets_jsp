package datos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelo.Cliente;

public class ClienteDAO {
    // CRUD - Create - Read - Update - Delete
    
    private static final String SQL_SELECT = "SELECT id_cliente, nombre, apellido, email, telefono, saldo FROM clientes";
    
    public List<Cliente> listar() {
        List<Cliente> clientes = new ArrayList<>();
        try(Connection conn = Conexion.getConnection();
                PreparedStatement stmt = conn.prepareStatement(SQL_SELECT);
                ResultSet rs = stmt.executeQuery();) {
            // Iterar clientes de la base de datos
            while(rs.next()) {
                Cliente cliente = new Cliente(
                        rs.getInt("id_cliente"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("email"),
                        rs.getString("telefono"),
                        rs.getDouble("saldo")
                );
                clientes.add(cliente);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return clientes;
    }
}