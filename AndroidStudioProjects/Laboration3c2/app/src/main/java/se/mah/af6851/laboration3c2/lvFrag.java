package se.mah.af6851.laboration3c2;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class lvFrag extends Fragment {
    private ListView listView;
    private Controller cont;

    public lvFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lv, container, false);
        listView = (ListView)view.findViewById(R.id.listView);
        listView.setOnItemClickListener(new clickListener());
        return view;
    }

    public void setController(Controller cont){
        this.cont = cont;
        cont.setListViewText(listView);
    }


    private class clickListener implements android.widget.AdapterView.OnItemClickListener {
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            cont.setText(position);
        }
    }
}
