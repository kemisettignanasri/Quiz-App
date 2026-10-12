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

public class QuetionActivity extends AppCompatActivity {

    int flag = 0;
    int correct =0;
    int wrong = 0;
    String selectedSubject;

    String[] questions;
    String[] options;
    String[] answers;


    TextView quitBtn, dispNo, score, question;
    Button next;
    RadioGroup radio_g;
    RadioButton rb1, rb2, rb3, rb4;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_quetion);
        selectedSubject = getIntent().getStringExtra("subject");

        if (selectedSubject == null) {
            selectedSubject = "Java";
        }
        loadQuestions();
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
        dispNo.setText("1/" + questions.length);
        score.setText("0");

        rb1.setText(options[0]);
        rb2.setText(options[1]);
        rb3.setText(options[2]);
        rb4.setText(options[3]);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(radio_g.getCheckedRadioButtonId() == -1){
                    Toast.makeText(QuetionActivity.this, "Please select an option", Toast.LENGTH_SHORT).show();
                    return;
                }

                RadioButton uAnswer = findViewById(radio_g.getCheckedRadioButtonId());
                String ansText = uAnswer.getText().toString();

                if(ansText.equals(answers[flag])){
                    correct++;
                    Toast.makeText(QuetionActivity.this, "Hurray!! it was correct", Toast.LENGTH_SHORT).show();

                }else{
                    wrong++;
                    Toast.makeText(QuetionActivity.this,"Ohh!! it was incorrect", Toast.LENGTH_SHORT).show();
                }
                flag++;
                if(score!= null) {
                    score.setText(""+correct);
                    if (flag < questions.length) {
                        question.setText(questions[flag]);
                        rb1.setText(options[flag * 4]);
                        rb2.setText(options[flag * 4 + 1]);
                        rb3.setText(options[flag * 4 + 2]);
                        rb4.setText(options[flag * 4 + 3]);

                        dispNo.setText((flag + 1) + "/" + questions.length);
                    } else {
                        Intent intent = new Intent(QuetionActivity.this, ResultActivity.class);
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
                Intent intent = new Intent(QuetionActivity.this, ResultActivity.class);
                intent.putExtra("attempted", flag);
                intent.putExtra("correct", correct);
                intent.putExtra("wrong", wrong);
                startActivity(intent);
                finish();

            }
        });
    }
    private void loadQuestions() {
        switch (selectedSubject) {
            case "Python":
                questions = new String[]{
                        "Which keyword is used to define a function in Python?",
                        "Which data type stores key-value pairs?",
                        "What is the output of print(2 ** 3)?",
                        "Which symbol starts a single-line comment?",
                        "Which method adds an item to a list?",
                        "Which keyword is used for a loop over a sequence?",
                        "What is the result of len('Python')?",
                        "Which data type is immutable?",
                        "Which keyword handles exceptions?",
                        "What does input() return by default?"
                };

                options = new String[]{
                        "func", "def", "function", "define",
                        "List", "Tuple", "Dictionary", "Set",
                        "6", "8", "9", "5",
                        "//", "#", "/*", "--",
                        "add()", "append()", "insertEnd()", "push()",
                        "repeat", "foreach", "for", "loop",
                        "5", "6", "7", "8",
                        "List", "Dictionary", "Set", "Tuple",
                        "try", "catch", "except", "error",
                        "Integer", "String", "Boolean", "Float"
                };

                answers = new String[]{
                        "def",
                        "Dictionary",
                        "8",
                        "#",
                        "append()",
                        "for",
                        "6",
                        "Tuple",
                        "except",
                        "String"
                };
                break;
            case "C":
                questions = new String[]{
                        "Which function is the entry point of a standard C program?",
                        "Which format specifier is commonly used to print an int with printf?",
                        "Which symbol ends a C statement?",
                        "Which header declares printf()?",
                        "What is the index of the first element in a C array?",
                        "Which loop checks its condition before executing the body?",
                        "Which operator gets the address of a variable?",
                        "Which keyword declares a read-only variable?",
                        "Which function compares two C strings?",
                        "What does sizeof(int) return?"
                };

                options = new String[]{
                        "start()", "main()", "run()", "init()",
                        "%c", "%f", "%d", "%s",
                        ":", ";", ".", ",",
                        "<stdlib.h>", "<stdio.h>", "<string.h>", "<math.h>",
                        "1", "-1", "0", "Depends on the array",
                        "do-while", "while", "switch", "if-else",
                        "*", "&", "%", "#",
                        "static", "extern", "const", "register",
                        "strcpy()", "strcmp()", "strlen()", "strcat()",
                        "The size in bytes", "The number of bits", "The memory address", "The array length"
                };

                answers = new String[]{
                        "main()",
                        "%d",
                        ";",
                        "<stdio.h>",
                        "0",
                        "while",
                        "&",
                        "const",
                        "strcmp()",
                        "The size in bytes"
                };
                break;
            case "C++":
                questions = new String[]{
                        "Which feature allows a class to derive from another class in C++?",
                        "Which operator is used to access a member through an object pointer?",
                        "Which keyword creates an object dynamically in C++?",
                        "Which concept allows the same function name with different parameter lists?",
                        "Which access specifier makes class members accessible only within the class and its friends?",
                        "Which symbol is used for the scope resolution operator?",
                        "Which function is called automatically when an object is destroyed?",
                        "Which C++ feature supports runtime polymorphism?",
                        "Which header provides std::vector?",
                        "What is the usual purpose of a constructor?"
                };

                options = new String[]{
                        "Encapsulation", "Inheritance", "Compilation", "Recursion",
                        ".", "->", "::", "&",
                        "malloc", "new", "create", "alloc",
                        "Overriding", "Overloading", "Abstraction", "Casting",
                        "public", "protected", "private", "static",
                        ".", "->", "::", "==",
                        "Destructor", "Main function", "Copy operator", "Namespace",
                        "Function overloading only", "Virtual functions", "Preprocessor macros", "Header guards",
                        "<iostream>", "<string>", "<vector>", "<fstream>",
                        "To initialize an object", "To destroy an object", "To include a header", "To allocate a namespace"
                };

                answers = new String[]{
                        "Inheritance",
                        "->",
                        "new",
                        "Overloading",
                        "private",
                        "::",
                        "Destructor",
                        "Virtual functions",
                        "<vector>",
                        "To initialize an object"
                };
                break;

            case "Dart":
                questions = new String[]{
                        "Which keyword declares a variable whose value can change in Dart?",
                        "Which function is the entry point of a Dart application?",
                        "Which keyword declares a compile-time constant in Dart?",
                        "Which symbol is used for string interpolation in Dart?",
                        "Which collection stores key-value pairs?",
                        "Which keyword is used to define a class?",
                        "Which operator provides a default when a value is null?",
                        "Which keyword is used to return a value from a function?",
                        "Which method adds an item to a Dart List?",
                        "Which file extension is used for Dart source files?"
                };

                options = new String[]{
                        "final", "const", "var", "static",
                        "start()", "main()", "run()", "init()",
                        "var", "final", "const", "let",
                        "#", "$", "@", "%",
                        "List", "Set", "Map", "Queue",
                        "object", "class", "struct", "type",
                        "??", "&&", "||", "!=",
                        "give", "yield", "return", "send",
                        "append()", "add()", "push()", "insertEnd()",
                        ".java", ".dart", ".kt", ".xml"
                };

                answers = new String[]{
                        "var",
                        "main()",
                        "const",
                        "$",
                        "Map",
                        "class",
                        "??",
                        "return",
                        "add()",
                        ".dart"
                };
                break;

            case "SQL":
                questions = new String[]{
                        "Which SQL statement retrieves data from a table?",
                        "Which clause filters rows before grouping?",
                        "Which clause filters groups after GROUP BY?",
                        "Which keyword removes duplicate rows from a result?",
                        "Which function counts rows?",
                        "Which command changes existing rows in a table?",
                        "Which constraint uniquely identifies each row and does not allow NULL?",
                        "Which JOIN returns only matching rows from both tables?",
                        "Which command removes a table definition and its data?",
                        "Which clause sorts query results?"
                };

                options = new String[]{
                        "GET", "SELECT", "FETCHTABLE", "OPEN",
                        "HAVING", "ORDER BY", "WHERE", "GROUP BY",
                        "WHERE", "HAVING", "ORDER BY", "VALUES",
                        "UNIQUE", "DISTINCT", "SINGLE", "ONLY",
                        "TOTAL()", "SUMROWS()", "COUNT()", "NUMBER()",
                        "MODIFY", "CHANGE", "UPDATE", "ALTER",
                        "FOREIGN KEY", "CHECK", "PRIMARY KEY", "DEFAULT",
                        "LEFT JOIN", "CROSS JOIN", "INNER JOIN", "FULL JOIN",
                        "DELETE DATABASE", "DROP TABLE", "REMOVE TABLE", "CLEAR TABLE",
                        "GROUP BY", "SORT BY", "ORDER BY", "ARRANGE"
                };

                answers = new String[]{
                        "SELECT",
                        "WHERE",
                        "HAVING",
                        "DISTINCT",
                        "COUNT()",
                        "UPDATE",
                        "PRIMARY KEY",
                        "INNER JOIN",
                        "DROP TABLE",
                        "ORDER BY"
                };
                break;

            case "XML":
                questions = new String[]{
                        "What does XML stand for?",
                        "Which symbol begins an XML element tag?",
                        "What must an XML document have as its single top-level element?",
                        "How is an XML attribute value normally enclosed?",
                        "Which character sequence begins an XML comment?",
                        "Which character sequence ends an XML comment?",
                        "Are XML element names case-sensitive?",
                        "Which Android XML file declares app activities and permissions?",
                        "Which XML attribute sets a View's width in Android?",
                        "What does @string/app_name reference in Android XML?"
                };

                options = new String[]{
                        "Extra Markup Language", "Extensible Markup Language",
                        "Executable Markup Language", "External Machine Language",
                        "<", ">", "/", "#",
                        "A root element", "Two root elements",
                        "A closing tag only", "No root element",
                        "Single or double quotes", "Parentheses",
                        "Square brackets", "Curly braces",
                        "<!--", "//", "**", "##",
                        "-->", "!-->", "//", "##",
                        "Yes", "No", "Only in Android", "Only for attributes",
                        "strings.xml", "build.gradle", "AndroidManifest.xml", "colors.xml",
                        "android:height", "android:width", "android:size", "android:weight",
                        "A string resource named app_name", "An integer resource",
                        "A layout resource", "A drawable resource"
                };

                answers = new String[]{
                        "Extensible Markup Language",
                        "<",
                        "A root element",
                        "Single or double quotes",
                        "<!--",
                        "-->",
                        "Yes",
                        "AndroidManifest.xml",
                        "android:width",
                        "A string resource named app_name"
                };
                break;
            case "Kotlin":
                questions = new String[]{
                        "Which keyword declares a variable that can be reassigned?",
                        "Which keyword declares a read-only variable?",
                        "What is the entry-point function of a Kotlin application?",
                        "Which symbol is used for string interpolation?",
                        "Which keyword is used to declare a function?",
                        "Which operator safely accesses a nullable object?",
                        "Which keyword is used to define a class?",
                        "Which collection stores key-value pairs?",
                        "Which keyword returns a value from a function?",
                        "What is the file extension for Kotlin source files?"
                };

                options = new String[]{
                        "val", "var", "const", "let",
                        "var", "val", "mutable", "static",
                        "start()", "run()", "main()", "init()",
                        "#", "$", "@", "%",
                        "function", "method", "fun", "define",
                        "!!", "?.", "::", "?:",
                        "object", "struct", "class", "type",
                        "List", "Set", "Map", "Array",
                        "give", "return", "break", "yield",
                        ".java", ".kt", ".kotlin", ".class"
                };

                answers = new String[]{
                        "var",
                        "val",
                        "main()",
                        "$",
                        "fun",
                        "?.",
                        "class",
                        "Map",
                        "return",
                        ".kt"
                };
                break;
            case "Java":
            default:
                questions = new String[]{
                        "What is the main purpose of the Java Virtual Machine (JVM)?",
                        "Which of the following is NOT a primitive data type in Java?",
                        "What is the output of int x = 5; System.out.println(x++ + ++x)?",
                        "Which keyword is used when a class inherits another class?",
                        "What is true about local variables in Java?",
                        "What is the size of the int data type in Java?",
                        "Which keyword explicitly throws an exception?",
                        "Which is a valid Java application entry point?",
                        "What is method overloading?",
                        "What does final prevent when applied to a class?"
                };

                options = new String[]{
                        "Converts source code directly into machine code",
                        "Executes Java bytecode",
                        "Writes Java source code",
                        "Creates database tables",
                        "int", "float", "boolean", "String",
                        "10", "11", "12", "Compilation error",
                        "implements", "extends", "inherits", "super",
                        "They always default to zero",
                        "They always default to null",
                        "They must be initialized before use",
                        "They are automatically initialized to false",
                        "2 bytes", "4 bytes", "8 bytes", "Depends on the operating system",
                        "throw", "throws", "try", "catch",
                        "private void main(String[] args)",
                        "public static void main(String[] args)",
                        "public void start(String[] args)",
                        "static int run(String[] args)",
                        "Same method name with different parameter lists",
                        "Different method names with identical parameters",
                        "Overriding a superclass method only",
                        "Declaring every method as static",
                        "Creating objects of the class",
                        "Changing the class name",
                        "Extending the class",
                        "Instantiating the class"
                };

                answers = new String[]{
                        "Executes Java bytecode",
                        "String",
                        "12",
                        "extends",
                        "They must be initialized before use",
                        "4 bytes",
                        "throw",
                        "public static void main(String[] args)",
                        "Same method name with different parameter lists",
                        "Extending the class"
                };
                break;
        }
    }
}
