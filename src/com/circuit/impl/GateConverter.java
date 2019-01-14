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
 * @author 20184743
 */
final class GateConverter {
    static DoubleGate convert(Gate gate) {
        if (gate instanceof DoubleGate) {
            return ((DoubleGate) gate);
        }
        
        return new DoubleGate() {
            @Override
            public Double getDoubleVal() {
                return gate.getVal() ? 1.0 : 0.0;
            }

            @Override
            public Boolean getVal() {
                return gate.getVal();
            }
        };
    }
}
