package com.example.demo_taskmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    private lateinit var recyclerMessage: RecyclerView
    private lateinit var taskAdapter:TaskAdapter
    private val task = ArrayList<Task>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_main)
        recyclerMessage = findViewById(R.id.recyclerMessage)

        initData()

        taskAdapter = TaskAdapter(task)
        taskAdapter.onTaskClickListener = MyTaskClickListener()
        recyclerMessage.adapter = taskAdapter

        recyclerMessage.layoutManager =
            LinearLayoutManager(
                this,
                LinearLayoutManager.VERTICAL,
                false
            )
    }

    inner class MyTaskClickListener: TaskAdapter.OnTaskClickListener{
        override fun onTaskClick(position: Int, task: Task, view: View) {
            Toast.makeText(
                this@MainActivity,
                "My Action ${position+1} is clicked...",
                Toast.LENGTH_SHORT
            ).show()
        }

    }
    private fun initData() {
        task.add(
            Task(
                1,
                "Project Title : E-Commerce",
                "Description :  E-Commerce Platform for Handloom",
                "1-01-2024",
                "Pending"
            )
        )
        task.add(
            Task(
                2,
                "Project Title:Fresher's Buddy ",
                "Description: App for Fresher" ,
                "29-12-2023",
                "Completed"
            )
        )
        task.add(
            Task(
                3,
                "Project Title : Shopping App",
                "Description: App for shopping of Electronics Devices",
                "31-12-2023",
                "In Progress"

            )
        )


    }
}