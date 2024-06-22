package com.project.tiketpesawat.recycle

import com.project.tiketpesawat.R

object datagambar {
    private val planeName = arrayOf(
        "Air Asia",
        "Batik Air",
        "Citilink",
        "Lion Air",
        "Sriwijaya",
        "Trans Nusa"
    )

    private val planePrice = arrayOf(
        "Rp.1.000.000",
        "Rp.915.000",
        "Rp.1.300.000",
        "Rp.1.250.000",
        "Rp.1.100.000",
        "Rp.2.000.000"
    )

    private val planeImage =  arrayOf(
        R.drawable.airasia,
        R.drawable.batik,
        R.drawable.citilink,
        R.drawable.lion,
        R.drawable.sriwijaya,
        R.drawable.transnusa
    )

    private val planePoint = arrayOf(
        "Dapatkan 40 Point",
        "Dapatkan 30 Point",
        "Dapatkan 65 Point",
        "Dapatkan 45 Point",
        "Dapatkan 43 Point",
        "Dapatkan 80 Point"
    )


    val  listData : ArrayList<OSandroid>
    get() {
        val list = arrayListOf<OSandroid>()
        for (position in planeName.indices) {
            val android = OSandroid()
            android.Nameplane = planeName[position]
            android.Imgplane = planeImage[position]
            android.Price = planePrice[position]
            android.Point = planePoint[position]
            list.add(android)
        }
        return list
    }
}