package gestionactores;


/**
 * Esta es una interfaz que define el comportamiento de un objeto contratable.
 * Las clases que implementan esta interfaz deben proporcionar una
 * implementación para el método calcularSueldo().
 */
public interface Contratable {

    /**
     * Método que indica que el objeto tiene un sueldo. Este método debe ser
     * implementado por las clases que implementan esta interfaz.
     *
     * @return
     */
    double calcularSueldo();
}
