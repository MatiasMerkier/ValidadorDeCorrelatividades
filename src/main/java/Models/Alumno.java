package Models;

import java.util.ArrayList;

public class Alumno {

  //Properties
  private  String Nombre;
  private  String Apellido;
  private  String Legajo;
  private ArrayList<Materia> MateriasAprobadas = new ArrayList<>();

  // Constructor
  public Alumno(
      String nombre,
      String apellido,
      String legajo)
  {
    this.Nombre = nombre;
    this.Apellido = apellido;
    this.Legajo = legajo;
  }

  // Getters
  public String getNombre() { return this.Nombre; }
  public String getApellido() { return this.Apellido; }
  public String getLegajo() { return this.Legajo; }
  public ArrayList<Materia> getMateriasAprobadas() { return this.MateriasAprobadas; }

  // Methods
  public void addMateriasAprobadas(Materia materia){ this.MateriasAprobadas.add(materia); }
  public void addMateriasAprobadas(ArrayList<Materia> materias){ this.MateriasAprobadas.addAll(materias); }
}
