package domain.entity;

import java.sql.Timestamp;

public class Paciente {
  private int id; 
    private String nombre;
    private String apellido;
    private Timestamp fecha_nacimiento;
    private  String direccion;
    private String telefono;
    private String email;


    public Paciente(String nombre,String apellido, Timestamp fecha_nacimiento, String direccion, String telefono, String email) {
        this.nombre = nombre;
        this.fecha_nacimiento = fecha_nacimiento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }


    public Paciente(int id, String nombre,String apellido, Timestamp fecha_nacimiento, String direccion, String telefono,
            String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_nacimiento = fecha_nacimiento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Timestamp getFecha_nacimiento() {
        return fecha_nacimiento;
    }
    public void setFecha_nacimiento(Timestamp fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }


    public String getApellido() {
        return apellido;
    }


    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
   
}
