import React from 'react';
import {
  View,
  Text,
  Button,
  StatusBar,
  StyleSheet,
  TouchableOpacity,
  Image,
} from 'react-native';
import {requestWriteExternalStorage} from '../../Permissions/Permission';
import {KeyboardView} from '../../components/index';

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
    headerRight: (
      <View style={{}}>
        <TouchableOpacity
          onPress={() => {
            navigation.openDrawer();
          }}
          style={{marginRight: 10}}>
          <Image source={require('../../Assets/Images/menu.png')} />
        </TouchableOpacity>
      </View>
    ),
  });

  componentDidMount() {
    this._navListener = this.props.navigation.addListener('didFocus', () => {
      StatusBar.setBarStyle('dark-content');
      StatusBar.setBackgroundColor('#2f2f2f');
      StatusBar.setHidden(false);
    });
    this.permission();
  }

  permission = async () => {
    const abc = await requestWriteExternalStorage();
    console.log(abc);
  };

  render() {
    return (
      <KeyboardView style={styles.containerStyle}>
      <Text>Home Screen</Text>
      </KeyboardView>
    );
  }
}

const styles = StyleSheet.create({
  containerStyle: {
    flex: 1,
    backgroundColor: 'powderblue',
  },
});

export {HomeScreen};
