package com.circuit.api;

public interface TypedPin<T> extends Pin, TypedGate<T> {
    void setValue(T value);
}
