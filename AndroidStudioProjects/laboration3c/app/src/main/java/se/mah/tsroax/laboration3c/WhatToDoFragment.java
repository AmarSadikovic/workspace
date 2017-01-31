package se.mah.tsroax.laboration3c;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 *
 */
public class WhatToDoFragment extends Fragment {
    private WhatToDoAdapter adapter;
    private Controller controller;


    public WhatToDoFragment() {
        // Required empty public constructor
    }

    public void setAdapter(WhatToDoAdapter adapter) {
        this.adapter = adapter;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_what_to_do, container, false);
        ListView lv = (ListView)view.findViewById(R.id.lvWhatToDo);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new ItemListener());
        return view;
    }


    private class ItemListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            controller.itemClicked(position);
        }
    }
}
