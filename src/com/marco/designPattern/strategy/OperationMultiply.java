package com.marco.designPattern.strategy;

public class OperationMultiply implements Strategy{
    public int doOperation(int a,int b){
        return a * b;
    }
}
