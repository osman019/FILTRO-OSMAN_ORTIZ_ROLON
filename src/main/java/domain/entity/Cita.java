package domain.entity;

import java.util.TimeZone;



public class Cita {
  
private int id;
private int paciente_id;
private int medico_id;
private TimeZone fecha_hora;
private estadoenum estado;

public Cita(int paciente_id, int medico_id, TimeZone fecha_hora, estadoenum estado) {
    this.paciente_id = paciente_id;
    this.medico_id = medico_id;
    this.fecha_hora = fecha_hora;
    this.estado = estado;
}

public int getId() {
    return id;
}

public void setId(int id) {
    this.id = id;
}

public int getPaciente_id() {
    return paciente_id;
}

public void setPaciente_id(int paciente_id) {
    this.paciente_id = paciente_id;
}

public int getMedico_id() {
    return medico_id;
}

public void setMedico_id(int medico_id) {
    this.medico_id = medico_id;
}

public TimeZone getFecha_hora() {
    return fecha_hora;
}

public void setFecha_hora(TimeZone fecha_hora) {
    this.fecha_hora = fecha_hora;
}

public estadoenum getEstado() {
    return estado;
}

public void setEstado(estadoenum estado) {
    this.estado = estado;
}



}
