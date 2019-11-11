/**
 *================= Code How to use =====================
 *     <GoogleAuth onResponse={this.gmailSignResonse}>
 *             <View style={styles.btn}>
 *             <Text>Gmail</Text>
 *             </View>
*          </GoogleAuth>
 */

import React, { Component } from 'react';
import { Text, View, ToastAndroid, AsyncStorage, Image, TouchableOpacity } from 'react-native';
import { GoogleSignin, GoogleSigninButton, statusCodes } from 'react-native-google-signin';
import PropTypes from 'prop-types';


class GoogleAuth extends Component {


    static navigationOptions = {
        header: null
    };

    componentDidMount() {

        GoogleSignin.configure({
            scopes: ['https://www.googleapis.com/auth/drive.readonly', 'email', 'profile'], // what API you want to access on behalf of the user, default is email and profile
            webClientId: '378551529825-2p56j5p96idimj26cet69qo0hhbvgo81.apps.googleusercontent.com', // client ID of type WEB for your server (needed to verify user ID and offline access)
            // offlineAccess: true, // if you want to access Google API on behalf of the user FROM YOUR SERVER
            //hostedDomain: '', // specifies a hosted domain restriction
            // loginHint: '', // [iOS] The user's ID, or email address, to be prefilled in the authentication UI if possible. [See docs here](https://developers.google.com/identity/sign-in/ios/api/interface_g_i_d_sign_in.html#a0a68c7504c31ab0b728432565f6e33fd)
            forceConsentPrompt: true, // [Android] if you want to show the authorization prompt at each login.
            // accountName: '', // [Android] specifies an account name on the device that should be used
            //iosClientId: '<FROM DEVELOPER CONSOLE>', // [iOS] optional, if you want to specify the client ID of type iOS (otherwise, it is taken from GoogleService-Info.plist)
        });
    }


    constructor(props) {
        super(props);
        this.state = {
            email: "",
            password: "",
            userInfo: null,
        };
    }



    _signIn = async () => {

        if (await GoogleSignin.isSignedIn()) {
            try {
                await GoogleSignin.revokeAccess();
                await GoogleSignin.signOut();
                alert("Logout Successfully")
            } catch (error) {
                console.error(error);
            }
        } else {
            try {
                await GoogleSignin.hasPlayServices();
                const userInfo = await GoogleSignin.signIn();
                // alert(JSON.stringify(userInfo.user.name))
                this.props.onResponse(userInfo)

            } catch (error) {
                if (error.code === statusCodes.SIGN_IN_CANCELLED) {
                    alert("SIGN_IN_CANCELLED")
                    // user cancelled the login flow
                } else if (error.code === statusCodes.IN_PROGRESS) {
                    alert("IN_PROGRESS")
                    // operation (f.e. sign in) is in progress already
                } else if (error.code === statusCodes.PLAY_SERVICES_NOT_AVAILABLE) {
                    alert("PLAY_SERVICES_NOT_AVAILABLE")
                    // play services not available or outdated
                } else {
                    alert("Error  " + JSON.stringify(error))
                    // some other error happened
                }
            }
        }
    }

    render() {
        return (
            <TouchableOpacity
                onPress={this._signIn}
                style={{ justifyContent: 'center' }} >
                {this.props.children}
            </TouchableOpacity>

        );
    }
}

GoogleAuth.propTypes = {
    onResponse: PropTypes.func,   // CallBack function used for return the Response
}

export { GoogleAuth };