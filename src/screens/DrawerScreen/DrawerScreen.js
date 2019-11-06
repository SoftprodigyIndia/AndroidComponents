import React, { Component } from "react";
import {
  ScrollView,
  Text,
  View,
  TouchableOpacity,
  StyleSheet
} from "react-native";

const MenuItem = ({ text, onpress }) => (
  <TouchableOpacity onPress={onpress} style={styles.singleMenuItem}>
    <View style={styles.icon}></View>
    <Text style={styles.menuItemName}>{text}</Text>
  </TouchableOpacity>
);

class DrawerScreen extends Component {

  render() {
    return (
      <View style={styles.root}>
        <Text style={styles.Label}>USER_NAME</Text>
        <ScrollView>
          <View style={styles.divider}></View>
          <View style={{ margin: 11, flex: 1 }}>
            <MenuItem text="Hello1" />
            <MenuItem text="Hello2" />
            <MenuItem text="Hello3" />
          </View>
        </ScrollView>
        <View
          style={[styles.divider,{
            alignSelf: "baseline"
          }]}
        ></View>
        <TouchableOpacity
          onPress={this.logOut}
          style={[styles.singleMenuItem,{
            alignSelf: "baseline",
            margin:10
          }]}
        >
          <View
            style={styles.icon}
          ></View>
          <Text style={styles.menuItemName}>
            Log Out
          </Text>
        </TouchableOpacity>
      </View>
    );
  }
}

const styles = StyleSheet.create({
  root: {
    flex: 1,
    backgroundColor: "#FFF"
    // alignItems: "center",
  },
  Label: {
    color: "#000",
    margin: 16,
    fontWeight: "bold",
    fontSize: 16
  },
  divider: {
    height: 1,
    width: "100%",
    backgroundColor: "lightgray"
  },
  singleMenuItem: {
    flexDirection: "row",
    alignItems: "center",
    marginBottom: 15
  },
  icon: {
    height: 20,
    width: 20,
    backgroundColor: "#000"
  },
  menuItemName: {
    color: "#000",
    marginLeft: 12,
    fontSize: 16
  }
});

export  {DrawerScreen};
