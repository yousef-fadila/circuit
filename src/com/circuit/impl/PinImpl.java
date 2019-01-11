/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.circuit.impl;

import com.circuit.api.Pin;


/**
 *
 * @author 20184731
 */
final class PinImpl implements Pin{

    public PinImpl(Boolean op) {
        this.op = op;
    }
    private Boolean op;
    @Override
    public void setValue(Boolean v1) {
        op = v1;
    }

    @Override
    public Boolean getVal() {
        return op;
    }
}
