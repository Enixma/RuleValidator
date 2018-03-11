package com.example.nakarinj.rulevalidatordemo.rule;

import java.util.ArrayList;
import java.util.List;

public class RuleSet<T1, T2> implements Rule<T1, T2> {

    public List<Rule<T1, T2>> rules = new ArrayList<>();
    private T2 error;

    public RuleSet() {
        this.rules = new ArrayList<>();
    }

    @Override
    public boolean isValid(T1 t) {
        for (Rule<T1, T2> rule : rules) {
            if (!rule.isValid(t)) {
                error = rule.getError();
                return false;
            }
        }
        return true;
    }

    @Override
    public T2 getError() {
        return error;
    }

    public RuleSet<T1, T2> addRule(Rule<T1, T2> rule) {
        rules.add(rule);
        return this;
    }

}