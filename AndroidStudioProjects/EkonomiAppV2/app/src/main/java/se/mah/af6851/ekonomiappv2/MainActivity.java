package se.mah.af6851.ekonomiappv2;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.DatePicker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private FragmentManager fm;
    private MainMenuFragment mainMenu;
    private MataInUtgifterFragment mataInUtgifter;
    private MataInInkomsterFragment mataInInkomster;
    private VisaUtgiftFragment visaUtgift;
    private VisaInkomstFragment visaInkomst;
    private NamnFragment namnFragment;
    private VisaTotalFragment visaTotal;
    private DetailedVisaInkomstFragment dVisaInkomst;
    private DetailedVisaUtgiftFragment dVisaUtgiftTest;
    private String helaNamnet = null;
    private SharedPreferences sharedPref;
    private SharedPreferences.Editor editor;
    private String tag = "myFragment";

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd", Locale.GERMAN);
    private Calendar calendar;


    private int whatDateId;
    //date picker
    private int year_x, month_x, day_x;
    private static final int DIALOG_ID = 0;
    private String stringDatum;
    private int datum;



    private String fornamn, efternamn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPref = getSharedPreferences("userinfo", Context.MODE_PRIVATE);
        editor = sharedPref.edit();

        calendar = Calendar.getInstance();
        year_x = calendar.get(Calendar.YEAR);
        month_x = calendar.get(Calendar.MONTH);
        day_x = calendar.get(Calendar.DAY_OF_MONTH);
        helaNamnet();

        fm = getFragmentManager();
        initializeComponents(savedInstanceState);


    }
    public void initializeComponents(Bundle saved){


        mainMenu = new MainMenuFragment();
        mataInUtgifter = new MataInUtgifterFragment();
        mataInInkomster = new MataInInkomsterFragment();
        visaUtgift = new VisaUtgiftFragment();
        visaInkomst = new VisaInkomstFragment();
        namnFragment = new NamnFragment();
        dVisaInkomst = new DetailedVisaInkomstFragment();
        visaTotal = new VisaTotalFragment();

        if(saved == null) {
            if (sharedPref.getString("fornamn","") == "") {
                setUi(namnFragment);
            } else {
                setUi(mainMenu);
            }
        }
    }

    protected Dialog onCreateDialog(int id){
        if(id == DIALOG_ID){
            return new DatePickerDialog(this, dPickerListener, year_x, month_x, day_x);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener dPickerListener = new DatePickerDialog.OnDateSetListener(){

        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth){
            calendar.set(Calendar.YEAR,year);
            calendar.set(Calendar.MONTH,monthOfYear);
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            stringDatum = sdf.format(calendar.getTime());
            datum = Integer.parseInt(stringDatum);
            try {
                if(whatDateId == 01) {
                    mataInUtgifter.setDatum(datum);
                }else if(whatDateId==02){
                    mataInInkomster.setDatum(datum);
                } else if(whatDateId == 11){
                    visaUtgift.setDatumFran(datum);
                }else if (whatDateId == 12){
                    visaUtgift.setDatumTill(datum);
                }else if(whatDateId == 21){
                    visaInkomst.setDatumFran(datum);
                }else if(whatDateId == 22){
                    visaInkomst.setDatumTill(datum);
                }
            } catch (ParseException e) {
                e.printStackTrace();
        }
        }

    };
    public void whatDate(int whatDateId){
        this.whatDateId = whatDateId;
    }

    public void mataInUtgifter(){
        setUi(mataInUtgifter);
    }

    public void mataInInkomster(){
        setUi(mataInInkomster);
    }

    public void visaUtgift(){
        setUi(visaUtgift);
    }

    public void visaInkomst(){
        setUi(visaInkomst);
    }

    public void mainMenu(){
        setUi(mainMenu);
    }

    public void visaTotal(){setUi(visaTotal);}

    public void dVisaInkomst(DetailedVisaInkomstFragment dVisaInkomst){
        this.dVisaInkomst = dVisaInkomst;
        setUi(dVisaInkomst);
    }

    public void dVisaUtgift(DetailedVisaUtgiftFragment dVisaUtgift){
        dVisaUtgiftTest = dVisaUtgift;
        setUi(dVisaUtgiftTest);
    }

    public void setUi(Fragment frag){

        if(frag instanceof MainMenuFragment){
            mainMenu.personInfo(helaNamnet);
        }else if(frag instanceof VisaTotalFragment){
            visaTotal.helaNamnet(helaNamnet);
        }

        FragmentTransaction fs = fm.beginTransaction();
        fs.addToBackStack(null);
        fs.replace(R.id.fl, frag);
        fm.executePendingTransactions();
        fs.commit();
    }

    public void userinfo(String fornamn, String efternamn){
        editor.putString("fornamn", fornamn);
        editor.putString("efternamn", efternamn);
        editor.apply();
        helaNamnet();
    }
    public void helaNamnet(){
        helaNamnet = sharedPref.getString("fornamn","")+" "+ sharedPref.getString("efternamn","");
    }
//    public String getHelaNamnet(String helaNamnet){
//        return helaNamnet;
//    }
}
