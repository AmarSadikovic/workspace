package se.mah.tsroax.staticfragment;

import android.app.FragmentManager;

import android.app.Activity;
        import android.os.Bundle;
        import android.view.Menu;
        import android.view.MenuItem;

public class MainActivity extends Activity {
    private RPSController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initController();
        startProgram();
    }

    private void initController() {
        FragmentManager fm = getFragmentManager();
        RPSPlayer computerPlayer = new RPSPlayer();
        ViewerFragment viewer = (ViewerFragment)fm.findFragmentById(R.id.viewer_fragment);
        InputFragment input = (InputFragment)fm.findFragmentById(R.id.input_fragment);
        controller = new RPSController(computerPlayer, viewer, input);
    }

    private void startProgram() {
        controller.newGame();
    }

}
