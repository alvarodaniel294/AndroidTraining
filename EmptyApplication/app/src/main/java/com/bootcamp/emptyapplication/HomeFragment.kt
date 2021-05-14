package com.bootcamp.emptyapplication

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.bootcamp.emptyapplication.Interfaces.IDogDetail

class   HomeFragment : Fragment(), IDogDetail{

    lateinit var recyclerAdapter: DogAdapter
    var dogs = mutableListOf<String>(
            "https://images.dog.ceo/breeds/hound-basset/n02088238_9626.jpg",
            "https://images.dog.ceo/breeds/mexicanhairless/n02113978_2425.jpg",
            "https://images.dog.ceo/breeds/elkhound-norwegian/n02091467_6962.jpg",
            "https://images.dog.ceo/breeds/hound-basset/n02088238_9626.jpg",
            "https://images.dog.ceo/breeds/setter-english/n02100735_4.jpg",
            "https://images.dog.ceo/breeds/groenendael/n02105056_7285.jpg")

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_home, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rv_RecycleView: RecyclerView = view.findViewById(R.id.rv_dogs)
        rv_RecycleView.layoutManager = LinearLayoutManager(parentFragment?.context) //HomeFragment().context
        recyclerAdapter = DogAdapter(dogs,this)
        rv_RecycleView.adapter = recyclerAdapter
        recyclerAdapter.notifyDataSetChanged()
        initSwipeRefresher(view)
    }

    fun initSwipeRefresher(view: View){
        Log.d("chris","entro adentro")
        val swipeRefreshLayout = view.findViewById<SwipeRefreshLayout>(R.id.home_swipe_refresh)
        swipeRefreshLayout.setOnRefreshListener {
            Toast.makeText(view.context,"Se empezo a refrescar la pag", Toast.LENGTH_SHORT).show()
            dogs.add("https://images.dog.ceo/breeds/hound-basset/n02088238_9626.jpg")
            dogs.add("https://images.dog.ceo/breeds/hound-basset/n02088238_9626.jpg")
            dogs.add("https://images.dog.ceo/breeds/hound-basset/n02088238_9626.jpg")
            recyclerAdapter.notifyDataSetChanged()
            swipeRefreshLayout.isRefreshing = false
        }
    }
    override fun didSelectImage(image: String) {
        Log.d("chris","se presiono la imagen :D ${image}")
        val navController = findNavController()
        val bundle = Bundle()
        bundle.putString("myDogImageUrl",image)
        navController.navigate(R.id.action_homeFragment_to_detailFragment,bundle)
        // cuando ocupar esto ??
//        Fragment fragment = new tasks();
//        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.replace(R.id.content_frame, fragment);
//        fragmentTransaction.addToBackStack(null);
//        fragmentTransaction.commit();
    }

}
