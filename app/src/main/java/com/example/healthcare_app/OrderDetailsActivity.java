package com.example.healthcare_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class OrderDetailsActivity extends AppCompatActivity {
    private String[][] order_details={};
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    ListView lst;
    ImageView VTBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);

        VTBack=findViewById(R.id.VTBackODT);
        lst=findViewById(R.id.listViewOD);

        VTBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(OrderDetailsActivity.this, HomeActivity.class));
            }
        });

        Database db=new Database(getApplicationContext(),"healthcare",null,1);
        SharedPreferences sharedPreferences=getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String username=sharedPreferences.getString("username","").toString();
        ArrayList dbData=db.getOrderData(username);

        order_details=new String[dbData.size()][];
        for(int i=0;i<order_details.length;i++){
            order_details[i]=new String[5];
            String arrData=dbData.get(i).toString();
            String[] strDara=arrData.split(java.util.regex.Pattern.quote("$"));
            order_details[i][0]=strDara[0];
            order_details[i][1]=strDara[1];
            if(strDara[7].compareTo("medicine")==0){
                order_details[i][3]="Del:"+strDara[4];
            }else {
                order_details[i][3]="Del:"+strDara[4]+" "+strDara[5];
            }
            order_details[i][2]="Rs."+strDara[6];
            order_details[i][4]=strDara[7];
        }

        list=new ArrayList();
        for(int i=0;i<order_details.length;i++){
            item=new HashMap<String,String>();
            item.put("line1",order_details[i][0]);
            item.put("line2",order_details[i][1]);
            item.put("line3",order_details[i][2]);
            item.put("line4",order_details[i][3]);
            item.put("line5",order_details[i][4]);
            list.add(item);
        }

        sa=new SimpleAdapter(this,list,
                R.layout.multi_lines2,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        lst.setAdapter(sa);
    }
}