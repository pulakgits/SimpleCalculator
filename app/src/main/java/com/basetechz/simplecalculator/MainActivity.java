package com.basetechz.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView resultTextView;
    private String currentNumber;
    private String operation;
    private double firstOperand;
    private double secondOperand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = findViewById(R.id.resultTextView);
        currentNumber = "";
        operation = "";
        firstOperand = 0;
        secondOperand = 0;

        findViewById(R.id.button0).setOnClickListener(this);
        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        findViewById(R.id.button4).setOnClickListener(this);
        findViewById(R.id.button5).setOnClickListener(this);
        findViewById(R.id.button6).setOnClickListener(this);
        findViewById(R.id.button7).setOnClickListener(this);
        findViewById(R.id.button8).setOnClickListener(this);
        findViewById(R.id.button9).setOnClickListener(this);
        findViewById(R.id.buttonAdd).setOnClickListener(this);
        findViewById(R.id.buttonSubtract).setOnClickListener(this);
        findViewById(R.id.buttonMultiply).setOnClickListener(this);
        findViewById(R.id.buttonDivide).setOnClickListener(this);
        findViewById(R.id.buttonClear).setOnClickListener(this);
        findViewById(R.id.buttonEquals).setOnClickListener(this);
    }
    @SuppressLint({"NonConstantResourceId", "SetTextI18n"})
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button0:
                currentNumber += "0";
                break;
            case R.id.button1:
                currentNumber += "1";
                break;
            case R.id.button2:
                currentNumber += "2";
                break;
            case R.id.button3:
                currentNumber += "3";
                break;
            case R.id.button4:
                currentNumber += "4";
                break;
            case R.id.button5:
                currentNumber += "5";
                break;
            case R.id.button6:
                currentNumber += "6";
                break;
            case R.id.button7:
                currentNumber += "7";
                break;
            case R.id.button8:
                currentNumber += "8";
                break;
            case R.id.button9:
                currentNumber += "9";
                break;
            case R.id.buttonAdd:
                firstOperand = Double.parseDouble(currentNumber);
                currentNumber = "";
                operation = "+";
                break;
            case R.id.buttonSubtract:
                firstOperand = Double.parseDouble(currentNumber);
                currentNumber = "";
                operation = "-";
                break;
            case R.id.buttonMultiply:
                firstOperand = Double.parseDouble(currentNumber);
                currentNumber = "";
                operation = "*";
                break;
            case R.id.buttonDivide:
                firstOperand = Double.parseDouble(currentNumber);
                currentNumber = "";
                operation = "/";
                break;
            case R.id.buttonClear:
                currentNumber = "";
                operation = "";
                firstOperand = 0;
                secondOperand = 0;
                break;
            case R.id.buttonEquals:
                if (currentNumber.isEmpty()) {
                    return;
                }
                secondOperand = Double.parseDouble(currentNumber);
                double result = 0;
                switch (operation) {
                    case "+":
                        result = firstOperand + secondOperand;
                        break;
                    case "-":
                        result = firstOperand - secondOperand;
                        break;
                    case "*":
                        result = firstOperand * secondOperand;
                        break;
                    case "/":
                        if (secondOperand == 0) {
                            resultTextView.setText("Error: Cannot divide by zero");
                            return;
                        }
                        result = firstOperand / secondOperand;
                        break;
                }
                currentNumber = String.valueOf(result);
                break;
        }
        resultTextView.setText(currentNumber);
    }
}
