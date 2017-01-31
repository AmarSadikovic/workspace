package se.mah.af6851.laboration1b;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Lab1bActivity extends AppCompatActivity {
    private EditText etName;
    private EditText etPhone;
    private EditText etEmail;
    private TextView tvSummary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab1b);
        etName = (EditText)findViewById(R.id.etName);
        etPhone = (EditText)findViewById(R.id.etPhone);
        etEmail = (EditText)findViewById(R.id.etEmail);
        tvSummary = (TextView)findViewById(R.id.tvSummary);
        Button btnSummary = (Button)findViewById(R.id.btnSummary);
        btnSummary.setOnClickListener(new ButtonListener() );
    }

    private class ButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            String str = summary();
            tvSummary.setText(str);

        }
        private String summary(){
            String res;
            res = "Name="+ etName.getText().toString() + ", phone= "+
                    etPhone.getText().toString()+", email="+
                    etEmail.getText().toString();
            return res;
        }
    }
}
