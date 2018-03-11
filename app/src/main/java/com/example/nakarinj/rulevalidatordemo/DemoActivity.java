package com.example.nakarinj.rulevalidatordemo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.nakarinj.rulevalidatordemo.rule.RuleSet;
import com.example.nakarinj.rulevalidatordemo.rule.string.StringEmailRule;
import com.example.nakarinj.rulevalidatordemo.rule.string.StringMaxLengthRule;
import com.example.nakarinj.rulevalidatordemo.rule.string.StringMinLengthRule;
import com.example.nakarinj.rulevalidatordemo.validator.RuleValidator;

public class DemoActivity extends AppCompatActivity {

    private EditText editTextUsername;
    private EditText editTextPassword;
    private RuleValidator<String, String> userNameValidator;
    private RuleValidator<String, String> passwordValidator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initValidator();

        editTextUsername = (EditText) findViewById(R.id.edit_text_username);
        editTextPassword = (EditText) findViewById(R.id.edit_text_password);

        final Button button = (Button) findViewById(R.id.btn_validate);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextUsername.setError(null);
                editTextPassword.setError(null);
                validateInput();
            }
        });
    }

    private void initValidator() {
        // Ex 1.
        // init a validator with a rule
        userNameValidator = new RuleValidator(new StringEmailRule("invalid email format"));

        // Ex 2.
        // init a validator with multiple rules
        RuleSet passwordRules = new RuleSet().addRule(new StringMinLengthRule(3, "password must contain at least 3 characters"))
                .addRule(new StringMaxLengthRule(6, "password must not exceed 6 characters"));
        passwordValidator = new RuleValidator(passwordRules);
    }

    private void validateInput() {
        userNameValidator.validate(editTextUsername.getText().toString().trim());
        passwordValidator.validate(editTextPassword.getText().toString().trim());
        displayResult();
    }

    private void displayResult() {
        if (userNameValidator.isValid() && passwordValidator.isValid()) {
            displaySuccessDialog();
        } else {
            if (!userNameValidator.isValid()) {
                editTextUsername.setError(userNameValidator.getErrors().get(0));
            }
            if (!passwordValidator.isValid()) {
                editTextPassword.setError(passwordValidator.getErrors().get(0));
            }
        }
    }

    private void displaySuccessDialog() {
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setMessage("Success");
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }
}
