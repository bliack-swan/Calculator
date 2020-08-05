package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView result;
    TextView cal_symbol;
    char symbol;
    EditText input_place;
    double num1 ;
    double num2 ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = findViewById(R.id.result_number);
        cal_symbol = findViewById(R.id.cal_symbol);
        symbol = '=';
        input_place = findViewById(R.id.input_number);
    }
    public void onPlus(View view){
        cal_symbol.setText(getResources().getText(R.string.cal_plus));
        symbol = '+';
    }
    public void onMinus(View view){
        cal_symbol.setText(getResources().getText(R.string.cal_minus));
        symbol = '-';
    }
    public void onStar(View view){
        cal_symbol.setText(getResources().getText(R.string.cal_star));
        symbol = 'x';
    }
    public void onSlash(View view){
        cal_symbol.setText(getResources().getText(R.string.cal_slash));
        symbol = '/';
    }
    public void onRoof(View view){
        cal_symbol.setText(getResources().getText(R.string.cal_roof));
        symbol = '^';
    }
    public void onEqual(View view){
        num1 = Double.parseDouble(result.getText().toString());
        num2 = Double.parseDouble(input_place.getText().toString());
        switch (symbol){
                case '=':
                    num1 = num2;
                    break;
                case '+':
                    num1 += num2;
                    break;
                case '-':
                    num1 -= num2;
                    break;
                case 'x':
                    num1 *= num2;
                    break;
                case '/':
                    num1 /= num2;
                    break;
                case '^':
                    num1 = Math.pow(num1,num2);
                    break;
            }
            result.setText(String.valueOf(num1));
        }
    public void onReset(View view){
        num1 = 0;
        cal_symbol.setText(getResources().getText(R.string.cal_equal));
        result.setText(String.valueOf(num1));
    }
    }
