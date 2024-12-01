
package negocio;

import java.util.List;
import java.util.Optional;
import model.Excursion;
import persistencia.ExcursionRepository;
import persistencia.Repository;


public class GestorExcursiones {
    private final Repository<Excursion> excursionesRepository;

    public GestorExcursiones(String filePath) {
        this.excursionesRepository = new ExcursionRepository(filePath);
    }

    public boolean agregarExcursion(Excursion excursion){
        this.excursionesRepository.add(excursion);   
        return true;
    }
    
    public Optional<Excursion> buscarPorId(int id){
        return excursionesRepository.findById(id);
    }
    
    public List<Excursion> consultarExcursionesPorPrecio(double precioMin){
        return excursionesRepository.findBy(e -> e.calcularPrecioFinal()>=precioMin);
    }
    
    
    
    
    
    
}
