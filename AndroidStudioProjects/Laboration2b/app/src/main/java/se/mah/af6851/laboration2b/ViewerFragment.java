package se.mah.af6851.laboration2b;


import android.app.Fragment;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ViewerFragment extends Fragment {
    private TextView textView;

    public ViewerFragment() {

    }

    public void updateViewer(int click){
        String text = String.valueOf(click);
        textView.setText(text);
    }
    private void initializeComponents(View view) {
        textView =(TextView)view.findViewById(R.id.clickView);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_viewer, container, false);
        textView = (TextView)view.findViewById(R.id.clickView);
        initializeComponents(view);
        return  view;
    }

}
