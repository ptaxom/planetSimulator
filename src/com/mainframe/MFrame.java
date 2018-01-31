package com.mainframe;

import com.sandbox.PlanetSystem;

public class MFrame {

    public static void main(String[] args) {
        PlanetSystem planetSystem = new PlanetSystem();
        new CFrame(planetSystem);
        new VFrame(planetSystem);
    }
}
