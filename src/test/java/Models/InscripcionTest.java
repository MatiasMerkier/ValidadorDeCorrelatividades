package Models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InscripcionTest {

  @Test
  public void InscripcionAprobada(){
    var alumno = new Alumno("Matias","Merkier","2038493");
    var algoritmos = new Materia("Algoritmos", new ArrayList<>());
    var paradigmas = new Materia("Paradigmas De Programacion", new ArrayList<>(List.of(algoritmos)));
    var dds = new Materia("Diseño de sistemas", new ArrayList<>(List.of(paradigmas)));

    alumno.addMateriasAprobadas(new ArrayList<>(List.of(paradigmas, algoritmos)));
    var inscripcion = new Inscripcion(alumno, new ArrayList<>(List.of(dds)));

    Assertions.assertTrue(inscripcion.aprobada());
    // DDS necesita a paradigmas, y paradigmas necesita a algoritmos
    // Por lo tanto debe tener las 2 aprobadas
  }

  @Test
  public void InscripcionRechazada(){
    var alumno = new Alumno("Matias","Merkier","2038493");
    var algoritmos = new Materia("Algoritmos", new ArrayList<>());
    var paradigmas = new Materia("Paradigmas De Programacion", new ArrayList<>(List.of(algoritmos)));
    var discreta = new Materia("Matematica Discreta", new ArrayList<>());
    var dds = new Materia("Diseño de sistemas", new ArrayList<>(List.of(paradigmas, discreta)));

    alumno.addMateriasAprobadas(new ArrayList<>(List.of(paradigmas, algoritmos)));
    var inscripcion = new Inscripcion(alumno, new ArrayList<>(List.of(dds)));

    Assertions.assertFalse(inscripcion.aprobada());
    // DDS Ahora ademas de necesitar a algoritmos y paradigmas tambien necesita a discreta
  }


}