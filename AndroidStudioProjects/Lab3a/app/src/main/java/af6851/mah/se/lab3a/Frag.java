package af6851.mah.se.lab3a;


import android.app.Fragment;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Frag extends Fragment {
    private Controller controller;
    private ListView listView;
    private Button button;
    private TextView textView;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_frag, container, false);
        listView = (ListView) view.findViewById(R.id.listView);
        button = (Button) view.findViewById(R.id.button);
        textView = (TextView) view.findViewById(R.id.textView);
        listView.setOnItemClickListener(new ListViewListener());
        button.setOnClickListener(new ButtonViewListener());
        return view;
    }

    public void setColors(String[] content){

        listView.setAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,content));
    }

    public void setController(Controller controller){
        this.controller = controller;
    }

    public void setButtonText(String text){
        button.setText(text);
    }
    public void setTextViewColor(int color){
        textView.setBackgroundColor(color);
    }

    private class ListViewListener implements android.widget.AdapterView.OnItemClickListener {
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            controller.listClick(position);

        }
    }

    private class ButtonViewListener implements View.OnClickListener {
        public void onClick(View v) {
            controller.buttonClick();
        }
    }
}
