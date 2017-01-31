package se.mah.af6851.ekonomiappv2;


import android.graphics.Color;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class VisaTotalFragment extends Fragment {
    private MainActivity ui;
    private MyDBHandler dbHandler;
    private TextView tvTotal, tvHeader;
    private String namn;

    public VisaTotalFragment() {
        // Required empty public constructor
    }

    public void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setRetainInstance(true);
    }
    public void helaNamnet(String helaNamnet){
        namn = helaNamnet;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_visa_total, container, false);
        ui = (MainActivity) getActivity();
        tvTotal = (TextView) view.findViewById(R.id.tvTotal);
        tvHeader = (TextView) view.findViewById(R.id.tvHeader);

        TextView tvTotalInkomst = (TextView) view.findViewById(R.id.tvTotalInkomst);
        TextView tvTotalUtgift = (TextView) view.findViewById(R.id.tvTotalUtgift);
        dbHandler = new MyDBHandler(getActivity(), null, null, 1);
        long utgifter = dbHandler.databaseTotalUtgifter();

        long inkomster = dbHandler.databaseTotalInkomster();
        long total = inkomster - utgifter;
        String totalaEkonomin = "" + total + "kr";
        String inkomsterString = "" + inkomster;
        String utgifterString = "" + utgifter;

        //Inkomst
        tvTotalInkomst.setTextColor(Color.GREEN);
        tvTotalInkomst.setText(inkomsterString+"kr");

        //Utgift
        tvTotalUtgift.setTextColor(Color.RED);
        tvTotalUtgift.setText(utgifterString+"kr");

        if (total < 0) {
            tvTotal.setTextColor(Color.RED);
            tvTotal.setText(totalaEkonomin);
            tvHeader.setText("Din nuvarande ekonomi " + namn + " måste förbättras!");
        } else if (total > 0) {
            tvTotal.setTextColor(Color.GREEN);
            tvTotal.setText(totalaEkonomin);
            tvHeader.setText("Din nuvarande ekonomi " + namn + " är bra!");
        } else {
            tvTotal.setTextColor(Color.WHITE);
            tvTotal.setText(totalaEkonomin);
            tvHeader.setText("Din nuvarande ekonomi " + namn + " kunde varit bättre!");
        }
        return view;
    }

}
