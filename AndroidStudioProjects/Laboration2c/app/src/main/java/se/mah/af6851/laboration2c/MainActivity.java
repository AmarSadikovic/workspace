package se.mah.af6851.laboration2c;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;


import android.view.View;


public class MainActivity extends Activity {
    private Controller cont;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initController();

    }

    public void previousInstructions(View view){
        cont.previousClick();
    }
    public void initController(){
        FragmentManager fm = getFragmentManager();
        ViewerFragment vf = (ViewerFragment)fm.findFragmentById(R.id.ViewerFragment);
        InputFragment input = (InputFragment)fm.findFragmentById(R.id.InputFragment);
        cont = new Controller (vf, input, this);
    }
}
