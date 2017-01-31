package se.mah.af6851.ekonomiappv2;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainMenuFragment extends Fragment {
    private MainActivity ui;
    private String [] choice = {"Mata in utgifter", "Mata in inkomster", "Visa utgifter", "Visa inkomster","Visa total"};
    private TextView tvPersonInfo;
    private String personInfo;


    public MainMenuFragment() {
        // Required empty public constructor
    }

    public void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setRetainInstance(true);

    }
    public void personInfo(String helaNamnet){
        personInfo = helaNamnet;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_menu, container, false);
        ui =(MainActivity)getActivity();
        tvPersonInfo = (TextView)view.findViewById(R.id.tvPersonInfo);
        ListView listViewMainMenu = (ListView)view.findViewById(R.id.listViewMainMenu);
        listViewMainMenu.setAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, choice));
        listViewMainMenu.setOnItemClickListener(new ListViewListener());
        tvPersonInfo.setText("Välkommen "+personInfo+"!");
        return view;
    }
    private class ListViewListener implements android.widget.AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            if(position == 0){
                ui.mataInUtgifter();
            }else if(position == 1){
                ui.mataInInkomster();
            }else if(position == 2){
                ui.visaUtgift();
            }else if (position == 3){
                ui.visaInkomst();
            }else if (position == 4){
                ui.visaTotal();
            }
        }
    }
}
