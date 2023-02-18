package com.mony.recyclerviewsample

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mony.recyclerviewsample.data.Datasource
import com.mony.recyclerviewsample.databinding.ActivityMainBinding
import com.mony.recyclerviewsample.models.Affirmation

class MainActivity : AppCompatActivity() {

    private lateinit var _binding : ActivityMainBinding

    /* Flag to check layout manager. */
    private var isLinearLayoutManager = false

    private lateinit var data : List<Affirmation>
    private lateinit var recyclerView : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        val view = _binding.root
        setContentView(view)

        /* Gets data from datasource list of [Affirmation]. */
        data = Datasource().loadAffirmations()

        /* Setting up recycler view. */
        recyclerView = _binding.affirmationRecyclerView

        /* Creating an adapter object [ItemAdapter]. */
        val adapter = ItemAdapter(this, data)

        /* Attaching adapter to recycler view. */
        recyclerView.adapter = adapter

        /* Setting up layout manager for recycler view. */
        chooseLayout()

        // [ALTERNATIVELY]
        // recyclerView.layoutManager = GridLayoutManager(this, 2);

        /* For optimizing performance. */
        recyclerView.setHasFixedSize(true)
    }

    /* Sets recycle view layout depending upon flag. */
    private fun chooseLayout(){
        if(isLinearLayoutManager){
            recyclerView.layoutManager = LinearLayoutManager(this)
        } else {
            recyclerView.layoutManager = GridLayoutManager(this, 2)
        }

        val adapter = ItemAdapter(this, data)
        recyclerView.adapter = adapter
    }

    /* Changes icon depending upon selected layout. */
    private fun setIcon(menuItem : MenuItem?){
        if(menuItem == null) {
            return
        }

        menuItem.icon =
            if (isLinearLayoutManager)
                ContextCompat.getDrawable(this, R.drawable.linear_layout)
            else
                ContextCompat.getDrawable(this, R.drawable.grid_layout)
    }

    /* Instantiates options menu. */
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.layout_menu, menu)
        val layoutButton = menu?.findItem(R.id.action_switch_layout)
        setIcon(layoutButton)

        return true
    }

    /* Event handler for menu item. */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_switch_layout -> {

                isLinearLayoutManager = !isLinearLayoutManager
                chooseLayout()
                setIcon(item)

                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}