package af6851.mah.se.howto;

import android.app.FragmentManager;
import android.os.Bundle;
import android.app.Activity;


public class MainActivity extends Activity {
    private Controller cont;
    private tvFrag tvFrag;
    private lvFrag lvFrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getFragmentManager();
        tvFrag = (tvFrag) fm.findFragmentById(R.id.tvFrag);
        lvFrag = (lvFrag) fm.findFragmentById(R.id.lvFrag);
        cont = new Controller(tvFrag);
        lvFrag.setController(cont);
    }

}
