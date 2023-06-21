package Programa;
import Auxiliares.Entry;
import Auxiliares.Par;
import Auxiliares.Position;
import Auxiliares.Comparador2;
import Excepciones.EmptyPriorityQueueException;
import Excepciones.InvalidKeyException;
import Excepciones.InvalidPositionException;
import TDAColaCP.Comparador;
import TDAColaCP.Heap;
import TDAColaCP.PriorityQueue;
import TDADiccionario.Dictionary;
import TDADiccionario.DiccionarioHash;
import TDALista.PositionList;
import TDALista.ListaDE;
/**
 * Clase que representa la implementación de la lógica del programa.
 */
public class Programa {
    protected String Materia;
    protected PositionList<Par<Integer, Integer>> registroAlumnos;

    /**
     * Inicializa un registro de alumnos.
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public Programa() {
        registroAlumnos = new ListaDE();
    }

    /**
     * Establece la materia en la que se encuentra el programa.
     *
     * @param s la materia a establecer.
     */
    public void setMateria(String s) {
        this.Materia = s;
    }

    /**
     * Obtiene la materia en la que se encuentra el programa.
     *
     * @return la materia en la que se encuentra el programa.
     */
    public String getMateria() {
        return this.Materia;
    }

    /**
     * Agrega un alumno al registro de alumnos, si no está presente.
     *
     * @param e el alumno a agregar.
     * @return true si el alumno fue agregado al registro, false si ya estaba presente.
     */
    public Boolean setAlumno(Par<Integer, Integer> e) {
        boolean cumplio = false;
        if (this.getAlumnoLu(e.getValue()) == null) {
            registroAlumnos.addLast(e);
            cumplio = true;
        }
        return cumplio;
    }

    /**
     * Busca un alumno en el registro por su número de legajo (LU).
     *
     * @param lu el número de legajo del alumno.
     * @return el alumno con el número de legajo especificado, o null si no se encuentra.
     */
    public Par<Integer, Integer> getAlumnoLu(int lu) {
        Par<Integer, Integer> e = null;
        for (Par<Integer, Integer> p : registroAlumnos) {
            if (p.getValue().equals(lu)) {
                e = p;
                break;
            }
        }
        return e;
    }

    /**
     * Elimina un alumno del registro por su número de legajo (LU).
     *
     * @param lu el número de legajo del alumno a eliminar.
     * @return true si se encontró y eliminó al alumno, false si el alumno no estaba en el registro.
     */
    public Boolean eliminarAlumnoLu(int lu) {
        boolean cumplio = false;
        for (Position<Par<Integer, Integer>> p : registroAlumnos.positions()) {
            if (p.element().getValue().equals(lu)) {
                try {
                    registroAlumnos.remove(p);
                    cumplio = true;
                } catch (InvalidPositionException e1) {
                }
                break;
            }
        }
        return cumplio;
    }

    /**
     * Obtiene los alumnos aprobados con una nota mayor o igual a 60.
     *
     * @return alumnos aprobados.
     */
    public PositionList<Par<Integer, Integer>> getAlumnosAprobados() {
        PositionList<Par<Integer, Integer>> aprobados = new ListaDE<>();
        for (Par<Integer, Integer> alumno : registroAlumnos) {
            if (alumno.getKey() >= 60) {
                aprobados.addLast(alumno);
            }
        }
        return aprobados;
    }

    /**
     * Obtiene los alumnos desaprobados con una nota menor a 60.
     *
     * @return alumnos desaprobados.
     */
    public PositionList<Par<Integer, Integer>> getAlumnosDesaprobados() {
        PositionList<Par<Integer, Integer>> desaprobados = new ListaDE<>();
        for (Par<Integer, Integer> alumno : registroAlumnos) {
            if (alumno.getKey() < 60) {
                desaprobados.addLast(alumno);
            }
        }
        return desaprobados;
    }

    /**
     * Calcula el promedio de todas las notas de los alumnos en el registro.
     *
     * @return el promedio de notas redondeado a entero.
     */
    public int calcularPromedio() {
        int promedio = 0;
        for (Par<Integer, Integer> p : registroAlumnos) {
            promedio = promedio + p.getKey();
        }
        return promedio / registroAlumnos.size();
    }

    /**
     * Consulta los alumnos que tienen una nota especificada.
     *
     * @param nota la nota a buscar.
     * @return un iterable con los alumnos que tienen la nota especificada.
     */
    public Iterable<Entry<Integer, Integer>> alumnosConNota(int nota) {
        Dictionary<Integer, Integer> d = new DiccionarioHash<>();
        Iterable<Entry<Integer, Integer>> e = null;
        for (Par<Integer, Integer> p : registroAlumnos) {
            try {
                d.insert(p.getKey(), p.getValue());
            } catch (InvalidKeyException e2) {
            }
        }
        try {
            e = d.findAll(nota);
        } catch (InvalidKeyException e1) {
        }

        return e;
    }

    /**
     * Obtiene la nota mínima entre todas las notas de los alumnos en el registro.
     *
     * @return la nota mínima.
     */
    public int NotaMinima() {
        PriorityQueue<Integer, Integer> pq = new Heap<>(new Comparador<>());
        int toReturn = 0;
        for (Par<Integer, Integer> p : registroAlumnos) {
            try {
                pq.insert(p.getKey(), p.getValue());
            } catch (InvalidKeyException e) {
            }
        }
        try {
            toReturn = pq.min().getKey();
        } catch (EmptyPriorityQueueException e) {
        }

        return toReturn;
    }

    /**
     * Obtiene las notas de los alumnos ordenadas de mayor a menor.
     *
     * @return las notas de los alumnos ordenadas de mayor a menor.
     */
    public PositionList<Entry<Integer, Integer>> NotaMayorMenor() {
        PriorityQueue<Integer, Integer> pq = new Heap<>(new Comparador2<>());
        PositionList<Entry<Integer, Integer>> pl = new ListaDE<>();
        for (Par<Integer, Integer> p : registroAlumnos) {
            try {
                pq.insert(p.getKey(), p.getValue());
            } catch (InvalidKeyException e2) {
            }
        }
        try {
            while (pq.size() != 0) {
                pl.addLast(pq.removeMin());
            }
        } catch (EmptyPriorityQueueException e1) {
        }

        return pl;
    }
}
