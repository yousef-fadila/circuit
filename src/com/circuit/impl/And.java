/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.circuit.impl;

import com.circuit.api.Gate;
import com.circuit.api.DoubleGate;

/**
 *
 * @author 20184731
 */
final class And implements DoubleGate {

    private DoubleGate op1;
    private DoubleGate op2;

    And(Gate op1, Gate op2) {
        this.op1 = GateConverter.convert(op1);
        this.op2 = GateConverter.convert(op2);
    }

    And(DoubleGate op1, DoubleGate op2) {
        this.op1 = op1;
        this.op2 = op2;
    }

    @Override
    public Boolean getVal() {
        return op1.getVal() && op2.getVal();
    }
    
    @Override
    public Double getDoubleVal() {
        return  op1.getDoubleVal()* op2.getDoubleVal();
    }

    @Override
    public String toString() {
        return "(" + op1.toString() +"&" + op2.toString() + ")";
    }
}
