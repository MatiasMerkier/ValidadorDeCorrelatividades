package Models;

import java.util.ArrayList;

public class Materia {

  // Properties
  private String Nombre;
  private ArrayList<Materia> Correlativas = new ArrayList<>();

  // Constructor
  public Materia(String nombre, ArrayList<Materia> correlativas){
    this.Nombre = nombre;
    this.Correlativas = correlativas;
  }

  // Getters
  public String getNombre() { return this.Nombre; }
  public ArrayList<Materia> getCorrelativas() { return this.Correlativas; }

  // Setters
  public void setNombre(String nombre) { this.Nombre = nombre; }
  public void setCorrelativas(ArrayList<Materia> correlativas) { this.Correlativas = correlativas; }

  // Methods
  public void addCorrelativa(Materia materia) { this.Correlativas.add(materia); }
  public void addCorrelativa(ArrayList<Materia> materias) { this.Correlativas.addAll(materias); }
}
