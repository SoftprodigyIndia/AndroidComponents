import React from 'react';
import {View,Text} from 'react-native'

export class SplashScreen extends React.Component{
  constructor(props){
    super(props)
  }
  componentDidMount() {
    setTimeout(
      () => {
        this._bootstrapAsync();
      },
      1 * 2000
    );
  }
  render(){
    return (
      <View>
        <Text>Splash Screen</Text>
      </View>
    )
  }


_bootstrapAsync = async () => {
 // const userToken = await AsyncStorage.getItem("userToken");
  this.props.navigation.navigate(true ? "MainHome" : "Login");
};


}