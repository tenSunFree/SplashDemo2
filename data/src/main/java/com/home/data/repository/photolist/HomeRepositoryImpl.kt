package com.home.data.repository.photolist

import com.home.data.Loggerg
import com.home.data.datasource.DataSource
import com.home.data.entity.CommentEntity
import com.home.data.mapper.Mapper
import com.home.data.request.GetCommentsRequest
import com.home.data.response.CommentResponse
import io.reactivex.Single
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val remoteDataSource: DataSource.SingleReadable<GetCommentsRequest, List<CommentResponse>>,
    private val photoResponseToPhotoEntity: Mapper<CommentResponse, CommentEntity>
) : HomeRepository {

    override fun getComments(request: GetCommentsRequest): Single<MutableList<CommentEntity>> {
        Loggerg.d("PhotoListRepositoryImpl, getListOfPhotos")
        return remoteDataSource.read(request)
            .toObservable()
            .flatMapIterable {
                it }
            .map { photosResponse ->
                photoResponseToPhotoEntity.mapFromTo(photosResponse)
            }
            .toList()
    }
}