package com.alierkoc.filmlerv1.model.fav

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class FavList(
    @PrimaryKey(autoGenerate = true) val uid: Int,
    @ColumnInfo(name = "id") var id: String,
    @ColumnInfo(name = "backdropPath") var backdropPath: String
)