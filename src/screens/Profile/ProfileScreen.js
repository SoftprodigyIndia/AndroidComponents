import React from 'react';
import {View,Text} from 'react-native'

export class ProfileScreen extends React.Component{
  static navigationOptions = ({navigation}) => ({
    title: 'Profile',
    headerStyle: {
      backgroundColor: '#2f2f2f',
    
    },
    headerTintColor: '#fff',
    headerTitleStyle: {
      fontSize: 16,
    },
  });
  render(){
    return (
      <View>
        <Text>Profile Screen </Text>
      </View>
    )
  }
}