package priorizacionTareas;

public class Tarea {
	private String nombre;
	private int prioridad; // 1 = Máxima, 10 = Mínima
	private int usoRecursos;

	public Tarea(String nombre, int prioridad, int usoRecursos) {
		this.nombre = nombre;
		this.prioridad = prioridad;
		this.usoRecursos = usoRecursos;
	}

	// Getters
	public String getNombre() {
		return nombre;
	}

	public int getPrioridad() {
		return prioridad;
	}

	public int getUsoRecursos() {
		return usoRecursos;
	}

	@Override
	public String toString() {
		return String.format("[%s | Prioridad: %d | Carga: %d%%]", nombre, prioridad, usoRecursos);
	}
}