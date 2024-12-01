package persistencia;

import exception.PersistenciaException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class GestorPersistencia<T> implements Serializer<T> {

    @Override
    public void guardarDatos(String filePath, List<T> data) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(data);
        } catch (IOException e) {
            throw new PersistenciaException("Error al guardar datos: " + e.getMessage());
        }
    }

    @Override
    public List<T> cargarDatos(String filePath) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return (List<T>) ois.readObject();
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            throw new PersistenciaException("Error al cargar los datos: " + e.getMessage());
        }
    }

}
