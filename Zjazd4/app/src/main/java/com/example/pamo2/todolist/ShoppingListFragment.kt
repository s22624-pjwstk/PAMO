package com.example.pamo2.todolist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pamo2.R

class ShoppingListFragment : Fragment() {

    private lateinit var shoppingListRecyclerView: RecyclerView
    private lateinit var shoppingListAdapter: ShoppingListAdapter

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.activity_shopping_list, container, false)

        val shoppingItems = listOf("Jajka", "Szynka")

        shoppingListRecyclerView = view.findViewById(R.id.shopping_list_recycler_view)
        shoppingListAdapter = ShoppingListAdapter(shoppingItems)
        shoppingListRecyclerView.adapter = shoppingListAdapter
        shoppingListRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        return view
    }
}