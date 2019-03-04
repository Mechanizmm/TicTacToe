package com.example.favouritetoys;

import android.content.Context;
import android.content.DialogInterface;
import android.os.SystemClock;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    boolean playerX = false;

    Button[][] b = new Button[3][3];

    int[][] board = new int[3][3];
    //0 - not set
    //1 - X set
    //2 - O set

    private int[] buttonsID = {
        R.id.button1,
        R.id.button2,
        R.id.button3,
        R.id.button4,
        R.id.button5,
        R.id.button6,
        R.id.button7,
        R.id.button8,
        R.id.button9,
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resetBoard();
    }


    public void onClick(View v)
    {
        switch (v.getId()) {

            case R.id.button1:
                if(board[0][0] == 0) {
                    if (playerX) {
                        b[0][0].setText("X");
                        board[0][0] = 1;
                    } else {
                        b[0][0].setText("O");
                        board[0][0] = 2;
                    }
                    playerX = !playerX;
                }
            break;

            case R.id.button2:
                if(board[0][1] == 0) {
                    if (playerX) {
                        b[0][1].setText("X");
                        board[0][1] = 1;
                    } else {
                        b[0][1].setText("O");
                        board[0][1] = 2;
                    }
                    playerX = !playerX;
                }
            break;

            case R.id.button3:
                if(board[0][2] == 0) {
                    if (playerX) {
                        b[0][2].setText("X");
                        board[0][2] = 1;
                    } else {
                        b[0][2].setText("O");
                        board[0][2] = 2;
                    }
                    playerX = !playerX;
                }
            break;

            case R.id.button4:
                if(board[1][0] == 0) {
                    if (playerX) {
                        b[1][0].setText("X");
                        board[1][0] = 1;
                    } else {
                        b[1][0].setText("O");
                        board[1][0] = 2;
                    }
                    playerX = !playerX;
                }
            break;

            case R.id.button5:
                if(board[1][1] == 0) {
                    if (playerX) {
                        b[1][1].setText("X");
                        board[1][1] = 1;
                    } else {
                        b[1][1].setText("O");
                        board[1][1] = 2;
                    }
                    playerX = !playerX;
                }
            break;

            case R.id.button6:
                if(board[1][2] == 0) {
                    if (playerX) {
                        b[1][2].setText("X");
                        board[1][2] = 1;
                    } else {
                        b[1][2].setText("O");
                        board[1][2] = 2;
                    }
                    playerX = !playerX;
                }
            break;

            case R.id.button7:
                if(board[2][0] == 0) {
                    if (playerX) {
                        b[2][0].setText("X");
                        board[2][0] = 1;
                    } else {
                        b[2][0].setText("O");
                        board[2][0] = 2;
                    }
                    playerX = !playerX;
                }
            break;

            case R.id.button8:
                if(board[2][1] == 0) {
                    if (playerX) {
                        b[2][1].setText("X");
                        board[2][1] = 1;
                    } else {
                        b[2][1].setText("O");
                        board[2][1] = 2;
                    }
                    playerX = !playerX;
                }
            break;

            case R.id.button9:
                if(board[2][2] == 0) {
                    if (playerX) {
                        b[2][2].setText("X");
                        board[2][2] = 1;
                    } else {
                        b[2][2].setText("O");
                        board[2][2] = 2;
                    }
                    playerX = !playerX;
                }
            break;
        }

        checkWinner();
        setText();
    }

    public void setText()
    {
        TextView whoIsNext = (TextView) findViewById(R.id.textView);

        if(playerX)
        {
            whoIsNext.setText("Tura gracza: X");
        }
        else
        {
            whoIsNext.setText("Tura gracza: O");
        }
    }


    public void resetBoard()
    {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                board[i][j] = 0;
            }
        }

        //initButtons
        int idx = 0;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                b[i][j] = (Button) findViewById(buttonsID[idx]);
                b[i][j].setText("");
                idx++;
            }
        }

        playerX = false;
        setText();
    }

    private void checkWinner(){

        //Horizontal --- rows
        for(int i=0; i<3; i++){
            if(board[i][0] == board[i][1] && board[i][0] == board[i][2]){
                if (board[i][0]==1){
                    result("Player X winner\n" + (i+1)+" row");
                    break;
                }
                else if (board[i][0]==2) {
                    result("Player 0 winner\n" + (i+1)+" row");
                    break;
                }
            }
        }

        //Vertical --- columns
        for(int i=0; i<3; i++){
            if(board[0][i] == board[1][i] && board[0][i] == board[2][i]){
                if (board[0][i]==1){
                    result("Player X winner\n" + (i+1)+" column");
                    break;
                }
                else if (board[0][i]==2) {
                    result("Player 0 winner\n" + (i+1)+" column");
                    break;
                }
            }
        }

        //First diagonal
        if(board[0][0] == board[1][1] && board[0][0] == board[2][2]){
            if (board[0][0]==1){
                result("Player X winner\nFirst Diagonal");
            }
            else if (board[0][0]==2) {
                result("Player 0 winner\nFirst Diagonal");
            }
        }

        //Second diagonal
        if(board[0][2] == board[1][1] && board[0][2] == board[2][0]){
            if (board[0][2]==1){
                result("Player X winner\nSecond Diagonal");
            }
            else if (board[0][2]==2) {
                result("Player 0 winner\nSecond Diagonal");
            }
        }
    }

    private void result(String winner){
        System.out.println(winner);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(winner)
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        resetBoard();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
