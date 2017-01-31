package se.mah.af6851.laboration3c2;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Activity;


public class MainActivity extends Activity {
    private Controller cont;
//    private tvFrag tvFrag;
//    private lvFrag lvFrag;
//    private FragmentManager fm;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getFragmentManager();
        tvFrag = (tvFrag) fm.findFragmentById(R.id.tvFrag);
        lvFrag = (lvFrag) fm.findFragmentById(R.id.lvFrag);

        cont = new Controller(tvFrag);
        lvFrag.setController(cont);
    }

   public void setFragment(Fragment lvFrag, boolean backstack){
       FragmentManager fm = getFragmentManager();
       FragmentTransaction ft = fm.beginTransaction();
       ft.replace(R.id.fl, lvFrag);

       if(backstack){
           ft.addToBackStack(null);
       }
       ft.commit();

   }

}
