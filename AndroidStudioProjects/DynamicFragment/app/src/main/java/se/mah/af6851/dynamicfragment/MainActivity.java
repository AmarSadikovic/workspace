package se.mah.af6851.dynamicfragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class MainActivity extends Activity {
    private FragmentManager fm;
    private AppleFragment apple;
    private BaconFragment bacon;
    private KiwiFragment kiwi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fm = getFragmentManager();
        apple = new AppleFragment();
        bacon = new BaconFragment();
        kiwi = new KiwiFragment();
        setUi(apple);
    }

    public void bacon(){
        setUi(bacon);
    }
    public void apple(){
        setUi(apple);
    }
    public void kiwi(){
        setUi(kiwi);
    }

    public void setUi(Fragment frag){
        if(frag instanceof AppleFragment){
            apple.setActivity(this);
        }else if(frag instanceof KiwiFragment) {
            kiwi.setActivity(this);
        }else if(frag instanceof BaconFragment){
            bacon.setActivity(this);
        }
        FragmentTransaction fs = fm.beginTransaction();
        fs.addToBackStack(null);
        fs.replace(R.id.fl, frag);
        fs.commit();

    }

}
