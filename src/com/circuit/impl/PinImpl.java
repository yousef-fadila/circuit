/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.circuit.impl;

import com.circuit.api.TypedPin;


/**
 *
 * @author 20184731
 */
final class PinImpl implements TypedPin<Double> {

    private Double value; 
    
    PinImpl(Double value) {
        this.value = value;
    }
   
    @Override
    public void setValue(Boolean v1) {
        value = v1 ? 1. : 0;
    }
    
    @Override
    public void setValue(Double v1) {
        value = v1;
    }

    @Override
    public Boolean getVal() {
        if(!value.equals(1.0) && !value.equals(0.0)) {
            throw new UnsupportedOperationException("You have double as input: " + value);
        }
        
        return getValue() == 1.0;
    }
    
    @Override
    public Double getValue() {
        
        if (value < 0 || value > 1.0) {
            throw new IllegalStateException("Pin value is out of range: " + value);
        }
        
        return value;
    }
}
