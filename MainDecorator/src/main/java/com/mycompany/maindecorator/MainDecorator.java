
package com.mycompany.maindecorator;

public class MainDecorator {
    public static void main(String[] args) {
        Bebida pedido = new CafeSimple();
        pedido = new ConLeche(pedido); // Envolvemos el café con leche
        
        System.out.println("Pedido: " + pedido.getDescription());
        System.out.println("Total: $" + pedido.cost());
    }
}