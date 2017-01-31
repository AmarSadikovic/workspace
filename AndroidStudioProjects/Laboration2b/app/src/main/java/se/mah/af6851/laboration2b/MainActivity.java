package se.mah.af6851.laboration2b;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getFragmentManager();
        ViewerFragment vf;
        vf = (ViewerFragment)fm.findFragmentById(R.id.fragment_viewer);
        InputFragment ifs;
        ifs = (InputFragment)fm.findFragmentById(R.id.fragment_input);
        Controller cont = new Controller(vf);
        ifs.setController(cont);
    }
}
