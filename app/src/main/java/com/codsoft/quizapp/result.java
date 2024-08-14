package com.codsoft.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.mikhaellopez.circularprogressbar.CircularProgressBar;

public class result extends AppCompatActivity {

    TextView txt1,txt2,txt3,txt4;
    Button btn;
    CircularProgressBar cbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);
        /*  ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });*/

        txt1 = findViewById(R.id.textView);
        txt2 = findViewById(R.id.textView2);
        txt3 = findViewById(R.id.textView3);
        txt4 = findViewById(R.id.textView4);
        btn = findViewById(R.id.restart);
        cbar = findViewById(R.id.cprogress);

        cbar.setProgress(questions.correct);
//Correct
        StringBuffer a = new StringBuffer();
        a.append("Correct Answers : "+ questions.correct+"\n");
//Incorrect
        StringBuffer b = new StringBuffer();
        b.append("Incorrect Answers : "+ questions.incorrect+"\n");
//Score
        StringBuffer c = new StringBuffer();
        c.append("Total Score : "+ questions.correct+"\n");
//progress bar's text view
        StringBuffer d = new StringBuffer();
        d.append(questions.correct+"/ "+"5");

        txt1.setText(a);
        txt2.setText(b);
        txt3.setText(c);
        txt4.setText(d);

        questions.correct = 0;
        questions.incorrect = 0;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(result.this,MainActivity.class);
                startActivity(intent);
            }
        });






    }
}