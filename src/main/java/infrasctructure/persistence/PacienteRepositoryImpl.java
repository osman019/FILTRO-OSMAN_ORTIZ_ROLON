package infrasctructure.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import domain.entity.Paciente;
import domain.repository.PacienteRepository;
import infrasctructure.database.ConnectionDb;

public class PacienteRepositoryImpl implements PacienteRepository {
private final ConnectionDb connection;

public PacienteRepositoryImpl(ConnectionDb connection) {
    this.connection = connection;
}

@Override
public void actualizarPaciente(Paciente paciente) {

    
}

@Override
public void crearPaciente(Paciente paciente) {
    String sql = "INSERT INTO paciente (nombre, apellido, fecha_nacimiento, direccion,telefono,email) VALUES (?, ?, ?, ?, ?, ?)";
    try (Connection conexion = connection.getConexion();
        PreparedStatement stmt = conexion.prepareStatement(sql)) {
      stmt.setString(1, paciente.getNombre());
      stmt.setString(2, paciente.getApellido());
      stmt.setTimestamp(3, paciente.getFecha_nacimiento());
      stmt.setString(4, paciente.getDireccion());
      stmt.setString(5, paciente.getTelefono());
      stmt.setString(6, paciente.getEmail());
      stmt.executeUpdate();
      System.out.println("Paciente registrado correctamente...");
    } catch (SQLException e) {
        e.printStackTrace();
    }

}

@Override
public void eliminarPaciente(int id) {
   
    String sql = "DELETE FROM paciente WHERE id = ?";
    try (Connection conexion = connection.getConexion();
        PreparedStatement stmt = conexion.prepareStatement(sql)) {
      stmt.setInt(1, id);
      stmt.executeUpdate();
      System.out.println("Paciente eliminado correctamente");
    } catch (SQLException e) {
      e.printStackTrace();
    }
}

@Override
public Paciente obtenerPacientePorId(int id) {
    String sql = "SELECT * FROM paciente WHERE id = ?";
    try (Connection conexion = connection.getConexion();
      PreparedStatement stmt = conexion.prepareStatement(sql)) {
      stmt.setInt(1, id);
      ResultSet rs = stmt.executeQuery();
     if (rs.next()) {
          Paciente paciente = new Paciente(
               rs.getInt("id"),
              rs.getString("nombre"),
              rs.getString("apellido"),
              rs.getTimestamp("fecha_nacimiento"),
              rs.getString("direccion"),
              rs.getString("telefono"),
              rs.getString("email")
             
          );

        
          System.out.println( paciente);

          return paciente;
      } else {
          System.out.println("No se encotro el usuario con " + id);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
}

@Override
public List<Paciente> obtenerTodosLosPacientes() {
    
    return null;
}


}
