package io.rivmt.deepdark

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener, View.OnLongClickListener {

    private val TAG = "MainAct"

    var nowRunning: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Fullscreen
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Button
        btn_start.setOnClickListener(this)
        layout_master.setOnLongClickListener(this)
    }

    override fun onPause() {
        super.onPause()
        disableDarkScreen()
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.btn_start -> {
                enableDarkScreen()
            }
        }
    }

    override fun onLongClick(v: View?): Boolean {
        when(v?.id) {
            R.id.layout_master -> {
                disableDarkScreen()
            }
            else -> return false
        }

        return true
    }

    private fun enableDarkScreen() {
        nowRunning = true
        layout_main.visibility = View.GONE
        Log.d(TAG, "Activate")
        Toast.makeText(this, getString(R.string.txt_start_msg), Toast.LENGTH_SHORT).show()
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
    }

    private fun disableDarkScreen() {
        nowRunning = false
        layout_main.visibility = View.VISIBLE
        Log.d(TAG, "Deactivate")
        Toast.makeText(this, getString(R.string.txt_end_msg), Toast.LENGTH_SHORT).show()
        window.clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
    }
}
