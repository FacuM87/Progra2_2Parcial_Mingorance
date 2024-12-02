package model;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import negocio.GestorReservas;

public abstract class Excursion implements Serializable {

    private static int contadorId = 1;
    protected int id;
    protected String titulo;
    protected double precioBase;
    protected int cupoMaximo;
    protected transient GestorReservas gestorReservas;
    protected List<String> actividades;

    public Excursion(String titulo, double precioBase, int cupoMaximo) {
        this.id = contadorId++;
        if(titulo == null || titulo.length()<3){
            throw new IllegalArgumentException("El titulo no puede tener menos de 3 caracteres");
        } else {
            this.titulo = titulo;
        }
        
        this.precioBase = precioBase;
        
        if(cupoMaximo<1){
            throw new IllegalArgumentException("Cupo maximo no puede ser menor a 1");
        } else {
            this.cupoMaximo = cupoMaximo;
        }
        
        this.gestorReservas = new GestorReservas(cupoMaximo, this.generarFilePath());
        this.actividades = new ArrayList<>();
    }

    public boolean realizarReserva(String cliente) {
        gestorReservas.realizarReserva(new Reserva(cliente, this.id));
        return true;
    }

    public abstract double calcularPrecioFinal();

    public void agregarActividad(String actividad) {
        this.actividades.add(actividad);
    }

    public String mostrarResumen() {
        return "\nTitulo: " + this.titulo + "\n" + "Precio base: $" + this.precioBase + "\n" + "Cupo maximo: " + this.cupoMaximo + "\n";
    }

    public String generarFilePath() {
        return "reservas_excursion_" + this.id + ".dat";
    }

    private Optional<List<Reserva>> traerResrevas() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(this.generarFilePath()))) {
            List<Reserva> reservas = (List<Reserva>) ois.readObject();
            return Optional.of(reservas);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al cargar las reservas: " + e.getMessage());
            return Optional.empty();
        }
    }

    public int getId() {
        return id;
    }

    public List<String> getActividades() {
        return actividades;
    }

    public int getCupoMaximo() {
        return cupoMaximo;
    }
    

    @Override
    public String toString() {
        return "Excursion{" + "id=" + id + ", titulo=" + titulo + ", precioBase=" + precioBase + ", cupoMaximo=" + cupoMaximo + ", actividades=" + actividades + '}';
    }
    
    
    
    

}
