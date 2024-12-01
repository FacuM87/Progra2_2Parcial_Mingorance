
package persistencia;

import java.util.List;


public interface Serializer <T> {
    void guardarDatos(String filePath, List<T> data);
    List<T> cargarDatos(String filePath);
}
