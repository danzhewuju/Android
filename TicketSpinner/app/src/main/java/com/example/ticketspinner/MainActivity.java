package com.example.ticketspinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    String Ticket;
    TextView txv;
    Spinner cinema,choose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txv = (TextView) findViewById(R.id.txv);
        cinema = (Spinner) findViewById(R.id.spinner);
        choose= (Spinner) findViewById(R.id.spinner);


    }

    public void order(View v) {
        String [] cinemas=getResources().getStringArray(R.array.cinemas);
        int ID = cinema.getSelectedItemPosition();
        Ticket=cinemas[ID];
        String []times=getResources().getStringArray(R.array.cinemas);
        int indox=choose.getSelectedItemPosition();

        txv.setText("已经订购"+Ticket+"\n你已经选择"+times[indox]+"场次");
    }
}
