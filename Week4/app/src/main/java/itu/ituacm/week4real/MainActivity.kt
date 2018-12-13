package itu.ituacm.week4real

import android.content.Context
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import itu.ituacm.week4real.Fragments.MainFragment


class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        openFragment(MainFragment.newInstance(), "Main")
    }


    fun openFragment( fragment: Fragment, stackStr: String){
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment ,"mainfragment")
            .addToBackStack(stackStr)
            .commit()
    }
}
