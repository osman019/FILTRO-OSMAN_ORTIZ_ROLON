package ui;

import java.sql.Timestamp;
import java.util.Scanner;

import aplication.usecase.MedicoUsecase;
import domain.entity.Medico;

public class MedicoMenu {
    
    private MedicoUsecase medicoUsecase; 

    public MedicoMenu(MedicoUsecase medicoUsecase) {
        this.medicoUsecase = medicoUsecase;
    }

    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("===================================");
            System.out.println("Bienvenido al sistema de médicos");
            System.out.println("1. Crear médico");
            System.out.println("2. Obtener médico por ID");
            System.out.println("3. Actualizar médico");
            System.out.println("4. Eliminar médico");
            System.out.println("5. Salir");
            System.out.println("===================================");

            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    crearMedico(scanner);
                    break;
                case 2:
                    obtenerMedicoPorId(scanner);
                    break;
                case 3:
                    actualizarMedico(scanner);
                    break;
                case 4:
                    eliminarMedico(scanner);
                    break;
                case 5:
                    continuar = false;
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida, por favor intente de nuevo.");
            }
        }
    }

    private void crearMedico(Scanner scanner) {
        scanner.nextLine();  // Consumir salto de línea residual

        System.out.print("Ingrese el nombre del médico: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el ID de la especialidad: ");
        int especialidadId = scanner.nextInt();

        System.out.print("Ingrese el horario de inicio (YYYY-MM-DD HH:MM:SS): ");
        String inicioStr = scanner.next();
        Timestamp horarioInicio = Timestamp.valueOf(inicioStr);

        System.out.print("Ingrese el horario de fin (YYYY-MM-DD HH:MM:SS): ");
        String finStr = scanner.next();
        Timestamp horarioFin = Timestamp.valueOf(finStr);

        medicoUsecase.crearMedico(nombre, especialidadId, horarioInicio, horarioFin);
        System.out.println("Médico creado con éxito.");
    }

    private void obtenerMedicoPorId(Scanner scanner) {
        System.out.print("Ingrese el ID del médico a buscar: ");
        int id = scanner.nextInt();

        Medico medico = medicoUsecase.obtenerMedicoPorId(id);
        if (medico != null) {
            System.out.println("Médico encontrado:");
            System.out.println("ID: " + medico.getId());
            System.out.println("Nombre: " + medico.getNombre());
            System.out.println("Especialidad ID: " + medico.getEspecialidad_id());
            System.out.println("Horario inicio: " + medico.getHorario_inicio());
            System.out.println("Horario fin: " + medico.getHorario_fin());
        } else {
            System.out.println("No se encontró un médico con el ID " + id);
        }
    }

    private void actualizarMedico(Scanner scanner) {
        System.out.print("Ingrese el ID del médico a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir salto de línea residual

        System.out.print("Ingrese el nuevo nombre del médico: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el nuevo ID de la especialidad: ");
        int especialidadId = scanner.nextInt();

        System.out.print("Ingrese el nuevo horario de inicio (YYYY-MM-DD HH:MM:SS): ");
        String inicioStr = scanner.next();
        Timestamp horarioInicio = Timestamp.valueOf(inicioStr);

        System.out.print("Ingrese el nuevo horario de fin (YYYY-MM-DD HH:MM:SS): ");
        String finStr = scanner.next();
        Timestamp horarioFin = Timestamp.valueOf(finStr);

        medicoUsecase.actualizarMedico(id, nombre, especialidadId, horarioInicio, horarioFin);
        System.out.println("Médico actualizado con éxito.");
    }

    private void eliminarMedico(Scanner scanner) {
        System.out.print("Ingrese el ID del médico a eliminar: ");
        int id = scanner.nextInt();

        medicoUsecase.eliminarMedico(id);
        System.out.println("Médico eliminado con éxito.");
    }
}
