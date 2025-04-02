package ui;

import java.util.Scanner;

import aplication.usecase.PacienteUseCase;

public class PacienteMenu {
 private final Scanner teclado;
    private final PacienteUseCase pacienteUseCase;

    public PacienteMenu(Scanner teclado, PacienteUseCase pacienteUseCase) {
        this.teclado = teclado;
        this.pacienteUseCase = pacienteUseCase;
    }

 public void showMenu() {
        int opcion;
        do {
          
            System.out.println("----------------------------");
            System.out.println("-      MENU EMPLOYEE       -");
            System.out.println("----------------------------");
            System.out.println("1. Insert type Employee");
            System.out.println("2. Insert Employee");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Get Employee");
            System.out.println("0. Exit");
            System.out.println("----------------------------");
            System.out.println("Enter an option: ");
            while (!teclado.hasNextInt()) {
                System.out.println("¡Invalid entry. Enter only valid numbers!.");
                teclado.next();
            }
            opcion = teclado.nextInt();
            teclado.nextLine();

    
}while (opcion != 0);}}
