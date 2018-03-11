package com.example.nakarinj.rulevalidatordemo.validator;

import android.support.annotation.NonNull;

import com.example.nakarinj.rulevalidatordemo.rule.Rule;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nakarinj on 5/3/2018 AD.
 */
public class RuleValidator<T1, T2> {

    private List<Rule<T1, T2>> listOfRules;
    private T1 value;
    private List<T2> listOfErrors;

    public RuleValidator(T1 value, @NonNull List<Rule<T1, T2>> rules) {
        this.value = value;
        this.listOfRules = rules;
        validate();
    }

    public RuleValidator(@NonNull List<Rule<T1, T2>> rules) {
        this.listOfRules = rules;
    }

    public RuleValidator(T1 value, @NonNull Rule<T1, T2> rule) {
        this.value = value;
        this.listOfRules = new ArrayList<>();
        this.listOfRules.add(rule);
        validate();
    }

    public RuleValidator(@NonNull Rule<T1, T2> rule) {
        this.listOfRules = new ArrayList<>();
        this.listOfRules.add(rule);
    }

    private void validate() {
        this.listOfErrors = new ArrayList<>();
        if (listOfRules != null) {
            for (Rule<T1, T2> rule : listOfRules) {
                if (rule != null && !rule.isValid(value)) {
                    listOfErrors.add(rule.getError());
                }
            }
        }
    }

    public boolean isValid() {
        return listOfErrors != null && listOfErrors.isEmpty();
    }

    public List<T2> getErrors() {
        return listOfErrors;
    }

    public boolean isValid(T1 value) {
        this.value = value;
        validate();
        return isValid();
    }

    public List<T2> validate(T1 value) {
        this.value = value;
        validate();
        return getErrors();
    }


}
