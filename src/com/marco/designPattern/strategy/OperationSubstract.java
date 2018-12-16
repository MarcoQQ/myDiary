package com.marco.designPattern.strategy;

public class OperationSubstract implements Strategy{
    public int doOperation(int a,int b){
        return a - b;
    }
}
