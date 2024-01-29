package com.example.demo_taskmanager

  data class Task (
    var id: Int,
    var title : String,
    var body : String,
    var dueDate : String,
    var status : String,
  )