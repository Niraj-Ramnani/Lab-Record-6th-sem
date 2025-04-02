package com.example.program9;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GameView extends SurfaceView implements SurfaceHolder.Callback {
    private GameThread gameThread;
    private float ballX, ballY, ballRadius = 40, ballSpeedX = 15, ballSpeedY = -15; // Increased ball speed
    private float paddleX, paddleY, paddleWidth = 400, paddleHeight = 80; // Increased paddle size
    private int score = 0;
    private Paint ballPaint, paddlePaint, scorePaint;

    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);
        getHolder().addCallback(this);
        setFocusable(true);

        // Initialize paints
        ballPaint = new Paint();
        ballPaint.setColor(Color.RED);
        ballPaint.setStyle(Paint.Style.FILL);

        paddlePaint = new Paint();
        paddlePaint.setColor(Color.BLACK);
        paddlePaint.setStyle(Paint.Style.FILL);

        scorePaint = new Paint();
        scorePaint.setColor(Color.BLACK);
        scorePaint.setTextSize(50);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        // Initialize ball and paddle positions
        ballX = getWidth() / 2f;
        ballY = getHeight() / 2f;
        paddleX = getWidth() / 2f - paddleWidth / 2;
        paddleY = getHeight() - 180; // Moved paddle higher (closer to the top)

        // Start the game thread
        gameThread = new GameThread(this);
        gameThread.setRunning(true);
        gameThread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {}

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        gameThread.setRunning(false);
        while (retry) {
            try {
                gameThread.join();
                retry = false;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void update() {
        // Update ball position
        ballX += ballSpeedX;
        ballY += ballSpeedY;

        // Ball collision with walls
        if (ballX + ballRadius > getWidth() || ballX - ballRadius < 0) {
            ballSpeedX = -ballSpeedX;
        }
        if (ballY - ballRadius < 0) {
            ballSpeedY = -ballSpeedY;
            score++; // Increment score when ball hits the top
        }

        // Ball collision with paddle
        if (ballY + ballRadius > paddleY && ballY - ballRadius < paddleY + paddleHeight &&
                ballX > paddleX && ballX < paddleX + paddleWidth) {
            ballSpeedY = -ballSpeedY;
        }

        // Game over if ball falls below paddle
        if (ballY + ballRadius > getHeight()) {
            ballX = getWidth() / 2f;
            ballY = getHeight() / 2f;
            ballSpeedX = 8; // Reset to new speed
            ballSpeedY = -8; // Reset to new speed
            score = 0; // Reset score
        }
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (canvas == null) return;

        // Clear the canvas
        canvas.drawColor(Color.CYAN);

        // Draw the ball
        canvas.drawCircle(ballX, ballY, ballRadius, ballPaint);

        // Draw the paddle
        canvas.drawRect(paddleX, paddleY, paddleX + paddleWidth, paddleY + paddleHeight, paddlePaint);

        // Draw the score
        canvas.drawText("Score: " + score, 20, 50, scorePaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // Move paddle based on touch
        if (event.getAction() == MotionEvent.ACTION_MOVE || event.getAction() == MotionEvent.ACTION_DOWN) {
            paddleX = event.getX() - paddleWidth / 2;
            // Keep paddle within bounds
            if (paddleX < 0) paddleX = 0;
            if (paddleX + paddleWidth > getWidth()) paddleX = getWidth() - paddleWidth;
        }
        return true;
    }

    // Game thread class to handle game loop
    private class GameThread extends Thread {
        private SurfaceHolder surfaceHolder;
        private GameView gameView;
        private boolean running;

        public GameThread(GameView gameView) {
            this.gameView = gameView;
            this.surfaceHolder = gameView.getHolder();
        }

        public void setRunning(boolean running) {
            this.running = running;
        }

        @Override
        public void run() {
            while (running) {
                Canvas canvas = null;
                try {
                    canvas = surfaceHolder.lockCanvas();
                    synchronized (surfaceHolder) {
                        gameView.update();
                        gameView.draw(canvas);
                    }
                } finally {
                    if (canvas != null) {
                        surfaceHolder.unlockCanvasAndPost(canvas);
                    }
                }
                try {
                    Thread.sleep(16); // Aim for ~60 FPS
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}