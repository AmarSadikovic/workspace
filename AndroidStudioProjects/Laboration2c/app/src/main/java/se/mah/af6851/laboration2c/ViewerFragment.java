package se.mah.af6851.laboration2c;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class ViewerFragment extends Fragment {
    private TextView tvWhatToDo;
    private TextView tvContent;

    public ViewerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){

       View view = (View)inflater.inflate(R.layout.fragment_viewer, container, false);
        tvWhatToDo = (TextView) view.findViewById(R.id.tvWhatToDo);
        tvContent = (TextView) view.findViewById(R.id.tvContent);
        return view;

    }
    public void setWhatToDo(String whatToDo) {
        tvWhatToDo.setText(whatToDo);
    }

    public void setContent(String content) {
        tvContent.setText(content);
    }


}
