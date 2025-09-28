package com.mindcoin.dservicevp.Model

data class DeviceTokenResponse(
    val mssg: String,
    val status: Int,
    val content: List<DeviceTokenData>
)

data class DeviceTokenData(
    val uuid: String,
    val userId: String,
    val regToken: String,
    val osType: Int,
    val appVersion: String,
    val deviceInfo: String,
    val mobileId: String,
    val deviceId: String,
    val createdBy: String,
    val createdDate: String,
    val status: Int
)