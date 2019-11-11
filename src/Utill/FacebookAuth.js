/**
 *================= Code How to use =====================
 *   <FacebookAuth onResponse={this.FacebookSignResonse}>
              <View style={styles.btn}>
                <Text>Facebook</Text>
              </View>
            </FacebookAuth>
 */

import React, { Component } from 'react';
import { Text, View, ToastAndroid, AsyncStorage, Image, TouchableOpacity } from 'react-native';
import PropTypes from 'prop-types';
import { AccessToken } from 'react-native-fbsdk'
const FBSDK = require('react-native-fbsdk');
const {
    LoginManager,
} = FBSDK;


var that = null

class FacebookAuth extends Component {


    static navigationOptions = {
        header: null
    };

    componentDidMount() {
        that = this
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

        LoginManager.logOut()
        // Attempt a login using the Facebook login dialog,
        // asking for default permissions.
        LoginManager.logInWithPermissions(['public_profile']).then(
            function (result) {
                if (result.isCancelled) {
                    alert('Login was cancelled');
                } else {
                    console.log('Login was successful with permissions: '
                        + result.grantedPermissions.toString());
                    AccessToken.getCurrentAccessToken().then(
                        (data) => {

                            console.log("Access Token  =>>  " + data.accessToken.toString())
                            that.callback(data.accessToken.toString())
                        }
                    )
                }
            },
            function (error) {
                alert('Login failed with error: ' + error);
            }
        );
    }
    callback = (token) => {

        this.props.onResponse(token);
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

FacebookAuth.propTypes = {
    onResponse: PropTypes.func,   // CallBack function used for return the Response
}

export { FacebookAuth };