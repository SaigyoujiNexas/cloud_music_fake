package com.saigyouji.cloudmusic.persist.db.playList

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.saigyouji.cloudmusic.persist.db.PlayList
import com.saigyouji.cloudmusic.persist.db.PlaylistX
import kotlinx.coroutines.flow.Flow
@Dao
interface PlayListDao {
    @Query("SELECT *  FROM PLAY_LIST_TABLE")
    fun getAllPlayLists(): Flow<List<PlaylistX>>
    @Query("DELETE FROM play_list_table WHERE id IS :id")
    suspend fun deletePlayListById(id: Long)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(playList: PlaylistX)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(playLists: List<PlaylistX>)
    @Query("DELETE FROM play_list_table")
    suspend fun deleteAllPlayLists()
}