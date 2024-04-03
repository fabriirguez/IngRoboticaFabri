package edu.ucj.programacion.pec1.Fabricio_Andree_Rodriguez;

import java.util.ArrayList;
import java.util.Scanner;

// Clase para representar un vehículo 
class Autobus {
    private int numero;
    private String destino;
    private int plazasDisponibles;

    // Constructor de la clase Autobus
    public Autobus(int numero, String destino) {
        this.numero = numero;
        this.destino = destino;
    }

    // Métodos de acceso para obtener los datos del autobús
    public int getNumero() {
        return numero;
    }

    public String getDestino() {
        return destino;
    }

    public int getPlazasDisponibles() {
        return plazasDisponibles;
    }

    public void setPlazasDisponibles(int plazasDisponibles) {
        this.plazasDisponibles = plazasDisponibles;
    }
}

// Clase para representar un Pasajero
class Cliente {
    private int id;
    private String nombre;
    private String destino;

    // Constructor de la clase Cliente
    public Cliente(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    // Métodos de acceso para obtener los atributos del cliente    
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }
}

// Clase principal del programa utilizando el método main
public class Viajes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear empresa para almacenar autobuses
        ArrayList<Autobus> empresa = new ArrayList<>();

        // Crear autobuses
        System.out.println("¿Cuántos autobuses tiene la empresa?");
        int numAutobuses = scanner.nextInt();

        for (int i = 0; i < numAutobuses; i++) {
            System.out.println("Ingrese el número del autobús:");
            int numero = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            System.out.println("Ingrese el destino del autobús:");
            String destino = scanner.nextLine();
            System.out.println("Ingrese el número de plazas del autobús:");
            int plazas = scanner.nextInt();
            empresa.add(new Autobus(numero, destino));
            empresa.get(i).setPlazasDisponibles(plazas);
        }

        // Crear lista para almacenar los clientes
        System.out.println("¿Cuántos clientes desea asignar?");
        int numClientes = scanner.nextInt();

        ArrayList<Cliente> clientes = new ArrayList<>();

        // Solicitar información de cada cliente y almacenarla en la lista
        for (int i = 0; i < numClientes; i++) {
            System.out.println("Ingrese el ID del cliente:");
            int id = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            System.out.println("Ingrese el nombre del cliente:");
            String nombre = scanner.nextLine();
            clientes.add(new Cliente(id, nombre));
        }

        // Asignar destino a cada cliente
        for (Cliente cliente : clientes) {
            System.out.println("Hola " + cliente.getNombre() + ", ¿a qué destino deseas ir?");
            String destino = scanner.nextLine();
            boolean asignado = false;
            for (Autobus autobus : empresa) {
                if (autobus.getDestino().equalsIgnoreCase(destino) && autobus.getPlazasDisponibles() > 0) {
                    cliente.setDestino(destino);
                    autobus.setPlazasDisponibles(autobus.getPlazasDisponibles() - 1);
                    asignado = true;
                    System.out.println("Asignado al autobús con número " + autobus.getNumero());
                    break;
                }
            }
            if (!asignado) {
                System.out.println("Lo siento, no hay autobuses disponibles para tu destino.");
            }
        }

        // Mostrar asignaciones de clientes por autobús
        System.out.println("Asignaciones de clientes:");
        for (Autobus autobus : empresa) {
            System.out.println("Autobús con número " + autobus.getNumero() + " - Destino: " + autobus.getDestino());
            System.out.println("Clientes:");
            for (Cliente cliente : clientes) {
                if (cliente.getDestino() != null && cliente.getDestino().equalsIgnoreCase(autobus.getDestino())) {
                    System.out.println("- " + cliente.getNombre());
                }
            }
            System.out.println();
        }

        scanner.close();
    }
}

