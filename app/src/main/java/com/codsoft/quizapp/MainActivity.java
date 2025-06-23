package com.codsoft.quizapp;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.navigation.NavigationView;
import androidx.drawerlayout.widget.DrawerLayout;


public class MainActivity extends AppCompatActivity {

    NavigationView navigationView;
    ActionBarDrawerToggle actionBarDrawerToggle;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawerlayout);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        navigationView = findViewById(R.id.navigation_view);
        navigationView.setItemIconTintList(null);
        drawerLayout = findViewById(R.id.drawer);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open,
                R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();


                if (id == R.id.nav_privacy_policy) {
                    // Handle Privacy Policy action
                } else if (id == R.id.nav_terms_conditions) {
                    // Handle Terms & Conditions action
                } else if (id == R.id.nav_rate) {
                    Uri uri = Uri.parse("market://details?id=" + getApplication().getPackageName());
                    Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
                    // To count with Play market backstack, After pressing back button,
                    // to taken back to our application, we need to add following flags to intent.
                    goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                            Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                            Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                    try {
                        startActivity(goToMarket);
                    } catch (ActivityNotFoundException e) {
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("http://play.google.com/store/apps/details?id=" + getApplication().getPackageName())));
                    }

                } else if (id == R.id.nav_logout) {
                    Intent intent = new Intent(MainActivity.this, login.class);
                    startActivity(intent);
                }
                return true;
            }
        });


    }

    public void C(View view) {
        Intent intent = new Intent(MainActivity.this, questions.class);
        String a = "C";
        intent.putExtra("CATEGORY", a);
        startActivity(intent);
    }

    public void c_plusplus(View view) {
        Intent intent = new Intent(MainActivity.this, questions.class);
        String a = "C++";
        intent.putExtra("CATEGORY", a);
        startActivity(intent);
    }

    public void JAVA(View view) {
        Intent intent = new Intent(MainActivity.this, questions.class);
        String a = "Java";
        intent.putExtra("CATEGORY", a);
        startActivity(intent);
    }

    public void Python(View view) {
        Intent intent = new Intent(MainActivity.this, questions.class);
        String a = "Python";
        intent.putExtra("CATEGORY", a);
        startActivity(intent);
    }

    public void Kotlin(View view) {
        Intent intent = new Intent(MainActivity.this, questions.class);
        String a = "Kotlin";
        intent.putExtra("CATEGORY", a);
        startActivity(intent);
    }

    public void HTML(View view) {
        Intent intent = new Intent(MainActivity.this, questions.class);
        String a = "HTML";
        intent.putExtra("CATEGORY", a);
        startActivity(intent);
    }
}
