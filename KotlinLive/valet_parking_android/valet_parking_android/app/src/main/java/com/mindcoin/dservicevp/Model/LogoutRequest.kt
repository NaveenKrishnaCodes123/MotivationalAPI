package com.mindcoin.dservicevp.Model

data class LogoutRequest(
    val userId: String,
    val activityTime: String,
    val osType: Int
)
