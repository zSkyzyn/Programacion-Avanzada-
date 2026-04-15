
package com.mycompany.maindecorator;

public class ConLeche extends DecoradorBebida {
    
    public ConLeche(Bebida bebida) { 
        super(bebida); 
    }
    public String getDescription() { 
        return bebidaDecorada.getDescription() + " + Leche"; 
    }
    public double cost() {
        return bebidaDecorada.cost() + 40.0; 
    }
}