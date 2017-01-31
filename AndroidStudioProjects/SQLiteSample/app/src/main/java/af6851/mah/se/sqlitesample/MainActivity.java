package af6851.mah.se.sqlitesample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    EditText buckysInput;
    EditText editTextInput;
    TextView buckysText;
    MyDBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buckysInput = (EditText)findViewById(R.id.buckysInput);
        editTextInput = (EditText)findViewById(R.id.editTextInput);
        buckysText = (TextView)findViewById(R.id.buckysText);
        dbHandler = new MyDBHandler(this, null, null, 1); //Parameters from MyDBHandler
        printDatabase();
    }
    //Add a product to the database
    public void addButtonClicked(View view){
        Products product = new Products(buckysInput.getText().toString(), editTextInput.getText().toString());
        dbHandler.addProduct(product);
        printDatabase();
    }

    //Delete a product from the database
    public void deleteButtonClicked(View view){
        String inputText = buckysInput.getText().toString();
        dbHandler.deleteProduct(inputText); //Call the method in MYDBhandler.java
        printDatabase();
    }
    public void deleteAllButtonClicked(){
        dbHandler.deleteAllProduct();

    }

    public void printDatabase(){
     String dbString = dbHandler.databaseToString(); //method in MyDBHandler to print out the database as a String
     buckysText.setText(dbString);
     buckysInput.setText(""); //Erase the input from the input
    }
}
