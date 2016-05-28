package com.exemple.icarobrandao.aula7.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.icarobrandao.aula7.R;
import com.exemple.icarobrandao.aula7.adapters.UserListAdapter;
import com.exemple.icarobrandao.aula7.adapters.UserSugarListAdapter;
import com.exemple.icarobrandao.aula7.helpers.UserDAO;
import com.exemple.icarobrandao.aula7.models.UserSugar;
import com.exemple.icarobrandao.aula7.utils.Constants;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by icarobrandao on 28/05/16.
 */
public class MainSugarActivity extends AppCompatActivity {
    @BindView(R.id.listView)
    ListView listView;

    @BindView(R.id.btn_register)
    Button btnRegister;

    private UserSugarListAdapter userListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainSugarActivity.this, RegisterSugarActivity.class));
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

                new AlertDialog.Builder(MainSugarActivity.this)
                        .setTitle("Delete User")
                        .setMessage("Do you really want to delete this User?")
                        .setNegativeButton("Nope", null)
                        .setPositiveButton("yeah, i hate this hoe!", new
                                DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        UserSugar userSugar = (userListAdapter.getItem(position));
                                        userSugar.delete();
                                        updateList();
                                    }
                                }).show();

                return true;
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, final long id) {
                new AlertDialog.Builder(MainSugarActivity.this)
                        .setTitle("Edit User")
                        .setMessage("Do you really want to edit this User?")
                        .setNegativeButton("No, that's ok",null)
                        .setPositiveButton("yas", new
                                DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent i = new Intent(MainSugarActivity.this, UpdateActivity.class);
                                        i.putExtra(Constants.EXTRA_UPDATE_ACTIVITY, userListAdapter.getItem(position));
                                        startActivity(i);

                                    }
                                }).show();

            }
        });

    }

    private void updateList(){
        List<UserSugar> userList = UserSugar.listAll(UserSugar.class);
        userListAdapter = new UserSugarListAdapter(this, userList);
        listView.setAdapter(userListAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateList();
    }
}
