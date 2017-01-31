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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.text.ParseException;


/**
 * A simple {@link Fragment} subclass.
 */
public class VisaUtgiftFragment extends Fragment {
    private MainActivity ui;
    private MyDBHandler dbHandler;
    private ListView lvUtgift;
    private DetailedVisaUtgiftFragment dVisaUtgift;
    private EditText etFran;
    private EditText etTill;
    private Button btnSearch;
    private SimpleCursorAdapter esodaAdapter;

    static final int DIALOG_ID = 0;
    int datumFran, datumTill;
    int whatDateId;


    public VisaUtgiftFragment() {
        // Required empty public constructor
    }


    public void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_visa_utgift, container, false);
        ui = (MainActivity) getActivity();
        dVisaUtgift = new DetailedVisaUtgiftFragment();
        dbHandler = new MyDBHandler(getActivity(), null, null, 1);
        etFran = (EditText) view.findViewById(R.id.etFran);
        etTill = (EditText) view.findViewById(R.id.etTill);
        etFran.setOnClickListener(new ButtonClicked());
        etTill.setOnClickListener(new ButtonClicked());
        btnSearch = (Button) view.findViewById(R.id.btnSearch);
        btnSearch.setOnClickListener(new ButtonClicked());

        lvUtgift = (ListView) view.findViewById(R.id.lvUtgift);
        esodaAdapter = new SimpleCursorAdapter(getActivity(),
                R.layout.utgifter_item,
                dbHandler.getAllItemsInCursor(),
                new String[]{"_kategori", "_titel"},
                new int[]{R.id.utgifter_pic, R.id.tvUtgiftList},
                0);
        lvUtgift.setAdapter(esodaAdapter);
        setViewBinder();
        lvUtgift.setOnItemClickListener(new ListViewClicked());
        return view;
    }

    public void setViewBinder() {


        esodaAdapter.setViewBinder(new SimpleCursorAdapter.ViewBinder() {
            public boolean setViewValue(View view, Cursor cursor, int columnIndex) {
                if (view.getId() == R.id.utgifter_pic) {
                    ImageView IV = (ImageView) view;
                    int resID = getActivity().getApplicationContext().getResources().getIdentifier(cursor.getString(columnIndex), "drawable", getActivity().getApplicationContext().getPackageName());
                    IV.setImageDrawable(getActivity().getApplicationContext().getResources().getDrawable(resID));
                    return true;
                }
                return false;

            }
        });
    }

    private class ListViewClicked implements android.widget.AdapterView.OnItemClickListener {
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Cursor cursor = (Cursor) lvUtgift.getItemAtPosition(position);
            if (cursor != null) { //Should be the clicked listview and execute the code
                String stringId = cursor.getString(cursor.getColumnIndexOrThrow("_id"));
                ui.dVisaUtgift(dVisaUtgift);
                dVisaUtgift.databaseId(stringId);
            }
        }
    }

    private class ButtonClicked implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnSearch:
                    esodaAdapter = new SimpleCursorAdapter(getActivity(),
                            R.layout.utgifter_item,
                            dbHandler.getAllItemsByDate(datumFran, datumTill),
                            new String[]{"_kategori", "_titel"},
                            new int[]{R.id.utgifter_pic, R.id.tvUtgiftList},
                            0);
                    setViewBinder();

                    lvUtgift.setAdapter(esodaAdapter);
                    break;
                case R.id.etFran:
                    whatDateId = 11;
                    ui.whatDate(whatDateId);
                    ui.showDialog(DIALOG_ID);
                    break;
                case R.id.etTill:
                    whatDateId = 12;
                    ui.whatDate(whatDateId);
                    ui.showDialog(DIALOG_ID);
                    break;
            }


        }
    }

    public void setDatumFran(int datum) throws ParseException {
        datumFran = datum;
        String stringDatum = "" + datumFran;
        etFran.setText(stringDatum);
//        Toast.makeText(getActivity(),stringDatum, Toast.LENGTH_SHORT).show();
    }

    public void setDatumTill(int datum) throws ParseException {
        datumTill = datum;
        String stringDatum = "" + datum;
        etTill.setText(stringDatum);
//        Toast.makeText(getActivity(),stringDatum, Toast.LENGTH_SHORT).show();
    }
}
