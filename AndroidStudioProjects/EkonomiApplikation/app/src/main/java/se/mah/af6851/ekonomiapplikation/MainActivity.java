package se.mah.af6851.ekonomiapplikation;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fm;
    private MainMenuFragment mainMenu;
    private MataInUtgifterFragment mataInUtgifter;
    private MataInInkomsterFragment mataInInkomster;
    private VisaUtgiftFragment visaUtgift;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fm=getFragmentManager();
        mainMenu = new MainMenuFragment();
        mataInUtgifter = new MataInUtgifterFragment();
        mataInInkomster = new MataInInkomsterFragment();
        visaUtgift = new VisaUtgiftFragment();
        setUi(mainMenu);
    }

    public void MainMenu(){
        setUi(mainMenu);
    }
    public void MataInUtgifter(){
        setUi(mataInUtgifter);
    }
    public void MataInInkomster(){
        setUi(mataInInkomster);
    }
    public void visaUtgift(){
        setUi(visaUtgift);
    }

    public void setUi(Fragment frag){
        if(frag instanceof MainMenuFragment){
            mainMenu.setActivity(this);
        }else if(frag instanceof MataInUtgifterFragment){
            mataInUtgifter.setActivity(this);
        }else if(frag instanceof MataInInkomsterFragment){
            mataInInkomster.setActivity(this);
        }else if(frag instanceof VisaUtgiftFragment){
            visaUtgift.setActivity(this);
        }
        FragmentTransaction fs = fm.beginTransaction();
        fs.addToBackStack(null);
        fs.replace(R.id.fl, frag);
        fs.commit();
    }

}
