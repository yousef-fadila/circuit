package com.circuit.api;

public interface TypedGate <T> extends Gate {
    T getValue();
}
