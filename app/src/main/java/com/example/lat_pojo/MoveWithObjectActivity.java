package com.example.lat_pojo;

import android.app.Person;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lat_pojo.R;
public class MoveWithObjectActivity extends AppCompatActivity {
    public static String EXTRA_PERSON = " extra_person";
    public TextView tvObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_with_object);
        tvObject = (TextView)findViewById(R.id.tv_object_received);
        person mPerson = getIntent().getParcelableExtra(EXTRA_PERSON);
        String text = "Name : "+mPerson.getName()+", Email :"+
        mPerson.getEmail() + "Age : "+mPerson.getAge()+" Location :"+
        mPerson.getCity();
        tvObject.setText(text);
    }
}