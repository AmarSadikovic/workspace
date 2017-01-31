package se.mah.af6851.project12;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class SensorFragment extends Fragment {
    private TextView tvName, tvDescription, tvUses, powerTv, mEventValue_0, mEventValue_1, mEventValue_2, mAccuracy, mTime;
    private Button btnStart, btnStop;
    private String mEventValueString_0, mEventValueString_1, mEventValueString_2, sAccuracy, sTime, sPower;
    private String sensorName;
    private View view;
    private boolean getValues = false;

    public SensorFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_sensor, container, false);
        sensorName = (((MainActivity) getActivity()).getName());


        tvName = (TextView) view.findViewById(R.id.tvName);
        tvDescription = (TextView) view.findViewById(R.id.tvDescription);
        tvUses = (TextView) view.findViewById(R.id.tvUses);
        powerTv = (TextView) view.findViewById(R.id.powerTv);
        mEventValue_0 = (TextView) view.findViewById(R.id.mEventValue_0);
        mEventValue_1 = (TextView) view.findViewById(R.id.mEventValue_1);
        mEventValue_2 = (TextView) view.findViewById(R.id.mEventValue_2);
        mAccuracy = (TextView) view.findViewById(R.id.mAccuracy);
        mTime = (TextView) view.findViewById(R.id.mTime);
        btnStart = (Button) view.findViewById(R.id.btnStart);
        tvName.setText(((MainActivity) getActivity()).getName());
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getValues = true;
                ((MainActivity) getActivity()).registerListener();

            }
        });
        btnStop = (Button) view.findViewById(R.id.btnStop);
        btnStop.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                getValues = false;
                ((MainActivity) getActivity()).unregisterListener();
            }
        });
        initializeComponents(view);
        return view;
    }



    public void setChangedText(String SmEventValue_0, String SmEventValue_1, String SmEventValue_2, String sAccuracy, String sTime, String sPower) {
        this.mEventValueString_0 = SmEventValue_0;
        this.mEventValueString_1 = SmEventValue_1;
        this.mEventValueString_2 = SmEventValue_2;
        this.sAccuracy = sAccuracy;
        this.sTime = sTime;
        this.sPower = sPower;
        initializeComponents(view);
    }


    public void initializeComponents(View view) {

        if (sensorName.contains("3-axis Accelerometer")) {
            tvDescription.setText("-Description: Measures the acceleration force in m/s2 that is applied to a" +
                    " device on all three physical axes (x, y, and z), including the force of gravity.");
            tvUses.setText("-Comon Uses: Motion detection (shake, tilt, etc).");

            if (getValues) {
                mEventValue_0.setText("Physical axe x: " + mEventValueString_0 + " m/s2");
                mEventValue_1.setText("Physical axe y: " + mEventValueString_1 + " m/s2");
                mEventValue_2.setText("Physical axe z: " + mEventValueString_2 + " m/s2");

                mAccuracy.setText("Accuracy: " + sAccuracy);
                powerTv.setText("Power: " + sPower);
                mTime.setText("Time: " + sTime);
            }
        } else if (sensorName.contains("Magnetic")) {
            tvDescription.setText("-Description: Measures the ambient geomagnetic field for all three physical axes (x, y, z) in μT");
            tvUses.setText("-Comon Uses: Creating a compass.");

            if (getValues) {
                mEventValue_0.setText("Physical axe x: " + mEventValueString_0 + "  μT");
                mEventValue_1.setText("Physical axe y: " + mEventValueString_1 + " μT");
                mEventValue_2.setText("Physical axe z: " + mEventValueString_2 + " μT");

                mAccuracy.setText("Accuracy: " + sAccuracy);
                powerTv.setText("Power: " + sPower);
                mTime.setText("Time: " + sTime);
            }
        } else if (sensorName.contains("Gyroscope")) {
            tvDescription.setText("-Description: Measures a device's rate of rotation in rad/s around each of the three physical axes (x, y, and z).");
            tvUses.setText("-Comon Uses: Rotation detection (spin, turn, etc.");

            if (getValues) {
                mEventValue_0.setText("Physical axe x: " + mEventValueString_0 + "  rad/s");
                mEventValue_1.setText("Physical axe y: " + mEventValueString_1 + " rad/s");
                mEventValue_2.setText("Physical axe z: " + mEventValueString_2 + " rad/s");

                mAccuracy.setText("Accuracy: " + sAccuracy);
                powerTv.setText("Power: " + sPower);
                mTime.setText("Time: " + sTime);
            }
        } else if (sensorName.contains("Barometer")) {
            tvDescription.setText("-Description: Measures the ambient air pressure in hPa or mbar.");
            tvUses.setText("-Comon Uses: Monitoring air pressure changes.");

            if (getValues) {
                mEventValue_0.setText("Physical axe x: " + mEventValueString_0 + "  hpA or mbar");
                mEventValue_1.setText("Physical axe y: " + mEventValueString_1 + " hpA or mbar");
                mEventValue_2.setText("Physical axe z: " + mEventValueString_2 + " hpA or mbar");

                mAccuracy.setText("Accuracy: " + sAccuracy);
                powerTv.setText("Power: " + sPower);
                mTime.setText("Time: " + sTime);
            }
        } else if (sensorName.contains("Proximity")) {
            tvDescription.setText("Description: Measures the proximity of an object in cm relative " +
                    "to the view screen of a device. This sensor is typically used to determine " +
                    "whether a handset is being held up to a person's ear.");
            tvUses.setText("-Comon Uses: Phone position during a call.");

            if (getValues) {
                mEventValue_0.setText("Value: " + mEventValueString_0 + "  hpA or mbar");

                mAccuracy.setText("Accuracy: " + sAccuracy);
                powerTv.setText("Power: " + sPower);
                mTime.setText("Time: " + sTime);
            }
        } else if (sensorName.contains("RGB")) {
            tvDescription.setText("-Description: Notification light on the frontside of the screen, Changes" +
                    "color when a new notification pops up.");
            tvUses.setText("-Comon Uses: Alert user a for new notifications");

            if (getValues) {
                mEventValue_0.setText("Physical axe x: " + mEventValueString_0 + "  ");
                mEventValue_1.setText("Physical axe y: " + mEventValueString_1 + " ");
                mEventValue_2.setText("Physical axe z: " + mEventValueString_2 + " ");

                mAccuracy.setText("Accuracy: " + sAccuracy);
                powerTv.setText("Power: " + sPower);
                mTime.setText("Time: " + sTime);
            }
        } else if (sensorName.contains("relative humidity")) {
            tvDescription.setText("-Description: Measures the relative ambient humidity in percent (%)");
            tvUses.setText("-Comon Uses: Monitoring dewpoint, absolute, and relative humidity.");

            if (getValues) {
                mEventValue_0.setText("Physical axe x: " + mEventValueString_0 + " %");
                mEventValue_1.setText("Physical axe y: " + mEventValueString_1 + " %");
                mEventValue_2.setText("Physical axe z: " + mEventValueString_2 + " %");

                mAccuracy.setText("Accuracy: " + sAccuracy);
                powerTv.setText("Power: " + sPower);
                mTime.setText("Time: " + sTime);
            }
        } else if (sensorName.contains("ambient temperature")) {
            tvDescription.setText("-Description: Measures the temperature of the device in " +
                    "degrees Celsius (°C). This sensor implementation varies across devices and " +
                    "this sensor was replaced with the TYPE_AMBIENT_TEMPERATURE sensor in API Level 14");
            tvUses.setText("-Comon Uses: Monitoring temperatures.");

            if (getValues) {
                mEventValue_0.setText("Physical axe x: " + mEventValueString_0 + " °C");
                mEventValue_1.setText("Physical axe y: " + mEventValueString_1 + " °C");
                mEventValue_2.setText("Physical axe z: " + mEventValueString_2 + " °C");

                mAccuracy.setText("Accuracy: " + sAccuracy);
                powerTv.setText("Power: " + sPower);
                mTime.setText("Time: " + sTime);
            }
        } else if (sensorName.contains("Significant Motion")) {
            if (getValues) {
                mEventValue_0.setText("Physical axe x: " + mEventValueString_0 + " °C");
                mEventValue_1.setText("Physical axe y: " + mEventValueString_1 + " °C");
                mEventValue_2.setText("Physical axe z: " + mEventValueString_2 + " °C");

                mAccuracy.setText("Accuracy: " + sAccuracy);
                powerTv.setText("Power: " + sPower);
                mTime.setText("Time: " + sTime);
            }
        } else if (sensorName.contains("Step Detector")) {
            tvDescription.setText("-Description: This sensor triggers an event each time the" +
                    " user takes a step. Upon each user step, this sensor delivers an event with" +
                    " a value of 1.0 and a timestamp indicating when the step occurred.");
            tvUses.setText("-Comon Uses: Detects steps");

            if (getValues) {
                mEventValue_0.setText("Physical axe x: " + mEventValueString_0 + " step");
                mEventValue_1.setText("Physical axe y: " + mEventValueString_1 + " step");
                mEventValue_2.setText("Physical axe z: " + mEventValueString_2 + " step");

                mAccuracy.setText("Accuracy: " + sAccuracy);
                powerTv.setText("Power: " + sPower);
                mTime.setText("Time: " + sTime);
            }
        } else if (sensorName.contains("Step Counter")) {
            tvDescription.setText("-Description: This sensor triggers an event each time the" +
                    " user takes a step. This sensor counts each step since the sensor was activated.");
            tvUses.setText("-Comon Uses: Counting step");
            if (getValues) {
                mEventValue_0.setText("Physical axe x: " + mEventValueString_0 + " step");
                mEventValue_1.setText("Physical axe y: " + mEventValueString_1 + " step");
                mEventValue_2.setText("Physical axe z: " + mEventValueString_2 + " step");

                mAccuracy.setText("Accuracy: " + sAccuracy);
                powerTv.setText("Power: " + sPower);
                mTime.setText("Time: " + sTime);
            }
        } else if (sensorName.contains("UnCalibrated Gyroscope")) {
            tvDescription.setText("-Description: Measures a device's rate of rotation in rad/s uncalibrated" +
                    "around each of the three physical axes (x, y, and z).");
            tvUses.setText("-Comon Uses: Rotation detection (spin, turn, etc.).");

            if (getValues) {
                mEventValue_0.setText("Physical axe x: " + mEventValueString_0 + " rad/s");
                mEventValue_1.setText("Physical axe y: " + mEventValueString_1 + " rad/s");
                mEventValue_2.setText("Physical axe z: " + mEventValueString_2 + " rad/s");

                mAccuracy.setText("Accuracy: " + sAccuracy);
                powerTv.setText("Power: " + sPower);
                mTime.setText("Time: " + sTime);
            }
        } else if (sensorName.contains("Screen Orientation")) {
            Toast.makeText(getActivity(), "Case: " + sensorName, Toast.LENGTH_SHORT).show();
        } else if (sensorName.contains("Rotation Vector")) {
            tvDescription.setText("-Description: The rotation vector represents the orientation of" +
                    " the device as a combination of an angle and an axis, in which the device has" +
                    " rotated through an angle θ around an axis (x, y, or z).");
            tvUses.setText("-Comon Uses: Rotation detection (spin, turn, etc.");

            if (getValues) {
                mEventValue_0.setText("Physical axe x: " + mEventValueString_0 + " °");
                mEventValue_1.setText("Physical axe y: " + mEventValueString_1 + " °");
                mEventValue_2.setText("Physical axe z: " + mEventValueString_2 + " °");

                mAccuracy.setText("Accuracy: " + sAccuracy);
                powerTv.setText("Power: " + sPower);
                mTime.setText("Time: " + sTime);
            }
        } else if (sensorName.contains("Gravity")) {
            tvDescription.setText("-Description: Measures the force of gravity in m/s2 that is " +
                    "applied to a device on all three physical axes (x, y, z). ");
            tvUses.setText("-Comon Uses: Motion detection (shake, tilt, etc.).");

            if (getValues) {
                mEventValue_0.setText("Physical axe x: " + mEventValueString_0 + "  m/s2");
                mEventValue_1.setText("Physical axe y: " + mEventValueString_1 + "  m/s2");
                mEventValue_2.setText("Physical axe z: " + mEventValueString_2 + "  m/s2");

                mAccuracy.setText("Accuracy: " + sAccuracy);
                powerTv.setText("Power: " + sPower);
                mTime.setText("Time: " + sTime);
            }
        } else if (sensorName.contains("Linear Acceleration")) {
            tvDescription.setText("-Description: Measures the acceleration force in m/s2 that " +
                    "is applied to a device on all three physical axes (x, y, and z), excluding the force of gravity.");
            tvUses.setText("-Comon Uses: Monitoring acceleration along a single axis.");

            if (getValues) {
                mEventValue_0.setText("Physical axe x: " + mEventValueString_0 + "  m/s2");
                mEventValue_1.setText("Physical axe y: " + mEventValueString_1 + "  m/s2");
                mEventValue_2.setText("Physical axe z: " + mEventValueString_2 + "  m/s2");

                mAccuracy.setText("Accuracy: " + sAccuracy);
                powerTv.setText("Power: " + sPower);
                mTime.setText("Time: " + sTime);
            }
        } else if (sensorName.contains("Orientation")) {
            tvDescription.setText("-Description: Measures degrees of rotation that a device makes" +
                    " around all three physical axes (x, y, z).");
            tvUses.setText("-Comon Uses: Determining device position.");

            if (getValues) {
                mEventValue_0.setText("Physical axe x: " + mEventValueString_0 + " °");
                mEventValue_1.setText("Physical axe y: " + mEventValueString_1 + " °");
                mEventValue_2.setText("Physical axe z: " + mEventValueString_2 + " °");

                mAccuracy.setText("Accuracy: " + sAccuracy);
                powerTv.setText("Power: " + sPower);
                mTime.setText("Time: " + sTime);
            }
        }
    }
}
