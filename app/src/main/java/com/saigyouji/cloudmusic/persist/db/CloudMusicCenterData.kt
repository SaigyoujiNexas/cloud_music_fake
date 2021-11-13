package com.saigyouji.cloudmusic.persist.db.playList

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.saigyouji.cloudmusic.persist.db.PlaylistX

@Database(entities = arrayOf(PlaylistX::class), version = 1, exportSchema = false)
@TypeConverters(Convertor::class)
public abstract class MusicCenterData: RoomDatabase(){
    abstract fun playListDao(): PlayListDao

    companion object{
        @Volatile
        private var INSTANCE:MusicCenterData? = null

        fun getDatabase(context: Context): MusicCenterData
        {
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MusicCenterData::class.java,
                    "music_center"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }

}