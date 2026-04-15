
package com.mycompany.maindecorator;

public abstract class DecoradorBebida implements Bebida {
    protected Bebida bebidaDecorada;
    
    public DecoradorBebida(Bebida bebida) { 
        this.bebidaDecorada = bebida; 
    }
}
