package com.itu.dailyfilm

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import com.itu.dailyfilm.Fragments.ArchivedFragment
import com.itu.dailyfilm.Fragments.ChatFragment
import com.itu.dailyfilm.Fragments.HomePageFragment
class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        openNewFragment(ArchivedFragment.newInstance())
    }

    fun openNewFragment(fragment: Fragment){

        val manager = supportFragmentManager;
        val transaction: FragmentTransaction = manager.beginTransaction();
        transaction.add(R.id.main_activity_fragment_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
