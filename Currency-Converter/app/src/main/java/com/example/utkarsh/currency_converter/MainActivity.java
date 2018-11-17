package com.example.utkarsh.currency_converter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Declare the UI variable classes for UI elements subject to change
    TextView converted_value_in_dollar, converted_value_in_euro;
    EditText enter_value_in_inr;
    Button convert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Loads the UI in the Activity
        setContentView(R.layout.activity_main);

        //Instantiate the UI variable classes
        converted_value_in_dollar = (TextView)findViewById(R.id.value_in_dollar);
        converted_value_in_euro = (TextView)findViewById(R.id.converted_value_euro);
        enter_value_in_inr = (EditText)findViewById(R.id.editText);

        convert = (Button)findViewById(R.id.button);
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Check if value is less than = 1000
                //Obtain value in INR from edit text
                String value = enter_value_in_inr.getText().toString();

                //Check if value is not nil
                if(!value.equals("")) {

                    //convert value in string to integer
                    float value_float = Float.parseFloat(value);
                    //Set back the edit text value to blank
                    enter_value_in_inr.setText("");

                    //Check if the value is less than 1000
                    if (value_float <= 1000) {
                        //convert and display
                        //convert inr to $
                        float dollar_value = (float) value_float / 71.79f;
                        //set text for textview for $
                        converted_value_in_dollar.setText("Value in $ " + ": " + dollar_value);
                        //convert int to euro
                        float euro_value = (float) value_float / 81.98f;
                        //set text for textview for euro
                        converted_value_in_euro.setText("Value in Euro : " + euro_value);
                    } else {
                        //Displays short toast message.
                        Toast.makeText(getApplicationContext(), "Please enter a value less than 1000", Toast.LENGTH_SHORT).show();
                        //Resets the values of textviews to nil
                        converted_value_in_dollar.setText("Value in $ " + ": ");
                        converted_value_in_euro.setText("Value in Euro : ");

                    }
                }else{
                    Toast.makeText(getApplicationContext(), "Please enter a valid integer value less than 1000", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
