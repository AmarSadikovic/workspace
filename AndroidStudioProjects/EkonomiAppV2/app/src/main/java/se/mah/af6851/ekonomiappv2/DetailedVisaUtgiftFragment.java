package se.mah.af6851.ekonomiappv2;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailedVisaUtgiftFragment extends Fragment {
    private MainActivity ui;
    private int databaseId;
    private TextView tvTitel;
    private String string;
    private MyDBHandler dbHandler;

    public DetailedVisaUtgiftFragment() {
        // Required empty public constructor
    }

    public void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setRetainInstance(true);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detailed_visa_utgift, container, false);
        ui =(MainActivity)getActivity();
        dbHandler = new MyDBHandler(getActivity(), null, null, 1);
        tvTitel = (TextView)view.findViewById(R.id.tvTitelD);

        myDbMethods();
        return view;
    }

    public void databaseId(String stringId){
        databaseId = Integer.parseInt(stringId);
        string = stringId;

    }

    public void myDbMethods(){
        tvTitel.setText(dbHandler.databaseToStringTest(databaseId));
    }




}
