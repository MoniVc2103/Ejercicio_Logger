package gestionactores;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * *<strong>Representa una clase amateur.</strong>
 * Esta clase representa un amateur que extiende de la clase Actor.
 *
 * <p>
 * Los atributos de esta clase son:</p>
 * <ul>
 * <li>{@code numeroHoras}: numero de horas que ha trabajado el actor.</li>
 * </ul>
 *
 * @author Moni
 * @version 2.0
 * @since 19.04.2024
 */
public class Amateur extends Actor {

    private final static Logger LOGGER = Logger.getLogger(Amateur.class.getName());
    /**
     * Número de horas trabajadas por el actor.
     */
    private int numeroHoras;

    public Amateur() {
    }

    /**
     * <strong>Constructor.</strong>
     *
     * @param nif nif: identificador de cada amateur.
     * @param nombre nombre.
     * @param edad edad.
     * @param genero genero: hombre o mujer.
     * @param numeroHoras horas trabajadas.
     */
    public Amateur(String nif, String nombre, int edad, Genero genero, int numeroHoras) {
        super(nif, nombre, edad, genero);
        this.numeroHoras = numeroHoras;
        LOGGER.log(Level.FINE, "Constructor - Amateur - finalizado");
    }

    /**
     * <strong>Recupera el valor de las horas.</strong>
     *
     * @return numeroHoras.
     */
    public int getNumeroHoras() {
        return numeroHoras;
    }

    /**
     * <strong>Asigna el valor de las horas.</strong>
     *
     * @param numeroHoras
     */
    public void setNumeroHoras(int numeroHoras) {
        this.numeroHoras = numeroHoras;
    }

    /**
     * <strong>Calcula el valor del sueldo correspondiente segun las
     * horas</strong>
     * <p>
     * Se multiplica el numero de horas por el precio de horas</p>
     *
     * @return numeroHoras * Valor de la hora.
     */
    @Override
    public double calcularSueldo() {
        return numeroHoras * Actor.getPrecioHora();
    }

    /**
     * Devuelve una representación de cadena de este objeto.
     *
     * @return Una cadena que representa este objeto.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Actor Amateur ");
        sb.append(super.toString());
        sb.append(" Horas: ");
        sb.append(numeroHoras);
        sb.append(String.format(" Sueldo: %,.2f", calcularSueldo()));
        sb.append("\n");
        LOGGER.log(Level.FINE, "ToString - Amateur - finalizado");
        return sb.toString();

    }

}
