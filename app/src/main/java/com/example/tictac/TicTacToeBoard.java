package com.example.tictac;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

class TicTacToeBoard extends View {



    private final int gameBoardColor;
    private final int XColor;
    private final int OColor;
    private final int diagonalColor;

    private boolean winningLine = false;

    private int cellSize = getWidth() / 3;

    private final Paint paint = new Paint();

    public TicTacToeBoard(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);



        TypedArray a = context.getTheme().obtainStyledAttributes(attrs,
                R.styleable.TicTacToeBoard, 0, 0);

        try {
            gameBoardColor = a.getInteger(R.styleable.TicTacToeBoard_boardColor, 0);
            XColor = a.getInteger(R.styleable.TicTacToeBoard_XColor, 0);
            OColor = a.getInteger(R.styleable.TicTacToeBoard_OColor, 0);
            diagonalColor = a.getInteger(R.styleable.TicTacToeBoard_winningLineColor, 0);

        }finally {
            a.recycle();
        }
    }

    @Override
    protected void onMeasure(int width, int height){
        super.onMeasure(width, height);

        int dimension = Math.min(getMeasuredWidth(), getMeasuredHeight());
        cellSize = dimension/3;

        setMeasuredDimension(dimension, dimension);
    }





    /*
    private void drawMarkers(Canvas canvas){
        //will draw an X or O onto the board
        for (int r=0; r<3; r++){
            for (int c=0; c<3; c++){
                if (game.getGameBoard()[r][c] != 0){
                    if (game.getGameBoard()[r][c] == 1){
                        drawX(canvas, r, c);
                    }
                    else {
                        drawO(canvas, r, c);
                    }
                }
            }
        }
    }
*/
    private void drawX(Canvas canvas, int row, int col){
        paint.setColor(XColor);

        //positive sloping line
        canvas.drawLine((float) ((col+1)*cellSize - cellSize* 0.2),
                (float) (row*cellSize + cellSize* 0.2),
                (float) (col*cellSize + cellSize* 0.2),
                (float) ((row+1)*cellSize - cellSize* 0.2),
                paint);

        //negative sloping line
        canvas.drawLine((float) (col*cellSize + cellSize* 0.2),
                (float) (row*cellSize + cellSize* 0.2),
                (float) ((col+1)*cellSize - cellSize* 0.2),
                (float) ((row+1)*cellSize - cellSize* 0.2),
                paint);
    }

    private void drawO(Canvas canvas, int row, int col){
        paint.setColor(OColor);

        canvas.drawOval((float)(col*cellSize + cellSize* 0.2),
                (float)(row*cellSize + cellSize* 0.2),
                (float) ((col*cellSize+cellSize) - cellSize* 0.2),
                (float) ((row*cellSize+cellSize) - cellSize* 0.2),
                paint);
    }





}
