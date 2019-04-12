package com.example.tax;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText sal, viewcal;
    Button cal;
    Double total,taxis;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sal=findViewById(R.id.salary);
        viewcal=findViewById(R.id.viewcal);
        cal=findViewById(R.id.cal);

        cal.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        total = Double.parseDouble(sal.getText().toString())*12;

        switch (v.getId()) {
            case R.id.cal:
                if(total>=1 && total<200000){
                    taxis = (total/100);
                    viewcal.setText("Rs " + taxis.toString());
                }
                else if (total>=200000 && total<350000){
                    taxis= 2000 +((total -200000)* 0.15);
                    viewcal.setText("Rs " + taxis.toString());
                }
                else if(total>=350000){
                    taxis= 2000 + 22500 +((total - 350000)*0.25);
                    viewcal.setText("Rs " + taxis.toString());
                }
                break;
        }
    }
}
