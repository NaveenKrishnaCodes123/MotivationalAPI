package com.mindcoin.dservicevp

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import com.fasterxml.jackson.annotation.JsonSetter
import com.fasterxml.jackson.annotation.Nulls
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)
        Log.v("FCM", "FCM data: ${remoteMessage.data}")

        try {
            val dataMap = remoteMessage.data

            if (dataMap.isNotEmpty()) {
                val gsonJack = getJackJsonMapper()
                val jsonData = gsonJack.writeValueAsString(dataMap)
                val pushType = dataMap["pushType"]?.lowercase()
               // MyWorkerUtils().notificationTask(applicationContext, jsonData,pushType)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }


    }
    fun getJackJsonMapper(): ObjectMapper {


        val objectMapper = ObjectMapper().configure(
            DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
            false
        )
        objectMapper.configOverride(String::class.java).setterInfo = JsonSetter.Value.forValueNulls(Nulls.AS_EMPTY)
        return objectMapper
    }

    private fun showNotification(title: String, message: String) {
        val channelId = "default_channel"
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(channelId, "Default Channel", NotificationManager.IMPORTANCE_DEFAULT)
            notificationManager.createNotificationChannel(channel)
        }

        val builder = NotificationCompat.Builder(this, channelId)
            .setSmallIcon(R.drawable.parkingcar_48)
            .setContentTitle(title)
            .setContentText(message)
            .setAutoCancel(true)

        notificationManager.notify(100, builder.build())
    }

}

