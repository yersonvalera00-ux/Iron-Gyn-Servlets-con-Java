package com.ironhabitgym.socios;

import java.util.List;

public interface SocioDAO {
    List<Socio> listarTodos() throws Exception;
    Socio buscarPorId(int id) throws Exception;
    void insertar(Socio socio) throws Exception;
    void actualizar(Socio socio) throws Exception;
    void eliminar(int id) throws Exception;
}
