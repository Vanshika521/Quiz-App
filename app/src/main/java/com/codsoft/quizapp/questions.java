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



    String Cques[] = {"Which of the following correctly represents a comment in C?",
                        "Which of the following is the correct format specifier for printing an integer in C?",
                        "Which of the following is used to terminate a C statement?",
                        "Which of the following is not a valid variable name in C?",
                        "Which keyword is used to define a constant in C?"};
    String Cans[] = {"/* This is a comment */","%d",";","1number","const"};
    String Copt[] = {"// This is a comment", "/* This is a comment */", "-- This is a comment", "# This is a comment",
                        "%d","%c","%f","%s",
                        ",",".",";","*",
                        "_num","number1","1number","num_1",
                        "static","const","define","final"
    };

    String CPques[] = {"Which of the following is a correct way to declare a constant variable in C++?" ,
                        "Which of the following is a correct way to declare a class in C++?",
                        "Which of the following is used to allocate memory dynamically in C++?",
                        "Which of the following is a feature of Object-Oriented Programming (OOP) in C++?",
                        "Which of the following access specifiers are used in C++?"};
    String CPans[] = {"All of the above", "class MyClass {};","new","All of the above","All of the above"};
    String CPopt[] = {"const int x = 10;","int const x = 10;","#define x 10","All of the above",
                        "class MyClass {}","class MyClass();","class MyClass {};","class MyClass []",
                        "malloc()","calloc()","new", "free()",
                        "Inheritance","Encapsulation","Polymorphism","All of the above",
                        "public","private","protected","All of the above"};

    String javaques[] = {"Which keyword is used to inherit a class in Java?",
                        "Which of the following is not a primitive data type in Java?",
                        "Which of the following is used to create an object in Java?",
                        "Which of the following is a valid keyword in Java?",
                        "Which of the following is the correct syntax to declare an array in Java?"};
    String javaans[] = {"extends","String","new","interface","int[] arr = new int[5];"};
    String javaopt[] = {"implement","inherits","extends","super",
                        "int","float","char","String",
                        "new","create","malloc()","alloc()",
                        "interface","inherit","derive","finalize",
                        "int[] arr = new int[5];","int arr = new int[5];","int arr[5] = new int[];","int arr[] = new int;"};

    String pythonques[] = {"Which of the following is used to define a function in Python?",
                            "Which of the following data types is immutable in Python?",
                            "Which keyword is used to start a loop in Python?",
                            "How do you create a dictionary in Python?",
                            "Which of the following is not a keyword in Python?"};
    String pythonans[] = {"def","tuple","while","my_dict = {}","end"};
    String pythonopt[] = {"function","def","func","define",
                            "list","set","dictionary","tuple",
                            "loop","iterate","while","if",
                            "my_dict = {}","my_dict = []","my_dict = ()","my_dict = set()",
                            "try","finally","except","end"};


    String kotlinques[] = {"Which of the following is the correct way to declare a variable in Kotlin?",
                            "Which of the following is used to create a single-line comment in Kotlin?",
                            "What is the difference between val and var in Kotlin?",
                            "Which of the following is the correct way to define a function in Kotlin?",
                            "Which of the following is true about Kotlin?"};
    String kotlinans[] = {"var x: Int = 10","// This is a comment","var is mutable, val is immutable","fun myFunction() { }","Kotlin code can run on the JVM"};
    String kotlinopt[] = {"var x: Int = 10","int x = 10","x = 10 as Int","val x = 10 as Int",
                            "// This is a comment","/* This is a comment */","<!-- This is a comment -->","# This is a comment",
                            "val is mutable, var is immutable","var is mutable, val is immutable","Both are mutable","Both are immutable",
                            "fun myFunction() { }","def myFunction() { }","function myFunction() { }","void myFunction() { }",
                            "Kotlin is not compatible with Java.","Kotlin code can run on the JVM.","Kotlin does not support functional programming.","Kotlin cannot be used for Android development."};

    String htmlques[] = {"What does HTML stand for?",
                            "Which HTML element is used to define the title of a document?",
                            "Which of the following tags is used to create a hyperlink in HTML?",
                            "Which HTML element is used to create a numbered list?",
                            "Which attribute is used to specify an image source in HTML?"};
    String htmlans[] = {"HyperText Markup Language","<title>","<a>","<ol>","src"};
    String htmlopt[] = {"HyperText Markup Language","Home Tool Markup Language","Hyperlinks and Text Markup Language","Hyper Transfer Markup Language",
                            "<title>","<head>","<meta>","<body>",
                            "<a>","<link>","<href>","<hyperlink>",
                            "<ul>","<ol>","<li>","<dl>",
                            "link","src","href","image"};


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
        }else if (category.equals("Java")) {
            question = javaques;
            answer = javaans;
            option = javaopt;
        }else if (category.equals("Python")) {
            question = pythonques;
            answer = pythonans;
            option = pythonopt;
        }else if (category.equals("Kotlin")) {
            question = kotlinques;
            answer = kotlinans;
            option = kotlinopt;
        }else if (category.equals("HTML")) {
            question = htmlques;
            answer = htmlans;
            option = htmlopt;
        }


        //Score ( 0 )...   ,  Question number....
        final TextView score = (TextView) findViewById(R.id.textView4);
        TextView txt = (TextView) findViewById(R.id.textView+1);
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
                 //   Toast.makeText(questions.this, "Correct Answer !!!", Toast.LENGTH_SHORT).show();
                }

                else
                {
                    incorrect--;
                 //   Toast.makeText(questions.this, "Incorrect Answer !!!", Toast.LENGTH_SHORT).show();
                }



                if (score != null)
                {
                    score.setText("" + correct);
                }

                if (flag < question.length - 1)
                {
                    flag++; // Increment flag before setting the next question

                    tv.setText(question[flag]);
                    rbtnA.setText(option[flag * 4]);
                    rbtnB.setText(option[flag * 4 + 1]);
                    rbtnC.setText(option[flag * 4 + 2]);
                    rbtnD.setText(option[flag * 4 + 3]);

                    ques_no.setText((flag + 1) + "/" + question.length );

                }
                else
                {
                    marks = correct;
                    Intent intent1 = new Intent(questions.this, result.class);
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


