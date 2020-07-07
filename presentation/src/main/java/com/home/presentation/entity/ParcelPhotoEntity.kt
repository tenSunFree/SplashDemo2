package com.home.presentation.entity

import android.annotation.SuppressLint
import android.os.Parcelable
import com.home.presentation.model.ParcelPhotoUrlsData
import com.home.presentation.model.ParcelProfileImageData
import kotlinx.android.parcel.Parcelize

@SuppressLint("ParcelCreator")
@Parcelize
data class ParcelPhotoEntity(
    val id: String?,
    val createdAt: String?,
    val updatedAt: String?,
    val width: Int?,
    val height: Int?,
    val color: String?,
    val likes: Int?,
    val description: String?,
    val userId: String?,
    val usersName: String?,
    val userProfileImage: ParcelProfileImageData?,
    val photoUrls: ParcelPhotoUrlsData?
) : Parcelable