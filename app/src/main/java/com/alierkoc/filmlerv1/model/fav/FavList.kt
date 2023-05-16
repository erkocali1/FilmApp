package com.alierkoc.filmlerv1.model.fav

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favList")
data class FavList(    @PrimaryKey(autoGenerate = true)
                       @ColumnInfo(name = "id")
                        var id: Int,
                       @ColumnInfo(name = "backdropPath")
                      var backdropPath: String, ) {

    var uuid:Int=0

}