# Meeting-App
![image](https://user-images.githubusercontent.com/72026578/125147851-a9a6a680-e14b-11eb-817f-4d7f14a68864.png)

## About the App
An android application for a video/audio meeting/conference and many more which uses Firebase as its back-end. The concept of the app is similar to Microsft Team app.It uses Firebase Authentication for authentication, Firebase Cloud Firestore as its database, Firebase Cloud Storage as the storage and Firebase Cloud Messaging as the notification and messaging service. It uses Jitsi Meet SDK for the voice/video calling,chatting etc.
## Tech Stack Used
Android, Android Studio, XML, Firebase, Java

### Current Look of the App

<img src="https://user-images.githubusercontent.com/72026578/125152778-a2dc5b80-e16c-11eb-9309-53b2a1edf53b.png" width="25%"></img> <img src="https://user-images.githubusercontent.com/72026578/125152800-d8814480-e16c-11eb-85cc-7975568814d2.png" width="25%"></img><img src="https://user-images.githubusercontent.com/72026578/125152929-df5c8700-e16d-11eb-80b7-5950fdc0f410.png" width="25%"></img>

<img src="https://user-images.githubusercontent.com/72026578/125153066-f51e7c00-e16e-11eb-8159-f237f73221fb.png" width="25%"></img> <img src="https://user-images.githubusercontent.com/72026578/125153121-4e86ab00-e16f-11eb-8115-d6ddbb8d958e.png" width="25%"></img> <img src="https://user-images.githubusercontent.com/72026578/125153206-cc4ab680-e16f-11eb-8280-e98303fb1306.png" width="25%"></img>

### Project Overview
When u come on the app for the first time it welcomes with splash screen along with onboarding screen afterwards users will sign up for their account using some basic details. To store all of the user data we will be using the cloud fire store database, which is a flexible and scalable database for mobile, web, and server development from Firebase 
and Google Cloud Platform.After sign up, the user will sign in to their account. We will store logged 
user information into shared preferences to handle auto-sign in so users don't need to enter email 
and password every time.
After sign in, we will display a list of other users that are signed up in our application except for the 
currently logged user because nobody is going to start a video meeting with himself.
In a video meeting, the user will initiate the video meeting by sending a meeting invitation to another user.To send a meeting invitation we will use firebase cloud messaging which is a cross platform messaging solution that lets you reliably send messages at no cost. Using FCM, you can 
notify a client app that a new email or other data is available to sync.
Once the meeting invitation sent, the receiver has two options, accept or reject the invitation.On acceptance or rejection, the related response message will be sent to the meeting initiator or sender. If the user wants to cancel the meeting invitation, then it can be done by the hang-up process, in which another remote message will be sent to the receiver to cancel the current meeting invitation. This is the complete meeting invitation process. On acceptance of the meeting invitation, the video meeting will start using the Jitsi Meet and also do chatting and lot of stuff.





