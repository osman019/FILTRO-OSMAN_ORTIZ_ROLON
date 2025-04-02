package aplication.usecase;

import java.sql.Timestamp;


import domain.entity.Paciente;
import domain.repository.PacienteRepository;

public class PacienteUseCase {
private final PacienteRepository pacienteRepository;

public PacienteUseCase(PacienteRepository pacienteRepository) {
    this.pacienteRepository = pacienteRepository;
}

public void crearPaciente(String name,String apellido, Timestamp fecha_nacimiento, String direccion,String telefono,String email ){
    Paciente paciente = new Paciente(name,apellido, fecha_nacimiento, direccion, telefono, email);
    pacienteRepository.crearPaciente(paciente);
}

public  Paciente obtenerPacientePorId(int id ){
    return pacienteRepository.obtenerPacientePorId(id);


  
}
public void actualizarPaciente(int id,String name,String apellido, Timestamp fecha_nacimiento, String direccion,String telefono,String email){
    Paciente paciente = new Paciente(id,name,apellido, fecha_nacimiento, direccion, telefono, email);
    pacienteRepository.actualizarPaciente(paciente);
    }

   public void eliminarPaciente(int id){
    pacienteRepository.eliminarPaciente(id);
   }

  
}
