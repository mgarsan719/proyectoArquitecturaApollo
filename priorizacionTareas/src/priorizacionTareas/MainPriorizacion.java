package priorizacionTareas;

import java.util.Scanner;

public class MainPriorizacion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProcesosApollo agc = new ProcesosApollo();
        int opcion;

        System.out.println("--- INICIALIZANDO APOLLO GUIDANCE COMPUTER (AGC) ---");

        do {
            System.out.println("\nMENÚ DE CONTROL DE MISIÓN:");
            System.out.println("1. Cargar tarea predefinida (Aterrizaje)");
            System.out.println("2. Cargar tarea manual");
            System.out.println("3. Ver tareas en cola");
            System.out.println("4. EJECUTAR CICLO DE CPU");
            System.out.println("5. Abortar misión (Salir)");
            System.out.print("Seleccione una opción: ");
            
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    agc.cargarTarea(new Tarea("Aterrizaje (LGC)", 1, 60));
                    agc.cargarTarea(new Tarea("Telemetría MSFN", 2, 20));
                    System.out.println("[OK] Tareas críticas cargadas.");
                    break;

                case 2:
                    System.out.print("Nombre de la tarea: ");
                    String nombre = sc.nextLine();
                    System.out.print("Prioridad (1-Máxima, 10-Mínima): ");
                    int prioridad = sc.nextInt();
                    System.out.print("Uso de recursos (%): ");
                    int recursos = sc.nextInt();
                    
                    agc.cargarTarea(new Tarea(nombre, prioridad, recursos));
                    System.out.println("[OK] Tarea " + nombre + " añadida a la cola.");
                    break;

                case 3:
                    System.out.println("\n--- TAREAS EN BUFFER ---");
                    agc.mostrarTareasEnCola();
                    break;

                case 4:
                    System.out.println("\n[SISTEMA] Iniciando ciclo de procesamiento...");
                    agc.ejecutarCiclo();
                    break;

                case 5:
                    System.out.println("Cerrando sistemas... ¡Buena suerte, Comandante!");
                    break;

                default:
                    System.out.println("Error: Código de comando no reconocido.");
            }
        } while (opcion != 5);

        sc.close();
    }
}