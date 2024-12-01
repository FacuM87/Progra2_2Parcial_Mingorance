
package negocio;

import java.util.List;
import java.util.function.Predicate;
import model.Reserva;
import persistencia.Repository;
import persistencia.ReservaRepository;



public class GestorReservas {
    private final Repository<Reserva> reservasRepository;
    private final int cupoMaximo;

    public GestorReservas(int cupoMaximo, String filePath) {
        this.reservasRepository = new ReservaRepository(filePath);
        this.cupoMaximo = cupoMaximo;
       
    }

    public boolean realizarReserva(Reserva reserva){
        List<Reserva> listaReservas = this.reservasRepository.getAll();
        if(listaReservas.size()<this.cupoMaximo){
            reservasRepository.add(reserva);
            return true;
        } else {
            throw new IllegalArgumentException("La reserva no pudo realizarse. Cupo maximo alcanzado");
        }
        
    }
    
    public List<Reserva> getReservas(){
        return reservasRepository.getAll();
    }
    
    public double calcularIngresos(Predicate<Reserva> filtro){
        return reservasRepository.findBy(filtro).stream().mapToDouble(Reserva::getPrecio).sum();
        
    } 
    
    public double calcularIngresosTotales(){
        return reservasRepository.findBy(r-> r.isPagoConfirmado()).stream().mapToDouble(Reserva::getPrecio).sum();
    }
    
}
