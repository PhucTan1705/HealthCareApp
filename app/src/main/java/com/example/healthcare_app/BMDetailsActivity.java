package com.example.healthcare_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class BMDetailsActivity extends AppCompatActivity {
    TextView tvPackageName,tvTotalcost;
    EditText edBMD;
    Button btnAddToCart;

    ImageView VTBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmdetails);

        tvPackageName=findViewById(R.id.textViewBMDPackageName);
        tvTotalcost=findViewById(R.id.textViewBMDTotalCost);
        edBMD=findViewById(R.id.editTextBMDTextMultiline);
        edBMD.setKeyListener(null);
        VTBack=findViewById(R.id.VTBackBMD);
        btnAddToCart=findViewById(R.id.buttonBMDAddToCart);

        Intent intent=getIntent();
        tvPackageName.setText(intent.getStringExtra("text1"));
        edBMD.setText(intent.getStringExtra("text2"));
        tvTotalcost.setText("Tổng Cộng : "+intent.getStringExtra("text3")+"Vnd");

        VTBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BMDetailsActivity.this,BuyMedicineActivity.class));
            }
        });

        btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences=getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                String username=sharedPreferences.getString("username","").toString();
                String product=tvPackageName.getText().toString();
                float price=Float.parseFloat(intent.getStringExtra("text3").toString());

                Database db=new Database(getApplicationContext(),"healthcare",null,1);

                if(db.checkCart(username,product)==1){
                    Toast.makeText(getApplicationContext(),"Sản Phẩm Đã Được Thêm Vào Giỏ Hàng",Toast.LENGTH_SHORT).show();
                } else {
                    db.addCart(username,product,price,"medicine");
                    Toast.makeText(getApplicationContext(),"Đã Thêm Sản Phẩm Vào Giỏ Hàng",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(BMDetailsActivity.this,BuyMedicineActivity.class));
                }
            }
        });


    }
}