/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.circuit.impl;

import com.circuit.api.Factory;
import com.circuit.api.Gate;
import com.circuit.api.Pin;

/**
 *
 * @author 20184731
 */
public class FactoryImpl implements Factory{

    @Override
    public Pin createPin(Boolean initialValue) {
        return new PinImpl(initialValue);
    }

    @Override
    public Gate createAnd(Gate op1, Gate op2) {
         return new And(op1, op2);
    }

    @Override
    public Gate createOr(Gate op1, Gate op2) {
        return new Or(op1, op2);
    }

    @Override
    public Gate createNot(Gate op1) {
        return new Not(op1);
    }
    
}
