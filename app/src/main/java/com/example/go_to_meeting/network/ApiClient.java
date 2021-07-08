package com.example.go_to_meeting.network;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class ApiClient {

    private static Retrofit retrofit = null;
    //Here we are using retrofit for sending remote messages using firebase cloud messaging

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()

                    .baseUrl("https://fcm.googleapis.com/fcm/")
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .build();

        }
        return retrofit;
    }
}
