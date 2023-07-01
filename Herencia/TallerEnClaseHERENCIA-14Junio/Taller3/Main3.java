package Taller3;

import java.io.*;

public class Main3 {
    public static void main(String[] args) {
        BufferedReader leer     = new BufferedReader(new InputStreamReader(System.in));
        
        // los objetos de Estudiante y Trabajador se crean dentro de los cases porque se instancia una sola vez.

        // Variables
        String nombre = "", ced = "";
        int totP = 0, totC = 0, opcion=0, horasT = 0; // Puntos y creditos y horas trabajadas
        double indice, tarifaH = 0.0; 
        boolean bien;

        do {
            bien = true;
            try {
                System.out.print("Ingrese su nombre: ");
                nombre = leer.readLine();
            } catch (IOException e) {
                System.out.println("Ocurrio algo inesperado. Ingrese nuevamente.");
                bien = false;
            }
        } while (!bien);

        do {
            bien = true;
            try {
                System.out.print("Ingrese su cedula: ");
                ced = leer.readLine();
            } catch (IOException e) {
                System.out.println("Ocurrio algo inesperado. Ingrese nuevamente.");
                bien = false;
            }
        } while (!bien);
        
        // Menu para Estudiante o Trabajador
        System.out.println(""
        + "\tMenu\n"
        + "1. Estudiante\n"
        + "2. Trabajador\n");
        do {
            bien = true;
            try {
                System.out.print("Ingrese una opcion: ");
                opcion = Integer.parseInt(leer.readLine());
                if (opcion < 1 || opcion > 2) {
                    System.out.println("Opcion invalida. Ingrese otra vez");
                    bien = false;
                }
            } catch (IOException e) {
                System.out.println("Ocurrio algo inesperado. Ingrese nuevamente.");
                bien = false;
            } catch (NumberFormatException er) {
                System.out.println("El numero es invalido. Ingrese otra vez");
                bien = false;
            }
        } while (!bien);

        switch (opcion) {
            case 1: // estudiante
                Estudiante estudiante   = new Estudiante();
                do {
                    bien = true;
                    try {
                        System.out.print("Ingrese su cedula: ");
                        ced = leer.readLine();
                    } catch (IOException e) {
                        System.out.println("Ocurrio algo inesperado. Ingrese nuevamente.");
                        bien = false;
                    }
                } while (!bien);
        
                do {
                    bien = true;
                    try {
                        System.out.print("Ingrese el total de creditos: ");
                        totC = Integer.parseInt(leer.readLine());
                        // verificar que no sea menor que 0
                        if (totC < 0) {
                            System.out.println("Los créditos no pueden ser negativos");
                            bien = false;
                        }
                        if (totC == 0) {
                            System.out.println("0 créditos no es posible, no calcularias nada. Ingresa un numero mayor a 0");
                        }
                    } catch (IOException e) {
                        System.out.println("Ocurrio algo inesperado. Ingrese nuevamente.");
                        bien = false;
                    } catch (NumberFormatException er) {
                        System.out.println("El numero es invalido. Ingrese otra vez");
                        bien = false;
                    }
                } while (!bien);
        
                do {
                    bien = true;
                    try {
                        System.out.print("Ingrese el total de puntos: ");
                        totP = Integer.parseInt(leer.readLine());
                        // verificar que no se pase de los puntos
                        if (totP > (totC * 3)) {
                            System.out.println("Tienes mas puntos que los aceptados. No deberias tener mas de " 
                            + totC * 3 
                            + " puntos.\nIngresa otra vez.");
                            bien = false;
                        }
                    } catch (IOException e) {
                        System.out.println("Ocurrio algo inesperado. Ingrese nuevamente.");
                        bien = false;
                    } catch (NumberFormatException er) {
                        System.out.println("El numero es invalido. Ingrese otra vez");
                        bien = false;
                    }
                } while (!bien);
        
        
                // Trabajamos con el objeto
                estudiante.asignar(nombre, ced);
                estudiante.asignar(totP, totC);
                indice = estudiante.calcularI();
        
        
                // Imprimimos
                System.out.println("--------------------------------");
                System.out.println(String.format("|    Tu indice es de: %.2f     |", indice));
                System.out.println("--------------------------------");
                System.out.println(">> " + estudiante.mensaje(indice));
                break;
                
            case 2:
                Trabajador trabajador   = new Trabajador();

                do {
                    bien = true;
                    try {
                        System.out.print("Ingrese las horas trabajadas: ");
                        horasT = Integer.parseInt(leer.readLine());
                    } catch (IOException e) {
                        System.out.println("Ocurrio algo inesperado. Ingrese nuevamente.");
                        bien = false;
                    } catch (NumberFormatException er) {
                        System.out.println("El numero es invalido. Ingrese otra vez");
                        bien = false;
                    }
                } while (!bien);

                do {
                    bien = true;
                    try {
                        System.out.print("Ingrese la tarifa x hora: ");
                        tarifaH = Double.parseDouble(leer.readLine());
                    } catch (IOException e) {
                        System.out.println("Ocurrio algo inesperado. Ingrese nuevamente.");
                        bien = false;
                    } catch (NumberFormatException er) {
                        System.out.println("El numero es invalido. Ingrese otra vez");
                        bien = false;
                    }
                } while (!bien);

                // Trabajamos con el objeto
                trabajador.asignar(nombre, ced);
                trabajador.asignar(horasT, tarifaH);

                // Imprimimos
                System.out.println("--------------------------------");
                System.out.println(String.format("|    Tu salario es de: %.2f    |", trabajador.calcularSalario()));
                System.out.println("--------------------------------");
                break;
            }
                

        }
}
