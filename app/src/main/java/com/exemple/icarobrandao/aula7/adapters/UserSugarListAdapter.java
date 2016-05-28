package com.exemple.icarobrandao.aula7.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.icarobrandao.aula7.R;
import com.exemple.icarobrandao.aula7.models.User;
import com.exemple.icarobrandao.aula7.models.UserSugar;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by icarobrandao on 28/05/16.
 */
public class UserSugarListAdapter extends ArrayAdapter<UserSugar>{
    public UserSugarListAdapter(Context context, List<UserSugar> userList) {
        super(context, R.layout.item_user_list, userList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final ViewHolder holder;
        if (convertView == null) {
            convertView = View.inflate(getContext(), R.layout.item_user_list, null);
            holder = new ViewHolder();
            ButterKnife.bind(holder, convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        final UserSugar user = getItem(position);
        holder.name.setText(user.getName());
        holder.email.setText(user.getEmail());
        return convertView;
    }

    class ViewHolder{
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.email)
        TextView email;

    }
}
