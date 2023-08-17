package com.example.healthcare_app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.healthcare_app.databinding.ActivityHomeBinding;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityHomeBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sharedPreferences=getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String username=sharedPreferences.getString("username","").toString();
        Toast.makeText(getApplicationContext(),"Chào mừng "+username,Toast.LENGTH_SHORT).show();


        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarHome2.toolbar);
        binding.appBarHome2.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Healthcare123@gmail.com\n"+
                                "Phone: 123456789", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });



        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_LabTest, R.id.nav_BuyMedicine,R.id.nav_FindDoctor,R.id.nav_HealthArticles,R.id.nav_OrderDetails,R.id.nav_LogOut)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_home2);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        getSupportActionBar().setIcon(R.drawable.healthcare1);

        View headerView=navigationView.getHeaderView(0);
        TextView textView=headerView.findViewById(R.id.Headertext);
        textView.setText("Xin chào "+username);



        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_LogOut:
                        SharedPreferences.Editor editor=sharedPreferences.edit();
                        editor.clear();
                        editor.apply();
                        Toast.makeText(getApplicationContext(),"Xin hẹn gặp lại ",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(HomeActivity.this,LoginActivity.class));
                        return true;
                    case R.id.nav_LabTest:
                        startActivity(new Intent(HomeActivity.this,LabTestActivity.class));
                        return true;
                    case R.id.nav_BuyMedicine:
                        startActivity(new Intent(HomeActivity.this,BuyMedicineActivity.class));
                        return true;
                    case R.id.nav_FindDoctor:
                        startActivity(new Intent(HomeActivity.this,FindDoctorMainActivity.class));
                        return true;
                    case R.id.nav_HealthArticles:
                        startActivity(new Intent(HomeActivity.this,healthArticlesActivity.class));
                        return true;
                    case R.id.nav_OrderDetails:
                        startActivity(new Intent(HomeActivity.this,OrderDetailsActivity.class));
                        return true;
                }
                return true;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_activity, menu);
        menu.clear();
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_home2);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}