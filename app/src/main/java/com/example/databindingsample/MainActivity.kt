package com.example.databindingsample

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.databindingsample.databinding.ActivityMainBinding
import android.widget.Toast
import com.example.databindingsample.recycler.RecyclerActivity
import kotlinx.android.synthetic.main.activity_main_layout.view.*


class MainActivity : AppCompatActivity() {

    lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        user = User("Rimlee", "rimleetat@gmail.com")
        val handler = MyClickHandler(this)
        binding.user = user
        binding.handlers = handler
    }


    inner class MyClickHandler(val context: Context) {

        fun onNameClicked(view: View) {
            Toast.makeText(context, "Name = ${view.name_textview.text} clicked!", Toast.LENGTH_SHORT).show()
        }

        fun onEmailClick(view: View) {
            Toast.makeText(context, "Email = ${view.email_textview.text} clicked!", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this@MainActivity,RecyclerActivity::class.java))
        }
    }
}