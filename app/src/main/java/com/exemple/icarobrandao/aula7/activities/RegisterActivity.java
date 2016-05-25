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

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by icarobrandao on 21/05/16.
 */
public class RegisterActivity extends AppCompatActivity {
    @BindView(R.id.user_name)
    EditText userName;
    @BindView(R.id.user_email)
    EditText userEmail;

    @BindView(R.id.btn_back)
    Button btnBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @OnClick(R.id.btn_finish_register)
    public void registerUser(){
        String name = userName.getText().toString();
        String email = userEmail.getText().toString();

        if(!TextUtils.isEmpty(name)&& !TextUtils.isEmpty(email)) {
            User user = new User();
            user.setNome(name);
            user.setEmail(email);
            UserDAO userDAO = new UserDAO(this);
            userDAO.add(user);
            Toast.makeText(RegisterActivity.this, "You Saved a New User!", Toast.LENGTH_SHORT).show();
            finish();
        }else{
            Toast.makeText(RegisterActivity.this, "All Fields Must Be Completed, You Dummy!", Toast.LENGTH_SHORT).show();
        }

    }

}
