package af6851.mah.se.howto;

import android.app.Fragment;
import android.content.res.Resources;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Amar on 2016-09-21.
 */
public class Controller {
    private Instruction[] instructions = new Instruction[3];
    private int index = 0;
    private tvFrag ui;

    public Controller(tvFrag ui) {
        this.ui = ui;
        initializeResources();
    }

    private void initializeResources() {
        Resources res = ui.getResources();
        String whatToDo = res.getString(R.string.what_to_do);
        String content = res.getString(R.string.content);
        instructions[0] = new Instruction(whatToDo, content);
        instructions[1] = new Instruction(res.getString(R.string.what_to_do2), res.getString(R.string.content2));
        instructions[2] = new Instruction(res.getString(R.string.what_to_do3), res.getString(R.string.content3));
    }

    public void setListViewText(ListView listViewText){
        String[] text = {instructions[0].getWhatToDo(),instructions[1].getWhatToDo(), instructions[2].getWhatToDo()};
        listViewText.setAdapter(new ArrayAdapter<String>(ui.getActivity(),android.R.layout.simple_list_item_1, text));

    }

    public void setText(int i) {

        ui.setWhatToDo(instructions[i].getWhatToDo());
        ui.setContent((instructions[i].getContent()));
    }


}
