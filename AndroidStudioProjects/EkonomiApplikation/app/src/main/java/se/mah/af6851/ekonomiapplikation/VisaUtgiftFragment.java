package se.mah.af6851.ekonomiapplikation;


import android.database.Cursor;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class VisaUtgiftFragment extends Fragment {
    private MainActivity ui;
    private MyDBHandler dbHandler;
    private ListView lvUtgift;
    private SimpleCursorAdapter dataAdapter;

    public VisaUtgiftFragment() {
        // Required empty public constructor
    }

    public void setActivity(MainActivity ui){
        this.ui = ui;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_visa_utgift, container, false);
        lvUtgift = (ListView)view.findViewById(R.id.lvUtgift);
        dbHandler = new MyDBHandler(getActivity(), null, null, 1);
        displayListView();

        return view;
    }
    private void displayListView() {
        Cursor cursor = dbHandler.fetchWholeDatabase();

            String[] columns = new String[]{
                MyDBHandler.COLUMN_TITEL,
                MyDBHandler.COLUMN_KATEGORI,
                MyDBHandler.COLUMN_PRIS,
                MyDBHandler.COLUMN_DATUM
            };
        lvUtgift.setAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, columns));
        lvUtgift.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Cursor cursor = (Cursor)lvUtgift.getItemAtPosition(position);

                String CountryCode =
                        cursor.getString(cursor.getColumnIndex("_titel"));
            }
        });
    }


}
