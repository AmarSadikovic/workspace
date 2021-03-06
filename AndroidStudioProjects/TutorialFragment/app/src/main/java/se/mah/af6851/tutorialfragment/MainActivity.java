package se.mah.af6851.tutorialfragment;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
    boolean status = false;
    Button bn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bn = (Button)findViewById(R.id.bn);
        bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                if(!status) {
                    FragmentOne f1 = new FragmentOne();
                    fragmentTransaction.add(R.id.fragment_container, f1);
                    fragmentTransaction.commit();
                    bn.setText("Load second fragment");
                    status = true;


                }else {
                    FragmentTwo f2 = new FragmentTwo();
                    fragmentTransaction.add(R.id.fragment_container, f2);
                    fragmentTransaction.commit();
                    bn.setText("Load First fragment");
                    status = false;
                }
            }
        });

    }
}
