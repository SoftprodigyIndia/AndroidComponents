import React, { Component } from 'react';
import { Text, View } from 'react-native';
import Customtab from '../CustomNav/Customtab'
export default class ProfileScreen extends Component {
  render() {
    return (
      <View style={{ flex: 1, justifyContent: "center", alignItems: "center" }}>
        <Text  style={{fontSize:28}}>Profile Screen</Text>
        <Customtab navigation={this.props.navigation} active={2}/>
      </View>
    );
  }
}
