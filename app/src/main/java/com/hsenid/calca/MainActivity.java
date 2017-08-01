package com.hsenid.calca;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.CalOperations;

public class MainActivity extends AppCompatActivity {
    CalOperations calOperations = new CalOperations();
    private String input;
    private EditText display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickZero(View view) {
        display = (EditText) findViewById(R.id.txtDisplay);
        input = "0";
        calOperations.setDisplay(input, display);
    }

    public void clickNine(View view) {
        display = (EditText) findViewById(R.id.txtDisplay);
        input = "9";
        calOperations.setDisplay(input, display);
    }

    public void clickEight(View view) {
        display = (EditText) findViewById(R.id.txtDisplay);
        input = "8";
        calOperations.setDisplay(input, display);
    }

    public void clickSeven(View view) {
        display = (EditText) findViewById(R.id.txtDisplay);
        input = "7";
        calOperations.setDisplay(input, display);
    }

    public void clickSix(View view) {
        display = (EditText) findViewById(R.id.txtDisplay);
        input = "6";
        calOperations.setDisplay(input, display);
    }

    public void ClickFive(View view) {
        display = (EditText) findViewById(R.id.txtDisplay);
        input = "5";
        calOperations.setDisplay(input, display);
    }

    public void clickFour(View view) {
        display = (EditText) findViewById(R.id.txtDisplay);
        input = "4";
        calOperations.setDisplay(input, display);
    }

    public void clickThree(View view) {
        display = (EditText) findViewById(R.id.txtDisplay);
        input = "3";
        calOperations.setDisplay(input, display);
    }

    public void clickTwo(View view) {
        display = (EditText) findViewById(R.id.txtDisplay);
        input = "2";
        calOperations.setDisplay(input, display);
    }

    public void clickOne(View view) {
        display = (EditText) findViewById(R.id.txtDisplay);
        input = "1";
        calOperations.setDisplay(input, display);
    }

    public void clickAdd(View view) {
        display = (EditText) findViewById(R.id.txtDisplay);
        input = " + ";
        calOperations.setDisplay(input, display);
    }

    public void clickSubstract(View view) {
        display = (EditText) findViewById(R.id.txtDisplay);
        input = " - ";
        calOperations.setDisplay(input, display);
    }

    public void clickDevide(View view) {
        display = (EditText) findViewById(R.id.txtDisplay);
        input = " / ";
        calOperations.setDisplay(input, display);
    }

    public void clickMultifly(View view) {
        display = (EditText) findViewById(R.id.txtDisplay);
        input = " * ";
        calOperations.setDisplay(input, display);
    }

    public void clickBacksapce(View view) {
        display = (EditText) findViewById(R.id.txtDisplay);
        String displayToString = display.getText().toString();
        StringBuilder sb = new StringBuilder(displayToString);
        sb.deleteCharAt(displayToString.length() - 1);
        display.setText(sb.toString());
    }

    public void clickClear(View view) {
        display.setText("");
        input = null;
    }

    public void clickEqual(View view) {
        display = (EditText) findViewById(R.id.txtDisplay);
        display.setText(calOperations.calculate(display).toString());
    }
}
