package priorizacionTareas;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProcesosApollo {
	private List<Tarea> tareasActivas = new ArrayList<>();

    public void cargarTarea(Tarea t) {
        tareasActivas.add(t);
    }

    public void ejecutarCiclo() {
        int cargaTotal = calcularCargaTotal();

        System.out.println("\n--- ESTADO ACTUAL DEL AGC (Apollo Guidance Computer) ---");
        tareasActivas.forEach(t -> System.out.println("EJECUTANDO: " + t));

        if (cargaTotal > 100) {
            ejecutarFiltroHamilton(cargaTotal);
        } else {
            System.out.println("[STATUS] - NOMINAL. Carga del sistema: " + cargaTotal + "%");
        }
    }

    private void ejecutarFiltroHamilton(int cargaActual) {
        // Formato NASA para el log de consola
        System.err.println("\n[ALERTA 1202] - SOBRECARGA DETECTADA: " + cargaActual + "%");
        System.err.println("[SISTEMA] - Ejecutando Filtro Hamilton. Purgando tareas secundarias (P > 3)...");

        // REQUISITO 4: El hilo "Aterrizaje" (P1) es intocable
        // Esta lógica es agnóstica a la UI, ideal para mover a JS después
        this.tareasActivas = tareasActivas.stream()
                .filter(t -> t.getPrioridad() <= 3 || t.getNombre().equalsIgnoreCase("Aterrizaje"))
                .collect(Collectors.toList());

        System.out.println("\n[ESTADO FINAL] - CPU ESTABILIZADA");
        System.out.println("Nueva carga: " + calcularCargaTotal() + "%");
        tareasActivas.forEach(t -> System.out.println("MANTENIDO: " + t));
        System.out.println("---------------------------------------------------\n");
    }

    private int calcularCargaTotal() {
        return tareasActivas.stream().mapToInt(Tarea::getUsoRecursos).sum();
    }
}