package se.mah.af6851.ekonomiappv2;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class NamnFragment extends Fragment {
    private MainActivity ui;
    private Button btnVidare;
    private EditText etFornamn;
    private EditText etEfternamn;
    private String fornamn, efternamn, helaNamnet;

    public NamnFragment() {
        // Required empty public constructor
    }

    public void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_namn, container, false);
        ui =(MainActivity)getActivity();
        btnVidare = (Button)view.findViewById(R.id.btnVidare);
        etFornamn = (EditText)view.findViewById(R.id.etFornamn);
        etEfternamn = (EditText)view.findViewById(R.id.etEfternamn);

        btnVidare.setOnClickListener(new ButtonListener());
        helaNamnet = fornamn + efternamn;
        return view;
    }


    private class ButtonListener implements View.OnClickListener {

        public void onClick(View v) {
          if(v.getId()==R.id.btnVidare) {

              fornamn = etFornamn.getText().toString();
              efternamn = etEfternamn.getText().toString();

              ui.userinfo(fornamn, efternamn);
              ui.mainMenu();
          }
        }
    }
}
