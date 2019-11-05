import React, {Component} from 'react';
import {Text, StyleSheet, View, TouchableOpacity, Image,ScrollView} from 'react-native';
import EStyleSheet from 'react-native-extended-stylesheet';

export default class Customtab extends Component {
  constructor(props) {
    super(props);
    this.state = {
      color: 'black',
      HomeScreen: false,
      ProfileScreen: false,
      InfoScreen: false,
      //Navigator Variables
    };
  }

  //Check which screen is active and set true.
  Check() {
    const num = this.props.active;

    switch (num) {
      case 0:
        return;
      case 1:
        this.setState({
          HomeScreen: true,
          ProfileScreen: false,
          InfoScreen: false,
        });
        return;
      case 2:
        this.setState({
          HomeScreen: false,
          ProfileScreen: true,
          InfoScreen: false,
        });
        return;
      case 3:
        this.setState({
          HomeScreen: false,
          ProfileScreen: false,
          InfoScreen: true,
        });
        return;
    }
  }

  componentDidMount() {
    this.Check();
  }
//below we have to give image and title to tabs 
  render() {
    const navigation = this.props.navigation;

    return (
     
      <View
        style={{
          flexDirection: 'row',
          height: EStyleSheet.value('3.8rem'),
          width: '100%',
          backgroundColor: 'darkblue',
          bottom: 0,
          top:0,
          position: 'absolute',
        }}>
        <TouchableOpacity
             onPress={() => navigation.replace('Home')}
             activeOpacity={1.0}
          style={{
            flex: 1,
            height: '100%',
            justifyContent: 'space-around',
            alignItems: 'center',
          }}>
      
          <Text
            style={{
              color: this.state.HomeScreen ? '#FFFFFF' : '#7A8691',
              fontWeight: 'bold',
              fontSize: EStyleSheet.value('0.8rem'),
              fontFamily: 'raleway',
              marginBottom: EStyleSheet.value('0.5rem'),
            }}>
            Home
          </Text>
        </TouchableOpacity>

        <TouchableOpacity
          onPress={() => navigation.replace('Profile')}
          activeOpacity={1.0}
          style={{
            flex: 1,
            height: '100%',
            justifyContent: 'space-around',
            alignItems: 'center',
          }}>
      
          <Text
            style={{
              color: this.state.ProfileScreen ? 'white' : '#7A8691',
              fontWeight: 'bold',
              fontSize: EStyleSheet.value('0.8rem'),
              fontFamily: 'raleway',
              marginBottom: EStyleSheet.value('0.5rem'),
            }}>
            Profile
          </Text>
        </TouchableOpacity>

        <TouchableOpacity
          onPress={() => navigation.replace('Info')}
          activeOpacity={1.0}
          style={{
            flex: 1,
            height: '100%',
            justifyContent: 'space-around',
            alignItems: 'center',
          }}>

          <Text
            style={{
              color: this.state.InfoScreen ? 'white' : '#7A8691',
              fontWeight: 'bold',
              fontSize: EStyleSheet.value('0.8rem'),
              fontFamily: 'raleway',
              marginBottom: EStyleSheet.value('0.5rem'),
            }}>
            Info
          </Text>
        </TouchableOpacity>
      </View>
      
    );
  }
}
