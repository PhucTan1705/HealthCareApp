package com.example.healthcare_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class FindDoctorMainActivity extends AppCompatActivity {
    ImageView VTback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_doctor_main);

        CardView KhoaNhi =findViewById(R.id.cardFDKhoaNhi);
        KhoaNhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it= new Intent(FindDoctorMainActivity.this,DoctorDetailsActivity.class);
                it.putExtra("title","Bác Khoa Nhi");
                startActivity(it);
            }
        });

        CardView DocBone =findViewById(R.id.cardFDBone);
        DocBone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it= new Intent(FindDoctorMainActivity.this,DoctorDetailsActivity.class);
                it.putExtra("title","Bác Sĩ Xướng Khớp");
                startActivity(it);
            }
        });

        VTback=findViewById(R.id.VTBackFD);


        VTback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FindDoctorMainActivity.this, HomeActivity.class));
            }
        });

        CardView TQphysician =findViewById(R.id.cardFDFamilyTongQuat);
       TQphysician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it= new Intent(FindDoctorMainActivity.this,DoctorDetailsActivity.class);
                it.putExtra("title","Bác Sĩ Khám Tổng Quát");
                startActivity(it);
            }
        });

        CardView dietician =findViewById(R.id.cardFDDietician);
        dietician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it= new Intent(FindDoctorMainActivity.this,DoctorDetailsActivity.class);
                it.putExtra("title","Chuyên Gia Dinh Dưỡng");
                startActivity(it);
            }
        });

        CardView dentist =findViewById(R.id.cardFDDentist);
        dentist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it= new Intent(FindDoctorMainActivity.this,DoctorDetailsActivity.class);
                it.putExtra("title","Nha Sĩ");
                startActivity(it);
            }
        });

        CardView surgeon =findViewById(R.id.cardFDSurgeon);
        surgeon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it= new Intent(FindDoctorMainActivity.this,DoctorDetailsActivity.class);
                it.putExtra("title","Giải Phẫu");
                startActivity(it);
            }
        });

        CardView cardiologists =findViewById(R.id.cardFDCardiologists);
        cardiologists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it= new Intent(FindDoctorMainActivity.this,DoctorDetailsActivity.class);
                it.putExtra("title","Bác Sĩ Tim Mạch");
                startActivity(it);
            }
        });

        CardView bsmat =findViewById(R.id.cardFDEye);
        bsmat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it= new Intent(FindDoctorMainActivity.this,DoctorDetailsActivity.class);
                it.putExtra("title","Bác Sĩ Mắt");
                startActivity(it);
            }
        });

        CardView bstk =findViewById(R.id.cardFDTK);
        bstk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it= new Intent(FindDoctorMainActivity.this,DoctorDetailsActivity.class);
                it.putExtra("title","Bác Thần Kinh");
                startActivity(it);
            }
        });

    }
}