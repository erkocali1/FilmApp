package com.alierkoc.filmlerv1.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.alierkoc.filmlerv1.model.fav.FavList
import com.alierkoc.filmlerv1.servis.FilmDAO

@Database(entities = [FavList::class], version = 1)
abstract class FilmFavDataBase : RoomDatabase() {

    abstract fun favFilmDao(): FilmDAO


//    companion object {
//        @Volatile
//        private var instance: FilmFavDataBase? = null
//        private val lock = Any()
//
//        operator fun invoke(context: Context) = instance ?: synchronized(lock) {
//            instance ?: createDataBase(context).also {
//                instance = it
//            }
//        }
//
//        private fun createDataBase(context: Context) =
//            Room.databaseBuilder(
//                context.applicationContext,
//                FilmFavDataBase::class.java,
//                "filmFavDataBase"
//            ).build()
//    }
}

