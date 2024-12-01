
package model;

import java.io.Serializable;

public class Reserva implements Serializable {
    private static int contadorId = 1;
    private final int idReserva;
    private final String cliente;
    private final String fechaReserva;
    private final double precio;
    private boolean pagoConfirmado;

    public Reserva(String cliente, String fechaReserva, double precio) {
        this.idReserva = contadorId++;
        this.cliente = cliente;
        this.fechaReserva = fechaReserva;
        this.precio = precio;
        this.pagoConfirmado = false;
    }
    

    public boolean confirmarPago(){
        this.pagoConfirmado = true;
        return true;
    }
    
    public String detalleReserva(){
        return "Cliente: "+this.cliente+"\nFecha Reserva: "+this.fechaReserva+"\nPrecio Final: $"+this.precio+"\nPago confirmado: "+this.pagoConfirmado;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public double getPrecio() {
        return precio;
    }

    public boolean isPagoConfirmado() {
        return pagoConfirmado;
    }
    
    
    
    
}
