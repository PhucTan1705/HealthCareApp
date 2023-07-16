package com.example.healthcare_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText eUser, eEmail, ePassword,eConPassword;
    Button btn;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        eUser=findViewById(R.id.editRegLoginUsername);
        eEmail=findViewById(R.id.editTextRegEmail);
        ePassword=findViewById(R.id.editTextRegPassword);

        eConPassword=findViewById(R.id.editTextRegConfirmPassword);
        btn=findViewById(R.id.buttonReg);
        tv=findViewById(R.id.tvExistingUser);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username=eUser.getText().toString();
                String password=ePassword.getText().toString();
                String email=eEmail.getText().toString();
                String conpass=eConPassword.getText().toString();
                Database db=new Database(getApplicationContext(),"healthcare",null, 1);

                if (username.length()==0 || password.length()==0 || email.length()==0 || conpass.length()==0){
                    Toast.makeText(getApplicationContext(),"Xin hãy điền đủ các thông tin", Toast.LENGTH_SHORT).show();
                } else {
                    if(password.compareTo(conpass)==0){
                        if(isVaild(password)){
                            db.register(username,email,password);
                            Toast.makeText(getApplicationContext(),"Đăng Ký Thành Công", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                        } else {
                            Toast.makeText(getApplicationContext(),"Mật khẩu phải từ 8 ký tự trở lên, có ít nhất 1 số, 1 ký tự và 1 ký tự đặc biệt", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(),"Mật khẩu và mật khẩu xác nhận phải giống nhau", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    public static boolean isVaild(String passwordhere){
        int f1=0,f2=0,f3=0;
        if(passwordhere.length()<8){
            return false;
        } else {
            for (int p=0;p<passwordhere.length();p++){
                if(Character.isLetter(passwordhere.charAt(p))){
                    f1=1;
                }
            }
            for (int c=0;c<passwordhere.length();c++){
                if(Character.isDigit(passwordhere.charAt(c))){
                    f2=1;
                }
            }
            for (int s=0;s<passwordhere.length();s++){
                char c=passwordhere.charAt(s);
                if(c>=33&&c<=46||c==64){
                    f3=1;
                }
            }
            if(f1==1 && f2==1 && f3==1)
                return true;
            return false;
        }
    }
}