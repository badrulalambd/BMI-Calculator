package com.badrulacademy.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    android.widget.Button mCalculateBmi;
    TextView mCurrentHeight, mCurrentWeight, mCurrentAge;
    ImageView mIncrementAge, mIncrementWeight, mDecrementAge, mDecrementWeight;
    SeekBar mSeekBarForHeight;
    RelativeLayout mMale, mFemale;
    int intWeight = 55;
    int intAge = 22;
    int currentProgress;
    String mIntProgress = "170";
    String typeOfUser = "0";
    String weight2 = "55";
    String age2 = "22";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        mCalculateBmi = findViewById(R.id.calculateBMI_id);

        mCurrentAge = findViewById(R.id.currentAge_id);
        mCurrentWeight = findViewById(R.id.currentWeight_id);
        mCurrentHeight = findViewById(R.id.currentHeight_id);
        mIncrementAge = findViewById(R.id.incrementAge_id);
        mDecrementAge = findViewById(R.id.decrementAge_id);
        mIncrementWeight = findViewById(R.id.incrementWeight_id);
        mDecrementWeight = findViewById(R.id.decrementWeight_id);
        mSeekBarForHeight = findViewById(R.id.seekBarForHeight_id);
        mMale = findViewById(R.id.male_id);
        mFemale = findViewById(R.id.female_id);

        //Listener adding..............
        mMale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMale.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.male_female_focus));
                mFemale.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.male_female_not_focus));
                typeOfUser = "Male";
            }
        });
        mFemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFemale.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.male_female_focus));
                mMale.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.male_female_not_focus));
                typeOfUser = "Female";
            }
        });

        //Code of SeekBar......
        mSeekBarForHeight.setMax(300);
        mSeekBarForHeight.setProgress(170);
        mSeekBarForHeight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                currentProgress = progress;
                mIntProgress=String.valueOf(currentProgress);
                mCurrentHeight.setText(mIntProgress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //Listener with increment/decrement button
        mIncrementAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intAge = intAge+1;
                age2 = String.valueOf(intAge);
                mCurrentAge.setText(age2);
            }
        });
        mDecrementAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intAge = intAge-1;
                age2 = String.valueOf(intAge);
                mCurrentAge.setText(age2);
            }
        });

        mIncrementWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intWeight = intWeight+1;
                weight2 = String.valueOf(intWeight);
                mCurrentWeight.setText(weight2);
            }
        });
        mDecrementWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intWeight = intWeight-1;
                weight2 = String.valueOf(intWeight);
                mCurrentWeight.setText(weight2);
            }
        });






        //Listener with CalculateButton
        mCalculateBmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(typeOfUser.equals("0")){
                    Toast.makeText(getApplicationContext(), "Select Your Gender First", Toast.LENGTH_SHORT).show();
                }
                else if(mIntProgress.equals("0")){
                    Toast.makeText(getApplicationContext(), "Select Your Height First", Toast.LENGTH_SHORT).show();
                }
                else if(intAge==0 || intAge<0){
                    Toast.makeText(getApplicationContext(), "Age is Incorrect", Toast.LENGTH_SHORT).show();
                }
                else if(intWeight==0 || intWeight<0){
                    Toast.makeText(getApplicationContext(), "Weight is Incorrect", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intent = new Intent(MainActivity.this, BmiActivity.class);

                    intent.putExtra("gender", typeOfUser);
                    intent.putExtra("height", mIntProgress);
                    intent.putExtra("weight", weight2);
                    intent.putExtra("age", age2);

                    startActivity(intent);
                }

            }
        });
    }
}