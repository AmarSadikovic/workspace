package se.mah.af6851.ekonomiapplikation;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 */
public class MataInInkomsterFragment extends Fragment {
    private MainActivity ui;
    private ArrayAdapter<CharSequence> adapter;
    private Spinner spinner;
    private EditText inkomstEtTitel;
    private EditText inkomstEtBelopp;
    private MyDBHandler dbHandler;

    public MataInInkomsterFragment() {
        // Required empty public constructor
    }
    public void setActivity(MainActivity ui){
        this.ui = ui;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mata_in_inkomster, container, false);
        spinner = (Spinner)view.findViewById(R.id.inkomstSpinner);
        adapter = ArrayAdapter.createFromResource(getActivity(), R.array.inkomsterKategori,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new SelectedSpinner());
        inkomstEtTitel = (EditText)view.findViewById(R.id.inkomstEtTitel);
        inkomstEtBelopp = (EditText)view.findViewById(R.id.inkomstEtBelopp);

        dbHandler = new MyDBHandler(getActivity(), null, null, 1);
        return view;
    }

    private class SelectedSpinner implements android.widget.AdapterView.OnItemSelectedListener {
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(getActivity().getBaseContext(),parent.getItemAtPosition(position)+" selected", Toast.LENGTH_LONG).show();
        }

        public void onNothingSelected(AdapterView<?> parent) {

        }
    }


}
