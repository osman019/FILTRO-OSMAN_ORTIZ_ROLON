package infrasctructure.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import domain.entity.Medico;
import domain.repository.MedicoRepository;
import infrasctructure.database.ConnectionDb;

public class MedicoRepositoryImpl implements MedicoRepository {
private final ConnectionDb connection;

public MedicoRepositoryImpl(ConnectionDb connection) {
    this.connection = connection;
}
    @Override
    public void crearMedico(Medico medico) {
        String sql = "INSERT INTO medicos (nombre, especialidad_id, horario_inicio, horario_fin) VALUES (?, ?, ?, ?)";
        try (Connection conexion = connection.getConexion();
        PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, medico.getNombre());
            stmt.setInt(2, medico.getEspecialidad_id());
            stmt.setTimestamp(3, medico.getHorario_inicio());
            stmt.setTimestamp(4, medico.getHorario_fin());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al crear el médico", e);
        }
    }

    @Override
    public Medico obtenerMedicoPorId(int id) {
        String sql = "SELECT * FROM medicos WHERE id = ?";
        try (Connection conexion = connection.getConexion();
        PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                String nombre = resultSet.getString("nombre");
                int especialidadId = resultSet.getInt("especialidad_id");
                Timestamp horarioInicio = resultSet.getTimestamp("horario_inicio");
                Timestamp horarioFin = resultSet.getTimestamp("horario_fin");
                return new Medico(id, nombre, especialidadId, horarioInicio, horarioFin);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al obtener el médico", e);
        }
        return null;
    }

    @Override
    public void actualizarMedico(Medico medico) {
        String sql = "UPDATE medicos SET nombre = ?, especialidad_id = ?, horario_inicio = ?, horario_fin = ? WHERE id = ?";
        try (Connection conexion = connection.getConexion();
        PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, medico.getNombre());
            stmt.setInt(2, medico.getEspecialidad_id());
            stmt.setTimestamp(3, medico.getHorario_inicio());
            stmt.setTimestamp(4, medico.getHorario_fin());
            stmt.setInt(5, medico.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al actualizar el médico", e);
        }
    }

    @Override
    public void eliminarMedico(int id) {
        String sql = "DELETE FROM medicos WHERE id = ?";
        try (Connection conexion = connection.getConexion();
        PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al eliminar el médico", e);
        }
    }

    // Si necesitas obtener todos los médicos, por ejemplo
    @Override
    public List<Medico> obtenerTodosLosMedicos() {
        List<Medico> medicos = new ArrayList<>();
        String sql = "SELECT * FROM medicos";
        try (Connection conexion = connection.getConexion();
        PreparedStatement stmt = conexion.prepareStatement(sql)) {
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                int especialidadId = resultSet.getInt("especialidad_id");
                Timestamp horarioInicio = resultSet.getTimestamp("horario_inicio");
                Timestamp horarioFin = resultSet.getTimestamp("horario_fin");
                medicos.add(new Medico(id, nombre, especialidadId, horarioInicio, horarioFin));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al obtener la lista de médicos", e);
        }
        return medicos;
    }
}

    

