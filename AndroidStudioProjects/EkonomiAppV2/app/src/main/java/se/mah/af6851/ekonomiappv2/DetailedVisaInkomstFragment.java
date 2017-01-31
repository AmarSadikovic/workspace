package se.mah.af6851.ekonomiappv2;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailedVisaInkomstFragment extends Fragment {
    private MainActivity ui;
    private int databaseId;
    private TextView tvTitelInkomst;
    private String string;
    private MyDBHandler dbHandler;

    public DetailedVisaInkomstFragment() {
        // Required empty public constructor
    }
    public void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setRetainInstance(true);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detailed_visa_inkomst, container, false);
        ui = (MainActivity) getActivity();
        dbHandler = new MyDBHandler(getActivity(), null, null, 1);
        tvTitelInkomst = (TextView) view.findViewById(R.id.tvTitelIDInkomst);

        myDbMethods();
        return view;
    }

    public void databaseId(String stringId) {
        databaseId = Integer.parseInt(stringId);
        string = stringId;
    }

    public void myDbMethods() {
        tvTitelInkomst.setText(dbHandler.databaseToStringInkomster(databaseId));
    }

}
