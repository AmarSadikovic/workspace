package af6851.mah.se.howto;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class tvFrag extends Fragment {
    private TextView tvWhatToDo;
    private TextView tvContent;

    public tvFrag() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tv, container, false);
        tvWhatToDo = (TextView) view.findViewById(R.id.tvWhatToDo);
        tvContent = (TextView) view.findViewById(R.id.tvContent);
        return view;
    }

    public void setWhatToDo(String whatToDo) {
        tvWhatToDo.setText(whatToDo);
    }

    public void setContent(String content) {
        tvContent.setText(content);
    }
}
