package com.example.nakarinj.rulevalidatordemo.rule;

public interface Rule<T1, T2> {

    boolean isValid(T1 t);

    T2 getError();
}
