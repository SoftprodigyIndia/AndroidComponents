import React from 'react';
import {View, Text, Button, StatusBar} from 'react-native';
import {requestWriteExternalStorage} from '../../Permissions/Permission';

class HomeScreen extends React.Component {
  constructor(props) {
    super(props);
  }
  static navigationOptions = ({navigation}) => ({
    title: 'Home',
    headerStyle: {
      backgroundColor: '#2f2f2f',
    },
    headerTintColor: '#fff',
    headerTitleStyle: {
      //  fontSize: 18,
    },
  });

  componentDidMount() {
    this._navListener = this.props.navigation.addListener('didFocus', () => {
      StatusBar.setBarStyle('light-content');
      StatusBar.setBackgroundColor('red');
      StatusBar.setHidden(false);
    });
    this.permission();
  }

  permission = async () => {
    const abc = await requestWriteExternalStorage();
    alert(abc);
  };

  render() {
    return (
      <View>
        <Text>Home screen</Text>
      </View>
    );
  }
}
export {HomeScreen};
