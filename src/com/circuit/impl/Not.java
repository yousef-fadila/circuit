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
final class Not implements Gate {
    private Gate op1;

    public Not(Gate op1) {
        this.op1 = op1;
    }

    @Override
    public Boolean getVal() {
        return !op1.getVal();
    }
    
    @Override
    public Double getDoubleVal() {
        return  1. - op1.getDoubleVal(); 
    }

    @Override
    public String toString() {
        return "¬" + op1.toString();
    }
}