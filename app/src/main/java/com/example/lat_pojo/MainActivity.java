package com.example.lat_pojo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public Button btnMoveActivity;
    public Button btnMoveWithDataActivity;
    public Button btnMoveWithObject;
    Button btnDialNumber;
    Button btnMoveResult;
    TextView tvResult;

    private int REQUEST_CODE = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnMoveActivity = (Button)findViewById(R.id.btn_move_activity);
        btnMoveActivity.setOnClickListener(this);
        btnMoveWithDataActivity =
                (Button)findViewById(R.id.btn_move_with_data_activity);
        btnMoveWithDataActivity.setOnClickListener(this);
        btnMoveWithObject =
                (Button)findViewById(R.id.btn_move_activity_object);
        btnMoveWithObject.setOnClickListener(this);
        btnDialNumber = findViewById(R.id.btn_dial_number);
        btnDialNumber.setOnClickListener(this);
        btnMoveResult = findViewById(R.id.btn_move_for_result);
        btnMoveResult.setOnClickListener(this);
        tvResult = findViewById(R.id.tv_result);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_move_activity:
                Intent moveIntent = new Intent(MainActivity.this,
                        MoveActivity.class);
                startActivity(moveIntent);

                break;

            case R.id.btn_move_with_data_activity:
                Intent moveWithDataIntent = new Intent(MainActivity.this,
                        MoveWithDataActivity.class);
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME,
                        "......");
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE,
                        2);
                startActivity(moveWithDataIntent);

                break;

            case R.id.btn_move_activity_object:
                person mPerson = new person();
                mPerson.setName(".....");
                mPerson.setAge(1);

                mPerson.setEmail("awasgalak@gmail.com");

                mPerson.setCity("Bandung");
                Intent moveWithObjectIntent = new Intent(MainActivity.this,
                        MoveWithObjectActivity.class);
                moveWithObjectIntent.putExtra(MoveWithObjectActivity.EXTRA_PERSON, mPerson);
                startActivity(moveWithObjectIntent);

                break;

            case R.id.btn_dial_number:
                String phoneNumber = "089603796012";
                Intent dialPhoneIntent = new Intent(Intent.ACTION_DIAL,
                        Uri.parse("tel:" + phoneNumber));
                startActivity(dialPhoneIntent);

                break;

            case R.id.btn_move_for_result:
                Intent moveForResultIntent = new Intent(MainActivity.this,
                        MoveForResultActivity.class);
                startActivityForResult(moveForResultIntent, REQUEST_CODE);
                break;
        }
    }
}
