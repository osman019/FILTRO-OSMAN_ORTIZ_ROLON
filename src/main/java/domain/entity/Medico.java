package domain.entity;

import java.sql.Timestamp;

public class Medico {


    private int id;
    private String nombre;
    private int especialidad_id;
    private Timestamp horario_inicio;
    private Timestamp horario_fin;


    public Medico(String nombre, int especialidad_id, Timestamp horario_inicio, Timestamp horario_fin) {
        this.nombre = nombre;
        this.especialidad_id = especialidad_id;
        this.horario_inicio = horario_inicio;
        this.horario_fin = horario_fin;
    }


    
    public Medico(int id, String nombre, int especialidad_id, Timestamp horario_inicio, Timestamp horario_fin) {
        this.id = id;
        this.nombre = nombre;
        this.especialidad_id = especialidad_id;
        this.horario_inicio = horario_inicio;
        this.horario_fin = horario_fin;
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
    public int getEspecialidad_id() {
        return especialidad_id;
    }
    public void setEspecialidad_id(int especialidad_id) {
        this.especialidad_id = especialidad_id;
    }
    public Timestamp getHorario_inicio() {
        return horario_inicio;
    }
    public void setHorario_inicio(Timestamp horario_inicio) {
        this.horario_inicio = horario_inicio;
    }
    public Timestamp getHorario_fin() {
        return horario_fin;
    }
    public void setHorario_fin(Timestamp horario_fin) {
        this.horario_fin = horario_fin;
    }
    


    
}
