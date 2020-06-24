package io.rivmt.deepdark

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener, View.OnLongClickListener {

    var nowRunning: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Button
        btn_start.setOnLongClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v) {
            btn_start -> {
                nowRunning = true
                layout_main.visibility = View.GONE
            }
        }
    }

    override fun onLongClick(v: View?): Boolean {
        when(v) {
            layout_master -> {
                nowRunning = false
                layout_main.visibility = View.VISIBLE
            }
            else -> return false
        }

        return true
    }
}
