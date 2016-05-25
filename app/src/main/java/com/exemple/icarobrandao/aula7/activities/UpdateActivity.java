package com.exemple.icarobrandao.aula7.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.icarobrandao.aula7.R;
import com.exemple.icarobrandao.aula7.helpers.UserDAO;
import com.exemple.icarobrandao.aula7.models.User;
import com.exemple.icarobrandao.aula7.utils.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by icarobrandao on 25/05/16.
 */
public class UpdateActivity extends AppCompatActivity {
    @BindView(R.id.user_name)
    EditText userName;
    @BindView(R.id.user_email)
    EditText userEmail;

    @BindView(R.id.btn_back)
    Button btnBack;
    @BindView(R.id.btn_update_register)
    Button btnUpdate;

    User user = new User();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        ButterKnife.bind(this);

        if (getIntent().getExtras().containsKey(Constants.EXTRA_UPDATE_ACTIVITY)){
            user = (User) getIntent().getExtras().getSerializable(Constants.EXTRA_UPDATE_ACTIVITY);
        }

        userName.setText(user.getNome().toString());
        userEmail.setText(user.getEmail().toString());


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = userName.getText().toString();
                String email = userEmail.getText().toString();

                if(!TextUtils.isEmpty(name)&& !TextUtils.isEmpty(email)) {
                   User aux = new User();
                   aux.setId(user.getId());
                   aux.setNome(userName.getText().toString());
                   aux.setEmail(userEmail.getText().toString());

                   UserDAO userDAO = new UserDAO(UpdateActivity.this);
                   userDAO.update(aux);
                   Toast.makeText(UpdateActivity.this, "User Updated!", Toast.LENGTH_SHORT).show();
                   finish();
               }else{
                   Toast.makeText(UpdateActivity.this, "All Fields Must Be Completed, You Dummy!",Toast.LENGTH_SHORT).show();
               }
            }
        });

    }

}
