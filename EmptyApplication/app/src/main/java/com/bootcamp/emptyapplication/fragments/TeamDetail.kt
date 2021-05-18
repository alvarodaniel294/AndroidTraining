package com.bootcamp.emptyapplication.fragments

import android.os.Bundle
import android.text.method.LinkMovementMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bootcamp.emptyapplication.R
import com.squareup.picasso.Picasso

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TeamDetail.newInstance] factory method to
 * create an instance of this fragment.
 */
class TeamDetail : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_team_detail, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment TeamDetail.
         */
        const val NAME = "Name"
        const val IMAGE = "Image"
        const val DESCRIPTION = "Description"
        const val URL = "Url"
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TeamDetail().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val nameUser: String = arguments?.getString(NAME)?: "emptyTeam"
        val image: Int = arguments?.getInt(IMAGE)?: 1
        val description: String = arguments?.getString(DESCRIPTION)?: "emptyDescription"
        val url: String = arguments?.getString(URL)?: "emptyUrl"

        val nameLabel = view.findViewById<TextView>(R.id.nameTeam)
        val pictureTeam = view.findViewById<ImageView>(R.id.pictureTeam)
        val descriptionTeam = view.findViewById<TextView>(R.id.description)
        val urlTeam = view.findViewById<TextView>(R.id.url)
        nameLabel.text = nameUser
        descriptionTeam.text = description
        urlTeam.text = url
        urlTeam.movementMethod = LinkMovementMethod.getInstance()
        Picasso.get()
            .load(image)
            .into(pictureTeam)
    }

}