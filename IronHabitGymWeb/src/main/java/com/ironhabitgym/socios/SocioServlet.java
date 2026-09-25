package com.ironhabitgym.socios;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Controlador único del módulo Socios.
 * GET  -> listar / mostrar formulario (nuevo o edición)
 * POST -> guardar (insertar o actualizar) / eliminar
 */
@WebServlet("/socios")
public class SocioServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final SocioDAO dao = new SocioDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String accion = req.getParameter("accion");
        if (accion == null) accion = "listar";

        try {
            switch (accion) {
                case "nuevo":
                    req.setAttribute("socio", new Socio());
                    forward(req, resp, "/WEB-INF/vistas/formSocio.jsp");
                    break;

                case "editar":
                    int id = Integer.parseInt(req.getParameter("id"));
                    Socio socio = dao.buscarPorId(id);
                    req.setAttribute("socio", socio);
                    forward(req, resp, "/WEB-INF/vistas/formSocio.jsp");
                    break;

                case "eliminar":
                    dao.eliminar(Integer.parseInt(req.getParameter("id")));
                    resp.sendRedirect("socios?accion=listar");
                    break;

                case "listar":
                default:
                    List<Socio> lista = dao.listarTodos();
                    req.setAttribute("listaSocios", lista);
                    forward(req, resp, "/WEB-INF/vistas/listarSocios.jsp");
                    break;
            }
        } catch (Exception e) {
            req.setAttribute("error", "Error al procesar la solicitud: " + e.getMessage());
            forward(req, resp, "/WEB-INF/vistas/listarSocios.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        String accion = req.getParameter("accion");

        try {
            if ("guardar".equals(accion)) {
                Socio s = new Socio();
                String idParam = req.getParameter("id");
                s.setNombreCompleto(req.getParameter("nombreCompleto"));
                s.setTelefono(req.getParameter("telefono"));
                s.setEmail(req.getParameter("email"));
                s.setMembresia(req.getParameter("membresia"));
                s.setFechaIngreso(req.getParameter("fechaIngreso"));
                s.setEstado(req.getParameter("estado"));
                s.setPeso(parseDoubleSeguro(req.getParameter("peso")));
                s.setEstatura(parseDoubleSeguro(req.getParameter("estatura")));
                s.setGrasa(parseDoubleSeguro(req.getParameter("grasa")));
                s.setMusculo(parseDoubleSeguro(req.getParameter("musculo")));
                s.setAntecedentes(req.getParameter("antecedentes"));

                if (idParam == null || idParam.isEmpty()) {
                    dao.insertar(s);
                } else {
                    s.setId(Integer.parseInt(idParam));
                    dao.actualizar(s);
                }
                resp.sendRedirect("socios?accion=listar");

            } else {
                resp.sendRedirect("socios?accion=listar");
            }
        } catch (Exception e) {
            req.setAttribute("error", "Error al guardar: " + e.getMessage());
            forward(req, resp, "/WEB-INF/vistas/formSocio.jsp");
        }
    }

    private Double parseDoubleSeguro(String valor) {
        if (valor == null || valor.trim().isEmpty()) return null;
        try {
            return Double.parseDouble(valor);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private void forward(HttpServletRequest req, HttpServletResponse resp, String ruta)
            throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher(ruta);
        rd.forward(req, resp);
    }
}
