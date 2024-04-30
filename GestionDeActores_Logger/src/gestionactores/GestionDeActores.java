package gestionactores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * *<strong>Representa una clase para gestionar los actores.</strong>
 * Esta clase se recoge los datos de los importes fijos y horas, se leen los
 * actores, se muestran todos los objetos introducidos y se muestran los objetos
 * de la clase perro.
 *
 * @author Moni
 * @version 2.0
 * @since 20.04.2024
 */
public class GestionDeActores {
//primero un logger static 

    private final static Logger Log_Raiz = Logger.getLogger("gestionactores");
    private final static Logger LOGGER = Logger.getLogger(GestionDeActores.class.getName());

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Contratable> actores = new ArrayList();

    private static void borrarConsolaPorDefecto() {
        Logger rootLogger = Logger.getLogger("");
        Handler[] handlers = rootLogger.getHandlers();
        if (handlers[0] instanceof ConsoleHandler) {
            rootLogger.removeHandler(handlers[0]);
        }
    }

    public static void main(String[] args) throws SecurityException, IOException {

        try {

            borrarConsolaPorDefecto();
            LOGGER.setLevel(Level.ALL);

            Handler fileHandlerWarning = new FileHandler("./gestionactoresWarning.log", true);
            Handler fileHandlerFinest = new FileHandler("./gestionactoresDetalle.log", true);

            fileHandlerWarning.setLevel(Level.WARNING);
            fileHandlerFinest.setLevel(Level.FINEST);

            SimpleFormatter simpleFormatter = new SimpleFormatter();

            fileHandlerWarning.setFormatter(simpleFormatter);
            fileHandlerFinest.setFormatter(simpleFormatter);

            Log_Raiz.addHandler(fileHandlerWarning);
            Log_Raiz.addHandler(fileHandlerFinest);

            leerImportes();
            leerActores();
            mostrarTodos();
            mostrarPerros();

        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, "Error de IO");
        } catch (SecurityException ex) {
            LOGGER.log(Level.SEVERE, "Error de Seguridad");
        }

    }

    public static void leerImportes() {///leer datos static
        LOGGER.log(Level.INFO, "LeerImportes - GestionActores - iniciado");
        double fijo, hora;
        do {
            System.out.print("Importe fijo: ");
            fijo = sc.nextDouble();
        } while (fijo < 1);
        do {
            System.out.print("Importe hora: ");
            hora = sc.nextDouble();
        } while (hora < 1);
        Actor.setImporteFijo(fijo);
        Actor.setPrecioHora(hora);
    }

    public static void leerActores() {
        int N, tipo, edad, horas, representaciones, x;
        String nif, nombre;
        Genero genero;
        RazaPerro raza;
        double sueldo;
        boolean repetido;
        Amateur amateur;
        Profesional profesional;
        PerroActor perro;

        do {
            System.out.print("Introduce número de actores: ");
            N = sc.nextInt();
        } while (N < 1);
        for (int i = 1; i <= N; i++) {
            do {
                System.out.print("Tipo de actor 1-> Amateur 2-> Profesional 3-> Perro ");
                tipo = sc.nextInt();
            } while (tipo != 1 && tipo != 2 && tipo != 3);
            sc.nextLine();
            if (tipo != 3) {/// Actor
                do {
                    repetido = false;
                    System.out.print("Nif: ");
                    nif = sc.nextLine();
                    if (existeId(nif)) {
                        System.out.println("Nif repetido");
                        repetido = true;
                    }
                } while (repetido);

                System.out.print("Nombre: ");
                nombre = sc.nextLine();

                do {
                    System.out.print("Edad: ");
                    edad = sc.nextInt();
                } while (edad < 0);

                do {
                    System.out.print("Genero 1-> Hombre 2-> Mujer ");
                    x = sc.nextInt();
                } while (x != 1 && x != 2);

                genero = Genero.values()[x - 1];

                if (tipo == 1) {//Actor Amateur
                    do {
                        System.out.print("Número de horas: ");
                        horas = sc.nextInt();
                    } while (horas < 0);
                    amateur = new Amateur(nif, nombre, edad, genero, horas);
                    actores.add(amateur);
                } else { //Actor Profesional
                    do {
                        System.out.print("Número de representaciones: ");
                        representaciones = sc.nextInt();
                    } while (representaciones < 0);
                    profesional = new Profesional(nif, nombre, edad, genero, representaciones);
                    actores.add(profesional);
                }
            } else {//Perro
                do {
                    repetido = false;
                    System.out.print("Identificador: ");
                    nif = sc.nextLine();
                    if (existeId(nif)) {
                        System.out.println("Identificador repetido");
                        repetido = true;
                    }
                } while (repetido);
                System.out.print("Nombre: ");
                nombre = sc.nextLine();
                do {
                    System.out.print("Edad: ");
                    edad = sc.nextInt();
                } while (edad < 0);
                do {
                    System.out.print("Raza 1-> CHIHUAHA 2-> BOXER 3-> PASTOR ALEMAN 4-> LABRADOR ");
                    x = sc.nextInt();
                } while (x < 1 || x > 4);

                raza = RazaPerro.values()[x - 1];
                do {
                    System.out.print("Sueldo: ");
                    sueldo = sc.nextDouble();
                } while (sueldo < 0);
                perro = new PerroActor(sueldo, raza, edad, nif, nombre);
                actores.add(perro);
            }
        }
        LOGGER.log(Level.INFO, "LeerImportes - GestionActores - finalizado");
    }

    public static void mostrarTodos() {
        LOGGER.log(Level.FINEST, "MostrarTodos - GestionActores - iniciado");
        System.out.println("Listado de todos los actores ordenados por sueldo\n");
        Collections.sort(actores, new Comparator<Contratable>() {
            @Override
            public int compare(Contratable o1, Contratable o2) { //ordenar todos por sueldo 
                if (o1.calcularSueldo() > o2.calcularSueldo()) {
                    return 1;
                } else if (o1.calcularSueldo() < o2.calcularSueldo()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        for (Contratable c : actores) {
            System.out.println(c);
        }
        LOGGER.log(Level.FINEST, "MostrarTodos - GestionActores - finalizado");
    }

    public static void mostrarPerros() {
        System.out.println("Listado alfabético de todos los perros\n");
        ArrayList<PerroActor> perros = new ArrayList();
        for (Contratable c : actores) {
            if (c instanceof PerroActor) {
                perros.add((PerroActor) c);
            }
        }
        if (!perros.isEmpty()) {
            Collections.sort(perros); //ordenar perros por nombre
            for (PerroActor p : perros) {
                System.out.println(p);
            }
        } else {
            System.out.println("No hay perros");
        }
    }

    public static boolean existeId(String id) {
        LOGGER.log(Level.SEVERE, "existeId - GestionActores - iniciado");
        Amateur a = new Amateur();
        Profesional p = new Profesional();
        PerroActor pa = new PerroActor();
        a.setNif(id);
        p.setNif(id);
        pa.setId(id);
        if (actores.contains(p) || actores.contains(a) || actores.contains(pa)) {
            return true;
        }
        return false;
    }
}
