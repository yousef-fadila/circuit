/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.circuit.impl;

import com.circuit.api.Gate;

/**
 *
 * @author 20184731
 */
final class Or implements Gate {

    public Or(Gate op1, Gate op2) {
        this.op1 = op1;
        this.op2 = op2;
    }
    private Gate op1;
    private Gate op2;
    
    @Override
    public Boolean getVal() {
        return op1.getVal() || op2.getVal();
    }
    
    @Override
    public Double getDoubleVal() {
        return 1. - (1. - op1.getDoubleVal()) * (1. - op2.getDoubleVal());         
    }

    @Override
    public String toString() {
        return "(" + op1.toString() +"|" + op2.toString() + ")";
    }
}