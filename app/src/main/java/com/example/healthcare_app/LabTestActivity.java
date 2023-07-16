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

import java.util.ArrayList;
import java.util.HashMap;

public class LabTestActivity extends AppCompatActivity {
    private String[][] packages ={
            {"Gói 1: Xét Nghiệm Tổng Quát", "", "", "", "639000"},
            {"Gói 2: Xét Nghiệm Glucose", "", "", "", "180000"},
            {"Gói 3: Xét Nghiệm Kháng Thể Covid-19 - IgG", "", "", "", "150000"},
            {"Gói 4: Xét Nghiệm Tuyến Giáp", "", "", "", "350000"},
            {"Gói 5: Xét Nghiệm Miễn Dịch", "", "", "", "690000"}
    };

    private String[] package_details={
            "Xét Nghiệm Glucose\n"+
                    "Công Thức Máu\n"+
                    "HbAlc\n"+
                    " Iron Studies\n"+
                    "Kindney Function Test\n"+
                    "LDH Lactate Dehydrogenase, Serum\n"+
                    "Lipid Profile\n"+
                    "Liver Function Test",
            "Xét Nghiệm Glucose",
            "Xét Nghiệm Kháng Thể Covid-19 - IgG",
            "Hồ Sơ Tuyến Giáp - Tổng (T3,T4 & TSH Ultra-sensitive)",
            "Công Thức Máu\n"+
                    "CRP (C Reactive Protein) Quantiative Serum\n"+
                    " Iron Studies\n"+
                    "Kindney Function Test\n"+
                    "Vitamin D Total-25 Hydroxy\n"+
                    "Liver Function Test\n"+
                    "Lipid Profile"
    };
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    ImageView VTback,VTcart;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test);

        VTback=findViewById(R.id.VTBackLabtest);
        VTcart=findViewById(R.id.VTCartLabTest);
        listView=findViewById(R.id.listViewLT);

        VTback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LabTestActivity.this,HomeActivity2.class));
            }
        });


        list=new ArrayList();
        for (int i=0;i<packages.length;i++) {
            item = new HashMap<String, String>();
            item.put("line1", packages[i][0]);
            item.put("line2", packages[i][1]);
            item.put("line3", packages[i][2]);
            item.put("line4", packages[i][3]);
            item.put("line5", "Giá:"+packages[i][4]+" VND");
            list.add(item);
        }

        sa= new SimpleAdapter(this,list,
                R.layout.multi_lines2,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        listView.setAdapter(sa);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it=new Intent(LabTestActivity.this,LabTestDetailsMainActivity.class);
                it.putExtra("text1",packages[i][0]);
                it.putExtra("text2",package_details[i]);
                it.putExtra("text3",packages[i][4]);
                startActivity(it);
            }
        });


        VTcart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LabTestActivity.this,CartLabActivity.class));
            }
        });
    }

}