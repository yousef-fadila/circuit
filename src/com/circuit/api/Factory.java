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
public interface Factory {
    Pin createPin(Boolean initialValue);
    Gate createAnd(Gate op1, Gate op2);
    Gate createOr(Gate op1, Gate op2);
    Gate createNot(Gate op1);
}