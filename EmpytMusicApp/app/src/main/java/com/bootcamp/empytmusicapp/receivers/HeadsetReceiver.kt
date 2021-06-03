package com.bootcamp.empytmusicapp.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.util.Log
import android.widget.Toast


class HeadsetReceiver private constructor(): BroadcastReceiver() {

    // instances
    var callback: HeadsetReceiverCallback? = null

    //region singleton
    private object HOLDER {
        val INSTANCE = HeadsetReceiver()
    }

    companion object {
        val instance: HeadsetReceiver by lazy { HOLDER.INSTANCE }
    }
    //endregion

    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == Intent.ACTION_HEADSET_PLUG) {
            if(intent.getIntExtra("state", -1) == 0) {
                callback?.onHeadsetDisconnected()
            } else {
                callback?.onHeadsetConnected()
            }
        }
    }

    fun register(context: Context) {
        val receiverFilter = IntentFilter(Intent.ACTION_HEADSET_PLUG)
        context.registerReceiver(this, receiverFilter)
    }

    fun unregister(context: Context) {
        context.unregisterReceiver(this)
        callback = null
    }

    interface HeadsetReceiverCallback {
        fun onHeadsetConnected()
        fun onHeadsetDisconnected()
    }
}