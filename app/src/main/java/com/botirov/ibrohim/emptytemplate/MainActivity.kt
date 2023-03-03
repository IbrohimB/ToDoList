package com.botirov.ibrohim.emptytemplate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.GravityCompat
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import com.botirov.ibrohim.emptytemplate.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var taskViewModel: TaskViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val drawerLayout=binding.drawerLayout
        val imgMenu= binding.imgMenu

        val navView= binding.navDawar
        navView.itemIconTintList=null
        imgMenu.setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }
        val navController = Navigation.findNavController(this,R.id.fragment)
        NavigationUI.setupWithNavController(navView,navController)

        val textTitle= binding.title
        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            textTitle.text = destination.label

        }

        taskViewModel=ViewModelProvider(this).get(TaskViewModel::class.java)

    }
}