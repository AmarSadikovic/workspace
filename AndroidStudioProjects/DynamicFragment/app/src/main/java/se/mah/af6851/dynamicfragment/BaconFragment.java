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
public class BaconFragment extends Fragment {
    private MainActivity ui;
    private Button btnBacon;

    public BaconFragment() {
        // Required empty public constructor
    }

    public void setActivity(MainActivity ui){
        this.ui = ui;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bacon, container, false);
        btnBacon = (Button)view.findViewById(R.id.btnBacon);
        btnBacon.setOnClickListener(new ClickButton());
        return view;
    }

    private class ClickButton implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            ui.apple();
        }
    }
}
