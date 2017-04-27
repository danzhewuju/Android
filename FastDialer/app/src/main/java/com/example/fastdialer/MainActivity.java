package com.example.fastdialer;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void Call(View view){
        Intent it=new Intent();
        it.setAction(Intent.ACTION_VIEW);
        it.setData(Uri.parse("tel:15901867519"));
        startActivity(it);
    }
}
