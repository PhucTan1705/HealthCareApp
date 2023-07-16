package com.example.healthcare_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class HADetailsActivity extends AppCompatActivity {
    TextView tv1;
    ImageView img, VTBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hadetails);

        VTBack=findViewById(R.id.VTBackHAD);
        tv1=findViewById(R.id.textViewHADTitle);
        img=findViewById(R.id.imageView);

        Intent intent=getIntent();
        tv1.setText(intent.getStringExtra("text1"));
        Bundle bundle=getIntent().getExtras();
        if(bundle!=null){
            int resID=bundle.getInt("text2");
            img.setImageResource(resID);
        }
        VTBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HADetailsActivity.this,healthArticlesActivity.class));
            }
        });
    }
}