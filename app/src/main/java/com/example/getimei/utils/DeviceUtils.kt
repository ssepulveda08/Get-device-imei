package com.example.getimei.utils

import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.provider.Settings
import androidx.core.content.ContextCompat

@SuppressLint("MissingPermission", "HardwareIds")
fun getDeviceID(context: Context): String {
    return Settings.Secure.getString(
        context.contentResolver,
        Settings.Secure.ANDROID_ID
    )
}

private fun checkPermissionManifest(context: Context, permission: String): Boolean =
    ContextCompat.checkSelfPermission(
        context,
        permission
    ) == PackageManager.PERMISSION_GRANTED

