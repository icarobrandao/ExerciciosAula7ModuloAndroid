package com.exemple.icarobrandao.aula7.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.icarobrandao.aula7.R;
import com.exemple.icarobrandao.aula7.models.User;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by icarobrandao on 21/05/16.
 */
public class UserListAdapter extends ArrayAdapter<User> {

    public UserListAdapter(Context context, List<User> userList) {
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
        final User user = getItem(position);
        holder.name.setText(user.getNome());
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
