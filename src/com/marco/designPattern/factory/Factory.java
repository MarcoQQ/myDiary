package com.marco.designPattern.factory;

public class Factory {
    public Shape getShape(String shapeType){
        if(shapeType == null){
            return null;
        }else if(shapeType == "CIRCLE"){
            return new Circle();
        }else if(shapeType == "SQUARE"){
            return new Square();
        }
        return null;
    }
}
