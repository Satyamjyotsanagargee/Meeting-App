package com.example.go_to_meeting.utilities;

import java.util.HashMap;
//Here we are using constant because  most of things are in key value pair to avoid mistakes while writing key
public class Constants {
    //Create shared preference name and also create key name
    public static String KEY_COLLECTION_USERS="users";
    public static String KEY_FIRST_NAME="first_name";
    public static String KEY_LAST_NAME="last_name";
    public static String KEY_EMAIL="email";
    public static String KEY_PASSWORD="password";
    public static String KEY_USER_ID="USER_ID";
    public static String KEY_FCM_TOKEN="fcm_token";
    public static final String KEY_PREFERENCE_NAME="VideoMeetingPreference";
    public static final String KEY_IS_SIGNED_IN="IsSignedIn";
    //Headers for API request
    public static final String REMOTE_MSG_AUTHORIZATION="Authorization";
    public static final String REMOTE_MSG_CONTENT_TYPE="Content-Type";
    //For sending custom data with remote message
    public static final String REMOTE_MSG_TYPE="type";
    public static final String REMOTE_MSG_INVITATION="invitation";
    public static final String REMOTE_MSG_MEETING_TYPE="meetingType";
    public static final String REMOTE_MSG_INVITER_TOKEN="inviterToken";
    public static final String REMOTE_MSG_DATA="data";
    public static final String REMOTE_MSG_REGISTRATION_IDS="registration_ids";
    public static final String REMOTE_MSG_INVITATION_RESPONSE="invitationResponse";
    public static final String REMOTE_MSG_INVITATION_ACCEPTED="accepted";
    public static final String REMOTE_MSG_INVITATION_REJECTED="rejected";
    public static final String REMOTE_MSG_INVITATION_CANCELLED="cancelled";
    //For meeting room
    public static final String REMOTE_MSG_MEETING_ROOM="meetingRoom";


    public static HashMap<String, String> getRemoteMessageHeaders() {
        //HashMap is for headers
        HashMap<String, String> headers = new HashMap<>();
        headers.put(
        //Authorization for headers
                Constants.REMOTE_MSG_AUTHORIZATION,
                //Server key which need in headers of API request
                //Server key copied from firebase console
                "key= AAAAxQmtrkc:APA91bGj-ryfmnIYJWBfhiycfCsx4y9_N3vEeH82H6_OPPtLOAlE3BrTF_F7iijXJozmsnJeumrP3kc9-8B2Md8U5UB_eLYBSRUmZksAabx11EOeVgZMAjdRxBLdHlcFRsX1kYnwMKiW"

        );
        //Content type header
        headers.put(Constants.REMOTE_MSG_CONTENT_TYPE, "application/json");
        return headers;

    }
}
