package domain.repository;


    

    import domain.entity.Paciente;
    import java.util.List;
    
    public interface PacienteRepository {
    
     
        void crearPaciente(Paciente paciente);
    
      
        Paciente obtenerPacientePorId(int id);
    
        
        List<Paciente> obtenerTodosLosPacientes();
    
        
        void actualizarPaciente(Paciente paciente);
    
    
        void eliminarPaciente(int id);
    }
    
