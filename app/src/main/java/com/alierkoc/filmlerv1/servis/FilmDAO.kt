package com.alierkoc.filmlerv1.servis

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.alierkoc.filmlerv1.model.fav.FavList
@Dao
interface FilmDAO {

    //data access
    @Insert
     fun insertAll(favList: FavList):Long


    @Query("SELECT*FROM favList")
     fun getAllFav():List<FavList>

    @Query("SELECT*FROM favList WHERE uuid=:filmId")
     fun getFav(filmId:Int):List<FavList>

//    @Query("DELETE FROM favList WHERE uuid=:filmId")
//     fun deleteFav(filmId:Int):List<FavList>
}