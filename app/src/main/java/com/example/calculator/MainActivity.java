package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView number_result;
    private String text;
    private char symbol;
    private double num1;
    private double num2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        number_result = findViewById(R.id.result_number);
        num1 = 0;
        text = "";
    }

    // Operation button
    public void onPlus(View view) {
        symbol = '+';
    }

    public void onMinus(View view) {
        symbol = '-';
    }

    public void onStar(View view) {
        symbol = 'x';
    }

    public void onSlash(View view) {
        symbol = '/';
    }

    public void onRoof(View view) {
        symbol = '^';
    }

    public void onEqual(View view) {
        symbol = '=';
    }

    public void onReset(View view) {
        number_result.setText("0");
    }
    public void onDel(View view){
        text = number_result.getText().toString();
        number_result.setText(text.substring(0,text.length()-1));
    }
    // Calculation button
    public void onOne(View view){
        if (number_result.getText().toString().equals("0")){
            number_result.setText("1");
        }
        else{number_result.append("1");}
    }
    public void onTwo(View view){
        if (number_result.getText().toString().equals("0")){
            number_result.setText("2");
        }
        else{number_result.append("2");}
    }
    public void onThree(View view){
        if (number_result.getText().toString().equals("0")){
            number_result.setText("3");
        }
        else{number_result.append("3");}
    }
    public void onFour(View view){
        if (number_result.getText().toString().equals("0")){
            number_result.setText("4");
        }
        else{number_result.append("4");}
    }
    public void onFive(View view){
        if (number_result.getText().toString().equals("0")){
            number_result.setText("5");
        }
        else{number_result.append("5");}
    }
    public void onSix(View view){
        if (number_result.getText().toString().equals("0")){
            number_result.setText("6");
        }
        else{number_result.append("6");}
    }
    public void onSeven(View view){
        if (number_result.getText().toString().equals("0")){
            number_result.setText("7");
        }
        else{number_result.append("7");}
    }
    public void onEight(View view){
        if (number_result.getText().toString().equals("0")){
            number_result.setText("8");
        }
        else{number_result.append("8");}
    }
    public void onNine(View view){
        if (number_result.getText().toString().equals("0")){
            number_result.setText("9");
        }
        else{number_result.append("9");}
    }
    public void onZero(View view) {
        if (!number_result.getText().toString().equals("0")) {
            number_result.append("0");
        }
    }
    public void onComma(View view) {
        text = number_result.getText().toString();
        if(!text.contains(",")){
            number_result.append(",");
        }

    }

}
