The first step is to install in your project:

# npm install --save react-navigation

The second step is to install react-native-gesture-handler

# npm install --save react-native-gesture-handler

The third step is to install react-navigation-stack

# npm install --save react-navigation-stack

The fourth step is to install react-navigation-drawer & react-native-reanimated

# npm install react-navigation-drawer

# npm install react-native-reanimated

Android
Follow the steps below:

If you use one of the native navigation libraries (e.g. wix/react-native-navigation), you should follow this separate guide to get gesture handler library set up on Android. Ignore the rest of this step – it only applies to RN apps that use a standard Android project layout.

Update your MainActivity.java file (or wherever you create an instance of ReactActivityDelegate), so that it overrides the method responsible for creating ReactRootView instance and then use the root view wrapper provided by this library. Do not forget to import ReactActivityDelegate, ReactRootView, and RNGestureHandlerEnabledRootView:

package com.swmansion.gesturehandler.react.example;

import com.facebook.react.ReactActivity;
import com.facebook.react.ReactActivityDelegate;
import com.facebook.react.ReactRootView;
import com.swmansion.gesturehandler.react.RNGestureHandlerEnabledRootView;

public class MainActivity extends ReactActivity {

@Override
protected String getMainComponentName() {
return "Example";
}

@Override
protected ReactActivityDelegate createReactActivityDelegate() {
return new ReactActivityDelegate(this, getMainComponentName()) {
@Override
protected ReactRootView createRootView() {
return new RNGestureHandlerEnabledRootView(MainActivity.this);
}
}
}
}

The fifth step is to install react-navigation-tabs

# npm install react-navigation-tabs

IF you want to download media or any files from server install rn-fetch-blob

# npm install --save rn-fetch-blob

IF you want Gmail Authentication
use GoogleAuth.js from Utill

# npm install react-native-google-signin

IF you want Facebook Authentication
use FacebookAuth.js from Utill

# npm install react-native-fbsdk

     add these in strings.value for fb login
    <string name="facebook_app_id">57273595XXXXXX</string>
    <string name="fb_login_protocol_scheme">fb57273595XXXXXX</string>
