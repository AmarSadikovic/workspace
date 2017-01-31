package se.mah.af6851.laboration2btest;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btnPrevious;
    private Button btnNext;
    private TextView tvWhatToDo;
    private TextView tvContent;
    private Controller cont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeComponents();
        registerListeners();
        cont = new Controller(this);
    }


    private void initializeComponents() {
        btnPrevious = (Button)findViewById(R.id.btnPrevious);
        btnNext = (Button)findViewById(R.id.btnNext);
        tvWhatToDo = (TextView)findViewById(R.id.tvWhatToDo);
        tvContent = (TextView)findViewById(R.id.tvContent);
    }

    public void registerListeners() {
        btnNext.setOnClickListener(new NextListener());
    }

    public void previousInstructions(View view){
        cont.previousClick();
    }

    public void setWhatToDo(String whatToDo) {
        tvWhatToDo.setText(whatToDo);
    }

    public void setContent(String content) {
        tvContent.setText(content);
    }

    private class NextListener implements View.OnClickListener{
        public void onClick(View v){
            cont.nextClick();

        }
    }
}
