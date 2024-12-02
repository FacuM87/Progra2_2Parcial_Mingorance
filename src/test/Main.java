
package test;

import model.ExcursionAventura;
import model.Reserva;
import negocio.GestorExcursiones;
import negocio.GestorReservas;


public class Main {

    public static void main(String[] args) {
        try{
            System.out.println("Test 1-1\n");
            ExcursionAventura excursionAventura1 = new ExcursionAventura(3,200,"Rafting en el Río Claro", 1500, 10);
            GestorExcursiones gestorExcursiones = new GestorExcursiones("excursiones.bin");
            gestorExcursiones.agregarExcursion(excursionAventura1);
            System.out.println("-----------------------------\n");
            
            
            System.out.println("Test 1-2\n");
            
            ExcursionAventura excursionAventura2 = new ExcursionAventura(2,200,"Excursion en la montaña", 1500, -2);
            System.out.println("-----------------------------\n");
            
        }catch(Exception e){
            System.out.println("Error en test 1: "+e.getMessage());
        }
        
        try{
            System.out.println("\nTest 1-3");
            ExcursionAventura excursionAventura3 = new ExcursionAventura(5,500,"", 1500, 5);
            System.out.println("-----------------------------\n");
        }catch(Exception e){
            System.out.println("Error en test 1: "+e.getMessage());
        }
        try{
            System.out.println("\nTest 1-4");
            ExcursionAventura excursionAventura4 = new ExcursionAventura(5,500,"Ra", 1500, 5);
            System.out.println("-----------------------------\n");
        }catch(Exception e){
            System.out.println("Error en test 1: "+e.getMessage());
        }
        
        try{
            System.out.println("\nTest 1-5");
            ExcursionAventura excursionAventura5 = new ExcursionAventura(3,200,"Rafting en el Rio Claro", 1500, 5);
            System.out.println("Precio final: $"+excursionAventura5.calcularPrecioFinal());
            System.out.println("-----------------------------\n");
            
            System.out.println("Test 1-6");
            excursionAventura5.agregarActividad("Navegar el rio");
            excursionAventura5.agregarActividad("Instruccion sobre seguridad");
            System.out.println("Actividades agregadas correctamente: "+excursionAventura5.getActividades());
        }catch(Exception e){
            System.out.println("Error en test 1: "+e.getMessage());
        }
        
        try{
            System.out.println("\nTest 2-1");
            ExcursionAventura excursionAventura6 = new ExcursionAventura(3,200,"Rafting en el Río Claro", 1500, 1);
            GestorExcursiones gestorExcursiones = new GestorExcursiones("excursiones.bin");
            gestorExcursiones.agregarExcursion(excursionAventura6);
            System.out.println(gestorExcursiones.traerExcursiones());
            Reserva r1 = new Reserva("Carlos Perez",6);
            GestorReservas gestorReservas = new GestorReservas(excursionAventura6.getCupoMaximo(), "reservas.bin");
            gestorReservas.realizarReserva(r1);
            System.out.println(gestorReservas.getReservas());
        }catch(Exception e){
            System.out.println("Error en test 2: "+e.getMessage());
        }
    }
    
}
