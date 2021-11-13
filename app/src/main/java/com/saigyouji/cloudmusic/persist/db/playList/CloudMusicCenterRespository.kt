package com.saigyouji.cloudmusic.persist.db.playList

import androidx.annotation.WorkerThread
import com.saigyouji.cloudmusic.persist.db.PlaylistX
import kotlinx.coroutines.flow.Flow

class CloudMusicCenterRespository
    (private val playlistDao: PlayListDao) {
        val allPlayLists: Flow<List<PlaylistX>> = playlistDao.getAllPlayLists()
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insertPlaylist(playlist: PlaylistX)
    {
        playlistDao.insert(playlist)
    }
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insertPlaylist(playlist: List<PlaylistX>)
    {
        playlistDao.insert(playlist)
    }

}