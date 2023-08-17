package com.example.healthcare_app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONObject;

import java.util.Calendar;

public class BookAppointmentActivity extends AppCompatActivity implements PaymentResultListener {
    EditText ed1,ed2,ed3,ed4;
    TextView tv;
    private DatePickerDialog datePickerDiaLog;
    private TimePickerDialog timePickerDialog;
    private Button dateButton,timeButton, btnBook;
    ImageView VTBack;
    String fees;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_appointment);

        tv=findViewById(R.id.textViewAppTitle);
        ed1=findViewById(R.id.editTextAppFullName);
        ed2=findViewById(R.id.editTextAppAddress);
        ed3=findViewById(R.id.editTextAppContactNumber);
        ed4=findViewById(R.id.editTextAppFees);
        dateButton=findViewById(R.id.buttonAppDate);
        timeButton=findViewById(R.id.buttonAppTime);
        btnBook=findViewById(R.id.buttonBookAppointment);
        VTBack=findViewById(R.id.VTBackBBA);

        ed1.setKeyListener(null);
        ed2.setKeyListener(null);
        ed3.setKeyListener(null);
        ed4.setKeyListener(null);

        Intent it =getIntent();
        String title=it.getStringExtra("text1");
        String fullname=it.getStringExtra("text2");
        String address=it.getStringExtra("text3");
        String contact=it.getStringExtra("text4");
        fees =it.getStringExtra("text5");

        tv.setText(title);
        ed1.setText(fullname);
        ed2.setText(address);
        ed3.setText(contact);
        ed4.setText("Giá:"+fees+"VND");

        //datepicker
        initDatePicker();
        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePickerDiaLog.show();
            }
        });

        //timePicker
        initTimePicker();
        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timePickerDialog.show();
            }
        });

       VTBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BookAppointmentActivity.this,FindDoctorMainActivity.class));
            }
        });

        btnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Database db=new Database(getApplicationContext(),"healthcare",null,1);
                SharedPreferences sharedPreferences=getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                String username=sharedPreferences.getString("username","").toString();
                if(db.checkAppoinmentExists(username,title+" => "+fullname,address,contact,dateButton.getText().toString(),timeButton.getText().toString())==1){
                    Toast.makeText(getApplicationContext(),"Bác Sĩ Đã Được Hẹn",Toast.LENGTH_SHORT).show();
                }else {
                    db.addOrder(username,title+ " => "+fullname,address,contact,0,dateButton.getText().toString(),timeButton.getText().toString(),Float.parseFloat(fees.toString()),"appointment");
                    makepayment();
                }

            }
        });

    }

    private void initDatePicker(){
        DatePickerDialog.OnDateSetListener dateSetListener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                i1=i1+1;
                dateButton.setText(i2+"/"+i1+"/"+i);
            }
        };
        Calendar cal=Calendar.getInstance();
        int year=cal.get(Calendar.YEAR);
        int month=cal.get(Calendar.MONTH);
        int day=cal.get(Calendar.DAY_OF_MONTH);

        int style= AlertDialog.THEME_HOLO_DARK;
        datePickerDiaLog=new DatePickerDialog(this,style,dateSetListener,year,month,day);
        datePickerDiaLog.getDatePicker().setMinDate(cal.getTimeInMillis()+86400000);
    }

    private void initTimePicker(){
        TimePickerDialog.OnTimeSetListener timeSetListener=new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                timeButton.setText(i+":"+i1);
            }
        };

        Calendar cal=Calendar.getInstance();
        int hrs=cal.get(Calendar.HOUR);
        int mins=cal.get(Calendar.MINUTE);

        int style= AlertDialog.THEME_HOLO_DARK;
        timePickerDialog=new TimePickerDialog(this,style,timeSetListener,hrs,mins,true);
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
            options.put("description", "Thanh toán hẹn trước");
            options.put("image", "https://s3.amazonaws.com/rzp-mobile/images/rzp.png");
            // options.put("order_id", "order_DBJOWzybf0sJbb");//from response of step 3.
            options.put("theme.color", "#004255");
            options.put("currency", "USD");
            options.put("amount", fees);//300 X 100
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
        startActivity(new Intent(BookAppointmentActivity.this, HomeActivity.class));
    }

    @Override
    public void onPaymentError(int i, String s) {
        Toast.makeText(getApplicationContext(),"Đã Phát Sinh Lỗi Trong Quá Trình Thanh Toán",Toast.LENGTH_SHORT).show();
    }
}