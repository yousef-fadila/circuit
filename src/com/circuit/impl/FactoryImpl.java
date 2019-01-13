/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.circuit.impl;

import com.circuit.api.*;

/**
 *
 * @author 20184731
 */
public final class FactoryImpl implements Factory {

    @Override
    public TypedPin<Double> createPin(Boolean initialValue) {
        return new PinImpl(initialValue ? 1.0 : 0.0);
    }

    @Override
    public TypedGate<Double> createAnd(Gate op1, Gate op2) {
         return new And(op1, op2);
    }

    @Override
    public TypedGate<Double> createOr(Gate op1, Gate op2) {
        return new Or(op1, op2);
    }

    @Override
    public TypedGate<Double> createNot(Gate op1) {
        return new Not(op1);
    }
}
