package com.example.lighititup_design

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main2.*
import java.util.*

class Main2Activity : AppCompatActivity() {

    lateinit var fieldAdapter: FieldAdapter
    val field = ArrayList<LocationItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        field.add(LocationItem("산부인과"))
        field.add(LocationItem("내과"))
        field.add(LocationItem("피부과"))
        field.add(LocationItem("이비인후과"))
        field.add(LocationItem("정형외과"))
        field.add(LocationItem("치과"))

        fieldAdapter = FieldAdapter(field)
        recyclerView_main2.adapter = fieldAdapter
        recyclerView_main2.setHasFixedSize(true)//어뎁터에 성능을 위한것
        //레이아웃매니저를 이용해 어뎁터의 방향을 결정
        recyclerView_main2.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
    }
}