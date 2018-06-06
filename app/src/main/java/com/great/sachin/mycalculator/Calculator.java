package com.great.sachin.mycalculator;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Calculator extends Activity implements View.OnClickListener {

    private enum OPERATOR{
        PLUS,SUBTRACT,MULTIPLY,DIVIDE,EQUAL
    }

    TextView txtCalculations;
    TextView txtResults;

    //WE WILL CREATE VARIABLE TO POSITION OUR NUMBER
    private String currentNumber;
    private String stringNumberAtLeft;
    private String stringNumberAtRight;

    private OPERATOR currentOperator;
    private int calculationResult;
    private String calculationString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        txtCalculations = findViewById(R.id.txtCalculations);
        txtResults = findViewById(R.id.textResult);

        currentNumber = "";
        calculationResult = 0 ;
        calculationString = "";

        findViewById(R.id.btnEqual).setOnClickListener(Calculator.this);
        findViewById(R.id.btn7).setOnClickListener(Calculator.this);
        findViewById(R.id.btn8).setOnClickListener(Calculator.this);
        findViewById(R.id.btn9).setOnClickListener(Calculator.this);
        findViewById(R.id.btn4).setOnClickListener(Calculator.this);
        findViewById(R.id.btn5).setOnClickListener(Calculator.this);
        findViewById(R.id.btn6).setOnClickListener(Calculator.this);
        findViewById(R.id.btn1).setOnClickListener(Calculator.this);
        findViewById(R.id.btn2).setOnClickListener(Calculator.this);
        findViewById(R.id.btn3).setOnClickListener(Calculator.this);
        findViewById(R.id.btnPlus).setOnClickListener(Calculator.this);
        findViewById(R.id.btnSubtract).setOnClickListener(Calculator.this);
        findViewById(R.id.btnMultiply).setOnClickListener(Calculator.this);
        findViewById(R.id.btn0).setOnClickListener(Calculator.this);
        findViewById(R.id.btnDivide).setOnClickListener(Calculator.this);
        findViewById(R.id.btnClear).setOnClickListener(Calculator.this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.btnEqual:
                operatorIsPressed(OPERATOR.EQUAL);
                break;


            case R.id.btn7:
                numberIsPressed(7);
                break;

            case R.id.btn8:
                numberIsPressed(8);
                break;

            case R.id.btn9:
                numberIsPressed(9);
                break;

            case R.id.btnPlus:
                operatorIsPressed(OPERATOR.PLUS);
                calculationString +=" + ";
                break;

            case R.id.btn4:
                numberIsPressed(4);
                break;

            case R.id.btn5:
                numberIsPressed(5);
                break;

            case R.id.btn6:
                numberIsPressed(6);
                break;

            case R.id.btn1:
                numberIsPressed(1);
                break;

            case R.id.btn2:
                numberIsPressed(2);
                break;

            case R.id.btn3:
                numberIsPressed(3);
                break;

            case R.id.btnSubtract:
                operatorIsPressed(OPERATOR.SUBTRACT);
                calculationString +=" - ";
                break;

            case R.id.btnMultiply:
                operatorIsPressed(OPERATOR.MULTIPLY);
                calculationString +=" x ";
                break;

            case R.id.btnDivide:
                operatorIsPressed(OPERATOR.DIVIDE);
                calculationString +=" / ";
                break;

            case R.id.btnClear:
                clearData();
                break;

            case R.id.btn0:
                numberIsPressed(0);
                break;

        }

        txtCalculations.setText(calculationString);
    }

    private void numberIsPressed(int pressedNumber){

        currentNumber = currentNumber + String.valueOf(pressedNumber);
        txtResults.setText(currentNumber);
        calculationString = currentNumber;
        txtCalculations.setText(calculationString);

    }

    private void operatorIsPressed(OPERATOR operatorPressed){

        if(currentOperator!=null) {

            if (currentNumber != "") {

                stringNumberAtRight = currentNumber;//Its going to be at right when pressed
                currentNumber = "";
                switch (currentOperator) {

                    case PLUS:

                        calculationResult = Integer.parseInt(stringNumberAtLeft) +
                                Integer.parseInt(stringNumberAtRight);
                        break;

                    case SUBTRACT:

                        calculationResult = Integer.parseInt(stringNumberAtLeft) -
                                Integer.parseInt(stringNumberAtRight);
                        break;

                    case MULTIPLY:

                        calculationResult = Integer.parseInt(stringNumberAtLeft) *
                                Integer.parseInt(stringNumberAtRight);
                        break;

                    case DIVIDE:

                        calculationResult = Integer.parseInt(stringNumberAtLeft) /
                                Integer.parseInt(stringNumberAtRight);

                        break;

                }

                stringNumberAtLeft = String.valueOf(calculationResult);
                txtResults.setText(stringNumberAtLeft);
                calculationString = stringNumberAtLeft;

            }
        }
        else{
            stringNumberAtLeft = currentNumber;
            currentNumber="";
        }
        currentOperator = operatorPressed;
    }

    public void clearData(){
        stringNumberAtLeft="";
        stringNumberAtRight="";
        calculationString="";
        txtResults.setText("0");
        currentOperator=null;
        calculationString="0";

    }
}

