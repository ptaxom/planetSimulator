package com.mainframe;

import com.sandbox.Vector;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class CPanel extends JPanel implements Runnable{

    private static final double dAngle = 0.1;


    private CFrame cFrame;

    public CPanel(CFrame cFrame){
        super(null);
        this.cFrame = cFrame;
        (new Thread(this)).start();

    }

    public static Color getColor(int z){
        int[] x = new int[3];
        int pos = 2;
        while(z > 0){
            x[pos--] = z % 256;
            z/=256;
        }
        return new Color(x[2],x[1],x[0]);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        Color color = getColor(cFrame.getColor().getValue());
        g2.setColor(color);
        g2.setPaint(color);
        Rectangle2D colorPicture = new Rectangle2D.Double(260,60,25,25);
        g2.fill(colorPicture);
        g2.draw(colorPicture);
        g2.setPaint(Color.WHITE); g2.setColor(Color.WHITE);
        g2.draw(new Rectangle2D.Double(90,120,180,180));

        g2.setPaint(Color.BLACK); g2.setColor(Color.BLACK);
        g2.draw(new Line2D.Double(180,120,180,300));
        g2.draw(new Line2D.Double(90,210,270,210));
        g2.draw(new Line2D.Double(180,120,175,130));
        g2.draw(new Line2D.Double(180,120,185,130));
        g2.draw(new Line2D.Double(270,210,260,205));
        g2.draw(new Line2D.Double(270,210,260,215));
        String sX = cFrame.getSpeedX().getText();
        String sY = cFrame.getSpeedY().getText();
        if (sX.isEmpty() || sX == "-") sX = "0"; if (sY.isEmpty() || sY == "-") sY = "0";

        Vector v;
        try{
            v = new Vector(Double.parseDouble(sX),Double.parseDouble(sY));
        } catch (java.lang.NumberFormatException e){
            v = new Vector(0,0);
        }
        if (v.getAbs() > 9){
            v.setY(v.getY()/v.getAbs()*9);
            v.setX(v.getX()/v.getAbs()*9);
            g2.setColor(Color.RED); g2.setPaint(Color.RED);
        }
        else {
            g2.setPaint(Color.BLACK); g2.setColor(Color.BLACK);
        }
        g2.draw(new Line2D.Double(180,210,180+10*v.getX(),210-10*v.getY()));
        g2.draw(new Line2D.Double(180+9*v.getAbs()*Math.cos(v.angle()-dAngle),210-9*v.getAbs()*Math.sin(v.angle()-dAngle),
                180+10*v.getX(),210-10*v.getY()));
        g2.draw(new Line2D.Double(180+9*v.getAbs()*Math.cos(v.angle()+dAngle),210-9*v.getAbs()*Math.sin(v.angle()+dAngle),
                180+10*v.getX(),210-10*v.getY()));

    }

    @Override
    public void run() {
        while(true){
            try {
                super.repaint();
                Thread.sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
