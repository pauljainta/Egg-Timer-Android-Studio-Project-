package com.example.appeggtimer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SeekBar seekBar;
    Button button;
    TextView textView;
    CountDownTimer countDownTimer;


    public void GO(View view)
    {



        if(button.getText().toString().equalsIgnoreCase("GO")) {
            button.setText("STOP");

             countDownTimer = new CountDownTimer(seekBar.getProgress() * 1000, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    int time_in_seconds = (int) (millisUntilFinished / 1000);

                    String time = (time_in_seconds / 60) + ":" + (time_in_seconds % 60);
                   // if (time_in_seconds % 60 < 10) time = time + "0";
                    if (time_in_seconds / 60 < 10) time = "0" + time;

                    textView.setText(time);
                }

                @Override
                public void onFinish() {

                   

                }
            };

          countDownTimer.start();

        }
        else
        {
           if(countDownTimer!=null)  countDownTimer.cancel();

            button.setText("GO");
            seekBar.setProgress(10);
            seekBar.setMax(2000);
            String time=(seekBar.getProgress()/60)+":"+(seekBar.getProgress()%60);
            //     if(progress%60 <10) time=time+"0";
            if(seekBar.getProgress()/60 <10) time="0"+time;

            textView.setText(time);


        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar=findViewById(R.id.seekBar);
        button=findViewById(R.id.button);
        textView=findViewById(R.id.textView);

        seekBar.setProgress(10);
        seekBar.setMax(2000);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                String time=(progress/60)+":"+(progress%60);
           //     if(progress%60 <10) time=time+"0";
                if(progress/60 <10) time="0"+time;

                textView.setText(time);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {



            }
        });

    }
}