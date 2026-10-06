package com.example.quizapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    private RecyclerView quizRecyclerView;
    private ArrayList<String> quizList;
    private ProgressBar timerProgressBar;
    private final int timeLimit = 30000; // 10 seconds
    private final int interval = 100; // Update every 100ms

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        toolbar = findViewById(R.id.toolbar);
        timerProgressBar = findViewById(R.id.timerProgressBar);

        if (timerProgressBar != null) {
            startTimer();
        } else {
            Toast.makeText(this, "Error: Timer ProgressBar not found!", Toast.LENGTH_SHORT).show();
        }
    }

    private void startTimer() {
        if (timerProgressBar == null) return; // Avoids null pointer exception

        timerProgressBar.setMax(100);
        timerProgressBar.setProgress(100);

        CountDownTimer countDownTimer = new CountDownTimer(timeLimit, interval) {
            @Override
            public void onTick(long millisUntilFinished) {
                if (timerProgressBar != null) {
                    int progress = (int) ((millisUntilFinished * 100) / timeLimit);
                    timerProgressBar.setProgress(progress);
                }
            }

            @Override
            public void onFinish() {
                if (timerProgressBar != null) {
                    timerProgressBar.setProgress(0);
                }
                Toast.makeText(MainActivity.this, "Time is up!", Toast.LENGTH_SHORT).show();
            }
        }.start();
    }



    private void navigateTo(Class<?> activity) {
        Intent intent = new Intent(MainActivity.this, activity);
        startActivity(intent);
    }


    public void java(View view) {
        startActivity(new Intent(MainActivity.this, QuetionActivity.class));
        finish();
    }

    public void kotlin(View view) {
        startActivity(new Intent(MainActivity.this, QuestionActivity2.class));
        finish();
    }

    public void python(View view) {
        startActivity(new Intent(MainActivity.this, QuetionActivity.class));
        finish();
    }

    public void cpp(View view) {
        startActivity(new Intent(MainActivity.this, QuetionActivity.class));
        finish();
    }

    public void dart(View view) {
        startActivity(new Intent(MainActivity.this, QuetionActivity.class));
        finish();
    }

    public void sql(View view) {
        startActivity(new Intent(MainActivity.this, QuetionActivity.class));
        finish();
    }

    public void xml(View view) {
        startActivity(new Intent(MainActivity.this, QuetionActivity.class));
        finish();
    }

    public void c(View view) {
        startActivity(new Intent(MainActivity.this, QuetionActivity.class));
        finish();
    }
}
