package se.mah.af6851.project12;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends Activity implements SensorEventListener {

    private SensorManager mSensorManager;
    private Sensor mSensor;
    private FragmentManager fm;
    private lvFragment lvFragment;
    private SensorFragment sensorFragment;
    private List<Sensor> sensorList;
    private boolean sensorActivated;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sensorActivated = false;
        setContentView(R.layout.activity_main);
        fm = getFragmentManager();
        lvFragment = new lvFragment();
        sensorFragment = new SensorFragment();
        mSensorManager = (SensorManager) this.getSystemService(Context.SENSOR_SERVICE);
        sensorList = mSensorManager.getSensorList(Sensor.TYPE_ALL);
        setFragment(lvFragment, false);


    }

    public List getSensorList() {
        return sensorList;
    }

    public void showSensor(int position) {
        mSensor = sensorList.get(position);
        setFragment(sensorFragment, true);
    }

    public void registerListener() {
        mSensorManager.registerListener(this, mSensor, mSensorManager.SENSOR_DELAY_NORMAL);
        sensorActivated = true;
    }

    public void unregisterListener() {
        mSensorManager.unregisterListener(this);
        sensorActivated = false;
        Toast.makeText(this, "Sensor unRegistered", Toast.LENGTH_SHORT).show();
    }

    public String getName() {
        return mSensor.getName();
    }

    public void setFragment(Fragment frag, boolean backstack) {
        FragmentTransaction fs = fm.beginTransaction();
        fs.replace(R.id.fl, frag);
        if (backstack) {
            fs.addToBackStack(null);
        }
        fs.commit();
        fm.executePendingTransactions();
    }

    @Override
    public void onBackPressed() {
        setFragment(lvFragment, false);
        if(sensorActivated) {
            unregisterListener();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
        Toast.makeText(this, "Sensor unRegistered", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mSensorManager.unregisterListener(this);
        Toast.makeText(this, "Sensor unRegistered", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        String value0 = String.valueOf(event.values[0]);
        String value1 = String.valueOf(event.values[1]);
        String value2 = String.valueOf(event.values[2]);
        String accuracy = String.valueOf(event.accuracy);
        String timestamp = String.valueOf(event.timestamp);
        String power = String.valueOf(mSensor.getPower());

        sensorFragment.setChangedText(value0, value1, value2, accuracy, timestamp, power);

    }


    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
