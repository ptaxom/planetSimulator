package com.sandbox;

import java.awt.*;
import java.util.Deque;
import java.util.LinkedList;

public class Planet {

    private static int cnt = 78;
    private static boolean track = true;

    public static boolean isTrack() {
        return track;
    }

    private double x;
    private double y;
    private double m;
    private Color color;
    private Vector speed;
    private double r;
    private Deque<Point> prevPos;
    private boolean isStatic;

    public double getR() {
        return r;
    }

    public Planet(double x, double y, double m, Color color, Vector speed, double r, boolean isStatic) {
        this.x = x;
        this.y = y;
        this.m = m;
        this.color = color;
        this.speed = speed;
        this.speed.setY(-this.speed.getY());
        this.r = r;
        this.prevPos = new LinkedList<>();
        this.isStatic = isStatic;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public boolean isStatic() {
        return isStatic;
    }

    public double getM() {

        return m;
    }

    public Color getColor() {
        return color;
    }

    private void move(){
        prevPos.addFirst(new Point(this.x,this.y));
        if (prevPos.size() >=cnt)
            prevPos.removeLast();
        this.x+=speed.getX();
        this.y+=speed.getY();
    }

    public void Update(Vector v){
        this.speed.add(v);
        this.move();
    }


    public double getDistance(Planet planet){
        return Math.sqrt((planet.x-this.x)*(planet.x-this.x) +
                (planet.y-this.y)*(planet.y-this.y));
    }

    public Deque<Point> getPrevPos() {
        return prevPos;
    }

    public static int getCnt() {
        return cnt;
    }
}
