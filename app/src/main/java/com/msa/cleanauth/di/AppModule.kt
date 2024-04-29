package com.msa.cleanauth.di

import com.msa.data.api.ProductApi
import com.msa.data.repository.product.ProductRepositoryImp
import com.msa.domain.repository.ProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    fun provideProductRemoteDataSoure(productApi: ProductApi) : ProductRepository{
        return  ProductRepositoryImp(productApi);
    }
    @Singleton
    @Provides
    fun provideMovieApi(retrofit: Retrofit): ProductApi {
        return retrofit.create(ProductApi::class.java)
    }
}