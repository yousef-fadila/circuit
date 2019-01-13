/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.circuit.impl;

import com.circuit.api.Gate;
import com.circuit.api.TypedGate;

/**
 *
 * @author 20184731
 */
final class And implements TypedGate<Double> {

    private TypedGate<Double> op1;
    private TypedGate<Double> op2;

    And(Gate op1, Gate op2) {
        this.op1 = ((TypedGate<Double>) op1);
        this.op2 = ((TypedGate<Double>) op2);
    }

    And(TypedGate<Double> op1, TypedGate<Double> op2) {
        this.op1 = op1;
        this.op2 = op2;
    }

    @Override
    public Boolean getVal() {
        return op1.getVal() && op2.getVal();
    }
    
    @Override
    public Double getValue() {
        return  op1.getValue() * op2.getValue();
    }

    @Override
    public String toString() {
        return "(" + op1.toString() +"&" + op2.toString() + ")";
    }
}
