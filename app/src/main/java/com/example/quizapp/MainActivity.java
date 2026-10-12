package com.example.quizapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    private android.widget.Button signOutButton;
    private RecyclerView quizRecyclerView;
    private ArrayList<String> quizList;
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
        signOutButton = findViewById(R.id.signOutButton);

        signOutButton.setOnClickListener(view -> {
            FirebaseAuth.getInstance().signOut();

            Intent intent = new Intent(MainActivity.this, SignIn.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |
                    Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        });
    }





    private void navigateTo(Class<?> activity) {
        Intent intent = new Intent(MainActivity.this, activity);
        startActivity(intent);
    }


    public void java(View view) {
        Intent intent = new Intent(MainActivity.this, QuetionActivity.class);
        intent.putExtra("subject", "Java");
        startActivity(intent);
        finish();
    }

    public void kotlin(View view) {
        Intent intent = new Intent(MainActivity.this, QuetionActivity.class);
        intent.putExtra("subject", "Kotlin");
        startActivity(intent);
        finish();
    }

    public void python(View view) {
        Intent intent = new Intent(MainActivity.this, QuetionActivity.class);
        intent.putExtra("subject", "Python");
        startActivity(intent);
        finish();
    }

    public void cpp(View view) {
        Intent intent = new Intent(MainActivity.this, QuetionActivity.class);
        intent.putExtra("subject", "C++");
        startActivity(intent);
        finish();
    }

    public void dart(View view) {
        Intent intent = new Intent(MainActivity.this, QuetionActivity.class);
        intent.putExtra("subject", "Dart");
        startActivity(intent);
        finish();
    }

    public void sql(View view) {
        Intent intent = new Intent(MainActivity.this, QuetionActivity.class);
        intent.putExtra("subject", "SQL");
        startActivity(intent);
        finish();
    }

    public void xml(View view) {
        Intent intent = new Intent(MainActivity.this, QuetionActivity.class);
        intent.putExtra("subject", "XML");
        startActivity(intent);
        finish();
    }

    public void c(View view) {
        Intent intent = new Intent(MainActivity.this, QuetionActivity.class);
        intent.putExtra("subject", "C");
        startActivity(intent);
        finish();
    }
}
