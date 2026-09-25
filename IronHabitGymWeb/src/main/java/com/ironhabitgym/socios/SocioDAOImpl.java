package com.ironhabitgym.socios;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SocioDAOImpl implements SocioDAO {

    @Override
    public List<Socio> listarTodos() throws Exception {
        List<Socio> lista = new ArrayList<>();
        String sql = "SELECT * FROM socios ORDER BY id_socio DESC";
        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(mapearFila(rs));
            }
        }
        return lista;
    }

    @Override
    public Socio buscarPorId(int id) throws Exception {
        String sql = "SELECT * FROM socios WHERE id_socio = ?";
        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return mapearFila(rs);
            }
        }
        return null;
    }

    @Override
    public void insertar(Socio s) throws Exception {
        String sql = "INSERT INTO socios (nombre_completo, telefono, email, membresia, "
                   + "fecha_ingreso, estado, peso, estatura, grasa, musculo, antecedentes) "
                   + "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            enlazarParametros(ps, s);
            ps.executeUpdate();
        }
    }

    @Override
    public void actualizar(Socio s) throws Exception {
        String sql = "UPDATE socios SET nombre_completo=?, telefono=?, email=?, membresia=?, "
                   + "fecha_ingreso=?, estado=?, peso=?, estatura=?, grasa=?, musculo=?, antecedentes=? "
                   + "WHERE id_socio=?";
        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            enlazarParametros(ps, s);
            ps.setInt(12, s.getId());
            ps.executeUpdate();
        }
    }

    @Override
    public void eliminar(int id) throws Exception {
        String sql = "DELETE FROM socios WHERE id_socio = ?";
        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    // -- helpers --

    private void enlazarParametros(PreparedStatement ps, Socio s) throws SQLException {
        ps.setString(1, s.getNombreCompleto());
        ps.setString(2, s.getTelefono());
        ps.setString(3, s.getEmail());
        ps.setString(4, s.getMembresia());
        ps.setString(5, s.getFechaIngreso());
        ps.setString(6, s.getEstado());
        setNullableDouble(ps, 7, s.getPeso());
        setNullableDouble(ps, 8, s.getEstatura());
        setNullableDouble(ps, 9, s.getGrasa());
        setNullableDouble(ps, 10, s.getMusculo());
        ps.setString(11, s.getAntecedentes());
    }

    private void setNullableDouble(PreparedStatement ps, int idx, Double valor) throws SQLException {
        if (valor == null) ps.setNull(idx, Types.DECIMAL);
        else ps.setDouble(idx, valor);
    }

    private Socio mapearFila(ResultSet rs) throws SQLException {
        Socio s = new Socio();
        s.setId(rs.getInt("id_socio"));
        s.setNombreCompleto(rs.getString("nombre_completo"));
        s.setTelefono(rs.getString("telefono"));
        s.setEmail(rs.getString("email"));
        s.setMembresia(rs.getString("membresia"));
        s.setFechaIngreso(rs.getString("fecha_ingreso"));
        s.setEstado(rs.getString("estado"));
        // DECIMAL en MySQL: getDouble() maneja la conversión correctamente (evitar getObject()+cast)
        s.setPeso(rs.getObject("peso") != null ? rs.getDouble("peso") : null);
        s.setEstatura(rs.getObject("estatura") != null ? rs.getDouble("estatura") : null);
        s.setGrasa(rs.getObject("grasa") != null ? rs.getDouble("grasa") : null);
        s.setMusculo(rs.getObject("musculo") != null ? rs.getDouble("musculo") : null);
        s.setAntecedentes(rs.getString("antecedentes"));
        return s;
    }
}
