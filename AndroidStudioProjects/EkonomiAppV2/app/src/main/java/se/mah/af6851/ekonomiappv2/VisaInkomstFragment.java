package se.mah.af6851.ekonomiappv2;


import android.database.Cursor;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.text.ParseException;

import static se.mah.af6851.ekonomiappv2.R.id.etFranInkomst;
import static se.mah.af6851.ekonomiappv2.R.id.etTill;


/**
 * A simple {@link Fragment} subclass.
 */
public class VisaInkomstFragment extends Fragment {
    private MainActivity ui;
    private MyDBHandler dbHandler;
    private ListView lvInkomst;
    private DetailedVisaInkomstFragment dVisaInkomst;
    private EditText etFranInkomst;
    private EditText etTillInkomst;
    private Button btnSearchInkomst;

    static final int DIALOG_ID = 0;
    int datumFranInkomst, datumTillInkomst;
    int whatDateId;

    public VisaInkomstFragment() {

    }

    public void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setRetainInstance(true);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_visa_inkomst, container, false);
        ui = (MainActivity) getActivity();
        dVisaInkomst = new DetailedVisaInkomstFragment();
        dbHandler = new MyDBHandler(getActivity(), null, null, 1);
        etFranInkomst = (EditText) view.findViewById(R.id.etFranInkomst);
        etTillInkomst = (EditText) view.findViewById(R.id.etTillInkomst);
        etFranInkomst.setOnClickListener(new ButtonClicked());
        etTillInkomst.setOnClickListener(new ButtonClicked());
        btnSearchInkomst = (Button) view.findViewById(R.id.btnSearchInkomst);
        btnSearchInkomst.setOnClickListener(new ButtonClicked());
        lvInkomst = (ListView) view.findViewById(R.id.lvInkomst);
        lvInkomst.setAdapter(new SimpleCursorAdapter(getActivity(),
                R.layout.inkomster_item,
                dbHandler.getAllItemsInCursorI(),
                new String[]{"_inkomster_kategori","_inkomster_titel"},
                new int[]{R.id.item_kategori, R.id.item_titel},
                0));
        lvInkomst.setOnItemClickListener(new ListViewClicked());
        return view;
    }

    private class ListViewClicked implements android.widget.AdapterView.OnItemClickListener{
        public void onItemClick(AdapterView<?> parent, View view, int position, long id){
            Cursor cursor = (Cursor) lvInkomst.getItemAtPosition(position);
            if(cursor != null){
                String stringId = cursor.getString(cursor.getColumnIndexOrThrow("_id"));
                ui.dVisaInkomst(dVisaInkomst);
                dVisaInkomst.databaseId(stringId);
            }
        }
    }

    private class ButtonClicked implements View.OnClickListener {
        @Override
        public void onClick(View v){
            switch(v.getId()){
                case R.id.btnSearchInkomst:
                    lvInkomst.setAdapter(new SimpleCursorAdapter(getActivity(),
                            R.layout.inkomster_item,
                            dbHandler.getAllItemsByDateInkomst(datumFranInkomst, datumTillInkomst),
                            new String[]{"_inkomster_kategori","_inkomster_titel"},
                            new int[]{R.id.item_kategori, R.id.item_titel},
                            0));
                    break;
                case R.id.etFranInkomst:
                    whatDateId = 21;
                    ui.whatDate(whatDateId);
                    ui.showDialog(DIALOG_ID);
                    break;
                case R.id.etTillInkomst:
                    whatDateId = 22;
                    ui.whatDate(whatDateId);
                    ui.showDialog(DIALOG_ID);
                    break;
            }
        }
    }

    public void setDatumFran(int datum) throws ParseException{
        String stringDatum = ""+datum;
        datumFranInkomst = datum;
        etFranInkomst.setText(stringDatum);
    }

    public void setDatumTill(int datum) throws ParseException{
        String stringDatum = "" +datum;
        datumTillInkomst = datum;
        etTillInkomst.setText(stringDatum);
    }
}
