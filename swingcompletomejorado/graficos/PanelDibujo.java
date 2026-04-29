package com.mycompany.swingcompletomejorado.graficos;

import javax.swing.*;
import java.awt.*;

public class PanelDibujo extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.CYAN);
        g.fillRect(0,0,400,400);

        g.setColor(Color.GREEN);
        g.fillRect(0,300,400,100);

        g.setColor(Color.YELLOW);
        g.fillOval(50,50,80,80);

        g.setColor(Color.RED);
        g.fillRect(200,200,100,100);

        int x[] = {200,250,300};
        int y[] = {200,150,200};
        g.setColor(Color.BLACK);
        g.fillPolygon(x,y,3);
    }
}