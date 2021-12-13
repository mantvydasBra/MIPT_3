package com.example.mipt_3;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import org.mariuszgromada.math.mxparser.Expression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MainActivity extends AppCompatActivity {

    Button btnZero, btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight,
            btnNine, btnClear, btnMod, btnDiv, btnRoot, btnMultiply, btnSub, btnAdd, btnEqual,
            btnDot, btnPlusMinus;
    ImageButton btnDel;
    TextView txtCalculatorScreen;
    ConstraintLayout mainLayout;
    Boolean solved = false;

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
        mainLayout = findViewById(R.id.mainLayout);

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
            checkForSolved();
            clearText();
        });

        btnDel.setOnClickListener(view -> {
            checkForSolved();
            deleteChar();
        });

        btnMod.setOnClickListener(view -> updateText("%"));

        btnDiv.setOnClickListener(view -> updateText("÷"));

        btnRoot.setOnClickListener(view -> updateText("√"));

        btnMultiply.setOnClickListener(view -> updateText("×"));

        btnSub.setOnClickListener(view -> updateText("-"));

        btnAdd.setOnClickListener(view -> updateText("+"));

        btnEqual.setOnClickListener(view -> {
            calculate();
            solved = true;
        });

        btnDot.setOnClickListener(view -> updateText("."));

        btnPlusMinus.setOnClickListener(view -> changeSign());
    }

    public void changeSign () {
        txtCalculatorScreen.setTextColor(Color.WHITE);
        CharSequence textHolder = txtCalculatorScreen.getText();
        txtCalculatorScreen.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);
        // StringBuilder to make it more simple
        StringBuilder sb = new StringBuilder(textHolder);
        // If it's the first character, just add it
        if (textHolder.length() == 0) {
            txtCalculatorScreen.setText("-");
        }
        // if there is only one character and it's a -, just remove it
        else if (textHolder.length() == 1 && textHolder.charAt(0) == '-') {
            deleteChar();
        }
        // If there is a - in front, remove it from front
        else if (textHolder.charAt(0) == '-') {
            txtCalculatorScreen.setText(textHolder.toString().substring(1));
        }
        // Else, just add in front of string with StringBuilder.
        else {
            sb.insert(0, '-');
            textHolder = sb.toString();
            txtCalculatorScreen.setText(textHolder);
        }
    }

    public void updateText(String charToAdd) {
        txtCalculatorScreen.setTextColor(Color.WHITE);
        txtCalculatorScreen.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);
        CharSequence textHolder = txtCalculatorScreen.getText();

        // First clear text if there was a solved equation recently
        checkForSolved();

        // If there is only one number and it's a 0, replace the 0 by new number
        if (textHolder.length() == 1 && textHolder.charAt(0) == '0' && !charToAdd.equals(".") ) {
            txtCalculatorScreen.setText(String.format("%s", charToAdd));
            return;
        }
        // Don't allow to start the equation with specific symbols
        else if (textHolder.length() == 0) {
            if (charToAdd.equals("%") || charToAdd.equals("×") || charToAdd.equals("÷") || charToAdd.equals("+")) {
                txtCalculatorScreen.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
                return;
            }
        }
        // Check if last character is a symbol, if yes - don't allow to add a repeating one
        else if (charToAdd.equals("×") || charToAdd.equals("÷") || charToAdd.equals("-") || charToAdd.equals("+")) {
            String specialChars = "×÷+-";
            String lastChar = String.valueOf(textHolder.charAt(textHolder.length() - 1));
            String nextToLastChar = "";
            // Check if there is more than 2 chars, to not error out
            // Store a character if it's a symbol (for when there is *-, ÷- etc.. to change it)
            if (textHolder.length() > 2) {
                String temporary = String.valueOf(textHolder.charAt(textHolder.length() - 2));
                if (specialChars.contains(temporary))
                    nextToLastChar = temporary;
            }
            // If last symbol is + and entered is -, swap them.
            if (lastChar.equals("+") && charToAdd.equals("-")) {
                deleteChar();
            }
            else if (nextToLastChar.isEmpty()) {
                // Otherwise, delete last character if char to add isn't a -
                if (specialChars.contains(lastChar) && !charToAdd.equals("-")) {
                        deleteChar();
                }
                // If entered symbol is same as the last, delete it.
                else if (lastChar.equals(charToAdd)) {
                    deleteChar();
                }
            }
            // If last char is - and there is another symbol in front of it, change them with new symbol.
            else if (specialChars.contains(lastChar)) {
                deleteChar();
                deleteChar();
            }

        }
        // Split numbers by symbols to check for floating point operator
        else if (charToAdd.equals(".")) {
            String[] numbers = textHolder.toString().split("[×÷\\-+]");
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

    // Delete 1 character
    public void deleteChar () {
        if (!txtCalculatorScreen.getText().toString().equals("")) {
            txtCalculatorScreen.setText(txtCalculatorScreen.getText().toString().substring(0, txtCalculatorScreen.getText().length() - 1));
            if (txtCalculatorScreen.getText().toString().equals(""))
                txtCalculatorScreen.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
        }
    }

    // Delete whole text
    public void clearText () {
        if (!txtCalculatorScreen.getText().toString().equals("")) {
            txtCalculatorScreen.setText("");
            txtCalculatorScreen.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
        }
    }

    // Check if it was solved recently
    public void checkForSolved () {
        if (solved) {
            clearText();
            solved = false;
        }
    }

    public void calculate () {
        txtCalculatorScreen.setTextColor(Color.WHITE);
        txtCalculatorScreen.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);
        String equation = txtCalculatorScreen.getText().toString();
        // Don't do anything if there are less than 2 digits
        if (equation.length() < 2) {
            return;
        }

        // Replace special chars
        equation = equation.replaceAll("÷", "/");
        equation = equation.replaceAll("×", "*");
        equation = equation.replaceAll("(\\d)√", "$1*√");
        equation = equation.replaceAll("√+(\\d)", "sqrt($1)");

        Pattern pattern = Pattern.compile("/0");
        Matcher matcher = pattern.matcher(equation);
        // Check for division by 0
        if (matcher.find()) {
            txtCalculatorScreen.setText(String.format("%s\n%s", txtCalculatorScreen.getText(), "Can't divide by 0!"));
            return;
        }


        Expression exp = new Expression(equation);
        // For debugging
        exp.checkSyntax();
        System.out.println(exp.getErrorMessage());
        String result = String.valueOf(exp.calculate());

        if (result.equals("NaN")) {
            result = "Error!";
        }

        // Setting max chars for answer to not flood the textview
        txtCalculatorScreen.setText(String.format("%s\n%.13s", txtCalculatorScreen.getText(), result));
    }
}