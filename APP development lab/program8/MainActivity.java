package com.example.program8;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import java.io.*;

public class MainActivity extends AppCompatActivity {
    private EditText etInput;
    private TextView tvOutput;
    private static final int PERMISSION_REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etInput = findViewById(R.id.etInput);
        tvOutput = findViewById(R.id.tvOutput);
        Button btnWrite = findViewById(R.id.btnWrite);
        Button btnRead = findViewById(R.id.btnRead);

        // Request permissions
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    PERMISSION_REQUEST_CODE);
        }

        // Write data to SD Card
        btnWrite.setOnClickListener(v -> writeToSDCard(etInput.getText().toString()));

        // Read data from SD Card
        btnRead.setOnClickListener(v -> readFromSDCard());
    }

    private void writeToSDCard(String data) {
        if (isExternalStorageWritable()) {
            File file = new File(getExternalFilesDir(null), "data.txt");
            try (FileOutputStream fos = new FileOutputStream(file);
                 OutputStreamWriter osw = new OutputStreamWriter(fos)) {
                osw.write(data);
                tvOutput.setText("Data written to: " + file.getAbsolutePath());
            } catch (IOException e) {
                tvOutput.setText("Error writing file: " + e.getMessage());
            }
        } else {
            tvOutput.setText("SD Card not writable!");
        }
    }

    private void readFromSDCard() {
        if (isExternalStorageReadable()) {
            File file = new File(getExternalFilesDir(null), "data.txt");
            if (file.exists()) {
                try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                    StringBuilder sb = new StringBuilder();
                    String line;
                    while ((line = br.readLine()) != null) {
                        sb.append(line).append("\n");
                    }
                    tvOutput.setText("Read Data: \n" + sb.toString());
                } catch (IOException e) {
                    tvOutput.setText("Error reading file: " + e.getMessage());
                }
            } else {
                tvOutput.setText("File does not exist!");
            }
        } else {
            tvOutput.setText("SD Card not readable!");
        }
    }

    private boolean isExternalStorageWritable() {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }

    private boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        return state.equals(Environment.MEDIA_MOUNTED) || state.equals(Environment.MEDIA_MOUNTED_READ_ONLY);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                tvOutput.setText("Permission Denied!");
            }
        }
    }
}
