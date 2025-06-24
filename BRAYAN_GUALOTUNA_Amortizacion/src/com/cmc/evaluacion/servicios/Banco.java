package com.cmc.evaluacion.servicios;

import com.cmc.evaluacion.entidades.Cliente;
import com.cmc.evaluacion.entidades.Prestamo;
import java.util.ArrayList;

public class Banco {
    private ArrayList<Cliente> clientes;
    private ArrayList<Prestamo> prestamos;

    public Banco() {
        this.clientes = new ArrayList<Cliente>();
        this.prestamos = new ArrayList<Prestamo>();
    }

    public void agregarCliente(Cliente cliente) {
        if (cliente != null) {
            this.clientes.add(cliente);
            System.out.println("Cliente agregado exitosamente: " + cliente.getNombre() + " " + cliente.getApellido());
        } else {
            System.out.println("Error: No se puede agregar un cliente nulo");
        }
    }

    public Cliente buscarCliente(String cedula) {
        if (cedula == null || cedula.length() == 0) {
            System.out.println("Error: La cédula no puede estar vacía");
            return null;
        }

        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getCedula().equals(cedula)) {
                return clientes.get(i);
            }
        }

        System.out.println("Cliente con cédula " + cedula + " no encontrado");
        return null;
    }

    public void registrarCliente(Cliente cliente) {
        if (cliente == null) {
            return;
        }

        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getCedula().equals(cliente.getCedula())) {
                return;
            }
        }

        this.clientes.add(cliente);
    }

    public void mostrarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados en el banco");
            return;
        }

        System.out.println("=== CLIENTES DEL BANCO ===");
        for (int i = 0; i < clientes.size(); i++) {
            System.out.print((i + 1) + ". ");
            clientes.get(i).mostrarCliente();
        }
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public int getNumeroClientes() {
        return clientes.size();
    }

    public void asignarPrestamo(String cedula, Prestamo prestamo) {
        Cliente cliente = buscarCliente(cedula);
        if (cliente != null && prestamo != null) {
            prestamo.setCedulaCliente(cedula);
            prestamos.add(prestamo);
        }
    }

    public ArrayList<Prestamo> buscarPrestamos(String cedula) {
        ArrayList<Prestamo> prestamosCliente = new ArrayList<Prestamo>();

        if (cedula != null) {
            for (int i = 0; i < prestamos.size(); i++) {
                if (prestamos.get(i).getCedulaCliente().equals(cedula)) {
                    prestamosCliente.add(prestamos.get(i));
                }
            }
        }

        return prestamosCliente;
    }
}
