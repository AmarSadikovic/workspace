package se.mah.af6851.ekonomiapplikation;


import android.app.Fragment;
import android.os.Bundle;
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
public class MataInUtgifterFragment extends Fragment {
    private MainActivity ui;
    private ArrayAdapter<CharSequence>adapter;
    private Spinner spinner;
    private Button btnKlar;
    private EditText titelEt;
    private EditText prisEt;
    private TextView tvDatabase;
    private MyDBHandler dbHandler;
    private String kategori;
    private String datum = "2";

    public MataInUtgifterFragment() {
        // Required empty public constructor
    }

    public void setActivity(MainActivity ui){
        this.ui = ui;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mata_in_utgifter, container, false);
        spinner =(Spinner)view.findViewById(R.id.mainMenuSpinner);
        adapter = ArrayAdapter.createFromResource(getActivity(), R.array.utgifterKategori,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new SelectedSpinner());
        btnKlar = (Button)view.findViewById(R.id.btnKlar);
        btnKlar.setOnClickListener(new KlarClicked());
        titelEt = (EditText)view.findViewById(R.id.titelEt);
        prisEt = (EditText)view.findViewById(R.id.prisEt);
        tvDatabase = (TextView)view.findViewById(R.id.tvDatabase);

        dbHandler = new MyDBHandler(getActivity(), null, null, 1);
        return view;
    }

    private class SelectedSpinner implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            kategori = (String)(parent.getItemAtPosition(position));
           Toast.makeText(getActivity().getBaseContext(),parent.getItemAtPosition(position)+" selected", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
        }
    }

    private class KlarClicked implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Utgift utgift = new Utgift(titelEt.getText().toString(),kategori,prisEt.getText().toString(),datum);
            dbHandler.addUtgifter(utgift);
            String dbString = dbHandler.databaseToString();
            tvDatabase.setText(dbString);
        }
    }
}
