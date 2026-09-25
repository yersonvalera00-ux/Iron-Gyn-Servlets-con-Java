package com.ironhabitgym.socios;

public class Socio {

    private int id;
    private String nombreCompleto;
    private String telefono;
    private String email;
    private String membresia;
    private String fechaIngreso;
    private String estado;
    private Double peso;
    private Double estatura;
    private Double grasa;
    private Double musculo;
    private String antecedentes;

    public Socio() { }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombreCompleto() { return nombreCompleto; }
    public void setNombreCompleto(String nombreCompleto) { this.nombreCompleto = nombreCompleto; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getMembresia() { return membresia; }
    public void setMembresia(String membresia) { this.membresia = membresia; }

    public String getFechaIngreso() { return fechaIngreso; }
    public void setFechaIngreso(String fechaIngreso) { this.fechaIngreso = fechaIngreso; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public Double getPeso() { return peso; }
    public void setPeso(Double peso) { this.peso = peso; }

    public Double getEstatura() { return estatura; }
    public void setEstatura(Double estatura) { this.estatura = estatura; }

    public Double getGrasa() { return grasa; }
    public void setGrasa(Double grasa) { this.grasa = grasa; }

    public Double getMusculo() { return musculo; }
    public void setMusculo(Double musculo) { this.musculo = musculo; }

    public String getAntecedentes() { return antecedentes; }
    public void setAntecedentes(String antecedentes) { this.antecedentes = antecedentes; }
}
