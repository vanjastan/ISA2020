import { Component, OnInit } from '@angular/core';
import { Pharmacies } from 'src/app/components/models/pharmacies';
import { PharmaciesService } from 'src/app/services/pharmacies.service';

declare const L: any;

@Component({
  selector: 'app-header3',
  templateUrl: './header3.component.html',
  styleUrls: ['./header3.component.css']
})
export class Header3Component implements OnInit {

  constructor(){}
  
ngOnInit() {
  if (!navigator.geolocation) {
    console.log('location is not supported');
  }
  navigator.geolocation.getCurrentPosition((position) => {
    const coords = position.coords;
    const latLong = [44.820514, 20.467972];
    const latLong1 = [44.813008, 20.455033];

    console.log(
      `lat: ${position.coords.latitude}, lon: ${position.coords.longitude}`
    );
    let mymap = L.map('map').setView(latLong, 13);

    L.tileLayer(
      'https://api.mapbox.com/styles/v1/{id}/tiles/{z}/{x}/{y}?access_token=pk.eyJ1Ijoic3VicmF0MDA3IiwiYSI6ImNrYjNyMjJxYjBibnIyem55d2NhcTdzM2IifQ.-NnMzrAAlykYciP4RP9zYQ',
      {
        attribution:
          'Map data &copy; <a href="https://www.openstreetmap.org/">OpenStreetMap</a> contributors, <a href="https://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
        maxZoom: 18,
        id: 'mapbox/streets-v11',
        tileSize: 512,
        zoomOffset: -1,
        accessToken: 'your.mapbox.access.token',
      }
    ).addTo(mymap);

    let marker = L.marker(latLong).addTo(mymap);
    let marker1 = L.marker(latLong1).addTo(mymap);

    marker.bindPopup('<b>Benu</b>').openPopup();
    marker1.bindPopup('<b>Benu</b>').openPopup();

    let popup1 = L.popup()
      .setLatLng(latLong1)
      .setContent('Benu pharmacy')
      .openOn(mymap);

    let popup = L.popup()
      .setLatLng(latLong)
      .setContent('Benu pharmacy')
      .openOn(mymap);
  });
  this.watchPosition();
}

watchPosition() {
  let desLat = 0;
  let desLon = 0;
  let id = navigator.geolocation.watchPosition(
    (position) => {
      console.log(
        `lat: ${position.coords.latitude}, lon: ${position.coords.longitude}`
      );
      if (position.coords.latitude === desLat) {
        navigator.geolocation.clearWatch(id);
      }
    },
    (err) => {
      console.log(err);
    },
    {
      enableHighAccuracy: true,
      timeout: 5000,
      maximumAge: 0,
    }
  );
}
}

