package com.example.user.a2018038008;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button1;
    Button button2;
    private RadioGroup rg;
    private ImageView img;
    EditText text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setIcon(R.drawable.ic_launcher);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        rg = (RadioGroup)findViewById(R.id.radioGroup);
        img = (ImageView)findViewById(R.id.imageView);

        text = (EditText)findViewById(R.id.editText);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String msg = text.getText().toString(); // EditText 객체에 입력한 문자열 읽어옴
                Toast.makeText(getApplicationContext(), msg,
                        Toast.LENGTH_SHORT).show();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String msg = text.getText().toString();
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse(msg));
                startActivity(intent);
            }
        });

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                String  result;
                if(checkedId == R.id.radioButton)
                    img.setImageResource(R.drawable.oreo);
                else if (checkedId == R.id.radioButton2)
                    img.setImageResource(R.drawable.pie);
            }
        });

    }
}
