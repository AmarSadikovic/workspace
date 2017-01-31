package af6851.mah.se.lab3a;

import android.graphics.Color;

/**
 * Created by Amar on 2016-09-19.
 */
public class Controller {
    private Frag fragment;
    private String[] content = {"Röd", "Grön", "Blå", "Gul"};
    private int color = 0;
    public Controller(Frag fragment){
        this.fragment = fragment;
        fragment.setController(this);
        fragment.setColors(content);
    }
    public void buttonClick() {
        if(color == 0){
            fragment.setTextViewColor(Color.RED);
        }else if(color == 1){
            fragment.setTextViewColor(Color.GREEN);
        }else if(color == 2){
            fragment.setTextViewColor(Color.BLUE);
        }else if(color ==3){
            fragment.setTextViewColor(Color.YELLOW);
        }
    }

    public void listClick(int position) {
        color = position;
        fragment.setButtonText(content[position]);
    }
}
