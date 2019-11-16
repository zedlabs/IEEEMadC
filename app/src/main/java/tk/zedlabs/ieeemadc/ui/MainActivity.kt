package tk.zedlabs.ieeemadc.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*
import tk.zedlabs.ieeemadc.MainActivityViewModel
import tk.zedlabs.ieeemadc.R

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
    }

    override fun onResume() {
        super.onResume()
        showData()
    }

    private fun showData() {
        var aqi : Int
        viewModel.data.observe(this, Observer {
            aqi = it.data?.aqi!!
            aqi_text.text = aqi.toString()
            location_text.text = it.data!!.city!!.name.toString()
            setupUi(aqi)
        })
    }

    private fun setupUi(aqi: Int) {
            when(aqi){
                in 0..50 -> {aqi_text.setBackgroundColor(ResourcesCompat.getColor(resources, R.color.good, null))}
                in 51..100 -> {aqi_text.setBackgroundColor(ResourcesCompat.getColor(resources, R.color.moderate, null))}
                in 101..150 -> {aqi_text.setBackgroundColor(ResourcesCompat.getColor(resources, R.color.unhealthySensitive, null))}
                in 151..200 -> {aqi_text.setBackgroundColor(ResourcesCompat.getColor(resources, R.color.unhealthy, null))}
                in 201..300 -> {aqi_text.setBackgroundColor(ResourcesCompat.getColor(resources, R.color.veryUnhealthy, null))}
                in 300..999 -> {aqi_text.setBackgroundColor(ResourcesCompat.getColor(resources, R.color.hazardous, null))}
                else -> {aqi_text.text = getString(R.string.error_getting_aqi)}
            }
    }

}
