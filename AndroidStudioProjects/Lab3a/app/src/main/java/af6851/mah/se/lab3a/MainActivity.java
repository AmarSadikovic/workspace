package af6851.mah.se.lab3a;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;

public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_main);

        FragmentManager fm = getFragmentManager();
        Frag fragment = (Frag) fm.findFragmentById(R.id.fragment);
        new Controller (fragment);
    }
}
