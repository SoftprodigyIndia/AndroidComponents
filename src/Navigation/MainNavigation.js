import {createAppContainer,createSwitchNavigator} from 'react-navigation';
import {createStackNavigator} from 'react-navigation-stack';
import {
  SplashScreen,
  LoginScreen,
  SignUpScreen,
  HomeScreen,
  ExploreScreen,
  ProfileScreen,
} from '../screens';

const HomeStack = createStackNavigator({
  Home: {screen: HomeScreen},
} ,{
    headerMode: "screen",
    navigationOptions: {
    headerVisible: true
  }});

const ProfileStack = createStackNavigator({
  Profile: {screen: ProfileScreen},
});

const ExploreStack = createStackNavigator({
  Explore: {screen: ExploreScreen},
});

const LoginStack = createStackNavigator({
  Login: {screen: LoginScreen},
  SignUp: {screen: SignUpScreen},
},{
    initialRouteName:'Login',
    headerMode:'none'
});

const HomeNavigatorStack = createStackNavigator({
  Home: {screen: HomeStack},
  Profile: {screen: ProfileStack},
  Explore: {screen: ExploreStack},
},
{
    initialRouteName: 'Home',
    headerMode:'none'
  
});

const SplashStack = createStackNavigator({
    Splash: {screen: SplashScreen},
  },{
      headerMode:'none'
  });

const MainNavigator = createSwitchNavigator(
  {
    Splash: {screen: SplashStack},
    MainHome: {screen: HomeNavigatorStack},
    Login: {screen: LoginStack},
  },
  {
    initialRouteName: 'Splash',
  },
);

const AppContainer = createAppContainer(MainNavigator);

export default AppContainer;
