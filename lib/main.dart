import 'package:flutter/material.dart';
import 'package:flutter_googlemaps/maps.dart';
import 'package:flutter_spinkit/flutter_spinkit.dart';
import 'package:geolocator/geolocator.dart';
import 'package:google_maps_flutter/google_maps_flutter.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: Map(),
    );
  }
}

class MyHomePage extends StatefulWidget {
  MyHomePage({Key key, this.title}) : super(key: key);
  final String title;

  @override
  _MyHomePageState createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {

  Position position;
  Widget _child;
  @override

  void initState() {
    getCurrentLocation();
    _child=SpinKitRipple(color: Colors.amberAccent,
      size: 50.0,);
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    GoogleMapController _controller;
    return Scaffold(
        appBar: AppBar(
          title: Text(widget.title),
        ),
        body:_child);
  }

  Widget googlemaps() {
    return GoogleMap(
      mapType: MapType.normal,
      zoomGesturesEnabled: true,
      tiltGesturesEnabled: false,
      markers: _createMarker(),
      initialCameraPosition:
          CameraPosition(target: LatLng(position.latitude,position.longitude), zoom: 12.0),
      onMapCreated: (GoogleMapController controller) {
        var _controller = controller;

      },

    );
  }

  void getCurrentLocation() async {
    Position res = await Geolocator().getCurrentPosition();
    setState(() {
      position=res;
      _child=googlemaps();

    });
  }

  Set<Marker> _createMarker() {
    return<Marker>[Marker(
      markerId: MarkerId('demo'),
      position: LatLng(position.latitude,position.longitude),
      icon: BitmapDescriptor.defaultMarker,
      infoWindow: InfoWindow(title: "Demo")
    )].toSet();
  }
}
