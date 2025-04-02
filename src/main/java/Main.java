import java.util.Scanner;

import aplication.usecase.MedicoUsecase;
import domain.repository.MedicoRepository;
import infrasctructure.database.ConnectionFactory;
import infrasctructure.persistence.MedicoRepositoryImpl;
import ui.MedicoMenu;
import ui.PacienteMenu; 
public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        MedicoRepository medicoRepository = new MedicoRepositoryImpl(ConnectionFactory.crearConexion());
        MedicoUsecase medicousecase = new MedicoUsecase(medicoRepository);
        MedicoMenu medicoMenu = new MedicoMenu(medicousecase);  
        int opcion;
        do {
            System.out.println("----------------------------");
            System.out.println("-      CENTRO MEDICO       -");
            System.out.println("----------------------------");
            System.out.println("1. Menu medicos");
            System.out.println("2. Menu Pacientes");
            System.out.println("3. Menu Especialidades");
            System.out.println("4. Menu citas");
            System.out.println("0. Exit");
            System.out.println("----------------------------");
            System.out.print("Enter an option: ");
            
        
            while (!teclado.hasNextInt()) {
                System.out.println("Solo numeros válidos.");
                teclado.next();
            }
            
            opcion = teclado.nextInt();
            teclado.nextLine();  

            switch (opcion) {
                case 1:
                    medicoMenu.mostrarMenu();  //
                    break;
           
                default:
                    System.out.println("Invalid option. Try again.");
            }
        } while (opcion != 0);
        
        teclado.close();
    } 
}
