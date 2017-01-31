package se.mah.af6851.laboration2b;


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
    private Button btn;

    public InputFragment(){

    }

    public void setController(Controller cont){
        this.cont = cont;
    }

    public void click(){
        cont.btnClick();
    }

    private void initializeComponents(View view) {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_input, container, false);
        btn = (Button)view.findViewById(R.id.button);
        btn.setOnClickListener(new ClickButtonListener());
        return view;
    }
    private class ClickButtonListener implements View.OnClickListener{
        public void onClick(View v){
            cont.btnClick();
        }
    }
}
