package se.mah.af6851.laboration3a;


import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentFrag extends Fragment {
            private String [] colors = {"Röd", "Blå", "Gul", "Grön"};
    private Button btnFin;
    private TextView tv;
    private int color;


    public FragmentFrag() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_3, container, false);
        ListView listView = (ListView)view.findViewById(R.id.listView);
            listView.setAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, colors));
            listView.setOnItemClickListener(new ListViewListener());
        btnFin = (Button)view.findViewById(R.id.button);
        tv = (TextView) view.findViewById(R.id.textView);
        btnFin.setOnClickListener(new NextListener());
        return view;
    }

    private class ListViewListener implements android.widget.AdapterView.OnItemClickListener{
        public void onItemClick(AdapterView<?> parent, View view, int position, long id){
            TextView tv = (TextView)view;
            Log.d("OICL", colors[position] + " - "+tv.getText());

            if(position == 0){
                btnFin.setText("Red");
                btnFin.setTextColor(Color.RED);
                color = 0;
            }else if(position == 1){
                btnFin.setText("Blue");
                btnFin.setTextColor(Color.BLUE);
                color = 1;
            }else if(position == 2){
                btnFin.setText("Yellow");
                btnFin.setTextColor(Color.YELLOW);
                color = 2;
            }else if(position == 3){
                btnFin.setText("Green");
                btnFin.setTextColor(Color.GREEN);
                color = 3;
            }
        }
    }


    private class NextListener implements View.OnClickListener {
        public void onClick(View v) {
            if(v.getId()==btnFin.getId()){
                if(color == 0){
                    tv.setBackgroundColor(Color.RED);
                }else if (color == 1){
                    tv.setBackgroundColor(Color.BLUE);
                }else if(color == 2){
                    tv.setBackgroundColor(Color.YELLOW);
                }else if(color == 3){
                    tv.setBackgroundColor(Color.GREEN);
                }

            }

        }
    }
}
