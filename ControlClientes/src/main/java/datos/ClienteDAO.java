package datos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelo.Cliente;

public class ClienteDAO {
    // CRUD - Create - Read - Update - Delete
    
    private static final String SQL_SELECT = "SELECT id_cliente, nombre, apellido, email, telefono, saldo FROM clientes";
    private static final String SQL_INSERT = "INSERT INTO clientes(nombre, apellido, email, telefono, saldo) VALUES(?, ?, ?, ?, ?)";
    
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
    
    public int insertar(Cliente cliente) {
        int rows = 0;
        try(Connection conn = Conexion.getConnection();
                PreparedStatement stmt = conn.prepareStatement(SQL_INSERT)) {
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellido());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getTelefono());
            stmt.setDouble(5, cliente.getSaldo());
            
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return rows;
    }
    
}