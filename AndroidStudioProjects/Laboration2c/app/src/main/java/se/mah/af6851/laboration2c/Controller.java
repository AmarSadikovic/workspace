package se.mah.af6851.laboration2c;

import android.content.res.Resources;

/**
 * Created by Amar on 2016-09-01.
 */
public class Controller {
    private Instruction[] instructions = new Instruction[3];
    private int index = 0;
    private InputFragment input;
    private ViewerFragment vf;
    private MainActivity ui;
    private Resources res;

    public Controller(ViewerFragment vf, InputFragment input, MainActivity ui){
        this.vf = vf;
        this.input = input;
        this.ui=ui;
        initializeResources();
        input.setController(this);
        this.res = ui.getResources();
    }

    private void initializeResources() {
        this.res = vf.getResources();
        String whatToDo = res.getString(R.string.what_to_do);
        String content = res.getString(R.string.content);
        instructions[0] = new Instruction(whatToDo, content);
        instructions[1] = new Instruction(res.getString(R.string.what_to_do2), res.getString(R.string.content2));
        instructions[2] = new Instruction(res.getString(R.string.what_to_do3), res.getString(R.string.content3));
    }

    public void previousClick() {
        index--;
        if(index<0){
            index = instructions.length-1;
        }
        vf.setWhatToDo(instructions[index].getWhatToDo());
        vf.setContent(instructions[index].getContent());
    }

    public void nextClick(){
        index++;
        if(index==instructions.length){
            index=0;
        }
        vf.setWhatToDo(instructions[index].getWhatToDo());
        vf.setContent(instructions[index].getContent());
    }
}
