<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.ironhabitgym.socios.Socio" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Iron Habit Gym — Formulario de Socio</title>
  <style>
    body { font-family: Arial, sans-serif; background:#f4f4f7; margin:0; padding:2rem; }
    h1 { color:#8406f9; }
    form { max-width:480px; background:#fff; padding:1.5rem; border-radius:10px; box-shadow:0 2px 8px rgba(0,0,0,.06); }
    label { display:block; font-size:.8rem; font-weight:bold; margin:.75rem 0 .25rem; color:#444; }
    input, select, textarea { width:100%; padding:.5rem; border:1px solid #ddd; border-radius:6px; box-sizing:border-box; }
    .btn { padding:.6rem 1.2rem; border:none; border-radius:6px; font-weight:bold; cursor:pointer; }
    .btn-guardar { background:#8406f9; color:#fff; margin-top:1.25rem; }
    .btn-cancelar { background:#eee; color:#333; margin-top:1.25rem; margin-left:.5rem; text-decoration:none; display:inline-block; }
    .error { background:#fde2e2; color:#c0392b; padding:.75rem 1rem; border-radius:6px; margin-bottom:1rem; max-width:480px; }
  </style>
</head>
<body>
  <%
    Socio s = (Socio) request.getAttribute("socio");
    boolean esEdicion = (s != null && s.getId() != 0);
  %>
  <h1><%= esEdicion ? "Editar Socio" : "Registrar Nuevo Socio" %></h1>

  <% if (request.getAttribute("error") != null) { %>
    <div class="error"><%= request.getAttribute("error") %></div>
  <% } %>

  <!-- POST: creación y edición pasan por la misma acción "guardar" -->
  <form action="socios" method="post">
    <input type="hidden" name="accion" value="guardar">
    <% if (esEdicion) { %>
      <input type="hidden" name="id" value="<%= s.getId() %>">
    <% } %>

    <label for="nombreCompleto">Nombre Completo *</label>
    <input type="text" id="nombreCompleto" name="nombreCompleto" required
           value="<%= esEdicion ? s.getNombreCompleto() : "" %>">

    <label for="telefono">Teléfono *</label>
    <input type="tel" id="telefono" name="telefono" required
           value="<%= esEdicion ? s.getTelefono() : "" %>">

    <label for="email">Correo Electrónico *</label>
    <input type="email" id="email" name="email" required
           value="<%= esEdicion ? s.getEmail() : "" %>">

    <label for="membresia">Membresía</label>
    <select id="membresia" name="membresia">
      <option value="m1" <%= esEdicion && "m1".equals(s.getMembresia()) ? "selected" : "" %>>Plan Mensual General</option>
      <option value="m2" <%= esEdicion && "m2".equals(s.getMembresia()) ? "selected" : "" %>>Plan Trimestral</option>
      <option value="m3" <%= esEdicion && "m3".equals(s.getMembresia()) ? "selected" : "" %>>Plan Anual VIP</option>
    </select>

    <label for="fechaIngreso">Fecha de Ingreso *</label>
    <input type="date" id="fechaIngreso" name="fechaIngreso" required
           value="<%= esEdicion ? s.getFechaIngreso() : "" %>">

    <label for="estado">Estado</label>
    <select id="estado" name="estado">
      <option value="Activo" <%= esEdicion && "Activo".equals(s.getEstado()) ? "selected" : "" %>>Activo</option>
      <option value="Pendiente" <%= esEdicion && "Pendiente".equals(s.getEstado()) ? "selected" : "" %>>Pendiente</option>
      <option value="Vencido" <%= esEdicion && "Vencido".equals(s.getEstado()) ? "selected" : "" %>>Vencido</option>
    </select>

    <label for="peso">Peso (kg)</label>
    <input type="number" step="0.1" id="peso" name="peso" value="<%= esEdicion && s.getPeso() != null ? s.getPeso() : "" %>">

    <label for="estatura">Estatura (cm)</label>
    <input type="number" step="0.1" id="estatura" name="estatura" value="<%= esEdicion && s.getEstatura() != null ? s.getEstatura() : "" %>">

    <label for="grasa">% Grasa Corporal</label>
    <input type="number" step="0.1" id="grasa" name="grasa" value="<%= esEdicion && s.getGrasa() != null ? s.getGrasa() : "" %>">

    <label for="musculo">% Masa Muscular</label>
    <input type="number" step="0.1" id="musculo" name="musculo" value="<%= esEdicion && s.getMusculo() != null ? s.getMusculo() : "" %>">

    <label for="antecedentes">Antecedentes / Observaciones</label>
    <textarea id="antecedentes" name="antecedentes" rows="3"><%= esEdicion && s.getAntecedentes() != null ? s.getAntecedentes() : "" %></textarea>

    <button type="submit" class="btn btn-guardar"><%= esEdicion ? "Guardar Cambios" : "Registrar Socio" %></button>
    <a class="btn btn-cancelar" href="socios?accion=listar">Cancelar</a>
  </form>
</body>
</html>
