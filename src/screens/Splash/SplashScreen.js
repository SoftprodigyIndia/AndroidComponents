import React from 'react';
import {View,Text,StyleSheet,StatusBar} from 'react-native'

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
      <View style={styles.containerStyle}>
        <StatusBar hidden/>
        <Text style={{fontSize:20}}>Splash Screen</Text>
      </View>
    )
  }


_bootstrapAsync = async () => {
 // const userToken = await AsyncStorage.getItem("userToken");
  this.props.navigation.navigate(false ? "MainHome" : "Login");
};

}

const styles = StyleSheet.create({
  containerStyle: {
    flex: 1,
    backgroundColor: 'powderblue',
    alignItems:'center',justifyContent:'center'
  },
});
