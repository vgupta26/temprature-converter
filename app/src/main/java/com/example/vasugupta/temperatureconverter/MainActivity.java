package com.example.vasugupta.temperatureconverter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public SeekBar S1;
    public TextView C1;
    public TextView F1;
    public TextView T1;
    //int progress = 0;
    ImageView I1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        I1 = (ImageView) findViewById(R.id.image);
         F1= (TextView) findViewById(R.id.Feh);
        C1= (TextView) findViewById(R.id.Cel);
        T1= (TextView)findViewById(R.id.textView5);
        S1 = (SeekBar) findViewById(R.id.cont);
        S1.setMax(240);
      // S1.setProgress(progress);
     //   Toast.makeText(this, "App started",Toast.LENGTH_LONG).show();
        Seekbarprogress();
      }
  public void Seekbarprogress()
    {
    S1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar S1, int progress, boolean fromUser)
            {
                F1.setText(String.valueOf(progress));
               int c= (((progress-32)*5)/9);
                C1.setText(String.valueOf(c));
                Log.d("Value",String.valueOf(progress));

                if( S1.getProgress()>=40&&S1.getProgress()<=90)
            {
                Toast.makeText(getApplicationContext(), "Pleasant",Toast.LENGTH_SHORT).show();
                I1.setImageResource(R.drawable.medium);
                T1.setText("Just Right!");
                T1.setBackgroundColor(getResources().getColor(R.color.pleasant));
            }
                if( S1.getProgress()>=90)
                {
                    //Toast.makeText(getApplicationContext(), "Extreme Hot",Toast.LENGTH_SHORT).show();
                    I1.setImageResource(R.drawable.hot);
                    T1.setText("Too Hot!");
                    T1.setBackgroundColor(getResources().getColor(R.color.hot));
                }
                else if(S1.getProgress()<40)
                {
                    I1.setImageResource(R.drawable.cold);
                    T1.setText("Too Cold!");
                    T1.setBackgroundColor(getResources().getColor(R.color.cold));
                    //Toast.makeText(getApplicationContext(), "Extreme Cold",Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onStartTrackingTouch(SeekBar S1) {}
            @Override
            public void onStopTrackingTouch(SeekBar S1) {
                //Toast.makeText(getApplicationContext(), "" +"Slider Dropped",Toast.LENGTH_LONG).show();
                }

        });
    }


}


