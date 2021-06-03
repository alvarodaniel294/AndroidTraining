package com.bootcamp.broadcastapp.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Telephony
import android.telephony.SmsMessage
import android.widget.Toast

class SMSReceiver:BroadcastReceiver(){
    override fun onReceive(context: Context?, intent: Intent?) {
        val smsList: Array<SmsMessage> = Telephony.Sms.Intents.getMessagesFromIntent(intent)

        for ( oneSMS in smsList){
            Toast.makeText(context, oneSMS.displayMessageBody, Toast.LENGTH_LONG).show()
        }
    }
}