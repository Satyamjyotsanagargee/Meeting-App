package com.example.go_to_meeting.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.go_to_meeting.R;
import com.example.go_to_meeting.listeners.UsersListener;

import com.example.go_to_meeting.models.User;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    private List<User>users;
    private UsersListener usersListener;

    public UserAdapter(List<User> users,UsersListener usersListener)
    {
        this.users = users;
        this.usersListener=usersListener;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new UserViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.item_container_user,
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
     holder.setUserData(users.get(position));
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

     class UserViewHolder extends RecyclerView.ViewHolder{
    TextView textFirstChar,textUsername,textEmail;
    ImageView imageAudioMeeting,imageVideoMeeting;
    UserViewHolder(@NonNull View itemView) {
        super(itemView);
        textFirstChar=itemView.findViewById(R.id.textFirstChar);
        textUsername=itemView.findViewById(R.id.textUsername);
        textEmail=itemView.findViewById(R.id.textEmail);
        imageAudioMeeting=itemView.findViewById(R.id.imageAudioMeeting);
        imageVideoMeeting=itemView.findViewById(R.id.imageVideoMeeting);

    }
    void setUserData(User user)
    {
        textFirstChar.setText(user.firstName.substring(0,1));
        textUsername.setText(String.format("%s %s",user.firstName,user.lastName));
        textEmail.setText(user.email);
        imageAudioMeeting.setOnClickListener(v -> usersListener.initiateAudioMeeting(user));
        imageVideoMeeting.setOnClickListener(v -> usersListener.initiateVideoMeeting(user));

    }
}

}
