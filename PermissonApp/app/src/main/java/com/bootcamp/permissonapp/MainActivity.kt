package com.bootcamp.permissonapp

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.SmsManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    companion object {
        const val REQUEST_SMS = 5
    }

    lateinit var phonenumber: EditText

    val requestSMSpermissionLauncher =
        registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted: Boolean ->
            if (isGranted) {
                Toast.makeText(this, "GRANTED", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "not granted", Toast.LENGTH_LONG).show()

            }
        }

    val requestCallpermissionLauncher =
        registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted: Boolean ->
            if (isGranted) {
                Toast.makeText(this, "GRANTED", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "not granted", Toast.LENGTH_LONG).show()

            }
        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val buttonSMSPermission = findViewById<Button>(R.id.requestSMSpermission)
        val buttonSMSPermissionWithRequestCode =
            findViewById<Button>(R.id.requestPermissionWithRequestCode)
        val sendmsmsbtn = findViewById<Button>(R.id.sendSMSbtn)
        val buttonCallPermission = findViewById<Button>(R.id.requestCallPermission)
        val buttonCall = findViewById<Button>(R.id.btnCallPhone)
        phonenumber = findViewById(R.id.phoneText)

        buttonSMSPermission.setOnClickListener {
            requestSMSPermissions()
        }

        buttonSMSPermissionWithRequestCode.setOnClickListener {
            requestSMSPermissionWithRequestCode()
        }

        sendmsmsbtn.setOnClickListener {
            sendSMS()
        }

        buttonCallPermission.setOnClickListener {
            requestCallPermission()
        }

        buttonCall.setOnClickListener {
            callPhoneNumber()
        }

    }

    private fun requestCallPermission() {
        when {
            ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.CALL_PHONE
            ) == PackageManager.PERMISSION_GRANTED -> {
                // You can use the API that requires the permission.
                Toast.makeText(this, "already GRANTED", Toast.LENGTH_LONG).show()

            }
//            shouldShowRequestPermissionRationale(...) -> {
//            // In an educational UI, explain to the user why your app requires this
//            // permission for a specific feature to behave as expected. In this UI,
//            // include a "cancel" or "no thanks" button that allows the user to
//            // continue using your app without granting the permission.
//            showInContextUI(...)
//        }
            else -> {
                requestCallpermissionLauncher.launch(Manifest.permission.CALL_PHONE)
            }
        }
    }

    private fun requestSMSPermissionWithRequestCode() {
        when {
            ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.SEND_SMS
            ) == PackageManager.PERMISSION_GRANTED -> {
                // You can use the API that requires the permission.
                Toast.makeText(this, "already GRANTED", Toast.LENGTH_LONG).show()

            }
//            shouldShowRequestPermissionRationale(...) -> {
//            // In an educational UI, explain to the user why your app requires this
//            // permission for a specific feature to behave as expected. In this UI,
//            // include a "cancel" or "no thanks" button that allows the user to
//            // continue using your app without granting the permission.
//            showInContextUI(...)
//        }
            else -> {
                requestPermissions(arrayOf(Manifest.permission.SEND_SMS), REQUEST_SMS)
            }
        }

    }

    private fun sendSMS() {
        val phoneNumber = "+591 ${phonenumber.text.toString()}"
        val message = " test message "
        val smsManager: SmsManager = SmsManager.getDefault()
        val parts: ArrayList<String> = smsManager.divideMessage(message)
        smsManager.sendMultipartTextMessage(phoneNumber, null, parts, null, null)
    }

    private fun callPhoneNumber() {
        val phoneNumber = "+591 ${phonenumber.text.toString()}"
        val intentcall = Intent(Intent.ACTION_CALL, Uri.parse("tel: ${phoneNumber}"))
        startActivity(intentcall)
    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            REQUEST_SMS -> {
                if ((grantResults.isNotEmpty() &&
                            grantResults[0] == PackageManager.PERMISSION_GRANTED)
                ) {
                    Toast.makeText(this, " GRANTED", Toast.LENGTH_LONG).show()

                } else {
                    Toast.makeText(this, "NOT GRANTED", Toast.LENGTH_LONG).show()
                }
            }
            else -> {

            }
        }
    }

    private fun requestSMSPermissions() {
        when {
            ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.SEND_SMS
            ) == PackageManager.PERMISSION_GRANTED -> {
                // You can use the API that requires the permission.
            }
//            shouldShowRequestPermissionRationale(...) -> {
//            // In an educational UI, explain to the user why your app requires this
//            // permission for a specific feature to behave as expected. In this UI,
//            // include a "cancel" or "no thanks" button that allows the user to
//            // continue using your app without granting the permission.
//            showInContextUI(...)
//        }
            else -> {
                // You can directly ask for the permission.
                // The registered ActivityResultCallback gets the result of this request.
                requestSMSpermissionLauncher.launch(
                    Manifest.permission.SEND_SMS
                )
            }
        }
    }
}