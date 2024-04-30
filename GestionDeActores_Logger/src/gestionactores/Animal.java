package gestionactores;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * *<strong>Representa un animal.</strong>
 * Esta clase representa un animal con un id y un nombre.
 *
 * <p>
 * Los atributos de esta clase son:</p>
 * <ul>
 * <li>{@code id}: identificativo del animal.</li>
 * <li>{@code nombre}: nombre del animal.</li>
 * </ul>
 *
 * @author Moni
 * @version 2.0
 * @since 20.04.2024
 */
public abstract class Animal implements Comparable<Animal> {

    private final static Logger LOGGER = Logger.getLogger(Animal.class.getName());
    /**
     * Id del animal. El id del animal define su identificación siendo unica
     * para cada uno.
     */
    private String id;

    /**
     * Nombre del animal.
     */
    private String nombre;

    public Animal() {
    }

    /**
     * <strong>Constructor.</strong>
     *
     * @param identificador. El id del animal define su identificación siendo
     * unica para cada uno.
     * @param nombre nombre.
     */
    public Animal(String identificador, String nombre) {
        this.id = identificador;
        this.nombre = nombre;
        LOGGER.log(Level.CONFIG, "constructor - Animal - finalizado");
    }

    /**
     * <strong>Recupera el valor del id.</strong>
     *
     * @return id.
     */
    public String getId() {
        return id;
    }

    /**
     * <strong>Asigna el valor del id.</strong>
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * <strong>Recupera el valor del nombre.</strong>
     *
     * @return nombre.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * <strong>Asigna el valor del nombre.</strong>
     *
     * @param nombre.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
        LOGGER.log(Level.CONFIG, "setNombre - Animal - finalizado");
    }

    /**
     * <strong>Muestra todos los atributos de animal.</strong>
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(id);
        sb.append(" ").append(nombre);
        return sb.toString();
    }

    /**
     * <strong>Compara los nombres de cada animal para ordenar</strong>
     *
     * @param t
     */
    @Override
    public int compareTo(Animal t) {
        return this.nombre.compareToIgnoreCase(t.nombre);
    }

    /**
     * <strong>Compara los id´s de los animales para comprobar si ya existe.
     * Equals</strong>
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.id);
        return hash;
    }

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
        final Animal other = (Animal) obj;
        if (!this.id.equalsIgnoreCase(other.id)) {
            return false;
        }
        return true;
    }
}
