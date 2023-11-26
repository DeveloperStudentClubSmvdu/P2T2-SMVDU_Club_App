package com.rishav.smvduclubapp

import com.rishav.smvduclubapp.models.RvModel

object ClubConstant {
    private lateinit var dataList: ArrayList<RvModel>

    fun getData():ArrayList<RvModel>{

        dataList = ArrayList<RvModel>()

        dataList.add(RvModel(R.drawable.gdsc,"GDSC"))
        dataList.add(RvModel(R.drawable.gdsc,"AI Circle"))
        dataList.add(RvModel(R.drawable.gdsc,"STC"))
        dataList.add(RvModel(R.drawable.gdsc,"Code Club"))
        dataList.add(RvModel(R.drawable.gdsc,"Vikalp"))
        dataList.add(RvModel(R.drawable.gdsc,"VYOM"))
        dataList.add(RvModel(R.drawable.gdsc,"Music Club"))
        dataList.add(RvModel(R.drawable.gdsc,"Dance Club"))
        dataList.add(RvModel(R.drawable.gdsc,"Atelier"))
        dataList.add(RvModel(R.drawable.gdsc,"BCA"))
        dataList.add(RvModel(R.drawable.gdsc,"BSA"))
        dataList.add(RvModel(R.drawable.gdsc,"Theatre Club"))
        dataList.add(RvModel(R.drawable.gdsc,"Food Club"))
        dataList.add(RvModel(R.drawable.gdsc,"ECE Warriors"))

        return dataList

    }
}