package com.codsoft.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class questions extends AppCompatActivity {

    String question[] = {};
    String answer[] = {};
    String option[] = {};



    String Cques[] = {"C","A"};
    String Cans[] = {"A","C"};
    String Copt[] = {"B","BB","BBB","BBBB","CC","C","CCC","CCCC"};

    String CPques[] = {"C PLUS","AAA"};
    String CPans[] = {"C","BB"};
    String CPopt[] = {"CC","C","CCC","CCCC","B","BB","BBB","BBBB"};


    int flag = 0;

    public static int marks = 0,correct = 0,incorrect =0;

    TextView tv;
    Button nextbtn,quitbtn;
    RadioGroup rgrp;
    RadioButton rbtnA,rbtnB,rbtnC,rbtnD;
    private TextView ques_no;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // EdgeToEdge.enable(this);
        setContentView(R.layout.activity_questions);
       /* ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });*/

        Intent intent3 = getIntent();
        String category = intent3.getStringExtra("CATEGORY");

        if (category.equals("C")) {
            question = Cques;
            answer = Cans;
            option = Copt;
        } else if (category.equals("C++")) {
            question = CPques;
            answer = CPans;
            option = CPopt;
        }

        //Score ( 0 )...   ,  Question number....
        final TextView score = (TextView) findViewById(R.id.textView4);
        TextView txt = (TextView) findViewById(R.id.textView);
        Intent intent = getIntent();
        ques_no = findViewById(R.id.textView);

        nextbtn = (Button) findViewById(R.id.btn);
        quitbtn = (Button) findViewById(R.id.btn2);

        tv = (TextView) findViewById(R.id.textView2);

        rgrp = (RadioGroup) findViewById(R.id.rgrp);
        rbtnA = (RadioButton) findViewById(R.id.rbtnA);
        rbtnB = (RadioButton) findViewById(R.id.rbtnB);
        rbtnC = (RadioButton) findViewById(R.id.rbtnC);
        rbtnD = (RadioButton) findViewById(R.id.rbtnD);

        tv.setText(question[flag]);
        rbtnA.setText(option[0]);
        rbtnB.setText(option[1]);
        rbtnC.setText(option[2]);
        rbtnD.setText(option[3]);


        //Next Button ....
        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(rgrp.getCheckedRadioButtonId() == -1){
                    Toast.makeText(questions.this, "Choose Atleast One Option", Toast.LENGTH_SHORT).show();
                    return;
                }

                RadioButton ans = (RadioButton) findViewById(rgrp.getCheckedRadioButtonId());
                String check_answer = ans.getText().toString();

                if(check_answer.equals(answer[flag]))
                {
                    correct++;
                    Toast.makeText(questions.this, "Correct Answer !!!", Toast.LENGTH_SHORT).show();
                }

                else
                {
                    incorrect--;
                    Toast.makeText(questions.this, "Incorrect Answer !!!", Toast.LENGTH_SHORT).show();
                }

                flag++;

                if (score != null)
                {
                    score.setText(""+correct);
                }

                if(flag<question.length)
                {
                    tv.setText(question[flag]);
                    rbtnA.setText(option[flag * 4]);
                    rbtnB.setText(option[flag * 4 + 1]);
                    rbtnC.setText(option[flag * 4 + 2]);
                    rbtnD.setText(option[flag * 4 + 3]);

                   // ques_no.setText(flag+"/"+question.length);
                    ques_no.setText(flag+"/"+question.length+" Question");

                }
                else
                {
                    marks = correct ;
                    Intent intent1 = new Intent(questions.this , result.class);
                    startActivity(intent1);
                }

                rgrp.clearCheck();

            }
        });

        //Quit Button Code

        quitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(questions.this, result.class);
                startActivity(intent2);
            }
        });


    }
}


