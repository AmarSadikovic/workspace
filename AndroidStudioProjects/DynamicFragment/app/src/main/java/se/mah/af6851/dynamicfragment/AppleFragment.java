package se.mah.af6851.dynamicfragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class AppleFragment extends Fragment {
    private MainActivity ui;
    private Button btnApple;
    private Button btnAppleToKiwi;

    public AppleFragment() {
        // Required empty public constructor
    }


    public void setActivity(MainActivity ui){
        this.ui = ui;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      View view = inflater.inflate(R.layout.fragment_apple, container, false);
        btnApple = (Button) view.findViewById(R.id.btnApple);
        btnApple.setOnClickListener(new ClickButton());
        btnAppleToKiwi = (Button) view.findViewById(R.id.btnAppleToKiwi);
        btnAppleToKiwi.setOnClickListener(new KiwiClick());
        return view;
    }

    private class ClickButton implements View.OnClickListener {
        public void onClick(View v) {
            ui.bacon();
        }
    }

    private class KiwiClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            ui.kiwi();
        }
    }
}
