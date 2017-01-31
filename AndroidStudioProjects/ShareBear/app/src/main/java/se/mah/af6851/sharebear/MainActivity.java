package se.mah.af6851.sharebear;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.content.SharedPreferencesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText usernameInput;
    private EditText passwordInput;
    private TextView buckysText;
    private Button btnSaveInfo;
    private Button btnDisplayInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameInput = (EditText) findViewById(R.id.userInput);
        passwordInput = (EditText) findViewById(R.id.passwordInput);
        buckysText = (TextView) findViewById(R.id.buckysText);
        btnDisplayInfo = (Button) findViewById(R.id.btnDisplay);
        btnSaveInfo = (Button) findViewById(R.id.btnSave);
        btnDisplayInfo.setOnClickListener(new ButtonListener());
        btnSaveInfo.setOnClickListener(new ButtonListener());
    }

    private class ButtonListener implements Button.OnClickListener{
        SharedPreferences sharedPref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        public void onClick( View v){
            if(v.getId() == R.id.btnDisplay){
                String name = sharedPref.getString("username","");
                String pw = sharedPref.getString("password","");
                buckysText.setText("Username: "+name+"\nPassword: "
                                    + pw);

            }else if(v.getId() == R.id.btnSave){

                editor.putString("username", usernameInput.getText().toString());
                editor.putString("password", passwordInput.getText().toString());
                editor.apply();
                Toast.makeText(MainActivity.this, "Save!", Toast.LENGTH_LONG).show();

            }
        }
    }
}
