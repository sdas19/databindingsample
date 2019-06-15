package com.example.databindingsample.recycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.databindingsample.R
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.databindingsample.databinding.ActivityRecyclerBinding


class RecyclerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)
        val binding = DataBindingUtil.setContentView<ActivityRecyclerBinding>(this, R.layout.activity_recycler)
        binding.flightsRv.setLayoutManager(LinearLayoutManager(this));
        binding.flightsRv.addItemDecoration(
            DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        )

        val adapter = FlightsRecyclerViewAdapter(prepareData(), this)
        binding.setMyAdapter(adapter);
        //binding.flightsRv.setAdapter(adapter)
    }

    fun prepareData(): List<Flight> {
        val flights: MutableList<Flight> = ArrayList()

        var flight = Flight("Delta", "Seattle", "London", "10:20", "17:30", "$388")
        flights.add(flight)
        flight = Flight("Virgin Atlantic", "Seattle", "London", "10:20", "17:30", "$330")
        flights.add(flight)
        flight = Flight("American Airlines", "Seattle", "London", "10:20", "17:30", "$400")
        flights.add(flight)
        flight = Flight("British Airways", "Seattle", "London", "10:20", "17:30", "$440")
        flights.add(flight)
        flight = Flight("Quatar Airways", "Seattle", "London", "10:20", "17:30", "$300")
        flights.add(flight)
        flight = Flight("KLM", "Seattle", "London", "10:20", "17:30", "$350")
        flights.add(flight)
        flight = Flight("Emirates", "Seattle", "London", "10:20", "17:30", "$420")
        flights.add(flight)
        flight = Flight("Lufthansa", "Seattle", "London", "10:20", "17:30", "$390")
        flights.add(flight)
        flight = Flight("Air India", "Seattle", "London", "10:20", "17:30", "$350")
        flights.add(flight)
        flight = Flight("Jet Airways", "Seattle", "London", "10:20", "17:30", "$390")
        flights.add(flight)
        flight = Flight("United", "Seattle", "London", "10:20", "17:30", "$3450")
        flights.add(flight)
        flight = Flight("Air Canada", "Seattle", "London", "10:20", "17:30", "$398")
        flights.add(flight)

        return flights
    }
}
