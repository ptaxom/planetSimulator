package com.mainframe;

import com.sandbox.PlanetSystem;

import javax.swing.*;
import java.awt.*;

public class VFrame extends JFrame{

    public VFrame(PlanetSystem planetSystem) {
        super("Sandbox");
        setSize(1000,1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout());
        MyPanel panel = new MyPanel(planetSystem);
        add(panel);
        setVisible(true);
    }
}
