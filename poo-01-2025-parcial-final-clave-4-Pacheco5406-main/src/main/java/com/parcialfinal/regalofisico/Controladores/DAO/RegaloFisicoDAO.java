package com.parcialfinal.regalofisico.Controladores.DAO;

import com.parcialfinal.regalofisico.RegaloFisico;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO para manejar operaciones CRUD de RegaloFisico.
 * Usa ConexionBD para obtener la conexión.
 */
public class RegaloFisicoDAO {

    private Connection con;

    public RegaloFisicoDAO() {
        // Siempre usar la conexión única
        this.con = ConexionBD.getInstancia().getConnection();
    }

    /**
     * Inserta un nuevo regalo en la base de datos.
     */
    public void insertarRegalo(RegaloFisico regalo) {
        String sql = "INSERT INTO RegaloFisico (Destinatario, Remitente, Mensaje, TipoRegalo, FechaEnvio, TipoEnvio) VALUES (?,?,?,?,?,?)";
        try (Connection conn = ConexionBD.getInstancia().getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, regalo.getDestinatario());
            ps.setString(2, regalo.getRemitente());
            ps.setString(3, regalo.getMensaje());
            ps.setString(4, regalo.getTipoRegalo());
            ps.setDate(5, java.sql.Date.valueOf(regalo.getFechaEnvio()));
            ps.setString(6, regalo.getTipoEnvio());
            int filas = ps.executeUpdate();
            System.out.println("Filas afectadas: " + filas);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * Muestra todos los regalos registrados.
     */
    public List<RegaloFisico> obtenerRegalos() {
        List<RegaloFisico> lista = new ArrayList<>();
        String sql = "SELECT RegaloID, Destinatario, Remitente, Mensaje, TipoRegalo, FechaEnvio, TipoEnvio FROM RegaloFisico";

        try (Connection conn = ConexionBD.getInstancia().getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                RegaloFisico regalo = new RegaloFisico(
                        rs.getInt("RegaloID"),
                        rs.getString("Destinatario"),
                        rs.getString("Remitente"),
                        rs.getString("Mensaje"),
                        rs.getString("TipoRegalo"),
                        rs.getDate("FechaEnvio").toLocalDate(),
                        rs.getString("TipoEnvio")
                );
                lista.add(regalo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

}
