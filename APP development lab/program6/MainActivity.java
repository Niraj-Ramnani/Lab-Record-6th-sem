package com.example.program6;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private DBHelper dbHelper;
    private EditText etName, etClass, etMarks;
    private TextView tvResult;
    private Button btnAdd, btnView;
    private ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DBHelper(this);
        etName = findViewById(R.id.etName);
        etClass = findViewById(R.id.etClass);
        etMarks = findViewById(R.id.etMarks);
        tvResult = findViewById(R.id.tvResult);
        btnAdd = findViewById(R.id.btnAdd);
        btnView = findViewById(R.id.btnView);
        scrollView = findViewById(R.id.scrollView);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                String studentClass = etClass.getText().toString();
                int marks = Integer.parseInt(etMarks.getText().toString());
                dbHelper.insertStudent(name, studentClass, marks);
                etName.setText("");
                etClass.setText("");
                etMarks.setText("");
            }
        });

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor = dbHelper.getStudents();
                StringBuilder sb = new StringBuilder();
                while (cursor.moveToNext()) {
                    sb.append("ID: ").append(cursor.getInt(0))
                            .append("\nName: ").append(cursor.getString(1))
                            .append("\nClass: ").append(cursor.getString(2))
                            .append("\nMarks: ").append(cursor.getInt(3))
                            .append("\n----------------------\n");
                }
                cursor.close();
                tvResult.setText(sb.toString());
                scrollView.fullScroll(View.FOCUS_DOWN);
            }
        });
    }
}
