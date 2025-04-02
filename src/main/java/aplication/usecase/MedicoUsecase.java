package aplication.usecase;

import java.sql.Timestamp;

import domain.entity.Medico;

import domain.repository.MedicoRepository;


public class MedicoUsecase {
private final MedicoRepository medicoRepository;

public MedicoUsecase(MedicoRepository medicoRepository) {
    this.medicoRepository = medicoRepository;
}

public void crearMedico(String nombre, int especialidad_id, Timestamp horario_inicio, Timestamp horario_fin ){
    Medico medico = new Medico(nombre,especialidad_id,horario_inicio,horario_fin );
    medicoRepository.crearMedico(medico);
}
public Medico obtenerMedicoPorId(int id){
    return medicoRepository.obtenerMedicoPorId(id);

}
public void actualizarMedico(int id, String nombre, int especialidad_id, Timestamp horario_inicio, Timestamp horario_fin){
    Medico medico = new Medico(nombre, especialidad_id, horario_inicio, horario_fin);
    medicoRepository.actualizarMedico(medico);
}
public void eliminarMedico(int id){
    medicoRepository.eliminarMedico(id);
}

}
