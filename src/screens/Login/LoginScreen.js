import React from 'react';
import { KeyboardView } from '../../components'
import { View, Text, StyleSheet, TextInput, Button, ScrollView, TouchableOpacity } from 'react-native'
import { GoogleAuth } from '../../Utill/GoogleAuth';
import { FacebookAuth } from '../../Utill/FacebookAuth'

export class LoginScreen extends React.Component {
  constructor(props) {
    super(props)
    this.state = {
      Email: '',
      Password: ''
    }
  }

  validate = () => {

    if (this.state.Email == "") {
      alert("Username is empty");
    } else if (this.state.Password.length <= 5) {
      alert("Password must contains atleast 6 characters ");
    } else if (this.state.Email != "" && this.state.Password.length > 5) {
      //Hit api 
      this.props.navigation.navigate('Home')
    }
    else
      alert("Please Check Your Internet Connection");
  }

  gmailSignResonse = (response) => {
    console.log(response.tostring())
    alert(JSON.stringify(response.user.name))
  }

  FacebookSignResonse = (response) => {
    console.log(response)
    alert(JSON.stringify(response))
  }

  render() {
    return (
      <KeyboardView style={styles.containerStyle}>
        <ScrollView>
          <View>
            <TextInput placeholder="Email"
              returnKeyType={"next"}
              blurOnSubmit={false}
              onSubmitEditing={() => { this.password.focus(); }}
              onChangeText={text => this.setState({ Email: text })}
              style={[styles.email_pass_fields, { marginTop: 150 }]}
            />
            <TextInput placeholder="Password"
              secureTextEntry={true}
              ref={(input) => { this.password = input; }}
              onChangeText={text => this.setState({ Password: text })}
              style={styles.email_pass_fields}
            />
            <TouchableOpacity style={styles.btn} onPress={this.validate}>
              <Text style={{ fontSize: 18 }}>
                Log In
              </Text>
            </TouchableOpacity>
            <TouchableOpacity style={styles.btn} onPress={() => this.props.navigation.navigate("SignUp")}>
              <Text style={{ fontSize: 18 }}>
                Sign Up
              </Text>
            </TouchableOpacity>

            <GoogleAuth onResponse={this.gmailSignResonse}>
              <View style={styles.btn}>
                <Text>Gmail</Text>
              </View>
            </GoogleAuth>
            <FacebookAuth onResponse={this.FacebookSignResonse}>
              <View style={styles.btn}>
                <Text>Facebook</Text>
              </View>
            </FacebookAuth>
          </View>
        </ScrollView>
      </KeyboardView>
    )
  }
}
const styles = StyleSheet.create({
  containerStyle: {
    height: '100%',
    justifyContent: 'center'
  },
  email_pass_fields: {
    borderWidth: 1,
    borderColor: '#000',
    margin: 10,
    borderRadius: 10,
    paddingLeft: 10
  },
  btn: {
    margin: 10,
    height: 40,
    borderWidth: 1,
    borderColor: 'gray',
    backgroundColor: 'powderblue',
    borderRadius: 10,
    alignItems: 'center',
    fontSize: 15,
    justifyContent: 'center'
  }
});
