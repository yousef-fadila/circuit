package com.circuit.api;

public interface DoublePin extends Pin, DoubleGate {
    void setValue(Double value);
}
