import 'dart:async';

import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:geolocator/geolocator.dart';
import 'package:google_maps_flutter/google_maps_flutter.dart';

class Mapview extends StatefulWidget {
  Mapview({Key key, this.title}) : super(key: key);
  final String title;

  @override
  _MapviewState createState() => _MapviewState();
}

class _MapviewState extends State<Mapview> {
  Completer<GoogleMapController> _controller = Completer();
  static const LatLng _center = const LatLng(45.521563, -122.677433);

  var _markers;
  void _onMapCreated(GoogleMapController controller) {
    _controller.complete(controller);
  }



  @override
  Widget build(BuildContext context) {
    GoogleMapController _controller;
    return Scaffold(
        appBar: AppBar(
          title: Text(widget.title),
        ),
        body:Stack(
          children: <Widget>[
            googlemaps(),
            Padding(
              padding: const EdgeInsets.all(16.0),
              child: Align(
                alignment: Alignment.topRight,
                child: FloatingActionButton(
                  onPressed: () => print('button pressed'),
                  materialTapTargetSize: MaterialTapTargetSize.padded,
                  backgroundColor: Colors.green,
                  child: const Icon(Icons.map, size: 36.0),
                ),
              ),
            ),
           /* FloatingActionButton(
              onPressed: _createMarker,
              materialTapTargetSize: MaterialTapTargetSize.padded,
              backgroundColor: Colors.green,
              child: const Icon(Icons.add_location, size: 36.0),
            )*/
          ],
        ));
  }
  void _onMapTypeButtonPressed() {
    setState(() {
      MapType.normal;
    });
  }

  Widget googlemaps() {
    return GoogleMap(
      /*mapType: MapType.normal,
      zoomGesturesEnabled: true,
      tiltGesturesEnabled: false,
      markers: _createMarker(),*/
      initialCameraPosition:
      CameraPosition(target: _center, zoom: 12.0),
      onMapCreated: _onMapCreated

    );
  }
  /*void _onAddMarkerButtonPressed() {
    setState(() {
      _markers.add(Marker(
// This marker id can be anything that uniquely identifies each marker.
        markerId: MarkerId(_lastMapPosition.toString()),
        position: _lastMapPosition,
        infoWindow: InfoWindow(
          title: 'Really cool place',
          snippet: '5 Star Rating',
        ),
        icon: BitmapDescriptor.defaultMarker,
      ));
    });
  }
*/
  /*void getCurrentLocation() async {
    Position res = await Geolocator().getCurrentPosition();
    setState(() {
      position=res;
      _child=googlemaps();

    });
  }*/

  /*Set<Marker> _createMarker() {
    return<Marker>[Marker(
        markerId: MarkerId('demo'),
        position: LatLng(position.latitude,position.longitude),
        icon: BitmapDescriptor.defaultMarker,
        infoWindow: InfoWindow(title: "Demo")
    )].toSet();
  }*/
}