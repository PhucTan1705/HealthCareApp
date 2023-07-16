package com.example.healthcare_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String[][] doctor_details1=
            {
                    {"Tên BS: BS Tổng Quát 1","ĐC: HCM City","KN: 5yrs","ĐT:9898989898","600000"},
                    {"Tên BS: BS Tổng Quát 2","ĐC: TN","KN: 15yrs","ĐT:7898989898","900000"},
                    {"Tên BS: BS Tổng Quát 3","ĐC: HN City","KN: 8yrs","ĐT:8898989898","3000000"},
                    {"Tên BS: BS Tổng Quát 4","ĐC: DN","KN: 6yrs","ĐT:9898000000","500000"},
                    {"Tên BS: BS Tổng Quát 5","ĐC: BD","KN: 7yrs","ĐT:7798989898","800000"},
                    {"Tên BS: BS Tổng Quát 6","ĐC: BD","KN: 7yrs","ĐT:7798989898","800000"},
                    {"Tên BS: BS Tổng Quát 7","ĐC: BD","KN: 7yrs","ĐT:7798989898","800000"},
                    {"Tên BS: BS Tổng Quát 8","ĐC: BD","KN: 7yrs","ĐT:7798989898","800000"},
                    {"Tên BS: BS Tổng Quát 9","ĐC: BD","KN: 7yrs","ĐT:7798989898","800000"}
            };

    private String[][] doctor_details2=
            {
                    {"Tên BS: BS Dinh Dưỡng 1","ĐC: HCM City","KN: 5yrs","ĐT:9898989898","600000"},
                    {"Tên BS: BS Dinh Dưỡng 2","ĐC: TN","KN: 15yrs","ĐT:7898989898","900000"},
                    {"Tên BS: BS Dinh Dưỡng 3","ĐC: HN City","KN: 8yrs","ĐT:8898989898","3000000"},
                    {"Tên BS: BS Dinh Dưỡng 4","ĐC: DN","KN: 6yrs","ĐT:9898000000","500000"},
                    {"Tên BS: BS Dinh Dưỡng 5","ĐC: BD","KN: 7yrs","ĐT:7798989898","800000"},
                    {"Tên BS: BS Dinh Dưỡng 6","ĐC: DN","KN: 6yrs","ĐT:9898000000","500000"},
                    {"Tên BS: BS Dinh Dưỡng 7","ĐC: DN","KN: 6yrs","ĐT:9898000000","500000"},
                    {"Tên BS: BS Dinh Dưỡng 8","ĐC: DN","KN: 6yrs","ĐT:9898000000","500000"},
                    {"Tên BS: BS Dinh Dưỡng 9","ĐC: DN","KN: 6yrs","ĐT:9898000000","500000"}
            };

    private String[][] doctor_details3=
            {
                    {"Tên BS: Nha Sĩ 1","ĐC: HCM City","KN: 5yrs","ĐT:9898989898","600000"},
                    {"Tên BS: Nha Sĩ 2","ĐC: TN","KN: 15yrs","ĐT:7898989898","900000"},
                    {"Tên BS: Nha Sĩ 3","ĐC: HN City","KN: 8yrs","ĐT:8898989898","3000000"},
                    {"Tên BS: Nha Sĩ 4","ĐC: DN","KN: 6yrs","ĐT:9898000000","500000"},
                    {"Tên BS: Nha Sĩ 5","ĐC: BD","KN: 7yrs","ĐT:7798989898","800000"},
                    {"Tên BS: Nha Sĩ 6","ĐC: DN","KN: 6yrs","ĐT:9898000000","500000"},
                    {"Tên BS: Nha Sĩ 7","ĐC: DN","KN: 6yrs","ĐT:9898000000","500000"},
                    {"Tên BS: Nha Sĩ 8","ĐC: DN","KN: 6yrs","ĐT:9898000000","500000"},
                    {"Tên BS: Nha Sĩ 9","ĐC: DN","KN: 6yrs","ĐT:9898000000","500000"}

            };
    private String[][] doctor_details4=
            {
                    {"Tên BS: BS Giải Phẫu 1","ĐC: HCM City","KN: 5yrs","ĐT:9898989898","600000"},
                    {"Tên BS: BS Giải Phẫu 2","ĐC: TN","KN: 15yrs","ĐT:7898989898","900000"},
                    {"Tên BS: BS Giải Phẫu 3","ĐC: HN City","KN: 8yrs","ĐT:8898989898","3000000"},
                    {"Tên BS: BS Giải Phẫu 4","ĐC: DN","KN: 6yrs","ĐT:9898000000","500000"},
                    {"Tên BS: BS Giải Phẫu 5","ĐC: BD","KN: 7yrs","ĐT:7798989898","800000"},
                    {"Tên BS: BS Giải Phẫu 6","ĐC: DN","KN: 6yrs","ĐT:9898000000","500000"},
                    {"Tên BS: BS Giải Phẫu 7","ĐC: DN","KN: 6yrs","ĐT:9898000000","500000"},
                    {"Tên BS: BS Giải Phẫu 8","ĐC: DN","KN: 6yrs","ĐT:9898000000","500000"},
                    {"Tên BS: BS Giải Phẫu 9","ĐC: DN","KN: 6yrs","ĐT:9898000000","500000"}
            };

    private String[][] doctor_details5=
            {
                    {"Tên BS: BS Tim Mạch 1","ĐC: HCM City","KN: 5yrs","ĐT:9898989898","600000"},
                    {"Tên BS: BS Tim Mạch 2","ĐC: TN","KN: 15yrs","ĐT:7898989898","900000"},
                    {"Tên BS: BS Tim Mạch 3","ĐC: HN City","KN: 8yrs","ĐT:8898989898","3000000"},
                    {"Tên BS: BS Tim Mạch 4","ĐC: DN","KN: 6yrs","ĐT:9898000000","500000"},
                    {"Tên BS: BS Tim Mạch 5","ĐC: BD","KN: 7yrs","ĐT:7798989898","800000"},
                    {"Tên BS: BS Tim Mạch 6","ĐC: DN","KN: 6yrs","ĐT:9898000000","500000"},
                    {"Tên BS: BS Tim Mạch 7","ĐC: DN","KN: 6yrs","ĐT:9898000000","500000"},
                    {"Tên BS: BS Tim Mạch 8","ĐC: DN","KN: 6yrs","ĐT:9898000000","500000"},
                    {"Tên BS: BS Tim Mạch 9","ĐC: DN","KN: 6yrs","ĐT:9898000000","500000"}
            };
    private String[][] doctor_details6=
            {
                    {"Tên BS: BS Khoa Nhi 1","ĐC: HCM City","KN: 5yrs","ĐT:9898989898","600000"},
                    {"Tên BS: BS Khoa Nhi 2","ĐC: TN","KN: 15yrs","ĐT:7898989898","900000"},
                    {"Tên BS: BS Khoa Nhi 3","ĐC: HN City","KN: 8yrs","ĐT:8898989898","3000000"},
                    {"Tên BS: BS Khoa Nhi 4","ĐC: DN","KN: 6yrs","ĐT:9898000000","500000"},
                    {"Tên BS: BS Khoa Nhi 5","ĐC: BD","KN: 7yrs","ĐT:7798989898","800000"},
                    {"Tên BS: BS Khoa Nhi 6","ĐC: DN","KN: 6yrs","ĐT:9898000000","500000"},
                    {"Tên BS: BS Khoa Nhi 7","ĐC: DN","KN: 6yrs","ĐT:9898000000","500000"},
                    {"Tên BS: BS Khoa Nhi 8","ĐC: DN","KN: 6yrs","ĐT:9898000000","500000"},
                    {"Tên BS: BS Khoa Nhi 9","ĐC: DN","KN: 6yrs","ĐT:9898000000","500000"}
            };
    private String[][] doctor_details7=
            {
                    {"Tên BS: BS Xương Khớp 1","ĐC: HCM City","KN: 5yrs","ĐT:9898989898","600000"},
                    {"Tên BS: BS Xương Khớp 2","ĐC: TN","KN: 15yrs","ĐT:7898989898","900000"},
                    {"Tên BS: BS Xương Khớp 3","ĐC: HN City","KN: 8yrs","ĐT:8898989898","3000000"},
                    {"Tên BS: BS Xương Khớp 4","ĐC: DN","KN: 6yrs","ĐT:9898000000","500000"},
                    {"Tên BS: BS Xương Khớp 5","ĐC: BD","KN: 7yrs","ĐT:7798989898","800000"},
                    {"Tên BS: BS Xương Khớp 6","ĐC: DN","KN: 6yrs","ĐT:9898000000","500000"},
                    {"Tên BS: BS Xương Khớp 7","ĐC: DN","KN: 6yrs","ĐT:9898000000","500000"},
                    {"Tên BS: BS Xương Khớp 8","ĐC: DN","KN: 6yrs","ĐT:9898000000","500000"},
                    {"Tên BS: BS Xương Khớp 9","ĐC: DN","KN: 6yrs","ĐT:9898000000","500000"}
            };
    private String[][] doctor_details8=
            {
                    {"Tên BS: BS Mắt 1","ĐC: HCM City","KN: 5yrs","ĐT:9898989898","600000"},
                    {"Tên BS: BS Mắt 2","ĐC: TN","KN: 15yrs","ĐT:7898989898","900000"},
                    {"Tên BS: BS Mắt 3","ĐC: HN City","KN: 8yrs","ĐT:8898989898","3000000"},
                    {"Tên BS: BS Mắt 4","ĐC: DN","KN: 6yrs","ĐT:9898000000","500000"},
                    {"Tên BS: BS Mắt 5","ĐC: BD","KN: 7yrs","ĐT:7798989898","800000"},
                    {"Tên BS: BS Mắt 6","ĐC: DN","KN: 6yrs","ĐT:9898000000","500000"},
                    {"Tên BS: BS Mắt 7","ĐC: DN","KN: 6yrs","ĐT:9898000000","500000"},
                    {"Tên BS: BS Mắt 8","ĐC: DN","KN: 6yrs","ĐT:9898000000","500000"},
                    {"Tên BS: BS Mắt 9","ĐC: DN","KN: 6yrs","ĐT:9898000000","500000"}
            };

    private String[][] doctor_details9=
            {
                    {"Tên BS: BS Thần Kinh 1","ĐC: HCM City","KN: 5yrs","ĐT:9898989898","600000"},
                    {"Tên BS: BS Thần Kinh 2","ĐC: TN","KN: 15yrs","ĐT:7898989898","900000"},
                    {"Tên BS: BS Thần Kinh 3","ĐC: HN City","KN: 8yrs","ĐT:8898989898","3000000"},
                    {"Tên BS: BS Thần Kinh 4","ĐC: DN","KN: 6yrs","ĐT:9898000000","500000"},
                    {"Tên BS: BS Thần Kinh 5","ĐC: BD","KN: 7yrs","ĐT:7798989898","800000"},
                    {"Tên BS: BS Thần Kinh 6","ĐC: DN","KN: 6yrs","ĐT:9898000000","500000"},
                    {"Tên BS: BS Thần Kinh 7","ĐC: DN","KN: 6yrs","ĐT:9898000000","500000"},
                    {"Tên BS: BS Thần Kinh 8","ĐC: DN","KN: 6yrs","ĐT:9898000000","500000"},
                    {"Tên BS: BS Thần Kinh 9","ĐC: DN","KN: 6yrs","ĐT:9898000000","500000"}
            };
    TextView tv;
    String[][] doctor_details={};
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;

    ImageView VTBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv=findViewById(R.id.textViewDDTitle);
        VTBack=findViewById(R.id.VTBackFDD);


        Intent it=getIntent();
        String title=it.getStringExtra("title");
        tv.setText(title);


        switch (title){
            case "Bác Sĩ Khám Tổng Quát": doctor_details=doctor_details1;
                break;
            case "Chuyên Gia Dinh Dưỡng": doctor_details=doctor_details2;
                break;
            case "Nha Sĩ": doctor_details=doctor_details3;
                break;
            case "Giải Phẫu": doctor_details=doctor_details4;
                break;
            case "Bác Sĩ Tim Mạch": doctor_details=doctor_details5;
                break;
            case "Bác Khoa Nhi": doctor_details=doctor_details6;
                break;
            case "Bác Sĩ Xướng Khớp": doctor_details=doctor_details7;
                break;
            case "Bác Sĩ Mắt": doctor_details=doctor_details8;
                break;
            case "Bác Thần Kinh": doctor_details=doctor_details9;
                break;
        }

        VTBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this,FindDoctorMainActivity.class));
            }
        });

        list=new ArrayList();
        for (int i=0;i<doctor_details.length;i++) {
            item = new HashMap<String, String>();
            item.put("line1", doctor_details[i][0]);
            item.put("line2", doctor_details[i][1]);
            item.put("line3", doctor_details[i][2]);
            item.put("line4", doctor_details[i][3]);
            item.put("line5", "Giá:"+doctor_details[i][4]+"VND");
            list.add(item);
        }
        sa=new SimpleAdapter(this,list,
                R.layout.multi_lines2,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        ListView lst=findViewById(R.id.listViewDD);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it=new Intent(DoctorDetailsActivity.this,BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][3]);
                it.putExtra("text5",doctor_details[i][4]);
                startActivity(it);
            }
        });
    }
}