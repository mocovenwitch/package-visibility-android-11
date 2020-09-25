package com.mocoven.app3

import android.net.Uri
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, getDataFromApp1ContentProvider(), Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    private fun getDataFromApp1ContentProvider(): String {
        var result = "null"

        // fetch 1
        var cursor = this.contentResolver.query(
            Uri.parse("content://com.mocoven.app1.provider/name"),
            null,
            null,
            null,
            null
        )
        cursor?.let {
            if (it.count > 0) {
                it.moveToFirst()
                result = it.getString(0)
            }
        }

        // fetch 2
        cursor = this.contentResolver.query(
            Uri.parse("content://com.mocoven.app2.provider/name"),
            null,
            null,
            null,
            null
        )
        cursor?.let {
            if (it.count > 0) {
                it.moveToFirst()
                result += it.getString(0)
            }
        }

        cursor?.close()
        return result
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
