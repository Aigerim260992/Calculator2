package com.example.myapplication;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ButtonFragment extends Fragment implements View.OnClickListener {
    Button changeHFragment;
    String oneAnswer;
    TextView textView;
    Double firstValues;
    Double secondValues;
    String operation;
    Double result;
    ArrayList<String> list = new ArrayList<>();
    HistoryFragment historyFragment = historyFragment = new HistoryFragment();

    public ButtonFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView =
                inflater.inflate(R.layout.fragment_button, container, false);

        Button zero = rootView.findViewById(R.id.button_zero);
        Button two = rootView.findViewById(R.id.button_two);
        Button one = rootView.findViewById(R.id.button_one);
        Button three = rootView.findViewById(R.id.button_three);
        Button four = rootView.findViewById(R.id.button_four);
        Button five = rootView.findViewById(R.id.button_five);
        Button six = rootView.findViewById(R.id.button_six);
        Button seven = rootView.findViewById(R.id.button_seven);
        Button eight = rootView.findViewById(R.id.button_eight);
        Button nine = rootView.findViewById(R.id.button_nine);
        Button clear = rootView.findViewById(R.id.clear);

        Button plus = rootView.findViewById(R.id.button_plus);
        Button minus = rootView.findViewById(R.id.button_minus);
        Button division = rootView.findViewById(R.id.button_divide);
        Button multiply = rootView.findViewById(R.id.button_multiply);
        Button equal = rootView.findViewById(R.id.button_equals);

        plus.setOnClickListener(this);
        minus.setOnClickListener(this);
        division.setOnClickListener(this);
        multiply.setOnClickListener(this);
        equal.setOnClickListener(this);


        zero.setOnClickListener(this);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        clear.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView = view.findViewById(R.id.result_txt_view);

        changeHFragment = view.findViewById(R.id.ch_fr_his);
        changeHFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ForButton listener = (ForButton) getActivity();
                listener.historyOpen_interface();
            }
        });

    }

    @Override
    public void onClick(View v) {
        translateIdToIndex(v.getId());
    }

    int translateIdToIndex(int id) {
        switch (id) {
            case R.id.button_zero:
                textView.append("0");
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
            case R.id.button_four:
                textView.append("4");
                break;
            case R.id.button_five:
                textView.append("5");
                break;
            case R.id.button_six:
                textView.append("6");
                break;
            case R.id.button_seven:
                textView.append("7");
                break;
            case R.id.button_eight:
                textView.append("8");
                break;
            case R.id.button_nine:
                textView.append("9");
                break;
            case R.id.clear:
                textView.setText("");
                break;
            case R.id.button_plus:
                operation(R.id.button_plus);
                break;
            case R.id.button_minus:
                operation(R.id.button_minus);
                break;
            case R.id.button_multiply:
                operation(R.id.button_multiply);
                break;
            case R.id.button_divide:
                operation(R.id.button_divide);
                break;
            case R.id.button_equals:
                operation(R.id.button_equals);
                break;
        }
        return id;
    }

    public void operation(int id) {
        switch (id) {
            case R.id.button_plus:
                operation = "+";
                firstValues = Double.valueOf(textView.getText().toString());
                textView.setText(firstValues + "+");
                break;
            case R.id.button_minus:
                operation = "-";
                firstValues = Double.valueOf(textView.getText().toString());
                textView.setText(firstValues + "-");
                break;
            case R.id.button_multiply:
                operation = "*";
                firstValues = Double.valueOf(textView.getText().toString());
                textView.setText(firstValues + "*");
                break;
            case R.id.button_divide:
                operation = "/";
                firstValues = Double.valueOf(textView.getText().toString());
                textView.setText(firstValues + "/");
                break;
            case R.id.button_equals:
                if (operation != null) {
                    String second = textView.getText().toString().replace(firstValues + operation + "", "");
                    secondValues = Double.valueOf(second);
                    switch (operation) {
                        case "+":
                            result = firstValues + secondValues;
                            textView.setText(firstValues + "+" + secondValues + "=" + result);
                            break;
                        case "-":
                            result = firstValues - secondValues;
                            textView.setText(firstValues + "-" + secondValues + "=" + result);
                            break;
                        case "*":
                            result = firstValues * secondValues;
                            textView.setText(firstValues + "*" + secondValues + "=" + result);
                            break;
                        case "/":
                            result = firstValues / secondValues;
                            textView.setText(firstValues + "/" + secondValues + "=" + result);
                            break;
                    }
                }
            default:
                break;
        }
    }

    public void sendAnswer() {
        changeFragment(historyFragment);
        Bundle bundle = new Bundle();
        oneAnswer = textView.getText().toString();
        list.add(oneAnswer);
        bundle.putStringArrayList("key", list);
        historyFragment.setArguments(bundle);
    }

    public void changeFragment(Fragment fragment) {
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.commit();
    }
}




