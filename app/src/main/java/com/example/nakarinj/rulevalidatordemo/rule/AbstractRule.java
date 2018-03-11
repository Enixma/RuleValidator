package com.example.nakarinj.rulevalidatordemo.rule;

public abstract class AbstractRule<T1, T2> implements Rule<T1, T2> {

    private final T2 error;

    protected AbstractRule(T2 error) {
        this.error = error;
    }

    @Override
    public T2 getError() {
        return error;
    }

}