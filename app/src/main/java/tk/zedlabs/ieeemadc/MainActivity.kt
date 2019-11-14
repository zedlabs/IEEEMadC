package tk.zedlabs.ieeemadc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
        showData()

    }

    private fun showData() {

        viewModel.data.observe(this, Observer {
            aqi_text.text = it.data?.aqi.toString()
            Log.v("MainAct", it.data?.dominentpol +"try this")
            Log.v("MainAct", "try this: $it")
            Log.v("MainAct", "try this : ${it.data?.aqi}")
            Log.v("MainAct", "try this : ${it.data?.city}")
        })
    }


}
