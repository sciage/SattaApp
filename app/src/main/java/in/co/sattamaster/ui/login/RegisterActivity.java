package in.co.sattamaster.ui.login;

import androidx.core.content.res.ResourcesCompat;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.co.sattamaster.R;
import in.co.sattamaster.ui.autocomplete.Autocomplete;
import in.co.sattamaster.ui.autocomplete.AutocompleteCallback;
import in.co.sattamaster.ui.autocomplete.AutocompletePresenter;
import in.co.sattamaster.ui.autocomplete.UserPresenter;
import in.co.sattamaster.ui.base.BaseActivity;

public class RegisterActivity extends BaseActivity implements RegisterMvpView {

    @BindView(R.id.register_username) EditText register_username;
    @BindView(R.id.register_phone) EditText register_phone;
    @BindView(R.id.register_password) EditText register_password;
    @BindView(R.id.register_final) Button register_final;

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
            mPresenter.getAllModerator();
            // getGroupsJoined();
        } catch (Exception e) {
            e.printStackTrace();
        }

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

        setupUserAutocomplete(response);

    }
}
