package com.example.lenovo.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    Boolean player1=true;
    Boolean player2=false;
    HashMap<View ,Boolean> check=new HashMap<>();
    int player1Matrix[][]={{0,0,0},{0,0,0},{0,0,0}};
    int player2Matrix[][]={{0,0,0},{0,0,0},{0,0,0}};
    int rotationTemp=1;
    Button playAgain;
    ImageView playerTurn;

    public void playAgain(View view)
    {
        Intent i = getBaseContext().getPackageManager()
                .getLaunchIntentForPackage(getBaseContext().getPackageName());
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
    }

    public void disableOnClick()
    {
        ImageView first=findViewById(R.id.imageView1);
        ImageView second=findViewById(R.id.imageView2);
        ImageView third=findViewById(R.id.imageView3);
        ImageView fourth=findViewById(R.id.imageView4);
        ImageView fifth=findViewById(R.id.imageView5);
        ImageView sixth=findViewById(R.id.imageView6);
        ImageView seventh=findViewById(R.id.imageView7);
        ImageView eighth=findViewById(R.id.imageView8);
        ImageView ninth=findViewById(R.id.imageView9);
        first.setOnClickListener(null);
        second.setOnClickListener(null);
        third.setOnClickListener(null);
        fourth.setOnClickListener(null);
        fifth.setOnClickListener(null);
        sixth.setOnClickListener(null);
        seventh.setOnClickListener(null);
        eighth.setOnClickListener(null);
        ninth.setOnClickListener(null);
    }

    public Boolean gameFinish()
    {
        if(!player1)
        {
            //check player1Matrix

            //check rows
            if((player1Matrix[0][0]==1)&&(player1Matrix[0][1]==1)&&(player1Matrix[0][2]==1))
            {
                return true;
            }
            if((player1Matrix[1][0]==1)&&(player1Matrix[1][1]==1)&&(player1Matrix[1][2]==1))
            {
                return true;
            }
            if((player1Matrix[2][0]==1)&&(player1Matrix[2][1]==1)&&(player1Matrix[2][2]==1))
            {
                return true;
            }

            //check columns
            if((player1Matrix[0][0]==1)&&(player1Matrix[1][0]==1)&&(player1Matrix[2][0]==1))
            {
                return true;
            }
            if((player1Matrix[0][1]==1)&&(player1Matrix[1][1]==1)&&(player1Matrix[2][1]==1))
            {
                return true;
            }
            if((player1Matrix[0][2]==1)&&(player1Matrix[1][2]==1)&&(player1Matrix[2][2]==1))
            {
                return true;
            }

            //check diagonals
            if((player1Matrix[0][0]==1)&&(player1Matrix[1][1]==1)&&(player1Matrix[2][2]==1))
            {
                return true;
            }
            if((player1Matrix[0][2]==1)&&(player1Matrix[1][1]==1)&&(player1Matrix[2][0]==1))
            {
                return true;
            }
        }
        else if(!player2)
        {
            //check player2Matrix

            //check rows
            if((player2Matrix[0][0]==1)&&(player2Matrix[0][1]==1)&&(player2Matrix[0][2]==1))
            {
                return true;
            }
            if((player2Matrix[1][0]==1)&&(player2Matrix[1][1]==1)&&(player2Matrix[1][2]==1))
            {
                return true;
            }
            if((player2Matrix[2][0]==1)&&(player2Matrix[2][1]==1)&&(player2Matrix[2][2]==1))
            {
                return true;
            }

            //check columns
            if((player2Matrix[0][0]==1)&&(player2Matrix[1][0]==1)&&(player2Matrix[2][0]==1))
            {
                return true;
            }
            if((player2Matrix[0][1]==1)&&(player2Matrix[1][1]==1)&&(player2Matrix[2][1]==1))
            {
                return true;
            }
            if((player2Matrix[0][2]==1)&&(player2Matrix[1][2]==1)&&(player2Matrix[2][2]==1))
            {
                return true;
            }

            //check diagonals
            if((player2Matrix[0][0]==1)&&(player2Matrix[1][1]==1)&&(player2Matrix[2][2]==1))
            {
                return true;
            }
            if((player2Matrix[0][2]==1)&&(player2Matrix[1][1]==1)&&(player2Matrix[2][0]==1))
            {
                return true;
            }
        }
        return false;
    }

    public void markPoint(View view) {
        playerTurn = findViewById(R.id.playerTurn);
        TextView result = findViewById(R.id.result);
        CharSequence description=view.getContentDescription();
        int index=Integer.parseInt(description.toString());
        int row = -1;
        int column = -1;
        switch (index)
        {
            case 1: row=0;
                    column=0;
                    break;
            case 2: row=0;
                    column=1;
                    break;
            case 3: row=0;
                    column=2;
                    break;
            case 4: row=1;
                    column=0;
                    break;
            case 5: row=1;
                    column=1;
                    break;
            case 6: row=1;
                    column=2;
                    break;
            case 7: row=2;
                    column=0;
                    break;
            case 8: row=2;
                    column=1;
                    break;
            case 9: row=2;
                    column=2;
                    break;
        }
        if(!check.containsKey(view))
        {
            if(player1)
            {
                ImageView i=(ImageView) view;
                i.setImageResource(R.drawable.bart);
                view.animate().alpha(1.0f).setDuration(600);
                player1 = false;
                player2 = true;
                playerTurn.animate()
                        .rotation(360f*rotationTemp)
                        .setDuration(500);
                playerTurn.setImageResource(R.drawable.player2);

                player1Matrix[row][column]=1;
            }
            else if(player2)
            {
                ImageView i=(ImageView) view;
                i.setImageResource(R.drawable.micky);
                view.animate().alpha(1.0f).setDuration(600);
                player1 = true;
                player2 = false;
                playerTurn.animate()
                        .rotation(360f*rotationTemp)
                        .setDuration(500);
                playerTurn.setImageResource(R.drawable.player1);
                player2Matrix[row][column]=1;
            }
            rotationTemp++;
            check.put(view,true);

            if(gameFinish())
            {
                if(!player1)
                {
                    result.setText("Player 1 wins!");
                }
                else if(!player2)
                {
                    result.setText("Player 2 wins!");
                }
                playAgain.setVisibility(View.VISIBLE);
                disableOnClick();
                result.animate().translationYBy(-1400f).setDuration(1000);
                playerTurn.setVisibility(View.INVISIBLE);
                return;
            }
            else if(check.size()==9)
            {
                result.setText("It's a draw!");
                result.animate().translationYBy(-1400f).setDuration(1000);
                playerTurn.setVisibility(View.INVISIBLE);
                playAgain.setVisibility(View.VISIBLE);
            }
            else
            {
                result.setText("Keep playing");
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playAgain = findViewById(R.id.playAgain);
        playAgain.setVisibility(View.INVISIBLE);
    }
}
