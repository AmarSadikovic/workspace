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
public class KiwiFragment extends Fragment {
    private MainActivity ui;
    private Button btnKiwi;


    public KiwiFragment() {
        // Required empty public constructor
    }
    public void setActivity(MainActivity ui){
        this.ui = ui;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_kiwi, container, false);
        return view;
    }

}
