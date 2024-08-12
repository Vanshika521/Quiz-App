package com.codsoft.quizapp;



import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.navigation.NavigationView;

import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import firebase.com.protolitewrapper.BuildConfig;

public class MainActivity extends AppCompatActivity {

    NavigationView navigationView;
    ActionBarDrawerToggle actionBarDrawerToggle;
    DrawerLayout drawerLayout;


    public void C(View view) {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.drawerlayout);
        /*       ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });*/
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        navigationView = findViewById(R.id.navigation_view);
        navigationView.setItemIconTintList(null);
        drawerLayout = findViewById(R.id.drawer);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open,
                R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        /*navigationView.setNavigationItemSelectedListener(new
                                                                 NavigationView.OnNavigationItemSelectedListener() {
                                                                     @Override
                                                                     public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                                                                         switch (item.getItemId()) {
                                                                             // COMMON
                                                                             case R.id.facebookPage:

                                                                                 break;
                                                                             case R.id.website:
                                                                                 break;
                                                                             case R.id.nav_privacy_policy:
                                                                                 break;
                                                                             case R.id.nav_terms_conditions:
                                                                                 break;
                                                                             case R.id.more:
                                                                                 break;
                                                                             // COMMON
                                                                             // IMPORTANT //
                                                                             case R.id.nav_rate:
                                                                                 break;
                                                                             // IMPORTANT //
                                                                             // IMPORTANT //
                                                                             case R.id.nav_share:
                                                                                 break;
                                                                             // IMPORTANT //
                                                                         }
                                                                         return true;
                                                                     }
                                                                 });*/

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.facebookPage) {
                    // Handle Facebook page action

                } else if (id == R.id.website) {
                    // Handle Website action
                } else if (id == R.id.nav_privacy_policy) {
                    // Handle Privacy Policy action
                } else if (id == R.id.nav_terms_conditions) {
                    // Handle Terms & Conditions action
                } else if (id == R.id.nav_rate) {
                    Uri uri = Uri.parse("market://details?id=" + getApplication().getPackageName());
                    Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
                    // To count with Play market backstack, After pressing back button,
                    // to taken back to our application, we need to add following flags to intent.
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                                Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                                Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                    }
                    try {
                        startActivity(goToMarket);
                    } catch (ActivityNotFoundException e) {
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("http://play.google.com/store/apps/details?id=" + getApplication().getPackageName())));
                    }

                } else if (id == R.id.nav_share) {


                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Quiz App");
                    String shareMessage= "This Is Best Application For Quiz App.\n\n";
                    shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID;

                }
                return true;
            }
        });


    }


        public void c_plusplus (View view){
            Intent intent= new Intent(MainActivity.this, questions.class);
            startActivity(intent);
            finish();
        }

        public void JAVA (View view){
        }

        public void Python (View view){
        }

        public void Kotlin (View view){
        }

        public void HTML (View view){
        }
    }
