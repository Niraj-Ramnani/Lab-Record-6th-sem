package com.example.program5;

import android.os.Bundle;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set content view to a custom View directly
        setContentView(new View(this) {
            private Paint p = new Paint();

            @Override
            protected void onDraw(Canvas c) {
                super.onDraw(c);

                // Set background color
                c.drawColor(Color.MAGENTA);

                // Configure paint for filling
                p.setStyle(Paint.Style.FILL);

                // Draw Line (Thicker, Filled Effect)
                p.setColor(Color.RED);
                p.setStrokeWidth(20);
                c.drawLine(100, 300, 600, 300, p);

                // Draw First Rectangle (Filled)
                p.setColor(Color.GREEN);
                c.drawRect(200, 350, 400, 550, p);

                // Draw Circle (Filled)
                p.setColor(Color.BLUE);
                c.drawCircle(350, 750, 120, p);

                // Draw Second Rectangle (Filled)
                p.setColor(Color.CYAN);
                c.drawRect(100, 900, 600, 1100, p);
            }
        });
    }
}
