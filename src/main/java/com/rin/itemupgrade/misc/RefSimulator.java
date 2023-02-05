package com.rin.itemupgrade.misc;

public class RefSimulator<E> {
    E ref;
    public RefSimulator(E var1) {
        this.ref = var1;
    }

    public E GetValue() {
        return this.ref;
    }

    public E getValue() {
        return this.ref;
    }

    public void SetValue(E var1) {
        this.ref = var1;
    }

    public void setValue(E var1) {
        this.ref = var1;
    }

    public String toString() {
        return "Ref<" + this.ref + ">";
    }
}
