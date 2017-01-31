package se.mah.af6851.laboration3b;



import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {
    private String [] colors = {"Att starta en Activity", "Att lägga till en Activity"
            , "Att avläsa en Activity"};

    public ListFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        ListView listView = (ListView)view.findViewById(R.id.listView);
        listView.setAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, colors));
        listView.setOnItemClickListener(new ListViewListener());
        return view;
    }

    private class ListViewListener implements android.widget.AdapterView.OnItemClickListener {
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            if(position == 0){

            }else if(position == 1){

            }else if(position == 2){

            }
        }
    }
}
