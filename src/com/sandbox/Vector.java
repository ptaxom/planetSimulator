package com.sandbox;

public class Vector {

    private double x;
    private double y;

    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double angle(){
        return Math.atan2(y,x);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void add(Vector v){
        this.x+=v.getX();
        this.y+=v.getY();
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getAbs(){
        return Math.sqrt(x*x+y*y);
    }
}
