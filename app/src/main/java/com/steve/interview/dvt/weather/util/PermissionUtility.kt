package com.steve.interview.dvt.weather.util

import android.Manifest
import android.content.Context
import pub.devrel.easypermissions.EasyPermissions

object PermissionUtility {

    fun hasLocationPermissions(context: Context) =

        EasyPermissions.hasPermissions(
            context,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION,
        )

}