package se.mah.af6851.project12;


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
public class lvFragment extends Fragment {
    private ListView lv;

    public lvFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lv, container, false);
        lv = (ListView) view.findViewById(R.id.lv);
        lv.setAdapter(new ListAdapter(getActivity(), ((MainActivity) getActivity()).getSensorList()));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ((MainActivity)getActivity()).showSensor(position);
            }
        });
        return view;
    }

}
