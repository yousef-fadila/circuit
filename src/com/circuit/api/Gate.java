/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.circuit.api;

/**
 *
 * @author 20184731
 */
public interface Gate {

    Boolean getVal();
        
    default Double getDoubleVal() {
        throw new UnsupportedOperationException("getDoubleVal");
    }
}
