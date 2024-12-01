
package persistencia;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import model.Reserva;


public class ReservaRepository implements Repository<Reserva>{
    private final List<Reserva> reservas;
    private final GestorPersistencia<Reserva> persistencia;
    private final String filePath;

    public ReservaRepository(String filePath) {
        this.persistencia = new GestorPersistencia<>();
        this.reservas = this.persistencia.cargarDatos(filePath);
        this.filePath = filePath;
    }
    
    

    @Override
    public void add(Reserva reserva){
        boolean existeEnPersistencia = reservas.stream().anyMatch(r -> r.getIdReserva() == reserva.getIdReserva());
        if(existeEnPersistencia){return;}
        
        this.reservas.add(reserva);
        this.persistencia.guardarDatos(filePath, reservas);
    }

    @Override
    public void remove(int id) {
        this.reservas.removeIf(r -> r.getIdReserva()==id);
        this.persistencia.guardarDatos(filePath, reservas);
    }

    @Override
    public Optional<Reserva> findById(int id) {
        return reservas.stream().filter(r->r.getIdReserva()==id).findFirst();
    }

    @Override
    public List<Reserva> findBy(Predicate<Reserva> criterio) {
        return reservas.stream().filter(criterio).toList(); 
    }

    @Override
    public List<Reserva> getAll() {
        return this.reservas;
    }
    
    
    
}
