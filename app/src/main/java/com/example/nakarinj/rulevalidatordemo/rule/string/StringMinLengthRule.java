package com.example.nakarinj.rulevalidatordemo.rule.string;

import android.support.annotation.NonNull;

import com.example.nakarinj.rulevalidatordemo.rule.AbstractRule;

public class StringMinLengthRule<T> extends AbstractRule<String, T> {
    private int min;

    public StringMinLengthRule(int min, @NonNull T error) {
        super(error);
        this.min = min;
    }

    @Override
    public boolean isValid(String s) {
        return s != null && s.length() >= min;
    }
}
