package com.home.splashdemo2.di.modules.photolist

import com.home.data.datasource.DataSource
import com.home.data.entity.CommentEntity
import com.home.data.executors.base.ApplicationThread
import com.home.data.mapper.Mapper
import com.home.data.mapper.PhotoResponseToPhotoEntity
import com.home.data.repository.photolist.HomeRepository
import com.home.data.repository.photolist.HomeRepositoryImpl
import com.home.data.request.GetCommentsRequest
import com.home.data.response.CommentResponse
import com.home.presentation.executors.qualifiers.BackgroundThreadQ
import com.home.presentation.executors.qualifiers.MainThreadQ
import com.home.presentation.home.contract.HomeContract
import com.home.presentation.home.presenter.HomePresenter
import com.home.remote.api.PhotosAPI
import com.home.remote.datasource.GetCommentsRemoteDataSource
import com.home.splashdemo2.di.modules.providers.ProvidersModule
import com.home.splashdemo2.di.scopes.ForActivity
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module(includes = [ProvidersModule::class])
class PhotoListModule {

    @Provides
    @ForActivity
    fun providePhotoResponseToPhotoEntityMapper(): Mapper<CommentResponse, CommentEntity> {
        return PhotoResponseToPhotoEntity()
    }

    @Provides
    @ForActivity
    fun provideGetCommentsRemoteDataSource(
        photosAPI: PhotosAPI
    ): DataSource.SingleReadable<GetCommentsRequest, List<CommentResponse>> {
        return GetCommentsRemoteDataSource(photosAPI)
    }

    @Provides
    @ForActivity
    fun provideHomeRepository(
        remoteDataSource: DataSource.SingleReadable<GetCommentsRequest, List<CommentResponse>>,
        photoResponseToPhotoEntity: Mapper<CommentResponse, CommentEntity>
    ): HomeRepository {
        return HomeRepositoryImpl(remoteDataSource, photoResponseToPhotoEntity)
    }

    @Provides
    @ForActivity
    fun providePhotoListPresenter(
        repository: HomeRepository,
        compositeDisposable: CompositeDisposable,
        @MainThreadQ mainThread: ApplicationThread,
        @BackgroundThreadQ backgroundThread: ApplicationThread
    ): HomeContract.Presenter {
        return HomePresenter(
            repository,
            compositeDisposable,
            mainThread,
            backgroundThread
        )
    }
}