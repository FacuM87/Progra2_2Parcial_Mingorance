
package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.NoSuchElementException;
import persistencia.ExcursionRepository;

public class Reserva implements Serializable {
    private static int contadorId = 1;
    private final int idReserva;
    private final int idExcursion;
    private ExcursionRepository excursionRepository;
    private final String cliente;
    private final String fechaReserva;
    private double precio;
    private boolean pagoConfirmado;

    public Reserva(String cliente, int idExcursion) {
        this.idReserva = contadorId++;
        this.idExcursion = idExcursion;
        this.cliente = cliente;
        this.fechaReserva = LocalDate.now().toString();
        this.pagoConfirmado = false;
    }
    

    public boolean confirmarPago(){
        this.pagoConfirmado = true;
        return true;
    }
    
    public String detalleReserva(){
        return "Cliente: "+this.cliente+"\nFecha Reserva: "+this.fechaReserva+"Excursion: "+this.idExcursion+"\nPrecio Final: $"+this.precio+"\nPago confirmado: "+this.pagoConfirmado;
    }

    public int getIdReserva() {
        return idReserva;
    }
    
    public int getIdExcursion(){
        return idExcursion;
    }

    public double getPrecio() {
        return excursionRepository.findById(this.idExcursion)
                .orElseThrow(() -> new NoSuchElementException("No se encontró la excursión con ID: " + this.idExcursion))
                .calcularPrecioFinal();
        
    }

    public boolean isPagoConfirmado() {
        return pagoConfirmado;
    }

    @Override
    public String toString() {
        return "Reserva{" + "idReserva=" + idReserva + ", idExcursion=" + idExcursion + ", cliente=" + cliente + ", fechaReserva=" + fechaReserva + ", precio=" + precio + ", pagoConfirmado=" + pagoConfirmado + '}';
    }
    
    
    
}
