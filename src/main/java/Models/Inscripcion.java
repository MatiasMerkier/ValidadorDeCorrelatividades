package Models;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Inscripcion {

  // Properties
  private Alumno Alumno;
  private ArrayList<Materia> MateriasDeseadas;

  // Constructor
  public Inscripcion(Alumno alumno, ArrayList<Materia> materiasDeseadas)
  {
    this.Alumno = alumno;
    this.MateriasDeseadas = materiasDeseadas;
  }

  // Getters
  public Alumno getAlumno() { return this.Alumno; }
  public ArrayList<Materia> getMaterias() { return this.MateriasDeseadas; }

  // Sin Setter ya que no se deberia poder cambiar el alumno de una inscripcion

  // Methods
  public void addMateria(Materia materia) { this.MateriasDeseadas.add(materia); }
  public void addMateria(ArrayList<Materia> materias) { this.MateriasDeseadas.addAll(materias); }
  public void deleteMateria(Materia materia) {
    if(this.MateriasDeseadas.contains(materia)) this.MateriasDeseadas.remove(materia);
  }

  // Metodo principal pedido
  public boolean aprobada(){
    // ACLARACION!
    // Tomo en cuenta que el alumno tiene todas las materias aprobadas, es decir
    // Si DDS necesita tener PDP aprobada, y PDP necesita a algoritmos
    // y si el alumno tiene aprobado PDP, entonces tambien va a tener aprobado Algoritmos en su lista
    return this.Alumno.getMateriasAprobadas().containsAll(getCorrelativasRecursivas(this.MateriasDeseadas));
  }

  private ArrayList<Materia> getCorrelativasRecursivas(ArrayList<Materia> materiasDeseadas) {
    ArrayList<Materia> resultado = new ArrayList<>();
    for (Materia m : materiasDeseadas) {
      obtenerCorrelativas(m, resultado);
    }
    return resultado;
  }

  private void obtenerCorrelativas(Materia materia, ArrayList<Materia> acumulador) {
    for (Materia correlativa : materia.getCorrelativas()) {
      if (!acumulador.contains(correlativa)) { // Verifico duplicados
        acumulador.add(correlativa);
        obtenerCorrelativas(correlativa, acumulador);
      }
    }
  }

}
