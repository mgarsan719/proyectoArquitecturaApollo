package priorizacionTareas;

public class MainPriorizacion {
	public static void main(String[] args) {
		ProcesosApollo agc = new ProcesosApollo();

		// 1. Tareas críticas
		agc.cargarTarea(new Tarea("Aterrizaje (LGC)", 1, 60));
		agc.cargarTarea(new Tarea("Telemetría MSFN", 2, 20));

		// 2. Tareas secundarias que causarán el desbordamiento
		// (Similar al radar de encuentro que se dejó encendido por error en el 69)
		agc.cargarTarea(new Tarea("Radar de Encuentro", 5, 30));
		agc.cargarTarea(new Tarea("Actualización Pantalla", 8, 15));

		// Ejecución del ciclo de CPU
		agc.ejecutarCiclo();
	}
}