package com.example.go_to_meeting.listeners;

import com.example.go_to_meeting.models.User;
//To initiate video or audio meeting with any user we use this listener class

public interface UsersListener {

    void initiateVideoMeeting(User user);

    void initiateAudioMeeting(User user);
    void onMultipleUsersAction(Boolean isMultipleUsersSelected);

}
