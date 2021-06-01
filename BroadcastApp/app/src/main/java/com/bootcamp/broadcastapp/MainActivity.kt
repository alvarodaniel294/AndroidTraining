package com.bootcamp.broadcastapp

import android.Manifest
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import com.bootcamp.broadcastapp.broadcast.AirPlaneReceiver
import com.bootcamp.broadcastapp.broadcast.BatteryConnectionReceiver
import com.bootcamp.broadcastapp.broadcast.CustomBroadcast
import com.bootcamp.broadcastapp.broadcast.SMSReceiver

class MainActivity : AppCompatActivity() {

    lateinit var airPlaneReceiver: AirPlaneReceiver
    lateinit var batteryConnection: BatteryConnectionReceiver
    lateinit var smsReceiver: SMSReceiver
    lateinit var customBroadcast: CustomBroadcast


    val smsPermissionRequest = registerForActivityResult(ActivityResultContracts.RequestPermission()){
        if (it){

        }else{

        }
    }



    val smsObject:BroadcastReceiver = object:BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?) {

        }

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val intentToEmpty = Intent(this, EmpyActivity::class.java)
        airPlaneReceiver = AirPlaneReceiver()
        batteryConnection = BatteryConnectionReceiver()
        smsReceiver = SMSReceiver()
        customBroadcast = CustomBroadcast()


        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also {
            registerReceiver(AirPlaneReceiver(), it)
        }


        IntentFilter(Intent.ACTION_BATTERY_CHANGED).also {
            registerReceiver(batteryConnection, it)
        }

        IntentFilter("android.provider.Telephony.SMS_RECEIVED").also {
            registerReceiver(smsReceiver, it)
        }


        val intentfilter = IntentFilter("com.bootcamp.broadcastapp.CUSTOM_ACTION")

        registerReceiver(customBroadcast, intentfilter)


        findViewById<Button>(R.id.smsPermissions).setOnClickListener {
            requestSMSPermissions()
        }

        findViewById<Button>(R.id.sendBroadcastBtn).setOnClickListener {
            sendCustomBroadcast()
        }


    }

    private fun sendCustomBroadcast() {

        val broadcastIntent = Intent()
        broadcastIntent.action = "com.bootcamp.broadcastapp.CUSTOM_ACTION"
        sendBroadcast(broadcastIntent)
    }

    private fun requestSMSPermissions() {
        when {
            ContextCompat.checkSelfPermission(this, Manifest.permission.RECEIVE_SMS) == PackageManager.PERMISSION_GRANTED -> {

            }
            else ->{
                smsPermissionRequest.launch(Manifest.permission.RECEIVE_SMS)
            }
        }
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(airPlaneReceiver)
        unregisterReceiver(batteryConnection)
        unregisterReceiver(smsReceiver)
        unregisterReceiver(customBroadcast)
    }
}