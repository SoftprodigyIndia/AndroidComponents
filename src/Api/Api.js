import {BASE_URL} from '../Constants';

//if you want download files from server 
// intall rn-fetch-blob library 
// And Uncomment downloadFile function
// import RNFetchBlob from 'rn-fetch-blob'

//This is the Base Method Which is used by every Api
async function callServer(URL, method, body) {
  var headers = {
    'Content-Type': 'application/json',
  };

  console.log('URL => ' + BASE_URL + URL);
  console.log('Method => ' + method);
  console.log('Headers => ' + JSON.stringify(headers));
  console.log('Request => ' + JSON.stringify(body));

  return fetch(BASE_URL + URL, {
    headers: headers,
    method: method,
    body: body,
  })
    .then(response => {
      console.log(JSON.stringify(response));
      return response.json();
    })
    .catch(function(error) {
      console.log(`Request failed=${BASE_URL + URL}`, error);
      reject(error);
    });
}

// To Call this method  
// var xx = await LoginApi(Body)
export async function LoginApi(body) {
  return await callServer(`/Login`, 'POST', body);
}

export async function LogoutApi(body) {
  return await callServer(`/Logout`, 'POST', body);
}
export async function GetHomeDeatilApi(videoId, body) {
  return await callServer(`/Homeinfo/${videoId}`, 'GET', body);
}

export async function GetProfileDeatilApi(body) {
  return await callServer(`/Profileinfo`, 'POST', body);
}

// TO Upload Any Type of file  Call this method
//======= upload Video =======
// var yy = await uploadFile( URL, post_id, "Video",videoPath+"_video.mp4", "video/mpeg", this );
//here "this" is used to send for current reference , through we get upload progress callback
//======= upload IMAGE =======
// var yy1 = await uploadFile( url, post_id, "Image", videoPath+"_poster.jpg", "image/jpeg" );
export async function uploadFile(
  uploadURL,
  fileName,
  filePath,
  type,
  callBack,
) {
  return new Promise(async function(resolve) {
    const file = {
      uri: 'file:///' + filePath,
      name: fileName,
      type: type,
    };

    const xhr = new XMLHttpRequest();
    xhr.open('PUT', uploadURL);
    xhr.setRequestHeader('Content-Type', type);
    // xhr.setRequestHeader('x-amz-acl', 'public-read');

    xhr.upload.addEventListener('progress', function(event) {
      if (callBack) callBack.handleProgress(event);
    });

    console.log('URL => ' + JSON.stringify(uploadURL));
    console.log('Request => ' + JSON.stringify(file));

    xhr.send(file);

    xhr.onerror = async function() {
      console.log('Error  => ' + uploadURL);
      resolve({success: false, error: 'Some Error.'});
    };

    xhr.onreadystatechange = e => {
      if (xhr.readyState !== 4) {
        return;
      }
      if (xhr.status === 200) {
        console.log('SUCCESS', xhr.responseText);
        // resolve(JSON.parse(xhr.responseText));
      } else {
        console.warn('request_error');
      }
    };
    xhr.onload = async function() {
      console.log('====File Successfully Uploaded====');
      resolve({success: true});
    };
  });
}


// export async function downloadFile(URL){
//     console.log('File Download URL ', URL)

//     return new Promise(async function(resolve) {
//     RNFetchBlob
//   .config({
//     // add this option that makes response data to be stored as a file,
//     // this is much more performant.
//     fileCache : true,
//   })
//   .fetch('GET', URL, {
//     //some headers ..
//   })
//   .then((res) => {
//     // the temp file path
//     console.log('The file saved to ', res.path())
//     resolve(res)
//   })})

// }
