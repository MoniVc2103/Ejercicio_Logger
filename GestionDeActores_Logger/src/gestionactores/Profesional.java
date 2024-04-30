package gestionactores;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * *<strong>Representa una clase Prfoesional que extiende de actor.</strong>
 * Esta clase representa un actor profesional.
 *
 * <p>
 * Los atributos de esta clase son:</p>
 * <ul>
 * <li>{@code numeroRepresentaciones}: Representaciones que ha hecho el
 * actor.</li>
 * </ul>
 *
 * @author Moni
 * @version 2.0
 * @since 19.04.2024
 */
public class Profesional extends Actor {

    private final static Logger LOGGER = Logger.getLogger(Profesional.class.getName());

    /**
     * Numero de representaciones. Cantidad de representaciones que ha hecho el
     * actor.
     */
    private int numeroDeRepresentaciones;

    public Profesional() {
    }

    /**
     * <strong>Constructor.</strong>
     *
     * @param nif nif: identificador de cada profesional.
     * @param nombre nombre.
     * @param edad edad.
     * @param genero genero: hombre o mujer.
     * @param numeroDeRepresentaciones Representaciones realizadas por el
     * profesional.
     */
    public Profesional(String nif, String nombre, int edad, Genero genero, int numeroDeRepresentaciones) {
        super(nif, nombre, edad, genero);
        this.numeroDeRepresentaciones = numeroDeRepresentaciones;
        LOGGER.log(Level.INFO, "constructor - Profesional - finalizado");
    }

    /**
     * <strong>Recupera el valor del numero de representaciones.</strong>
     *
     * @return numeroDeRepresentaciones.
     */
    public int getNumeroDeRepresentaciones() {
        return numeroDeRepresentaciones;
    }

    /**
     * <strong>Asigna el valor del numero de representaciones.</strong>
     *
     * @param numeroDeRepresentaciones.
     */
    public void setNumeroDeRepresentaciones(int numeroDeRepresentaciones) {
        this.numeroDeRepresentaciones = numeroDeRepresentaciones;
        LOGGER.log(Level.CONFIG, "setNumeroRepresentaciones - Profesional - finalizado");
    }

    /**
     * <strong>Calcula el valor del sueldo correspondiente segun la cantidad de
     * representaciones</strong>
     * <p>
     * Se multiplica el numero de representaciones por el importe fijo</p>
     *
     *  * @return numero de representaciones * importe fijo.
     * @return
     */
    @Override
    public double calcularSueldo() {
        return numeroDeRepresentaciones * Actor.getImporteFijo();

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
        sb.append(" Representaciones: ");
        sb.append(numeroDeRepresentaciones);
        sb.append(String.format(" Sueldo: %,.2f", calcularSueldo()));
        sb.append("\n");
        return sb.toString();
    }

}
