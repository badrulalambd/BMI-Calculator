package com.badrulacademy.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class BmiActivity extends AppCompatActivity {

    android.widget.Button mRecalculateBmi;

    TextView mBmiDisplay, mBmiCategory, mGender;
    Intent intent;
    ImageView mImageView;
    String mBmi;
    float intBmi;
    String height, weight;
    float intHeight, intWeight;
    RelativeLayout mBackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        getSupportActionBar().setElevation(0);
        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"white\"></font>"));
        getSupportActionBar().setTitle("Result");
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#1e1d1d"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);


        intent = getIntent();
        mBmiDisplay = findViewById(R.id.bmiDisplay_id);
        mBmiCategory = findViewById(R.id.bmiCategory_id);
        mGender = findViewById(R.id.gendreDisplay_id);
        mBackground = findViewById(R.id.contentLayout_id);
        mImageView = findViewById(R.id.imageView_id);
        mRecalculateBmi = findViewById(R.id.reCalculateBMI_id);

        height = intent.getStringExtra("height");
        weight  = intent.getStringExtra("weight");

        intHeight = Float.parseFloat(height);
        intWeight = Float.parseFloat(weight);

        intHeight = intHeight/100;
        intBmi = intWeight/(intHeight*intHeight);

        mBmi = Float.toString(intBmi);

        if(intBmi<16){
            mBmiCategory.setText("Severe Thinness");
            mBackground.setBackgroundColor(Color.RED);
            mImageView.setImageResource(R.drawable.crosss);
        }
        else if(intBmi<16.9 && intBmi>16 ){
            mBmiCategory.setText("Moderate Thinness");
            mBackground.setBackgroundColor(Color.RED);
            mImageView.setImageResource(R.drawable.warning);
        }
        else if(intBmi<18.4 && intBmi>17 ){
            mBmiCategory.setText("Mild Thinness");
            mBackground.setBackgroundColor(Color.RED);
            mImageView.setImageResource(R.drawable.warning);
        }
        else if(intBmi<25 && intBmi>18.4 ){
            mBmiCategory.setText("Normal");
            //mBackground.setBackgroundColor(Color.YELLOW);
            mImageView.setImageResource(R.drawable.ok);
        }
        else if(intBmi<29.4 && intBmi>25){
            mBmiCategory.setText("Overweight");
            mBackground.setBackgroundColor(Color.RED);
            mImageView.setImageResource(R.drawable.warning);
        }
        else {
            mBmiCategory.setText("Obese Class 1");
            mBackground.setBackgroundColor(Color.RED);
            mImageView.setImageResource(R.drawable.warning);
        }

        mGender.setText(intent.getStringExtra("gender"));
        mBmiDisplay.setText(mBmi);





        mRecalculateBmi = findViewById(R.id.reCalculateBMI_id);

        mRecalculateBmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BmiActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}