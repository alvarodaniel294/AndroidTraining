package com.bootcamp.emptyapplication

import android.app.Activity
import android.nfc.tech.NfcV.get
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.squareup.picasso.Picasso
import java.lang.reflect.Array.get

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


/**
 * A simple [Fragment] subclass.
 * Use the [userDetails.newInstance] factory method to
 * create an instance of this fragment.
 */
class userDetails : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val nameUser: String? = arguments?.getString(NAME)?: "Pokemon"
        val image: String? = arguments?.getString(IMAGE)?: "1"
        val connected: Boolean? = (arguments?.getString(CONNECTED)?: false) as Boolean?

        val nameLabel = view.findViewById<TextView>(R.id.UserName)
        val userImageContent = view.findViewById<ImageView>(R.id.userImage)
        nameLabel.text = "Name: $nameUser"

        Glide.with(view)
            .load(image)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .centerCrop()
            .circleCrop()
            .into(userImageContent)

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_details, container, false)
    }

    companion object {
        const val NAME = "Name"
        const val IMAGE = "Image"
        const val CONNECTED = "Connected"
        fun newInstance(param1: String, param2: String) =
                userDetails().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}