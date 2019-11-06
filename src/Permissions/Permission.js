import {PermissionsAndroid} from 'react-native';

export async function requestWriteExternalStorage () {
    try {
      const granted = await PermissionsAndroid.request(
        PermissionsAndroid.PERMISSIONS.WRITE_EXTERNAL_STORAGE
      );
      if (granted === PermissionsAndroid.RESULTS.GRANTED) {
      return true
      } else {
      return false
      }
    } catch (err) {
      console.warn("AT Permission.js ===>"+err);
    }
  }