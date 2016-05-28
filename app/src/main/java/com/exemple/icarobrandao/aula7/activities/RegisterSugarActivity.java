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
import com.exemple.icarobrandao.aula7.models.UserSugar;
import com.exemple.icarobrandao.aula7.utils.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by icarobrandao on 28/05/16.
 */
public class RegisterSugarActivity extends AppCompatActivity {

    @BindView(R.id.user_name)
    EditText userName;
    @BindView(R.id.user_email)
    EditText userEmail;

    @BindView(R.id.btn_back)
    Button btnBack;

    @BindView(R.id.btn_finish_register)
    Button btnFinishRegister;

    UserSugar user;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);


        if(getIntent().getExtras() !=null) {
            btnFinishRegister.setText("UPDATE");
            if (getIntent().getExtras().containsKey(Constants.EXTRA_UPDATE_ACTIVITY)) {
                user = (UserSugar) getIntent().getExtras().getSerializable(Constants.EXTRA_UPDATE_ACTIVITY);

            }
            userName.setText(user.getName().toString());
            userEmail.setText(user.getEmail().toString());


            btnFinishRegister.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });

            btnFinishRegister.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String name = userName.getText().toString();
                    String email = userEmail.getText().toString();

                    if(!TextUtils.isEmpty(name)&& !TextUtils.isEmpty(email)) {
                        UserSugar aux = new UserSugar();
                        aux.setId(user.getId());
                        aux.setName(userName.getText().toString());
                        aux.setEmail(userEmail.getText().toString());
                        aux.save();

                        Toast.makeText(RegisterSugarActivity.this, "User Updated!", Toast.LENGTH_SHORT).show();
                        finish();
                    }else{
                        Toast.makeText(RegisterSugarActivity.this, "All Fields Must Be Completed, You Dummy!",Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        btnFinishRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = userName.getText().toString();
                String email = userEmail.getText().toString();

                if(!TextUtils.isEmpty(name)&& !TextUtils.isEmpty(email)) {
                    UserSugar user = new UserSugar();
                    user.setName(name);
                    user.setEmail(email);
                    user.save();
                    Toast.makeText(RegisterSugarActivity.this, "You Saved a New User!", Toast.LENGTH_SHORT).show();
                    finish();
                }else{
                    Toast.makeText(RegisterSugarActivity.this, "All Fields Must Be Completed, You Dummy!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}
