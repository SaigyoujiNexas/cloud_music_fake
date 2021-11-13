package com.saigyouji.cloudmusic.dataRemote.loginData

data class LoginInfo(
    val account: Account,
    val bindings: List<Binding>,
    val code: Int,
    val cookie: String,
    val loginExtData: LoginExtData,
    val loginType: Int,
    val profile: Profile,
    val token: String
)