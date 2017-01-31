package af6851.mah.se.howto;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class frag extends Fragment {
    private Controller cont;
    private Button btnPrevious;
    private Button btnNext;
    private TextView tvWhatToDo;
    private TextView tvContent;

    public frag() {
        // Required empty public constructor
    }


    public void setCont(Controller cont){
        this.cont = cont;
    }

    public void setWhatToDo(String whatToDo){
        tvWhatToDo.setText(whatToDo);
    }
    public void setContent(String content){
        tvContent.setText(content);
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_frag, container, false);
        btnPrevious = (Button) view.findViewById(R.id.btnPrevious);
        btnNext = (Button) view.findViewById(R.id.btnNext);
        tvWhatToDo = (TextView) view.findViewById(R.id.tvWhatToDo);
        tvContent = (TextView) view.findViewById(R.id.tvContent);
        btnNext.setOnClickListener(new NextListener());
//        btnPrevious.setOnClickListener(new PreviousListener());
        return view ;
    }

    private class NextListener implements View.OnClickListener {
        public void onClick(View v) {
            cont.nextClick();
        }
    }

//    private class PreviousListener implements View.OnClickListener {
//        public void onClick(View v){
//            cont.previousClick();
//        }
//    }
}
