package com.example.datetimepicker;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements
        View.OnClickListener,DatePickerDialog.OnDateSetListener,
        TimePickerDialog.OnTimeSetListener
{
   Calendar c=Calendar.getInstance();
    TextView txvDate;
    TextView txvTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txvDate= (TextView) findViewById(R.id.textView1);
        txvTime=(TextView)findViewById(R.id.textView2);
        txvDate.setOnClickListener(this);
        txvTime.setOnClickListener(this);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
txvDate.setText("日期："+year+"/"+month+"/"+dayOfMonth);
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
txvTime.setText("时间："+hourOfDay+":"+minute);
    }

    @Override
    public void onClick(View v) {
            if(v==txvDate){
                new DatePickerDialog(this,this,c.get(Calendar.YEAR),c.get(Calendar.MONTH),c.get(Calendar.DAY_OF_MONTH)).show();
            }
            else if(v==txvTime){
                new TimePickerDialog(this,this,c.get(Calendar.HOUR_OF_DAY),c.get(Calendar.MINUTE),true).show();
            }
    }
}
