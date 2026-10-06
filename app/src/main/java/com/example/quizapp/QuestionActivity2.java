package com.example.quizapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
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

public class QuestionActivity2 extends AppCompatActivity {

    int flag = 0;
    int marks = 0;
    public static int correct =0;
    int wrong = 0;

    String[] questions = {"What is the main purpose of the Java Virtual Machine (JVM)?",
            "Which of the following is not a Java primitive data type?",
            "What will be the output of the following code snippet?  int x = 5;\n" +
                    "System.out.println(x++ + ++x);\n",
            "Which keyword is used to inherit a class in Java?",
            "What is the default value of a local variable in Java?",
            "What is the size of an int variable in Java?",
            "Which of the following is used to handle exceptions in Java?",
            "What will happen if the main method is declared as private?",
            "Which Java feature allows multiple methods with the same name but different parameters?",
            "What does the final keyword in Java do?"};
    String[] options = {
            "Convert Java code to machine code","Execute Java bytecode","Compile Java source code","Manage memory allocation only",
            "int","float","boolean","string",
            "11","12","13","Compilation error",
            "implements","extends","inherits","super",
            "null","0","Depends on the data type","No default value (must be initialized)",
            "2 bytes","4 bytes","8 bytes","Depends on the system",
            "try-catch","throw","throws","All of the above",
            "The program will compile but not run","The program will run normally","The program will throw a runtime error","Compilation error",
            "Inheritance","Polymorphism","Method Overloading","Method Overriding",
            "Prevents method overriding","Prevents variable reassignment","Prevents class inheritance","All of the above"

    };
    String[] answers = {
            "Execute Java bytecode",
            "string",
            "13",
            "extends",
            "No default value (must be initialized)",
            "4 bytes",
            "All of the above",
            "The program will compile but not run",
            "Method Overloading",
            "All of the above"
    };


    TextView quitBtn, dispNo, score, question;
    Button next;
    RadioGroup radio_g;
    RadioButton rb1, rb2, rb3, rb4;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_question2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        quitBtn = findViewById(R.id.quitBtn);
        score = findViewById(R.id.score);
        question = findViewById(R.id.question);
        dispNo = findViewById(R.id.dispNo);
        next = findViewById(R.id.nextBtn);
        radio_g = findViewById(R.id.answerGroup);
        rb1 = findViewById(R.id.radioBtn1);
        rb2 = findViewById(R.id.radioBtn2);
        rb3 = findViewById(R.id.radioBtn3);
        rb4 = findViewById(R.id.radioBtn4);

        question.setText(questions[flag]);
        rb1.setText(options[0]);
        rb2.setText(options[1]);
        rb3.setText(options[2]);
        rb4.setText(options[3]);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(radio_g.getCheckedRadioButtonId() == -1){
                    Toast.makeText(QuestionActivity2.this, "Please select an option", Toast.LENGTH_SHORT).show();
                    return;
                }

                RadioButton uAnswer = findViewById(radio_g.getCheckedRadioButtonId());
                String ansText = uAnswer.getText().toString();

                if(ansText.equals(answers[flag])){
                    correct++;
                    Toast.makeText(QuestionActivity2.this, "Hurray!! it was correct", Toast.LENGTH_SHORT).show();

                }else{
                    wrong++;
                    Toast.makeText(QuestionActivity2.this,"Ohh!! it was incorrect", Toast.LENGTH_SHORT).show();
                }
                flag++;
                if(score!= null) {
                    score.setText(correct);
                    if (flag < questions.length) {
                        question.setText(questions[flag]);
                        rb1.setText(options[flag + 4]);
                        rb2.setText(options[flag + 4 + 1]);
                        rb3.setText(options[flag + 4 + 2]);
                        rb4.setText(options[flag + 4 + 3]);

                        dispNo.setText((flag + 1) + "/" + questions.length);
                    } else {
                        marks = correct;
                        Intent intent = new Intent(QuestionActivity2.this, ResultActivity.class);
                        intent.putExtra("attempted", flag);
                        intent.putExtra("correct", correct);
                        intent.putExtra("wrong", wrong);
                        startActivity(intent);
                        finish();

                    }
                    radio_g.clearCheck();
                }



            }
        });
        quitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuestionActivity2.this, ResultActivity.class);
                intent.putExtra("attempted", flag);
                intent.putExtra("correct", correct);
                intent.putExtra("wrong", wrong);
                startActivity(intent);
                finish();

            }
        });
    }
}
