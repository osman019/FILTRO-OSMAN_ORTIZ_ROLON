package domain.repository;

import java.util.List;

import domain.entity.Medico;


public interface MedicoRepository {

        void crearMedico(Medico medico);
    
      
        Medico obtenerMedicoPorId(int id);
    
        
        List<Medico> obtenerTodosLosMedicos();
    
        
        void actualizarMedico(Medico medico);
    
    
        void eliminarMedico(int id);
}
