package com.example.go_to_meeting.adapters;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.example.go_to_meeting.R;
import com.example.go_to_meeting.listeners.UsersListener;
import com.example.go_to_meeting.models.User;

import java.util.ArrayList;
import java.util.List;

/*The RecyclerView.Adapter that last bound this RecyclerView.ViewHolder
 null if this RecyclerView.ViewHolder is not bound by any adapter*/

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    private List<User>users;
    private UsersListener usersListener;
    private List<User>selectedUsers;


    public UserAdapter(List<User> users,UsersListener usersListener)
    {
        this.users = users;
        this.usersListener=usersListener;
        selectedUsers=new ArrayList<>();

    }

    public List<User> getSelectedUsers() {
        return selectedUsers;
    }

    @NonNull
    @Override
   // creates and initializes the ViewHolder and its associated View
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
    // fetches the appropriate data and uses the data to fill in the view holder's layout
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        holder.setUserData(users.get(position));
    }

    @Override
    //calls this method to get the size of the data set
    public int getItemCount() {
        return users.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder {
        TextView textFirstChar, textUsername, textEmail;
        ImageView imageAudioMeeting, imageVideoMeeting;
        ConstraintLayout userContainer;
        ImageView imageSelected;

        UserViewHolder(@NonNull View itemView) {
            super(itemView);
            textFirstChar = itemView.findViewById(R.id.textFirstChar);
            textUsername = itemView.findViewById(R.id.textUsername);
            textEmail = itemView.findViewById(R.id.textEmail);
            imageAudioMeeting = itemView.findViewById(R.id.imageAudioMeeting);
            imageVideoMeeting = itemView.findViewById(R.id.imageVideoMeeting);
            userContainer=itemView.findViewById(R.id.userContainer);
            imageSelected=itemView.findViewById(R.id.imageSelected);

        }

        void setUserData(User user) {
            textFirstChar.setText(user.firstName.substring(0, 1));
            textUsername.setText(String.format("%s %s", user.firstName, user.lastName));
            textEmail.setText(user.email);
            imageAudioMeeting.setOnClickListener(v -> usersListener.initiateAudioMeeting(user));
            imageVideoMeeting.setOnClickListener(v -> usersListener.initiateVideoMeeting(user));
            userContainer.setOnLongClickListener(v -> {
                if (imageSelected.getVisibility() != View.VISIBLE) {
                    selectedUsers.add(user);
                    imageSelected.setVisibility(View.VISIBLE);
                    imageVideoMeeting.setVisibility(View.GONE);
                    imageAudioMeeting.setVisibility(View.GONE);
                    usersListener.onMultipleUsersAction(true);
                }
                return true;
            });
            userContainer.setOnClickListener(v -> {
                if(imageSelected.getVisibility()==View.VISIBLE)
                {
                    selectedUsers.remove(user);
                    imageSelected.setVisibility(View.GONE);
                    imageVideoMeeting.setVisibility(View.VISIBLE);
                    imageAudioMeeting.setVisibility(View.VISIBLE);
                    if(selectedUsers.size()==0)
                    {
                        usersListener.onMultipleUsersAction(false);
                    }

                }else{
                    if(selectedUsers.size()>0)
                    {
                        selectedUsers.add(user);
                        imageSelected.setVisibility(View.VISIBLE);
                        imageVideoMeeting.setVisibility(View.GONE);
                        imageAudioMeeting.setVisibility(View.GONE);
                    }
                }
            });


        }
    }

}
