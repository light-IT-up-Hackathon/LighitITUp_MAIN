package com.example.lighititup_design

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main2.*
import java.util.*

class Main2Activity : AppCompatActivity() {

    lateinit var fieldAdapter: FieldAdapter
    lateinit var hospitalAdapter: HospitalAdapter
    val field = ArrayList<LocationItem>()
    val hospitals = ArrayList<Hospitals>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        field.add(LocationItem("산부인과"))
        field.add(LocationItem("내과"))
        field.add(LocationItem("피부과"))
        field.add(LocationItem("이비인후과"))
        field.add(LocationItem("정형외과"))
        field.add(LocationItem("치과"))

        hospitals.add(Hospitals(R.drawable.h_image0,"[엠엔비여성의원]","산부인과","평일 09시~20시","인천시 계양구"))
        hospitals.add(Hospitals(R.drawable.h_image0,"[복음병원]","산부인과","평일 09시~20시","인천시 계양구"))
        hospitals.add(Hospitals(R.drawable.h_image0,"[김성연의원]","산부인과","평일 08시~20시","인천시 계양구"))
        hospitals.add(Hospitals(R.drawable.h_image0,"[이소아의원]","산부인과","평일 09시~20시","경기도 고양시"))
        hospitals.add(Hospitals(R.drawable.h_image0,"[안예린의원]","산부인과","평일 10시~20시","서울시 구로구"))
        hospitals.add(Hospitals(R.drawable.h_image0,"[한유림의원]","산부인과","평일 08시~20시","서울시 노원구"))

        fieldAdapter = FieldAdapter(field)
        recyclerView_main2.adapter = fieldAdapter
        recyclerView_main2.setHasFixedSize(true)//어뎁터에 성능을 위한것
        //레이아웃매니저를 이용해 어뎁터의 방향을 결정
        recyclerView_main2.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        hospitalAdapter = HospitalAdapter(hospitals)
        recyclerGridView_main2.adapter=hospitalAdapter
        recyclerGridView_main2.layoutManager=GridLayoutManager(applicationContext,2)
    }
}