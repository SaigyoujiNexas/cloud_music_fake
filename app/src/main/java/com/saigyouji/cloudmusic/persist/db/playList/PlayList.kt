package com.saigyouji.cloudmusic.persist.db
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

data class PlayList(
    val code: Int,
    val more: Boolean,
    val playlist: List<PlaylistX>,
    val version: String
)
@Entity(tableName = "play_list_table")
data class PlaylistX(
    @ColumnInfo
    val adType: Int,
    @ColumnInfo
    val anonimous: Boolean,
    @ColumnInfo
    val artists: String?,
    @ColumnInfo
    val backgroundCoverId: Long,
    @ColumnInfo
    val backgroundCoverUrl: String?,
    @ColumnInfo
    val cloudTrackCount: Long,
    @ColumnInfo
    val commentThreadId: String,
    @ColumnInfo
    val coverImgId: Long,
    @ColumnInfo
    val coverImgId_str: String,
    @ColumnInfo
    val coverImgUrl: String,
    @ColumnInfo
    val createTime: Long,
    @ColumnInfo
    val creator: Creator,
    @ColumnInfo
    val description: String?,
    @ColumnInfo
    val englishTitle: String?,
    @ColumnInfo
    val highQuality: Boolean,
    @PrimaryKey
    @ColumnInfo
    val id: Long,
    @ColumnInfo
    val name: String,
    @ColumnInfo
    val newImported: Boolean,
    @ColumnInfo
    val opRecommend: Boolean,
    @ColumnInfo
    val ordered: Boolean,
    @ColumnInfo
    val playCount: Int,
    @ColumnInfo
    val privacy: Int,
    @ColumnInfo
    val recommendInfo: String,
    @ColumnInfo
    val shareStatus: Int?,
    @ColumnInfo
    val sharedUsers: String?,
    @ColumnInfo
    val specialType: Int,
    @ColumnInfo
    val status: Int,
    @ColumnInfo
    val subscribed: Boolean,
    @ColumnInfo
    val subscribedCount: Int,
    @ColumnInfo
    val subscribers: List<String>,
    @ColumnInfo
    val tags: List<String>,
    @ColumnInfo
    val titleImage: Int,
    @ColumnInfo
    val titleImageUrl: String?,
    @ColumnInfo
    val totalDuration: Int,
    @ColumnInfo
    val trackCount: Int,
    @ColumnInfo
    val trackNumberUpdateTime: Long,
    @ColumnInfo
    val trackUpdateTime: Long,
    @ColumnInfo
    val tracks: List<String>,
    @ColumnInfo
    val updateFrequency: String?,
    @ColumnInfo
    val updateTime: Long,
    @ColumnInfo
    val userId: Int
)
@Serializable
data class Creator(
    val accountStatus: Int,
    val anchor: Boolean,
    val authStatus: Int,
    val authenticationTypes: Int,
    val authority: Int,
    val avatarDetail: String?,
    val avatarImgId: Long,
    val avatarImgIdStr: String,
    val avatarImgId_str: String,
    val avatarUrl: String,
    val backgroundImgId: Long,
    val backgroundImgIdStr: String,
    val backgroundUrl: String,
    val birthday: Int,
    val city: Int,
    val defaultAvatar: Boolean,
    val description: String,
    val detailDescription: String,
    val djStatus: Int,
    val expertTags: List<String>?,
    val experts: List<String>?,
    val followed: Boolean,
    val gender: Int,
    val mutual: Boolean,
    val nickname: String,
    val province: Int,
    val remarkName: String?,
    val signature: String,
    val userId: Int,
    val userType: Int,
    val vipType: Int
)