package com.sandbox;

import java.util.ArrayList;
import java.util.List;

public class PlanetSystem {

    private static final double G = 1;
    private List<Planet> planetList;

    public PlanetSystem() {
        planetList = new ArrayList<>();
    }

    public void add(Planet planet){
     planetList.add(planet);
    }

    public void Update(){
        for(int i = 0; i < planetList.size(); i++)
            if (!planetList.get(i).isStatic())
            for(int j = 0; j < planetList.size(); j++)
                if (i!=j){
                    planetList.get(i).Update(this.Accelerate(planetList.get(i),planetList.get(j)));
                }
    }


    private Vector Accelerate(Planet from, Planet to){
        double accelerate = G*to.getM()/to.getDistance(from);
        Vector v = new Vector(to.getX()-from.getX(),to.getY()-from.getY());
        return new Vector(accelerate*Math.cos(v.angle()),accelerate*Math.sin(v.angle()));
    }

    public List<Planet> getPlanetList() {
        return planetList;
    }
}
