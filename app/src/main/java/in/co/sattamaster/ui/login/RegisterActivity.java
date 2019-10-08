package in.co.sattamaster.ui.login;

import androidx.core.content.res.ResourcesCompat;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.co.sattamaster.R;
import in.co.sattamaster.ui.Homepage.MainActivity;
import in.co.sattamaster.ui.autocomplete.Autocomplete;
import in.co.sattamaster.ui.autocomplete.AutocompleteCallback;
import in.co.sattamaster.ui.autocomplete.AutocompletePresenter;
import in.co.sattamaster.ui.autocomplete.UserPresenter;
import in.co.sattamaster.ui.base.BaseActivity;
import in.co.sattamaster.ui.base.MySharedPreferences;

public class RegisterActivity extends BaseActivity implements RegisterMvpView {

    @BindView(R.id.register_username) EditText register_username;
    @BindView(R.id.register_phone) EditText register_phone;
    @BindView(R.id.register_password) EditText register_password;
    @BindView(R.id.register_final) Button register_final;

    private List<AllModerators> response;

    protected boolean selectedModerator = false;


    @BindView(R.id.register_spinner) EditText register_spinner;
    private Autocomplete userAutocomplete;

    String moderator_id;

    @BindView(R.id.register_progressbar) View progressFrame;

    @Inject
    RegisterMvpPresenter<RegisterMvpView> mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(RegisterActivity.this);

        progressFrame.setVisibility(View.VISIBLE);

        try {
            mPresenter.getAllModerator(preferences);
            // getGroupsJoined();
        } catch (Exception e) {
            e.printStackTrace();
        }

        register_final.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (createUserObject() != null){
                    progressFrame.setVisibility(View.VISIBLE);
                    try {
                        mPresenter.registerNewUser(createUserObject(), preferences);
                        // getGroupsJoined();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }
        });

    }

    private JsonObject createUserObject(){
        JsonObject createJsonObject = null;

        if (!selectedModerator){
            if(!register_spinner.getText().toString().isEmpty()){

                boolean value = stringContainsItemFromList(register_spinner.getText().toString(), response);
                if (value){
                    selectedModerator = true;
                } else {
                    Toast.makeText(RegisterActivity.this, "Please enter moderator", Toast.LENGTH_SHORT).show();
                }

            }

        }


        if (register_username.getText().toString().isEmpty()){
            Toast.makeText(RegisterActivity.this, "Please enter username", Toast.LENGTH_SHORT).show();
        } else if (register_phone.getText().toString().isEmpty()){
            Toast.makeText(RegisterActivity.this, "Please enter phone", Toast.LENGTH_SHORT).show();
        } else  if (register_password.getText().toString().isEmpty() || register_password.getText().length()<6){
            register_password.setError("Please enter password of 6 words");
            Toast.makeText(RegisterActivity.this, "Please enter password", Toast.LENGTH_SHORT).show();
        } else   if (!selectedModerator){
            Toast.makeText(RegisterActivity.this, "Please enter moderator", Toast.LENGTH_SHORT).show();

        } else {
            createJsonObject = createJsonObject();
        }
        return createJsonObject;

    }

    public boolean stringContainsItemFromList(String inputStr, List<AllModerators> items)
    {
        for(int i =0; i < items.size(); i++)
        {
            if(inputStr.equalsIgnoreCase(items.get(i).getName()))
            {
                setModerator_id(items.get(i).getId());
                return true;
            }
        }
        return false;
    }

    private JsonObject createJsonObject(){
        JsonObject user = new JsonObject();
        try {
            user.addProperty("name", register_username.getText().toString());
            user.addProperty("phone", register_phone.getText().toString());
            user.addProperty("password", register_password.getText().toString());
            user.addProperty("moderator_id", this.moderator_id);
            user.addProperty("coin_balance", "0");

        } catch (JsonIOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return user;
    }

    private void setupUserAutocomplete(List<AllModerators> response) {
        // EditText edit = (EditText) findViewById(R.id.single);
        float elevation = 6f;
        Drawable backgroundDrawable = ResourcesCompat.getDrawable(getResources(), R.drawable.shadow, null);

        AutocompletePresenter<AllModerators> presenter = new UserPresenter(this, response);
        AutocompleteCallback<AllModerators> callback = new AutocompleteCallback<AllModerators>() {
            @Override
            public boolean onPopupItemClicked(Editable editable, AllModerators item) {
                editable.clear();
                editable.append(item.getName());
                setModerator_id(item.getId());
                selectedModerator = true;
                return true;
            }

            public void onPopupVisibilityChanged(boolean shown) {
            }
        };

        userAutocomplete = Autocomplete.<AllModerators>on(register_spinner)
                .with(elevation)
                .with(backgroundDrawable)
                .with(presenter)
                .with(callback)
                .build();
    }

    private void setModerator_id(String moderator_id) {
        this.moderator_id = moderator_id;
    }

    @Override
    protected void setUp() {

    }

    @Override
    public void getListAllGroups(List<AllModerators> response) {

        progressFrame.setVisibility(View.INVISIBLE);

        this.response = response;

        setupUserAutocomplete(response);

    }

    @Override
    public void getUserRegister(RegisterResponse response) {
        progressFrame.setVisibility(View.INVISIBLE);

        if (response.getStatus()){
             AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(RegisterActivity.this);
                alertDialogBuilder.setTitle("Registered Successful");
                alertDialogBuilder.setMessage("Please login to continue");
                alertDialogBuilder.setCancelable(false);
                alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        Intent intent = new Intent(RegisterActivity.this, LoginScreenActivity.class);
                        startActivity(intent);
                    }
                });
                alertDialogBuilder.show();

        }




    }

    @Override
    public void getRegisterError() {
        progressFrame.setVisibility(View.INVISIBLE);

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(RegisterActivity.this);
            alertDialogBuilder.setTitle("Mobile Number Already exists");
            alertDialogBuilder.setMessage("Please email owner to change password : ravigamerao@gmail.com");
            alertDialogBuilder.setCancelable(false);
            alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    
                }
            });
            alertDialogBuilder.show();



        Toast.makeText(this, "Mobile number already exists", Toast.LENGTH_SHORT).show();
    }
}
