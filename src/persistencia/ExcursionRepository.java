
package persistencia;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import model.Excursion;


public class ExcursionRepository implements Repository<Excursion>{
    private final List<Excursion> excursiones;
    private final GestorPersistencia<Excursion> persistencia;
    private final String filePath;
    private int ultimoId; // ¿PARA QUE ESTA ESTE ATRIBUTO ACÁ?

    public ExcursionRepository(String filePath) {
        this.persistencia = new GestorPersistencia<>();
        this.excursiones = this.persistencia.cargarDatos(filePath);
        this.filePath = filePath;
        
    }    

    @Override
    public void add(Excursion excursion) {
        boolean existeEnPersistencia = this.excursiones.stream().anyMatch(e -> e.getId() == excursion.getId());
        if(existeEnPersistencia){return;}
        this.excursiones.add(excursion);
        this.persistencia.guardarDatos(filePath, excursiones);
        System.out.println("Excursion agregada exitosamente con id "+excursion.getId());
    }

    @Override
    public void remove(int id) {
        this.excursiones.removeIf(e -> e.getId() == id);
        this.persistencia.guardarDatos(filePath, excursiones);
    }

    @Override
    public Optional<Excursion> findById(int id) {
        return excursiones.stream().filter(e -> e.getId() == id).findFirst();
    }

    @Override
    public List<Excursion> findBy(Predicate<Excursion> criterio) {
        return excursiones.stream().filter(criterio).toList();
    }

    @Override
    public List<Excursion> getAll() {
        return this.excursiones;
    }
   
   
}
