package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    TextView textView;

    Double firstValue;
    Double secondValue;
    String operation;
    Double result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        Intent intent = getIntent();

    }

    public void onNumberClick(View view) {
        switch (view.getId()) {
            case R.id.button_seven:
                textView.append("7");
                break;
            case R.id.button_eight:
                textView.append("8");
                break;
            case R.id.button_nine:
                textView.append("9");
                break;
            case R.id.button_four:
                textView.append("4");
                break;
            case R.id.button_five:
                textView.append("5");
                break;
            case R.id.button_six:
                textView.append("6");
                break;
            case R.id.button_one:
                textView.append("1");
                break;
            case R.id.button_two:
                textView.append("2");
                break;
            case R.id.button_three:
                textView.append("3");
                break;
            case R.id.button_zero:
                textView.append("0");
                break;

            case R.id.button_point:
                if (textView.getText().toString().length() > 0) {
                    textView.append(".");
                    break;
                } else {
                    textView.setText("");
                    break;
                }
            case R.id.button_clear:
                textView.setText("");
                break;
        }
    }

    public void onOperationClick(View view) {
        switch (view.getId()) {
            case R.id.button_plus:
                operation = "+";
                firstValue = Double.valueOf(textView.getText().toString());
                textView.setText(firstValue + "+");
                break;
            case R.id.button_minus:
                operation = "-";
                firstValue = Double.valueOf(textView.getText().toString());
                textView.setText(firstValue + "-");
                break;
            case R.id.button_multiply:
                operation = "*";
                firstValue = Double.valueOf(textView.getText().toString());
                textView.setText(firstValue + "*");
                break;
            case R.id.button_divide:
                operation = "/";
                firstValue = Double.valueOf(textView.getText().toString());
                textView.setText(firstValue + "/");
                break;
            case R.id.button_equals:

                if (operation != null) {
                    String second = textView.getText().toString().replace(firstValue + operation + "", "");
                    secondValue = Double.valueOf(second);


                    switch (operation) {
                        case "+":
                            result = firstValue + secondValue;
                            textView.setText(firstValue + "+" + secondValue + "=" + result);
                            break;
                        case "-":
                            result = firstValue - secondValue;
                            textView.setText(firstValue + "-" + secondValue + "=" + result);
                            break;
                        case "*":
                            result = firstValue * secondValue;
                            textView.setText(firstValue + "*" + secondValue + "=" + result);
                            break;
                        case "/":
                            result = firstValue / secondValue;
                            textView.setText(firstValue + "/" + secondValue + "=" + result);
                            break;
                    }
                }
                Intent intent1 = new Intent();
                intent1.putExtra("result", result.toString());
                setResult(RESULT_OK,intent1);
                finish();
            default:
                break;

        }

    }
}