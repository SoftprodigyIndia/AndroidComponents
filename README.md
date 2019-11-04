***Steps for google sign In***::  
1. cd ProjectName
2. npm install react-native-google-signin --save
3. cd ios && pod install && cd ..
4. Set up firebase:: 
https://aboutreact.com/integrate-firebase-in-android-and-ios-app/
5. React-native run-android

**Additional Steps for IOS::** 
1. Add project in firebase and add info.plist file 
2. Add this line in pod file :: pod ‘Firebase/Analytics’
3.Run pod install 
4. Add :     
#import <Firebase.h>     
[FIRApp configure];
5.Add URL Scheme for google login   
 Click your project name in the project navigation bar in Xcode and go to ‘TARGETS’ -     > ‘Info’ -> ‘URL Types’. Then, Click ‘+’ button and add your reversed client ID to ‘URL  Schemes’. You can get your reversed client ID from the list name of REVERSED_CLIENT_ID in the ‘GoogleService-Info.plist’.

 Reference link::  https://aboutreact.com/integrate-firebase-in-android-and-ios-app/
