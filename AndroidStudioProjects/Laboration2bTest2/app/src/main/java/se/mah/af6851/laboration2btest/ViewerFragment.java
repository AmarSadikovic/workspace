package se.mah.af6851.laboration2btest;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ViewerFragment extends Fragment {
    private TextView clickView;

    public ViewerFragment() {
        // Required empty public constructor
    }

    public void UpdateView(){

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_viewer, container, false);
        // Inflate the layout for this fragment
        return view;
    }

}
