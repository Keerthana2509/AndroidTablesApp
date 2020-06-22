package com.example.tablesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SeekBar
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val seekbar: SeekBar = findViewById(R.id.seekBar)
        val listView: ListView = findViewById(R.id.listview)
        seekbar.setOnSeekBarChangeListener(object :SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                val arraylist: ArrayList<Int> = ArrayList()
                var j=1
                while(j<11){
                    arraylist.add(j*progress)
                    j++
                }
                val arrayAdapter: ArrayAdapter<Int> = ArrayAdapter(this@MainActivity,android.R.layout.simple_list_item_1,arraylist)
                listView.adapter = arrayAdapter
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                Toast.makeText(applicationContext, "seekbar touch started!", Toast.LENGTH_SHORT).show()
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                Toast.makeText(applicationContext, "seekbar touch stopped!", Toast.LENGTH_SHORT).show()

            }
        })
    }
}
