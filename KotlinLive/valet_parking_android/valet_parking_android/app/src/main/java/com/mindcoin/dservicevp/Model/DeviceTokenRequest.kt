package com.mindcoin.dservicevp.Model

data class DeviceTokenRequest(
    val uuid: String,
    val userId: String,
    val regToken: String,
    val mobileId: String = "",
    val osType: Int = 0, // e.g., "android"
    val createdDate: String = "",
    val appVersion: String = "",
    val deviceInfo: String = "",
    val deviceId: String,
    val status: String = "1",
    val createdBy: String = "Admin"
)
