package com.mainframe;

import com.sandbox.Planet;
import com.sandbox.Point;
import com.sandbox.PlanetSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class MyPanel extends JPanel implements Runnable {

    private PlanetSystem planetSystem;

    public MyPanel(PlanetSystem planetSystem){
        this.planetSystem = planetSystem;
        (new Thread(this)).start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        for(Planet p : planetSystem.getPlanetList()){
            g2.setColor(p.getColor());
            Ellipse2D e = new Ellipse2D.Double(p.getX()-p.getR()/2,p.getY()-p.getR()/2,p.getR(),p.getR());
            g2.setPaint(p.getColor());
            g2.fill(e);
            g2.draw(e);
            int i = 2;
            if (Planet.isTrack())
            for(Point p2 : p.getPrevPos()){
                double curR = p.getR()/Math.sqrt(i);
                int r = p.getColor().getRed();
                int gr = p.getColor().getGreen();
                int b = p.getColor().getBlue();
                Color color = new Color(r,gr,b,(int)(255*(Planet.getCnt()-i)/Planet.getCnt()));
                g2.setColor(color);
                g2.setPaint(color);
                Ellipse2D e2 = new Ellipse2D.Double(p2.getX()-curR/2,p2.getY()-curR/2,curR,curR);
                g2.fill(e2);
                g2.draw(e2);
                i++;
            }
        }
    }

    @Override
    public void run() {
        while(true){
            super.repaint();
            planetSystem.Update();
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
