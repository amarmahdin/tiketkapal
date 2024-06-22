package com.project.tiketpesawat.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User (
    @PrimaryKey(autoGenerate = true) var uid: Int? = null,
    @ColumnInfo(name = "nama_penumpang") var namapenumpang: String?,
    @ColumnInfo (name = "keberangkatan") var Keberangkatan: String?,
    @ColumnInfo (name = "tujuan") val Tujuan: String?,
    @ColumnInfo (name = "tgl_berangkat") val Tglberangkat: String?,
    @ColumnInfo (name = "wkt_berangkat") val Wktberangkat: String?
    )