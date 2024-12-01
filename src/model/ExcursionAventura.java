
package model;


public class ExcursionAventura extends Excursion {
    
    private final int nivelDificultad;
    private final double seguroAdicional;

    public ExcursionAventura(int nivelDificultad, double seguroAdicional, String titulo, double precioBase, int cupoMaximo) {
        super(titulo, precioBase, cupoMaximo);
        this.nivelDificultad = nivelDificultad;
        this.seguroAdicional = seguroAdicional;
    }
    
    
    
    public String consejosSeguridad() {
        switch (this.nivelDificultad) {
            case 1 -> {return "Consejo 1";}
            case 2 -> {return "Consejo 2";}
            case 3 -> {return "Consejo 3";}
            case 4 -> {return "Consejo 4";}
            case 5 -> {return "Consejo 5";}
            default -> {return "Elija un nivel de dificultad valido.";}
        }
    }

    @Override
    public double calcularPrecioFinal() {
        return (this.precioBase * (1.1 *this.nivelDificultad))+this.seguroAdicional;
    }
}
