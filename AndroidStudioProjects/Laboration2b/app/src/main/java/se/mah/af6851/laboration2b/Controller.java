package se.mah.af6851.laboration2b;

/**
 * Created by Amar on 2016-09-01.
 */
public class Controller {
    private ViewerFragment viewerFragment;
    private int click = 0;


    public Controller(ViewerFragment viewerFragment){
        this.viewerFragment = viewerFragment;
    }

    public void btnClick(){
        click ++;
        viewerFragment.updateViewer(click);
    }


}
