package com.example.lighititup_design

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import org.jetbrains.anko.startActivity
import java.util.*

class FieldAdapter(val locationList : ArrayList<LocationItem>): RecyclerView.Adapter<FieldAdapter.CustomViewHolder>() {
    //뷰홀더가 처음 생성될때
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FieldAdapter.CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_main2, parent, false)
        return CustomViewHolder(view)
    }

    //재활용해주는 곳 및 값을 넣어주는 곳
    override fun onBindViewHolder(holder: FieldAdapter.CustomViewHolder, position: Int) {
        holder.bindItems(locationList[position])
        holder.itemView.setOnClickListener {
            itemClickListener.onClick(it, position)
        }
    }
    // (2) 리스너 인터페이스
    interface OnItemClickListener {
        fun onClick(v: View, position: Int)
    }
    // (3) 외부에서 클릭 시 이벤트 설정
    fun setItemClickListener(onItemClickListener: OnItemClickListener) {
        this.itemClickListener = onItemClickListener
    }
    // (4) setItemClickListener로 설정한 함수 실행
    private lateinit var itemClickListener : OnItemClickListener

    //리스트의 갯수를 적어준다
    override fun getItemCount(): Int {
        return locationList.size
    }

    //뷰홀더 클래스(음료수처럼 잡아주는 홀더)
    //이곳에서 파인드뷰아이디로 리스트 아이템에 있는 뷰들을 참조한다.
    inner class CustomViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(locationItem: LocationItem){
            val field = itemView.findViewById<TextView>(R.id.title_main2) //병원 종류
            field.text = locationItem.location
        }
    }
}