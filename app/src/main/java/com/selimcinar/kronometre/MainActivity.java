package com.selimcinar.kronometre;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //Global tanımlar
    TextView textView;
    int number;
    Runnable runnable;  //Bir işlemi birden fazla yapmaya yarayan işlemler

    Handler handler;  //Runnable kontrol etmeye yarar

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        number=0;
        button=findViewById(R.id.button);

    }
    public  void start(View view){
        /*
        //Normal kodlar
        textView.setText("Time : "+number);
        number++;
        textView.setText("Time : "+number);
        */

        //Objeler nesneler oluşturuldu
        handler = new Handler();
        runnable=new Runnable() {
            @Override
            public void run() {
                //Belli bir periyotta tüm işlemleri yapar.
                textView.setText("Time : "+number);
                number++;
                textView.setText("Time : "+number);
                handler.postDelayed(runnable,1000); //her bir saniyede artır
            }
        };
        handler.post(runnable);
        button.setEnabled(false); //Button tıklanamaz hale gelir.


    }
    public  void stop(View view){
        //Kronometre durdurma işlemi
        button.setEnabled(true); //Button tıklanabilir oldu
        handler.removeCallbacks(runnable);
        textView.setText("Time" + number);
    }
}
