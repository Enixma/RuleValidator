package com.example.nakarinj.rulevalidatordemo.rule.string;

import android.support.annotation.NonNull;

import com.example.nakarinj.rulevalidatordemo.rule.AbstractRule;

/**
 * Created by nakarinj on 5/3/2018 AD.
 */

public class StringMaxLengthRule<T> extends AbstractRule<String, T> {
    private int max;

    public StringMaxLengthRule(int max, @NonNull T error) {
        super(error);
        this.max = max;
    }

    @Override
    public boolean isValid(String s) {
        return s != null && s.length() <= max;
    }
}