package com.example.kmmsocial.auth.data

import com.example.kmmsocial.auth.domain.model.AuthResultData

internal fun AuthResponseData.toAuthResultData(): AuthResultData {
    return AuthResultData(
        id, name, bio, avatar, token, followersCount, followingCount
    )
}