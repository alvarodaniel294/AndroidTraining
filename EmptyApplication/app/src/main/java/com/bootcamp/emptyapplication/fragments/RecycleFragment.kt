package com.bootcamp.emptyapplication.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bootcamp.emptyapplication.Adapter.TeamAdapter
import com.bootcamp.emptyapplication.Interfaces.TeamListener
import com.bootcamp.emptyapplication.Models.Team
import com.bootcamp.emptyapplication.R
import com.bootcamp.emptyapplication.databinding.FragmentRecycleBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RecycleFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RecycleFragment : Fragment(), TeamListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var binding: FragmentRecycleBinding

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
        //var view = inflater.inflate(R.layout.fragment_recycle, container, false)

        binding = FragmentRecycleBinding.inflate(layoutInflater)
        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment RecycleFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RecycleFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewTeamDetailTap(team: Team) {
        val navController = findNavController()
        val bundle = Bundle()
        bundle.putString(TeamDetail.NAME, team.name)
        bundle.putString(TeamDetail.DESCRIPTION, team.description)
        bundle.putString(TeamDetail.URL, team.url)
        bundle.putInt(TeamDetail.IMAGE, team.image)
        navController.navigate(R.id.action_firstFragment_to_teamDetail, bundle)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listofTeams = Team.listofTeams()
        val recycler = binding.recycler
        val adapter = TeamAdapter(listofTeams,this)
        val layoutManager = LinearLayoutManager(this.context)

        recycler.layoutManager = layoutManager
        recycler.adapter = adapter

        binding.swipeRefreshLayout.setOnRefreshListener {
            listofTeams.add(Team("Real Potosi","Some info",R.drawable.realpo,"https://www.clubrealpotosi.com/"))
            adapter.notifyDataSetChanged()
            binding.swipeRefreshLayout.setRefreshing(false);
        }
    }

}