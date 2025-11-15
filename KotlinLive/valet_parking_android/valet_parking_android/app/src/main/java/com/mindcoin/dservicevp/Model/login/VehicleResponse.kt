package com.mindcoin.dservicevp.Model.login

data class VehicleResponse(
    val mssg: String,
    val content: List<List<Vehicle>>,
    val status: Int
)
data class Vehicle(
    val uuid: String,
    val parkingId: String,
    val userId: String,
    val checkOutRequestedType: Int,
    val vehicleNo: String,
    val vehicleType: String,
    val checkOutRequestedTime: String,
    val hookNo: String,
    val notes: String,
    val imageUrl: String?,
    val inTime: String,
    val outTime: String?,
    val createdDate: String,
    val modifiedDate: String,
    val status: Int
)

