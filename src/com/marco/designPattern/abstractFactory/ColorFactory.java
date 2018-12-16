package com.marco.designPattern.abstractFactory;

public class ColorFactory extends AbstractFactory{
    public Shape getShape(String shape) {
        return null;
    }

    public Color getColor(String color){
        if(color == null) {
            return null;
        }else if(color == "RED"){
            return new Red();
        }else if(color == "GREEN"){
            return new Green();
        }
        return null;
    }
}
