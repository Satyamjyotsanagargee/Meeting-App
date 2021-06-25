package com.example.go_to_meeting.listeners;

import com.example.go_to_meeting.models.User;

public interface UsersListener {

    void initiateVideoMeeting(User user);
    void initiateAudioMeeting(User user);
}
