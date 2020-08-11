package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Base64DataException;
import android.util.Log;
import android.util.LogPrinter;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView number_result;
    private Button knopka_plus;
    private Button knopka_minus;
    private Button knopka_star;
    private Button knopka_slash;
    private Button knopka_roof;
    private Button[] array_knopka;
    private String symbol = "";
    private String text_buffer;
    private Double num1;
    private Double num2;
    private boolean isWait = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        number_result = findViewById(R.id.result_number);
        num1 = 0.0;
        knopka_plus = findViewById(R.id.plus);
        knopka_minus = findViewById(R.id.minus);
        knopka_star = findViewById(R.id.star);
        knopka_slash = findViewById(R.id.slash);
        knopka_roof = findViewById(R.id.roof);
        array_knopka = new Button[] {knopka_plus,knopka_minus,knopka_roof,knopka_slash,knopka_star};
    }
    public void drawKnopka(Integer id_knopka){
        for (Button button : array_knopka) {
            if (button.getId() == id_knopka) {
                button.setBackgroundColor(getResources().getColor(R.color.color_white_purple));
            }else{
            button.setBackgroundColor(getResources().getColor(R.color.color_purple));}
        }
    }

    // Operation button
    public void onPlus(View view) {
        drawKnopka(R.id.plus);
        operation(view, "+");
    }

    public void onMinus(View view) {
        drawKnopka(R.id.minus);
        operation(view, "-");
    }

    public void onStar(View view) {
        drawKnopka(R.id.star);
        operation(view, "x");
    }

    public void onSlash(View view) {
        drawKnopka(R.id.slash);
        operation(view,"/");
    }

    public void onRoof(View view) {
        drawKnopka(R.id.roof);
        operation(view,"^");
    }
    public void operation(View view, String char_){
        if (number_result.getText().toString().equals("Infinity")) {
            onReset(view);
        }if(isWait){
            if (num1 != null && symbol.equals(char_)){
                onEqual(view); }
            else{symbol= char_;}
        } else{
            symbol= char_;
            num2 = myInputFilter(number_result.getText().toString());
            isWait = true;
            num1 = null;
        }
    }

    public void onEqual(View view) {
        if (number_result.getText().toString().equals("Infinity")) {
            onReset(view);
        }
        switch (symbol){
        case "+":
            num2 += num1;
            number_result.setText(myOutputFilter(cutDouble(num2)));
            break;
        case "-":
            num2 -= num1;
            number_result.setText(myOutputFilter(cutDouble(num2)));
            break;
        case "x":
            num2 *= num1;
            number_result.setText(myOutputFilter(cutDouble(num2)));
            break;
        case "/":
            num2 /= num1;
            number_result.setText(myOutputFilter(cutDouble(num2)));
            break;
        case "^":
            num2 = Math.pow(num2, num1);
            number_result.setText(myOutputFilter(cutDouble(num2)));
            break;
    }
    }
    public void onOrientation(View view){
        if (number_result.getText().toString().equals("Infinity")) {
            onReset(view);
        }
        double num3 = myInputFilter(number_result.getText().toString());
        num3 = -num3;
        number_result.setText(myOutputFilter(cutDouble(num3)));
        num1 = num3;
    }


    public void onReset(View view) {
        number_result.setText("0");
        num1 = 0.0 ;
        num2 = 0.0 ;
        symbol = "";
        for (Button button : array_knopka) {
                button.setBackgroundColor(getResources().getColor(R.color.color_purple));
        }
    }
    public void onDel(View view){
        if (number_result.getText().toString().equals("Infinity")) {
            onReset(view);
        }
        text_buffer = number_result.getText().toString();
        if (text_buffer.contains("E")){
            return;
        }
        else if( text_buffer.length() == 1){
            if (text_buffer.equals("0")) {
                return;
            }
            number_result.setText("0");
        }else {number_result.setText(text_buffer.substring(0,text_buffer.length()-1));
        if(number_result.getText().toString().equals("-")){number_result.setText("0");}}
        num1 = myInputFilter(number_result.getText().toString());
    }
    // Calculation button
    public void onOne(View view){
        onNumber(view,1);}

    public void onTwo(View view){
        onNumber(view,2);}

    public void onThree(View view){
        onNumber(view,3);}

    public void onFour(View view){
        onNumber(view,4);}

    public void onFive(View view){
        onNumber(view,5);}

    public void onSix(View view){
        onNumber(view,6);}

    public void onSeven(View view){
        onNumber(view,7);}

    public void onEight(View view){
        onNumber(view,8);}

    public void onNine(View view){
        onNumber(view,9); }

    public void onNumber(View view, Integer number){
        if (number_result.getText().toString().equals("Infinity")) {
            onReset(view);
        }
        if (number_result.getText().toString().equals("0") || isWait){
            number_result.setText(String.valueOf(number));
            isWait = false;
        }
        else{number_result.append(String.valueOf(number));}
        num1 = myInputFilter(number_result.getText().toString());
    }
    public void onZero(View view) {
        if (number_result.getText().toString().equals("Infinity")) {
            onReset(view);
        }
        if (isWait){
            number_result.setText("0");
        }
        if (!number_result.getText().toString().equals("0")) {
            number_result.append("0");
        }
        num1 = myInputFilter(number_result.getText().toString());
    }
    public void onComma(View view) {
        if (number_result.getText().toString().equals("Infinity")) {
            onReset(view);
        }
        text_buffer = number_result.getText().toString();
        if (text_buffer.isEmpty() || isWait){
            number_result.setText("0,");
            num1 = 0.0;
        }
        else if(!text_buffer.contains(",")){
            number_result.append(",");
        }

    }
    // Static method
    private static double myInputFilter(String text_f){
        text_f = text_f.replace(',','.');
        return  Double.parseDouble(text_f);
    }
    private static String myOutputFilter(String text_f){
        text_f = text_f.replace('.',',');
        return  text_f;
    }
    private static String cutDouble(Double num){
        if (!num.isInfinite()){
            String[] twoPart = String.valueOf(num).split("[.]");
            if (twoPart[1].equals("0")){
                return twoPart[0];}
            else{return String.valueOf(num);}}
        else{return "Infinity";}

    }

}


