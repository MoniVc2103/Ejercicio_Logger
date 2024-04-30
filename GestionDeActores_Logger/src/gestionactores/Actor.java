package gestionactores;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * *<strong>Representa una clase actor que implementa la interfaz
 * contratable.</strong>
 * Esta clase representa un actor contratable con un nif, nombre, edad,genero,
 * importe fijo(precio por actuacion) y precio por hora.
 *
 * <p>
 * Los atributos de esta clase son:</p>
 * <ul>
 * <li>{@code nif}: identificativo del actor.</li>
 * <li>{@code nombre}: nombre del actor.</li>
 * <li>{@code edad}: edad del actor.</li>
 * <li>{@code genero}: genero del actor.</li>
 * <li>{@code importeFijo}: importe a pagar a los actores profesionales por cada
 * representacion.</li>
 * <li>{@code precioHora}: importe a pagar a los actores amateur por hora de
 * trabajo.</li>
 * </ul>
 *
 * @author Moni
 * @version 2.0
 * @since 20.04.2024
 */
public abstract class Actor implements Contratable {

    private final static Logger LOGGER = Logger.getLogger(Actor.class.getName());
    /**
     * Nif del actor. El nif del actor define su identificación siendo unica
     * para cada uno.
     */
    private String nif;

    /**
     * Nombre del actor.
     */
    private String nombre;

    /**
     * Edad del actor.
     */
    private int edad;

    /**
     * Genero del actor. El genero del actor define si es hombre o mujer.
     */
    private Genero genero;
    /**
     * Importe fijo del actor. Importe a pagar por cada representacion de un
     * actor profesional.
     */
    private static double importeFijo;

    /**
     * Precio por hora. Importe a pagar por hora de trabajo de un actor amateur.
     */
    private static double precioHora;

    /**
     *
     */
    public Actor() {
    }

    /**
     * <strong>Constructor.</strong>
     *
     * @param nif nif: identificador de cada actor.
     * @param nombre nombre.
     * @param edad edad.
     * @param genero genero: hombre o mujer.
     */
    public Actor(String nif, String nombre, int edad, Genero genero) {
        LOGGER.log(Level.WARNING, "Constructor - Actor - iniciado");
        this.nif = nif;
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
        LOGGER.log(Level.WARNING, "Constructor - Actor - finalizado");
    }

    /**
     * <strong>Recupera el valor del nif.</strong>
     *
     * @return nif.
     */
    public String getNif() {
        return nif;
    }

    /**
     * <strong>Asigna el valor del nif.</strong>
     *
     * @param nif
     */
    public void setNif(String nif) {
        this.nif = nif;
    }

    /**
     * <strong>Recupera el valor del nombre.</strong>
     *
     * @return nombre.
     */
    public String getNombre() {
         LOGGER.log(Level.CONFIG, "getNombre - Actor - iniciado");
        return nombre;
    }

    /**
     * <strong>Asigna el valor del nombre.</strong>
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * <strong>Recupera el valor de la edad.</strong>
     *
     * @return edad.
     */
    public int getEdad() {
        return edad;
    }

    /**
     * <strong>Asigna el valor de la edad.</strong>
     *
     * @param edad
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * <strong>Recupera el valor del genero.</strong>
     *
     * @return genero: hombre o mujer.
     */
    public Genero getGenero() {
        return genero;
    }

    /**
     * <strong>Asigna el valor del genero.</strong>
     * hombre o mujer.
     *
     * @param genero
     */
    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    /**
     * <strong>Recupera el valor del importe fijo de actores
     * profesionales</strong>
     *
     * @return importeFijo.
     */
    public static double getImporteFijo() {
        return importeFijo;
    }

    /**
     * <strong>Asigna el valor del importe fijo de actores
     * profesionales.</strong>
     *
     * @param importeFijo
     */
    public static void setImporteFijo(double importeFijo) {
        Actor.importeFijo = importeFijo;
    }

    /**
     * <strong>Recupera el valor del importe fijo de actores amateur.</strong>
     *
     * @return importeFijo.
     */
    public static double getPrecioHora() {
        return precioHora;
    }

    /**
     * <strong>Asigna el valor del precio por horas de actores amateur.</strong>
     *
     * @param precioHora
     */
    public static void setPrecioHora(double precioHora) {
        Actor.precioHora = precioHora;
    }

    /**
     * Devuelve una representación de cadena de este objeto.
     *
     * @return Una cadena que representa este objeto.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(nif);
        sb.append(" ");
        sb.append(nombre);
        sb.append(" Edad: ");
        sb.append(edad);
        sb.append(" ");
        sb.append(genero);
        return sb.toString();
    }

    /**
     * <strong>Compara los nif´s de los actores para comprobar si ya existe.
     * Equals</strong>
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.nif);
        return hash;
    }

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Actor other = (Actor) obj;
        if (!this.nif.equalsIgnoreCase(other.nif)) {
            return false;
        }
        return true;
    }

}
