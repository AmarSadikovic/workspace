package se.mah.af6851.datepicker;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class datePickerFragment extends Fragment {

    MainActivity ui;
    Button button;
    int year_x, month_x, day_x;
    static final int DIALOG_ID = 0;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_date_picker, container, false);
        button = (Button)view.findViewById(R.id.button);
        button.setOnClickListener(new ButtonClicked());

        return view;
    }

    private class ButtonClicked implements View.OnClickListener {
        @Override
        public void onClick(View v) {
//            ui.showDialogOnButtonClick();
            ui.showDialog(DIALOG_ID);
        }
    }

    public void setDate(int year_x, int month_x, int day_x){
        this.year_x = year_x;
        this.month_x = month_x;
        this.day_x = day_x;
        Toast.makeText(getActivity(), year_x+"/"+month_x+"/"+day_x,Toast.LENGTH_SHORT).show();
        System.out.println(day_x);
    }
}
