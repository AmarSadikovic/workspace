package se.mah.af6851.ekonomiappv2;


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
import android.widget.Toast;

import java.text.ParseException;


/**
 * A simple {@link Fragment} subclass.
 */
public class MataInInkomsterFragment extends Fragment {
    private MainActivity ui;
    private ArrayAdapter<CharSequence> adapter;
    private Spinner spinner;
    private EditText inkomstEtTitel;
    private EditText inkomstEtBelopp;
    private Button btnKlar;
    private MyDBHandler dbHandler;
    private int datum;
    private String kategori;
    private Button btnDatePicker;

    static final int DIALOG_ID = 0;

    public MataInInkomsterFragment() {
        // Required empty public constructor
    }

    public void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mata_in_inkomster, container, false);
        ui =(MainActivity)getActivity();
        adapter = ArrayAdapter.createFromResource(getActivity(), R.array.inkomsterKategori,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner = (Spinner)view.findViewById(R.id.inkomstSpinner);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new SelectedSpinner());
        inkomstEtTitel = (EditText)view.findViewById(R.id.inkomstEtTitel);
        inkomstEtBelopp = (EditText)view.findViewById(R.id.inkomstEtBelopp);
        btnKlar = (Button)view.findViewById(R.id.btnKlar);
        btnKlar.setOnClickListener(new buttonClicked());
        btnDatePicker = (Button)view.findViewById(R.id.btnIDatePicker);
        btnDatePicker.setOnClickListener(new buttonClicked());

        dbHandler = new MyDBHandler(getActivity(), null, null, 1);
        return view;
    }

    private class SelectedSpinner implements android.widget.AdapterView.OnItemSelectedListener {
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            kategori = (String)parent.getItemAtPosition(position);
            Toast.makeText(getActivity().getBaseContext(),parent.getItemAtPosition(position)+" selected", Toast.LENGTH_LONG).show();
        }
        public void onNothingSelected(AdapterView<?> parent) {
        }
    }

    private class buttonClicked implements View.OnClickListener {
        public void onClick(View v) {
            switch(v.getId()) {
                case R.id.btnKlar:
                    Inkomst inkomst = new Inkomst(inkomstEtTitel.getText().toString(), kategori, Integer.parseInt(inkomstEtBelopp.getText().toString()), datum);
                    dbHandler.addInkomster(inkomst);
                    inkomstEtTitel.setText("");
                    inkomstEtBelopp.setText("");
                    break;
                case R.id.btnIDatePicker:
                    int whatId = 02;
                    ui.whatDate(whatId);
                    ui.showDialog(DIALOG_ID);
                    break;
            }

        }
    }
    public void setDatum(int datum) throws ParseException {
        this.datum = datum;
    }
}
