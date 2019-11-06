import React from 'react';
import {View, Image, TouchableOpacity} from 'react-native';
import {createAppContainer, createSwitchNavigator} from 'react-navigation';
import {createStackNavigator} from 'react-navigation-stack';
import {createDrawerNavigator} from 'react-navigation-drawer';
import {createMaterialTopTabNavigator} from 'react-navigation-tabs';
import {
  SplashScreen,
  LoginScreen,
  SignUpScreen,
  HomeScreen,
  ExploreScreen,
  ProfileScreen,
  DrawerScreen,
} from '../screens';

const SplashStack = createStackNavigator(
  {
    Splash: {screen: SplashScreen},
  },
  {
    headerMode: 'none',
  },
);

const LoginStack = createStackNavigator(
  {
    Login: {screen: LoginScreen},
    SignUp: {screen: SignUpScreen},
  },
  {
  },
);

const HomeStack = createStackNavigator(
  {
    Home: {screen: HomeScreen},
  },
  {
    initialRouteName: 'Home',
    headerMode: 'none',
  },
);

const ProfileStack = createStackNavigator(
  {
    Profile: {screen: ProfileScreen},
  },
  {
    initialRouteName: 'Profile',
    headerMode: 'none',
  },
);

const ExploreStack = createStackNavigator(
  {
    Explore: {screen: ExploreScreen},
  },
  {
    initialRouteName: 'Explore',
    headerMode: 'none',
  },
);

const HomeTabNavigator = createMaterialTopTabNavigator(
  {
    Home: {screen: HomeStack,
      navigationOptions: {
        tabBarIcon: ({ tintColor }) => (
          <Image source={require('../Assets/Images/menu.png')} />
        )
      }
    },
    Profile: {screen: ProfileStack},
    Explore: {screen: ExploreStack},
  },
  {
    initialRouteName: 'Home',
    tabBarPosition: 'bottom',
    tabBarOptions:{
      style:{ backgroundColor: "#000"},
    }
  },
);

const MainStack = createStackNavigator({
  HomeTab: {
    screen: HomeTabNavigator,

    navigationOptions: ({navigation}) => ({
      title: 'HomeTab',
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
            <Image source={require('../Assets/Images/menu.png')} />
          </TouchableOpacity>
        </View>
      ),
    }),
  },
});

const Drawer = createDrawerNavigator(
  {
    Drawer: {
      screen: MainStack,
    },
  },
  {
    initialRouteName: 'Drawer',
    contentComponent: DrawerScreen,
    drawerWidth: 220,
    drawerPosition: 'right',
    drawerType: 'slide',
    drawerLockMode: 'unlocked',
  },
);

const MainNavigator = createSwitchNavigator(
  {
    Splash: {screen: SplashStack},
    MainHome: {screen: Drawer},
    Login: {screen: LoginStack},
  },
  {
    initialRouteName: 'Splash',
  },
);

const AppContainer = createAppContainer(MainNavigator);

export default AppContainer;
