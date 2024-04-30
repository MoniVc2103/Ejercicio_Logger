/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestionactores;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * *<strong>Representa una clase perro actor que extiende de la clase perro e
 * implementa la interfaz contratable.</strong>
 * Esta clase representa un perro actor con sueldo.
 *
 * <p>
 * Los atributos de esta clase son:</p>
 * <ul>
 * <li>{@code sueldo}: sueldo del perro actor.</li>
 * </ul>
 *
 * @author Moni
 * @version 2.0
 * @since 20.04.2024
 */
public class PerroActor extends Perro implements Contratable {

    private final static Logger LOGGER = Logger.getLogger(PerroActor.class.getName());
    /**
     * Sueldo del perro actor.
     */
    private double sueldo;

    /**
     *
     */
    public PerroActor() {
    }

    /**
     * <strong>Constructor.</strong>
     *
     * @param sueldo sueldo: sueldo del perro.
     * @param raza raza: raza de perro.
     * @param edad edad.
     * @param identificador. El id del animal define su identificación siendo
     * unica para cada uno.
     * @param nombre nombre.
     */
    public PerroActor(double sueldo, RazaPerro raza, int edad, String identificador, String nombre) {
        super(raza, edad, identificador, nombre);
        this.sueldo = sueldo;
        LOGGER.log(Level.SEVERE, "Constructor - PerroActor - finalizado");
    }

    /**
     * <strong>Recupera el valor del sueldo.</strong>
     *
     * @return sueldo.
     */
    public double getSueldo() {
        return sueldo;
    }

    /**
     * <strong>Asigna el valor del sueldo.</strong>
     *
     * @param sueldo
     */
    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    /**
     * <strong>Calcula el valor del sueldo correspiente segun la raza y la
     * edad</strong>
     * <p>
     * Si el perro es de la raza pastor y tiene mas de 10 años, se le añade un
     * 10%.
     *
     * @return sueldo.
     */
    @Override
    public double calcularSueldo() {
        LOGGER.log(Level.SEVERE, "calcularSueldo - PerroActor - iniciado");
        if (this.getRaza() == RazaPerro.PASTORALEMAN && this.getEdad() >= 10) {
            return this.sueldo + this.sueldo * 10 / 100;
        }
        return this.sueldo;

    }

    /**
     * Devuelve una representación de cadena de este objeto.
     *
     * @return Una cadena que representa este objeto.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Perro ");
        sb.append(super.toString());
        sb.append(String.format(" sueldo: %,.2f\n", calcularSueldo()));
        return sb.toString();
    }

}
