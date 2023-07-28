package com.example.amobacodingchallenge.ui.patient_map_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.amobacodingchallenge.domain.entities.PatientLocation
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker

@Composable
fun MapScreenView(
     location: PatientLocation
) {

    val marker = LatLng(location.latitude, location.longitude)
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {

        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            GoogleMap(modifier = Modifier.fillMaxSize()) {
                Marker(position = marker)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MapViewPreview() {
 MapScreenView(location = PatientLocation(-16.63916,-28.270833))
}