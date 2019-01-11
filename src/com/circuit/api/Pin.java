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
public interface Pin extends Gate{
    void setValue(Boolean v1);
    
    default void setValue(Double v1) {
        throw new UnsupportedOperationException("getDoubleVal");
    }
}
