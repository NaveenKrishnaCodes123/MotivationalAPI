package com.mindcoin.dservicevp.Model

data class UpdatePasswordRequest(
    val password: String,
    val userId: String,
    val newPassword: String
)
