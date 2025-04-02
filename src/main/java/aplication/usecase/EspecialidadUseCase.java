package aplication.usecase;



import domain.entity.Especialidad;

import domain.repository.EspecialidadRepository;


public class EspecialidadUseCase {
private final EspecialidadRepository especialidadRepository;




public EspecialidadUseCase(EspecialidadRepository especialidadRepository) {
    this.especialidadRepository = especialidadRepository;
}
public void crearEspecialidad ( String nombre){
    Especialidad especialidad = new Especialidad(nombre );
    especialidadRepository.crearEspecialidad(especialidad);
}
public Especialidad obtenerEspecialidadPorId (int id){
    return especialidadRepository.obtenerEspecialidadPorId(id);

}
public void actualizarEspecialidad(int id, String nombre){
    Especialidad especialidad = new Especialidad(nombre);
    especialidadRepository.actualizarEspecialidad(especialidad);
}
public void eliminarEspecialidad(int id){
    especialidadRepository.eliminarEspecialidad(id);
}
}
