package com.mainframe;

import com.sandbox.Planet;
import com.sandbox.PlanetSystem;
import com.sandbox.Vector;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CFrame extends JFrame{


    private static final int height = 20;

    private PlanetSystem planetSystem;

    private JPanel panel;
    private JTextField pointX;
    private JTextField pointY;
    private JTextField mass;
    private JTextField R;
    private JRadioButton isStatic;
    private JSlider clr;
    private JTextField speedX;
    private JTextField speedY;

    public CFrame(PlanetSystem planetSystem){
        super("Controller");
        this.planetSystem = planetSystem;

        setLocation(1200,40);
        setSize(360,400);

        panel = new CPanel(this);
        JLabel pXLabel = new JLabel("Координата X: "); pXLabel.setBounds(20,10,110,height);
        JLabel pYLabel = new JLabel("Координата Y: "); pYLabel.setBounds(187,10,110,height);
        JLabel mLabel = new JLabel("Масса: "); mLabel.setBounds(20,height+10,50,height);
        JLabel rLabel = new JLabel("Радиус: "); rLabel.setBounds(120,height+10,50,height);
        JLabel sLabel = new JLabel("Неподвижна: "); sLabel.setBounds(220,height+10,100,height);
        JLabel cLabel = new JLabel("Цвет: "); cLabel.setBounds(20,2*(height+10),80,height);
        JLabel sxLabel = new JLabel("Скорость по X:"); sxLabel.setBounds(20,3*(height+10),110,height);
        JLabel syLabel = new JLabel("Скорость по Y:");  syLabel.setBounds(187,3*(height+10),110,height);

        pointX = new JTextField(4); pointX.setBounds(110,10,40,height);
        pointY = new JTextField(4);pointY.setBounds(277,10,40,height);
        mass = new JTextField(4); mass.setBounds(70,height+10,40,height);
        R = new JTextField(4); R.setBounds(170,height+10,40,height);
        isStatic = new JRadioButton("",false); isStatic.setBounds(300,height+10,40,height);
        clr = new JSlider(0,256*256*256-1,0); clr.setBounds(60,2*(height+10),200,height);
        speedX = new JTextField("0",4); speedX.setBounds(110,3*(height+10),40,height);
        speedY = new JTextField("0",4); speedY.setBounds(277,3*(height+10),40,height);
        JButton create = new JButton("Создать");
        create.setBounds(130,310,100,height);


        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double x = CheckString(pointX.getText());
                double y = CheckString(pointY.getText());
                double r = CheckString(R.getText());
                Color color = CPanel.getColor(clr.getValue());
                double m = CheckString(mass.getText());
                Vector v = new Vector(CheckString(speedX.getText()),CheckString(speedY.getText()));
                boolean st = isStatic.isSelected();
                planetSystem.add(new Planet(x,y,m,color,v,r,st));

            }
        });

        panel.add(pXLabel); panel.add(pointX); panel.add(pYLabel); panel.add(pointY);
        panel.add(mLabel); panel.add(mass); panel.add(rLabel); panel.add(R); panel.add(sLabel); panel.add(isStatic);
        panel.add(cLabel); panel.add(clr);
        panel.add(sxLabel); panel.add(speedX); panel.add(syLabel); panel.add(speedY);
        panel.add(create);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);


        setResizable(false);
        setVisible(true);
    }


    public JSlider getColor() {
        return clr;
    }


    public JTextField getSpeedX() {
        return speedX;
    }

    public JTextField getSpeedY() {
        return speedY;
    }


    public static double CheckString(String string){
        double z = 0;
        if (string.isEmpty())
            z = 0;
    try{
        z = Double.parseDouble(string);
    } catch (java.lang.NumberFormatException e){
        z = 0;
    }
        return z;
    }

}

