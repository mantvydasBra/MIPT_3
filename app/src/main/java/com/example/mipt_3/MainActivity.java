package com.example.mipt_3;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    Button btnZero, btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight,
            btnNine, btnClear, btnMod, btnDiv, btnRoot, btnMultiply, btnSub, btnAdd, btnEqual,
            btnDot, btnPlusMinus;
    ImageButton btnDel;
    TextView txtCalculatorScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnZero = findViewById(R.id.btnZero);
        btnOne = findViewById(R.id.btnOne);
        btnTwo = findViewById(R.id.btnTwo);
        btnThree = findViewById(R.id.btnThree);
        btnFour = findViewById(R.id.btnFour);
        btnFive = findViewById(R.id.btnFive);
        btnSix = findViewById(R.id.btnSix);
        btnSeven = findViewById(R.id.btnSeven);
        btnEight = findViewById(R.id.btnEight);
        btnNine = findViewById(R.id.btnNine);
        btnClear = findViewById(R.id.btnClear);
        btnDel = findViewById(R.id.btnDel);
        btnMod = findViewById(R.id.btnMod);
        btnDiv = findViewById(R.id.btnDiv);
        btnRoot = findViewById(R.id.btnSqrRoot);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnSub = findViewById(R.id.btnSub);
        btnAdd = findViewById(R.id.btnAdd);
        btnEqual = findViewById(R.id.btnEqual);
        btnDot = findViewById(R.id.btnDot);
        btnPlusMinus = findViewById(R.id.btnPlusMinus);
        txtCalculatorScreen = findViewById(R.id.txtCalculatorScreen);

        btnZero.setOnClickListener(view -> updateText("0"));

        btnOne.setOnClickListener(view -> updateText("1"));

        btnTwo.setOnClickListener(view -> updateText("2"));

        btnThree.setOnClickListener(view -> updateText("3"));

        btnFour.setOnClickListener(view -> updateText("4"));

        btnFive.setOnClickListener(view -> updateText("5"));

        btnSix.setOnClickListener(view -> updateText("6"));

        btnSeven.setOnClickListener(view -> updateText("7"));

        btnEight.setOnClickListener(view -> updateText("8"));

        btnNine.setOnClickListener(view -> updateText("9"));

        btnClear.setOnClickListener(view -> {
            if (!txtCalculatorScreen.getText().toString().equals("")) {
                txtCalculatorScreen.setText("");
                txtCalculatorScreen.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
            }
        });

        btnDel.setOnClickListener(view -> deleteChar());

        btnMod.setOnClickListener(view -> updateText("%"));

        btnDiv.setOnClickListener(view -> updateText("÷"));

        btnRoot.setOnClickListener(view -> updateText("√"));

        btnMultiply.setOnClickListener(view -> updateText("×"));

        btnSub.setOnClickListener(view -> updateText("-"));

        btnAdd.setOnClickListener(view -> updateText("+"));

        btnEqual.setOnClickListener(view -> {

        });

        btnDot.setOnClickListener(view -> updateText("."));

        btnPlusMinus.setOnClickListener(view -> updateText("±"));
    }

    public void updateText(String charToAdd) {
        txtCalculatorScreen.setTextColor(Color.WHITE);
        txtCalculatorScreen.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);
        CharSequence textHolder = txtCalculatorScreen.getText();

        // If there is only one number and it's a 0, replace the 0 by new number
        if (textHolder.length() == 1 && textHolder.charAt(0) == '0') {
            txtCalculatorScreen.setText(String.format("%s", charToAdd));
            return;
        }
        // Don't allow to start the equation with specific symbols
        else if (textHolder.length() == 0) {
            if (charToAdd.equals("±") || charToAdd.equals("×") || charToAdd.equals("÷"))
                return;
        }
        // TODO: fix this shit
        // Check if last character is a symbol, if yes - don't allow to add a repeating one
        else if (charToAdd.equals("×") || charToAdd.equals("÷") || charToAdd.equals("-") || charToAdd.equals("+")) {
            String lastChar = String.valueOf(textHolder.charAt(textHolder.length() - 1));
            // Check if there are already any symbols
            String[] numbers = textHolder.toString().split("×÷-+");
            if (charToAdd.equals(lastChar)) {
                return;
            }
            else if (charToAdd.equals("-") && !lastChar.equals('-')) {
            }
            else if (numbers.length != 0){
                deleteChar();
            }
        }
        // Split numbers by symbols to check for floating point operator
        else if (charToAdd.equals(".")) {
            String[] numbers = textHolder.toString().split("×÷-+");
            if (numbers.length != 0) {
                String temp = numbers[numbers.length - 1]; // Get last member of array, since we only need to check for current number
                for (int i = 0; i < temp.length(); i++) {
                    // If we find a dot in latest number, return (don't let to add another dot)
                    if (temp.charAt(i) == '.') {
                        return;
                    }
                }
            }
        }
        txtCalculatorScreen.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);
        txtCalculatorScreen.setText(String.format("%s%s", txtCalculatorScreen.getText(), charToAdd));
    }

    public void deleteChar () {
        if (!txtCalculatorScreen.getText().toString().equals("")) {
            txtCalculatorScreen.setText(txtCalculatorScreen.getText().toString().substring(0, txtCalculatorScreen.getText().length() - 1));
            if (txtCalculatorScreen.getText().toString().equals(""))
                txtCalculatorScreen.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
        }
    }

}