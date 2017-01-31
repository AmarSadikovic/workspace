package se.mah.af6851.progressbar;


import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {
    private ProgressBar progressBar;
    private Button myButton;
    private int progressionStatus = 0;
    private TextView textView;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = (ProgressBar)findViewById(R.id.myProgressBar);
        textView = (TextView)findViewById(R.id.myTextView);
        myButton = (Button)findViewById(R.id.myButton);

        myButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                progressionStatus = 0;
                new Thread(new Runnable() {
                    public void run(){
                        while(progressionStatus <100){
                            progressionStatus +=1;
                            handler.post(new Runnable() {
                                public void run(){
                                    progressBar.setProgress(progressionStatus);
                                    textView.setText("Progression: "+progressionStatus+"/"+progressBar.getMax());
                                }
                            });
                            try{
                                Thread.sleep(100);
                            }catch(InterruptedException e){
                                e.printStackTrace();
                            }
                        }
                    }
                }).start();

            }
        });
    }
}
