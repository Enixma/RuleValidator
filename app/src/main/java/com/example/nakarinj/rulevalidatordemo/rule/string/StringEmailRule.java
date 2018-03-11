package com.example.nakarinj.rulevalidatordemo.rule.string;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.example.nakarinj.rulevalidatordemo.rule.AbstractRule;

public class StringEmailRule<T2> extends AbstractRule<String, T2> {

    public StringEmailRule(@NonNull T2 error) {
        super(error);
    }

    @Override
    public boolean isValid(String s) {
        return !TextUtils.isEmpty(s) && android.util.Patterns.EMAIL_ADDRESS.matcher(s).matches();
    }
}
