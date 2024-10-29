package com.jah.tres_en_raya;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btn00, btn01, btn02, btn10, btn11, btn12, btn20, btn21, btn22, btnStart, btnNames;
    TextView lblTourn;
    AlertDialog.Builder dialog;
    Button[][] buttons;
    String[] names;
    boolean turno;
    boolean notWin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        //init components.
        btn00 = findViewById(R.id.btn00);btn01 = findViewById(R.id.btn01);btn02 = findViewById(R.id.btn02);
        btn10 = findViewById(R.id.btn10);btn11 = findViewById(R.id.btn11);btn12 = findViewById(R.id.btn12);
        btn20 = findViewById(R.id.btn20);btn21 = findViewById(R.id.btn21);btn22 = findViewById(R.id.btn22);
        btnStart = findViewById(R.id.btnStart);btnNames = findViewById(R.id.btnNames);lblTourn = findViewById(R.id.lblTourn);
        turno = true;notWin = true;
        names = new String[2]; names[0] = ""; names[1] = "";
        buttons = new Button[][]{
                {btn00, btn01, btn02},
                {btn10, btn11, btn12},
                {btn20, btn21, btn22}
        };
        //Listeners methods.
        startNewGame();
        btnStart.setOnClickListener(view -> createDialogStart());
        btnNames.setOnClickListener(view -> createDialogNames());
        btn00.setOnClickListener(pressedButton -> {
            playerTurn();
            playGame(pressedButton);
        });
        btn01.setOnClickListener(pressedButton -> {
            playerTurn();
            playGame(pressedButton);
        });
        btn02.setOnClickListener(pressedButton -> {
            playerTurn();
            playGame(pressedButton);
        });
        btn10.setOnClickListener(pressedButton -> {
            playerTurn();
            playGame(pressedButton);
        });
        btn11.setOnClickListener(pressedButton -> {
            playerTurn();
            playGame(pressedButton);
        });
        btn12.setOnClickListener(pressedButton -> {
            playerTurn();
            playGame(pressedButton);
        });
        btn20.setOnClickListener(pressedButton -> {
            playerTurn();
            playGame(pressedButton);
        });
        btn21.setOnClickListener(pressedButton -> {
            playerTurn();
            playGame(pressedButton);
        });
        btn22.setOnClickListener(pressedButton -> {
            playerTurn();
            playGame(pressedButton);
        });
    }
    //Control player turn. Change backgroundColor(P1 RED, P2 BLUE) and player name.
    private void playerTurn() {
        String str = "";
        if(!turno){
            str = getString(R.string.lblTourn) + " " + names[0];
            lblTourn.setText(str);
            lblTourn.setTextColor(getColor(R.color.TournP1));
        }else{
            str = getString(R.string.lblTourn)+ " " + names[1];
            lblTourn.setText(str);
            lblTourn.setTextColor(getColor(R.color.TournP2));
        }
    }
    //Pressed button control for mark as P1 or P2 square.
    private void playGame(View pressedButton) {
        if(turno){
            pressedButton.setBackgroundColor(getColor(R.color.TournP1));
            ((Button) pressedButton).setText(R.string.txtX);
            pressedButton.setEnabled(false);
            turno = false;
            winner();
        }else{
            pressedButton.setBackgroundColor(getColor(R.color.TournP2));
            ((Button) pressedButton).setText(R.string.txtO);
            pressedButton.setEnabled(false);
            turno = true;
            winner();
        }
    }
    //Check if P1 or P2 win the game.
    private void winner() {
        notWin = true;
        String str = "";
        if(buttons[0][0].getText().toString().contains("X") && buttons[0][1].getText().toString().contains("X") && buttons[0][2].getText().toString().contains("X")){
            str = names[0] + " " + getString(R.string.win);
            lblTourn.setText(str);
            lblTourn.setTextColor(getColor(R.color.TournP1));
            win();
            notWin = false;
        }
        if(buttons[0][0].getText().toString().contains("O") && buttons[0][1].getText().toString().contains("O") && buttons[0][2].getText().toString().contains("O")){
            str = names[0] + " " + getString(R.string.win);
            lblTourn.setText(str);
            lblTourn.setTextColor(getColor(R.color.TournP2));
            win();
            notWin = false;
        }
        if(buttons[0][0].getText().toString().contains("X") && buttons[1][0].getText().toString().contains("X") && buttons[2][0].getText().toString().contains("X")){
            str = names[0] + " " + getString(R.string.win);
            lblTourn.setText(str);
            lblTourn.setTextColor(getColor(R.color.TournP1));
            win();
            notWin = false;
        }
        if(buttons[0][0].getText().toString().contains("O") && buttons[1][0].getText().toString().contains("O") && buttons[2][0].getText().toString().contains("O")){
            str = names[1] + " " + getString(R.string.win);
            lblTourn.setText(str);
            lblTourn.setTextColor(getColor(R.color.TournP2));
            win();
            notWin = false;
        }
        if(buttons[0][0].getText().toString().contains("X") && buttons[1][1].getText().toString().contains("X") && buttons[2][2].getText().toString().contains("X")){
            str = names[0] + " " + getString(R.string.win);
            lblTourn.setText(str);
            lblTourn.setTextColor(getColor(R.color.TournP1));
            win();
            notWin = false;
        }
        if(buttons[0][0].getText().toString().contains("O") && buttons[1][1].getText().toString().contains("O") && buttons[2][2].getText().toString().contains("O")){
            str = names[1] + " " + getString(R.string.win);
            lblTourn.setText(str);
            lblTourn.setTextColor(getColor(R.color.TournP2));
            win();
            notWin = false;
        }
        if(buttons[0][1].getText().toString().contains("X") && buttons[1][1].getText().toString().contains("X") && buttons[2][1].getText().toString().contains("X")){
            str = names[0] + " " + getString(R.string.win);
            lblTourn.setText(str);
            lblTourn.setTextColor(getColor(R.color.TournP1));
            win();
            notWin = false;
        }
        if(buttons[0][1].getText().toString().contains("O") && buttons[1][1].getText().toString().contains("O") && buttons[2][1].getText().toString().contains("O")){
            str = names[1] + " " + getString(R.string.win);
            lblTourn.setText(str);
            lblTourn.setTextColor(getColor(R.color.TournP2));
            win();
            notWin = false;
        }
        if(buttons[0][2].getText().toString().contains("X") && buttons[1][2].getText().toString().contains("X") && buttons[2][2].getText().toString().contains("X")){
            str = names[0] + " " + getString(R.string.win);
            lblTourn.setText(str);
            lblTourn.setTextColor(getColor(R.color.TournP1));
            win();
            notWin = false;
        }
        if(buttons[0][2].getText().toString().contains("O") && buttons[1][2].getText().toString().contains("O") && buttons[2][2].getText().toString().contains("O")){
            str = names[1] + " " + getString(R.string.win);
            lblTourn.setText(str);
            lblTourn.setTextColor(getColor(R.color.TournP2));
            win();
            notWin = false;
        }
        if(buttons[1][0].getText().toString().contains("X") && buttons[1][1].getText().toString().contains("X") && buttons[1][2].getText().toString().contains("X")){
            str = names[0] + " " + getString(R.string.win);
            lblTourn.setText(str);
            lblTourn.setTextColor(getColor(R.color.TournP1));
            win();
            notWin = false;
        }
        if(buttons[1][0].getText().toString().contains("O") && buttons[1][1].getText().toString().contains("O") && buttons[1][2].getText().toString().contains("O")){
            str = names[1] + " " + getString(R.string.win);
            lblTourn.setText(str);
            lblTourn.setTextColor(getColor(R.color.TournP2));
            win();
            notWin = false;
        }
        if(buttons[2][0].getText().toString().contains("X") && buttons[2][1].getText().toString().contains("X") && buttons[2][2].getText().toString().contains("X")){
            str = names[0] + " " + getString(R.string.win);
            lblTourn.setText(str);
            lblTourn.setTextColor(getColor(R.color.TournP1));
            win();
            notWin = false;
        }
        if(buttons[2][0].getText().toString().contains("O") && buttons[2][1].getText().toString().contains("O") && buttons[2][2].getText().toString().contains("O")){
            str = names[1] + " " + getString(R.string.win);
            lblTourn.setText(str);
            lblTourn.setTextColor(getColor(R.color.TournP2));
            win();
            notWin = false;
        }
        if(buttons[2][0].getText().toString().contains("X") && buttons[1][1].getText().toString().contains("X") && buttons[0][2].getText().toString().contains("X")){
            str = names[0] + " " + getString(R.string.win);
            lblTourn.setText(str);
            lblTourn.setTextColor(getColor(R.color.TournP1));
            win();
            notWin = false;
        }
        if(buttons[2][0].getText().toString().contains("O") && buttons[1][1].getText().toString().contains("O") && buttons[0][2].getText().toString().contains("O")){
            str = names[1] + " " + getString(R.string.win);
            lblTourn.setText(str);
            lblTourn.setTextColor(getColor(R.color.TournP2));
            win();
            notWin = false;
        }
        //If nobody win all square´s all enable for pressed again. Can override one rival square.
        if(notWin) {
            for(int i = 0; i < buttons.length; i++) {
                for(int ind = 0; ind < buttons[i].length; ind++) {
                    buttons[i][ind].setEnabled(true);
                }
            }
        }
    }
    //If anyone win all buttons are disable.
    private void win() {
        for(int i = 0;i < buttons.length;i++){
            for(int ind = 0;ind < buttons.length;ind++){
                buttons[i][ind].setEnabled(false);
            }
        }
    }
    //Mehtod for create one AlertDialog.Builder when press button with content "names".
    private void createDialogNames() {
        dialog = new AlertDialog.Builder(this);
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        EditText name1 = new EditText(this);
        EditText name2 = new EditText(this);
        name1.setHint(R.string.dialogNames1Hint);
        name2.setHint(R.string.dialogNames2Hint);
        layout.addView(name1);
        layout.addView(name2);

        dialog.setCancelable(false)
                .setIcon(R.drawable.ic_launcher_foreground)
                .setTitle(R.string.dialogNamesTitle)
                .setView(layout)
                .setNegativeButton(R.string.dialogNamesNegative, null)
                .setPositiveButton(R.string.dialogNamesPositive, (dialogInterface, i) -> {
                    names[0] = name1.getText().toString();
                    names[1] = name2.getText().toString();
                })
                .create()
                .show();
    }
    //Method for create one AlertDialog.Builder when press button with content "start".
    private void createDialogStart() {
        dialog = new AlertDialog.Builder(this);

        dialog.setCancelable(false)
                .setIcon(R.drawable.ic_launcher_foreground)
                .setTitle(R.string.dialogStartTitle)
                .setMessage(R.string.dialogStartMessage)
                .setNegativeButton(R.string.dialogStartNegative, null)
                .setPositiveButton(R.string.dialogStartPositive, (dialogInterface, i) -> startNewGame())
                .create()
                .show();
    }
    //Start a new game. Reset all.
    private void startNewGame() {
        String str;
        for(Button[] button : buttons) {
            for (int column = 0; column < buttons.length; column++) {
                button[column].setBackgroundColor(getColor(R.color.btnsStart));
                button[column].setText("");
                button[column].setEnabled(true);
                turno = true;
            }
            if(names[0].isEmpty() && names[1].isEmpty()){
                names[0] = getString(R.string.emptyName1);
                names[1] = getString(R.string.emptyName2);
                str = getString(R.string.lblTourn) + " " + names[0];
                lblTourn.setText(str);
            }else{
                str = getString(R.string.lblTourn) + " " + names[0];
                lblTourn.setText(str);
                lblTourn.setTextColor(getColor(R.color.TournP1));
            }
        }
    }
}