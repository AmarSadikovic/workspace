package se.mah.af6851.facebooklogin;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONException;
import org.json.JSONObject;



/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    private TextView mTextDetails;
    private CallbackManager mCallbackManager;
    private String name;
    private SharedPreferences sharedPref;
    private SharedPreferences.Editor editor;
    private String email;

    private FacebookCallback<LoginResult> mCallback = new FacebookCallback<LoginResult>() {
        @Override
        public void onSuccess(final LoginResult loginResult) {
            GraphRequest request = GraphRequest.newMeRequest(
                    loginResult.getAccessToken(),
                    new GraphRequest.GraphJSONObjectCallback() {
                        @Override
                        public void onCompleted(
                                JSONObject object,
                                GraphResponse response) {

                            try {
                                if (object != null) {
                                    name  = object.getString("first_name") + " "+object.getString("last_name");
                                    email = object.getString("email");
                                    mTextDetails.setText("Welcome " + name);
                                    editor.putString("username", name);
                                    editor.putString("email", email);
                                    editor.apply();
                                }
                            } catch (JSONException e) {

                            }
                        }
                    });
            Bundle parameters = new Bundle();
            parameters.putString("fields", "id,name,email, first_name, last_name, gender");
            request.setParameters(parameters);
            request.executeAsync();
        }
//        }

        @Override
        public void onCancel() {
        }

        @Override
        public void onError(FacebookException error) {

        }
    };

    public MainFragment() {
        // Required empty public constructor
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getActivity().getApplicationContext());
        mCallbackManager = CallbackManager.Factory.create();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        mTextDetails = (TextView) view.findViewById(R.id.text_details);
        LoginButton loginButton = (LoginButton) view.findViewById(R.id.login_button);
        loginButton.setReadPermissions("public_profile", "email");//Only ask if you must

        loginButton.setFragment(this);
        loginButton.registerCallback(mCallbackManager, mCallback);

        sharedPref = this.getActivity().getSharedPreferences("userinfo", Context.MODE_PRIVATE);
        editor = sharedPref.edit();
        name = sharedPref.getString("username", "");
        email = sharedPref.getString("email","");

        if (name != "") {
            mTextDetails.setText(name);
        }
//        Toast.makeText(getActivity(), sharedPref.getString("username", ""), Toast.LENGTH_LONG).show();
        Toast.makeText(getActivity(), sharedPref.getString("email", ""), Toast.LENGTH_LONG).show();

        return view;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mCallbackManager.onActivityResult(requestCode, resultCode, data);


    }
}
