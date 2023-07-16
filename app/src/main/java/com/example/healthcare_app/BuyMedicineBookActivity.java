package com.example.healthcare_app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONObject;

public class BuyMedicineBookActivity extends AppCompatActivity implements PaymentResultListener {
    EditText edname,edaddress,edcontact,edpincode;
    Button btnbook;
    ImageView VTBack;
    String[]price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine_book);

        edname=findViewById(R.id.editTextBMBFullName);
        edaddress=findViewById(R.id.editTextBMBAddress);
        edcontact=findViewById(R.id.editTextBMBContactNumber);
        edpincode=findViewById(R.id.editTextBMBPinCode);
        btnbook=findViewById(R.id.buttonBMBooking);
        VTBack=findViewById(R.id.VTBackBMDB);

        Intent intent=getIntent();
        price=intent.getStringExtra("price").toString().split(java.util.regex.Pattern.quote(":"));
        String date=intent.getStringExtra("date");
        //String time=intent.getStringExtra("time");
        btnbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences=getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                String username=sharedPreferences.getString("username","").toString();
                Database db=new Database(getApplicationContext(),"healthcare",null,1);
                db.addOrder(username,edname.getText().toString(),edaddress.getText().toString(),edcontact.getText().toString(),Integer.parseInt(edpincode.getText().toString()),date.toString(),"",Float.parseFloat(price[1].toString()),"medicine");
                db.removeCart(username,"medicine");
                //Toast.makeText(getApplicationContext(),"Thanh Toán Thành Công",Toast.LENGTH_SHORT).show();
                //startActivity(new Intent(BuyMedicineBookActivity.this,HomeActivity2.class));
                makepayment();
            }
        });

        VTBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuyMedicineBookActivity.this,BuyMedicineActivity.class));
            }
        });
    }
    private void makepayment()
    {

        Checkout checkout = new Checkout();
        checkout.setKeyID("rzp_test_xbJx6XOPUTdhq0");

        checkout.setImage(R.drawable.healthcare1);
        final Activity activity = this;

        try {
            JSONObject options = new JSONObject();

            options.put("name", "Chăm Sóc Sức Khỏe 24/7");
            options.put("description", "Thanh toán mua thuốc");
            options.put("image", "https://s3.amazonaws.com/rzp-mobile/images/rzp.png");
            // options.put("order_id", "order_DBJOWzybf0sJbb");//from response of step 3.
            options.put("theme.color", "#004255");
            options.put("currency", "USD");
            options.put("amount", price[1]);//300 X 100
            options.put("prefill.email", "nanaxanime4@gmail.com");
            options.put("prefill.contact","0864945278");
            checkout.open(activity, options);
        } catch(Exception e) {
            Log.e("TAG", "Lỗi Khi Đang Thanh Toán", e);
        }
    }


    @Override
    public void onPaymentSuccess(String s)
    {
        Toast.makeText(getApplicationContext(),"Hẹn Bác Sĩ Thành Công",Toast.LENGTH_SHORT).show();
        startActivity(new Intent(BuyMedicineBookActivity.this,HomeActivity2.class));
    }

    @Override
    public void onPaymentError(int i, String s) {
        Toast.makeText(getApplicationContext(),"Đã Phát Sinh Lỗi Trong Quá Trình Thanh Toán",Toast.LENGTH_SHORT).show();
    }
}