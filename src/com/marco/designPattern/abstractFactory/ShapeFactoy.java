package com.marco.designPattern.abstractFactory;

public class ShapeFactoy extends AbstractFactory{

    public Shape getShape(String shape) {
        if(shape == null) {
            return null;
        }else if(shape == "CIRCLE"){
            return new Circle();
        }else if(shape == "SQUARE"){
            return new Square();
        }
        return null;
    }

    public Color getColor(String color){
        return null;
    }
}
