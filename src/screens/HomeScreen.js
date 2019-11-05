import React, { Component } from 'react';
import { Text, View } from 'react-native';
import Customtab from '../CustomNav/Customtab'

export default class HomeScreen extends Component {
  render() {
    return (
      <View style={{ flex: 1, justifyContent: "center", alignItems: "center" }}>
        <Text style={{fontSize:28}}>Home Screen</Text>
        <Customtab navigation={this.props.navigation} active={1}/>
      </View>
    );
  }
}
