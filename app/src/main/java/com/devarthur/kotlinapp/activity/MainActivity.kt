package com.devarthur.kotlinapp.activity

import android.os.Bundle
import com.devarthur.kotlinapp.R
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import com.devarthur.kotlinapp.extensions.setupToolbar
import com.devarthur.kotlinapp.extensions.toast

import com.devarthur.kotlinapp.domain.tipoCarro
import org.jetbrains.anko.startActivity

class MainActivity : BaseActivity() , NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupToolbar(R.id.toolbar)
        setupNavDrawer()
    }

    private fun setupNavDrawer(){
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        val toogle = ActionBarDrawerToggle(
            this,drawer,toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close)

        drawer.addDrawerListener(toogle)
        toogle.syncState()
        val nagivationView = findViewById<NavigationView>(R.id.nav_view)
        nagivationView.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.nav_item_carros_todos -> {
                toast("Clicou em carros")
            }
            R.id.nav_item_carros_classicos -> {

                //Old way of using it
//                val intent = Intent(context, CarrosActivity::class.java)
//                intent.putExtra("tipo", tipoCarro.classicos)
//                startActivity(intent)

                //Now we have anko - it make it shorter to pass intents and parameters
                startActivity<CarrosActivity>("type" to tipoCarro.classicos)

            }
            R.id.nav_item_carros_esportivos -> {
                startActivity<CarrosActivity>("type" to tipoCarro.esportivos)

            }
            R.id.nav_item_carros_luxo -> {

                startActivity<CarrosActivity>("type" to tipoCarro.luxo)

            }
            R.id.nav_item_site_livro -> {

                startActivity<WebViewActivity>()


            }
            R.id.nav_item_settings -> {
                toast("Clicou em configurações")

            }

        }
        //Closes the drawer after an event..
        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        drawer.closeDrawer(GravityCompat.START)

        return true
    }
}
