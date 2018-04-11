package com.example.cjcu.bmi;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;

public class main_activity extends AppCompatActivity implements View.OnClickListener{
    private Context mContext;

    private EditText mCM;
    private EditText mKG;
    private Button mButton;
    private Button mHelp;
    private TextView mBMI;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        mContext=this;

        mCM=findViewById(R.id.mCM);
        mKG=findViewById(R.id.mKG);
        mButton=findViewById(R.id.mButton);
        mButton.setOnClickListener(this);
        mHelp=findViewById(R.id.mHelp);
        mHelp.setOnClickListener(this);
        mBMI=findViewById(R.id.mBMI);
    }

    @Override
    public void onClick(View view) {
        if(view.equals(mButton)){
            try {
                float cm = Float.parseFloat(mCM.getText().toString());
                float kg = Float.parseFloat(mKG.getText().toString());
                mBMI.setText("BMI : "+Math.round(kg/Math.pow(cm/100,2)*10)/10.0);
            } catch (Exception e) {
                // none
            }
        }
        else if(view.equals(mHelp)){
            new AlertDialog.Builder(this).setMessage("enter your info and press calculate").setTitle("Help").setPositiveButton("OK",null).show();

            Intent intent = new Intent(this,secondActivity.class);
            startActivity(intent);
        }

    }
}
