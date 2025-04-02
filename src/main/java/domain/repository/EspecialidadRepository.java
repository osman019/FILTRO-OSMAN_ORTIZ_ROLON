package domain.repository;

import java.util.List;

import domain.entity.Especialidad;


public interface EspecialidadRepository {
      void crearEspecialidad(Especialidad especialidad);
    
      
        Especialidad obtenerEspecialidadPorId(int id);
    
        
        List<Especialidad> obtenerTodoslEspecialidades();
    
        
        void actualizarEspecialidad(Especialidad especialidad);
    
    
        void eliminarEspecialidad(int id);
}
