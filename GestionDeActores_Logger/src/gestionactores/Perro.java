package gestionactores;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * *<strong>Representa una clase perro.</strong>
 * Esta clase representa un perro que extiende de la clase Animal.
 *
 * <p>
 * Los atributos de esta clase son:</p>
 * <ul>
 * <li>{@code RazaPerro}: Raza a la que pertenece el perro</li>
 * <li>{@code edad}: edad del el perro</li>
 * </ul>
 *
 * @author Moni
 * @version 2.0
 * @since 19.04.2024
 */
public class Perro extends Animal {

    private final static Logger LOGGER = Logger.getLogger(Perro.class.getName());
    /**
     * Raza del perro. raza del perro.
     */
    private RazaPerro raza;

    /**
     * Edad del perro. edad del perro.
     */
    private int edad;

    public Perro() {
    }

    /**
     * <strong>Constructor.</strong>
     *
     * @param raza raza: raza de perro.
     * @param edad edad.
     * @param identificador. El id del animal define su identificación siendo
     * unica para cada uno.
     * @param nombre nombre.
     */
    public Perro(RazaPerro raza, int edad, String identificador, String nombre) {
        super(identificador, nombre);
        this.raza = raza;
        this.edad = edad;
        LOGGER.log(Level.FINEST, "constructor - Perro - finalizado");
    }

    /**
     * <strong>Recupera el valor de la raza.</strong>
     *
     * @return raza.
     */
    public RazaPerro getRaza() {
        return raza;
    }

    /**
     * <strong>Asigna el valor de la raza.</strong>
     *
     * @param raza
     */
    public void setRaza(RazaPerro raza) {
        this.raza = raza;
        LOGGER.log(Level.CONFIG, "setRaza - Animal - finalizado");
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
     * Devuelve una representación de cadena de este objeto.
     *
     * @return Una cadena que representa este objeto.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(" Raza: ").append(raza);
        sb.append(" Edad: ").append(edad);
        return sb.toString();
    }

}
