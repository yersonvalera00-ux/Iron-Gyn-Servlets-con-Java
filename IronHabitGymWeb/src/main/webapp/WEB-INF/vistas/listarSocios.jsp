<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List, com.ironhabitgym.socios.Socio" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Iron Habit Gym — Socios (Servlet + JSP)</title>
  <style>
    body { font-family: Arial, sans-serif; background:#f4f4f7; margin:0; padding:2rem; }
    h1 { color:#8406f9; }
    table { width:100%; border-collapse: collapse; background:#fff; box-shadow:0 2px 8px rgba(0,0,0,.06); }
    th, td { padding:.75rem 1rem; text-align:left; border-bottom:1px solid #eee; font-size:.9rem; }
    th { background:#8406f9; color:#fff; text-transform:uppercase; font-size:.75rem; }
    .btn { display:inline-block; padding:.4rem .9rem; border-radius:6px; text-decoration:none; font-size:.8rem; font-weight:bold; }
    .btn-nuevo { background:#8406f9; color:#fff; margin-bottom:1rem; }
    .btn-editar { background:#e5d4fb; color:#5a1ea6; margin-right:.4rem; }
    .btn-eliminar { background:#fde2e2; color:#c0392b; }
    .error { background:#fde2e2; color:#c0392b; padding:.75rem 1rem; border-radius:6px; margin-bottom:1rem; }
    .badge { padding:.2rem .6rem; border-radius:999px; font-size:.75rem; font-weight:bold; }
    .badge-Activo { background:#e6f9ee; color:#22c55e; }
    .badge-Vencido { background:#fde2e2; color:#ef4444; }
    .badge-Pendiente { background:#fef3e2; color:#f59e0b; }
  </style>
</head>
<body>
  <h1>Gestión de Socios — Iron Habit Gym</h1>

  <% if (request.getAttribute("error") != null) { %>
    <div class="error"><%= request.getAttribute("error") %></div>
  <% } %>

  <a class="btn btn-nuevo" href="socios?accion=nuevo">+ Nuevo Socio</a>

  <table>
    <thead>
      <tr>
        <th>ID</th><th>Nombre</th><th>Teléfono</th><th>Email</th>
        <th>Membresía</th><th>Ingreso</th><th>Estado</th><th>Acciones</th>
      </tr>
    </thead>
    <tbody>
      <%
        @SuppressWarnings("unchecked")
        List<Socio> lista = (List<Socio>) request.getAttribute("listaSocios");
        if (lista == null || lista.isEmpty()) {
      %>
        <tr><td colspan="8" style="text-align:center; color:#888;">No hay socios registrados.</td></tr>
      <%
        } else {
          for (Socio s : lista) {
      %>
      <tr>
        <td>#<%= s.getId() %></td>
        <td><%= s.getNombreCompleto() %></td>
        <td><%= s.getTelefono() %></td>
        <td><%= s.getEmail() %></td>
        <td><%= s.getMembresia() %></td>
        <td><%= s.getFechaIngreso() %></td>
        <td><span class="badge badge-<%= s.getEstado() %>"><%= s.getEstado() %></span></td>
        <td>
          <a class="btn btn-editar" href="socios?accion=editar&id=<%= s.getId() %>">Editar</a>
          <a class="btn btn-eliminar" href="socios?accion=eliminar&id=<%= s.getId() %>"
             onclick="return confirm('¿Eliminar este socio?');">Eliminar</a>
        </td>
      </tr>
      <%
          }
        }
      %>
    </tbody>
  </table>
</body>
</html>
