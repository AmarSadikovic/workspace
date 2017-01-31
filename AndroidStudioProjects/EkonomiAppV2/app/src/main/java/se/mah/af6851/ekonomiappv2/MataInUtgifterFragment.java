package se.mah.af6851.ekonomiappv2;


import android.annotation.TargetApi;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.icu.text.DateFormat;
import android.os.Build;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 */
public class MataInUtgifterFragment extends Fragment {
    private MainActivity ui;
    private ArrayAdapter<CharSequence> adapter;
    private Spinner spinner;
    private Button btnKlar, btnDatePicker;
    private EditText titelEt;
    private EditText prisEt;
    private MyDBHandler dbHandler;
    private int datum ;
    private String kategori;

    //date picker
    int mYear, mMonth, mDay;
    static final int DIALOG_ID = 0;


    public MataInUtgifterFragment() {
        // Required empty public constructor
    }

    public void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setRetainInstance(true);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mata_in_utgifter, container, false);
        ui =(MainActivity)getActivity();
        spinner =(Spinner)view.findViewById(R.id.mainMenuSpinner);
        adapter = ArrayAdapter.createFromResource(getActivity(), R.array.utgifterKategori,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new SelectedSpinner());
        btnKlar = (Button)view.findViewById(R.id.btnKlar);
        btnKlar.setOnClickListener(new KlarClicked());
        btnDatePicker = (Button)view.findViewById(R.id.btnDatePicker);
        btnDatePicker.setOnClickListener(new KlarClicked());
        titelEt = (EditText)view.findViewById(R.id.titelEt);
        prisEt = (EditText)view.findViewById(R.id.prisEt);

        dbHandler = new MyDBHandler(getActivity(), null, null, 1);

        return view;
    }

    private class SelectedSpinner implements android.widget.AdapterView.OnItemSelectedListener {
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            kategori =(String) parent.getItemAtPosition(position);
            Toast.makeText(getActivity().getBaseContext(),parent.getItemAtPosition(position)+" selected", Toast.LENGTH_LONG).show();
        }
        public void onNothingSelected(AdapterView<?> parent) {
        }
    }

    private class KlarClicked implements View.OnClickListener {
        public void onClick(View v) {
            switch(v.getId()) {
                case R.id.btnKlar:
                    Utgift utgift = new Utgift(titelEt.getText().toString(), kategori, Integer.parseInt(prisEt.getText().toString()), datum);
                    dbHandler.addUtgifter(utgift);
                    titelEt.setText("");
                    prisEt.setText("");
                    break;
                case R.id.btnDatePicker:
                    int whatId = 01;
                    ui.whatDate(whatId);
                    ui.showDialog(DIALOG_ID);
                    break;
            }
        }
    }
    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    public void setDatum(int datum) throws ParseException {
        this.datum = datum;
    }
}
