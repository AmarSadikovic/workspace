package se.mah.af6851.ekonomiapplikation;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainMenuFragment extends Fragment {
    private MainActivity ui;
    private String [] choice = {"Mata in utgifter", "Mata in inkomster", "Visa utgifter", "Visa inkomster","Visa total"};

    public MainMenuFragment() {
        // Required empty public constructor
    }
    public void setActivity(MainActivity ui){
        this.ui = ui;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_menu, container, false);
        ListView listViewMainMenu = (ListView)view.findViewById(R.id.listViewMainMenu);
            listViewMainMenu.setAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, choice));
            listViewMainMenu.setOnItemClickListener(new ListViewListener());
        return view;
    }




    private class ListViewListener implements android.widget.AdapterView.OnItemClickListener {
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            if(position == 0){
                ui.MataInUtgifter();
            }else if(position == 1){
                ui.MataInInkomster();
            }else if(position == 2){
                ui.visaUtgift();
            }
        }
    }
}
