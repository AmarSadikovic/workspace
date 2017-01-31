package se.mah.af6851.laboration2c;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class InputFragment extends Fragment {
    private Controller cont;
    private Button btnPrevious;
    private Button btnNext;


    public InputFragment() {
        // Required empty public constructor
    }
    public void setController(Controller cont){
        this.cont = cont;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = (View)inflater.inflate(R.layout.fragment_input, container, false);
            btnPrevious = (Button)view.findViewById(R.id.btnPrevious);
        btnNext = (Button)view.findViewById(R.id.btnNext);
        registerListeners();
        return view;

    }
    private class NextListener implements View.OnClickListener{
        public void onClick(View v){
            if(v.getId()==btnNext.getId()) {
                cont.nextClick();
            }else{
                cont.previousClick();
            }

        }
    }
    public void registerListeners() {
        btnPrevious.setOnClickListener(new NextListener());
        btnNext.setOnClickListener(new NextListener());
    }

}
