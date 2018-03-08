package com.uni.aisopp.palindrom_tester;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnCheckIfPalindrome;
    private TextView labelOutput;
    private EditText editInputString;
    private int outputLabelTextColour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCheckIfPalindrome = findViewById(R.id.btn_check_palindrome);
        labelOutput = findViewById(R.id.label_output);
        editInputString = findViewById(R.id.editText_palindrome_input);

        labelOutput.setText("");
        btnCheckIfPalindrome.setOnClickListener(onCheckIfPalindromeClickListener);
        outputLabelTextColour = labelOutput.getCurrentTextColor();
    }

    private View.OnClickListener onCheckIfPalindromeClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int resultCode = PalindromeTester.isPalindrome(editInputString.getText().toString());
            switch (resultCode) {
                case PalindromeTester.IS_EMPTY:
                    setErrorOutputLabelColour(getString(R.string.empty_input));
                    break;
                case PalindromeTester.IS_LESS_THAN_FIVE:
                    setErrorOutputLabelColour(getString(R.string.too_short_input));
                    break;
                case PalindromeTester.IS_NO_PALINDROME:
                    setOutputLabel(getString(R.string.is_no_palindrome));
                    break;
                case PalindromeTester.IS_PALINDROME:
                    setOutputLabel(getString(R.string.is_palindrome));
                    break;
            }
        }
    };


    /**
     *
     * @param response string to send to ui
     */
    private void setOutputLabel(String response) {
        labelOutput.setTextColor(outputLabelTextColour);
        labelOutput.setText(response);
    }

    /**
     * an input error occurs
     * @param error string to send ui
     */
    private void setErrorOutputLabelColour(String error){
        labelOutput.setTextColor(Color.RED);
        labelOutput.setText(error);
    }

}
