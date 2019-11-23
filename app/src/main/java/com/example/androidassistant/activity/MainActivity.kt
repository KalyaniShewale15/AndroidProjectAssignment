package com.example.androidassistant.activity

import com.example.androidassistant.adapter.ContryAdapter
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidassistant.net.NetConnector
import kotlinx.android.synthetic.main.activity_ifol_ist.*

import android.content.DialogInterface
import androidx.appcompat.app.AlertDialog
import com.example.androidassistant.module.InfornationRow
import com.example.androidassistant.uitils.AppLog
import com.facebook.drawee.backends.pipeline.Fresco
import android.content.Intent
import android.os.Handler
import android.provider.Settings
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.androidassistant.viewmodel.ContryViewModel
import kotlin.collections.ArrayList
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import androidx.appcompat.app.ActionBar


class MainActivity : AppCompatActivity() {


    var articleArrayList: ArrayList<InfornationRow> = ArrayList()
    internal var contryAdapter: ContryAdapter? = null
    var contryViewModel: ContryViewModel? = null
    var actionBar : ActionBar ? =null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Fresco.initialize(this);
        setContentView(com.example.androidassistant.R.layout.activity_ifol_ist)

        val TAG: String = MainActivity::class.java.simpleName
        var context :Context = this
        var netconnector = NetConnector()
         actionBar = supportActionBar
        if (netconnector.isConnectedToNetwork(context)) {
            // Show the connected screenn
            ll_progressbar.visibility = View.VISIBLE
            //getDataCall()
            getDataCfromRetrofit()

        } else {
            // Show disconnected screen
            Toast.makeText(applicationContext,
                " no net ", Toast.LENGTH_LONG).show()
            showNoInternetAlert()
            }

        // refresh data function call

        simple_swipe_refresh_layout.setOnRefreshListener( SwipeRefreshLayout.OnRefreshListener() {

            getDataCfromRetrofit()
            simple_swipe_refresh_layout.isRefreshing = false

            }
        );
}

    private fun getDataCfromRetrofit() {

        var contryViewModel: ContryViewModel = ViewModelProviders.of(this).get(
            ContryViewModel::class.java)
        contryViewModel.init()

        contryViewModel.getContryRepository()!!.observe(this, Observer { InforamationContry ->

          articleArrayList = InforamationContry.getInfornationRow()
            contryAdapter?.notifyDataSetChanged()

            updateActionBarTital(InforamationContry.getuntryTital())
            setupRecyclerView()
        })
        contryAdapter?.notifyDataSetChanged()

    }

    private fun updateActionBarTital(getuntryTital: String?) {
        actionBar!!.title = getuntryTital

    }

    private fun setupRecyclerView() {

        ll_progressbar.visibility = View.GONE

        AppLog.e("TAG", "output  articleArrayList in setupRecyclerView-------------> ${articleArrayList.toString()}")
        AppLog.e("TAG", "output  articleArrayList in setupRecyclerView-------------> ${articleArrayList.size}")

        if (contryAdapter == null) {
            contryAdapter = ContryAdapter(this@MainActivity, articleArrayList)

            actity_info_recylerview.setAdapter(contryAdapter)

            actity_info_recylerview.setLayoutManager(LinearLayoutManager(this))
            actity_info_recylerview.setItemAnimator(DefaultItemAnimator())
            actity_info_recylerview.setNestedScrollingEnabled(true)
        } else {
            contryAdapter?.notifyDataSetChanged()
        }
           }

    protected fun showNoInternetAlert() {
       val builder = AlertDialog.Builder(this)
       builder.setTitle(com.example.androidassistant.R.string.internet_alert_title)
       builder.setMessage(com.example.androidassistant.R.string.no_internet_msg)
       builder.setPositiveButton(
           com.example.androidassistant.R.string.quite_btn,
           DialogInterface.OnClickListener { dialog, which ->
               AppLog.i("main activity", "showNoInternetAlert() Yes")
               finish()
           })
       builder.setNegativeButton(
           com.example.androidassistant.R.string.setting_btn,
           DialogInterface.OnClickListener { dialog, which ->
               startActivity( Intent(Settings.ACTION_WIRELESS_SETTINGS))
           })
       builder.create()
       builder.show()
    }
    // back button handaler
    private var doubleBackToExitPressedOnce = false
    override fun onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed()
            finishAffinity();
            System.exit(0);
            return
        }

        this.doubleBackToExitPressedOnce = true
        Toast.makeText(this, com.example.androidassistant.R.string.click_back_again, Toast.LENGTH_SHORT).show()

        Handler().postDelayed(Runnable { doubleBackToExitPressedOnce = true }, 2000)
    }
}
