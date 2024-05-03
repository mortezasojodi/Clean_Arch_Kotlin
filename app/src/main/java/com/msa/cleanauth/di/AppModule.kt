package com.msa.cleanauth.di

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.msa.data.api.ProductApi
import com.msa.data.repository.product.ProductRepositoryImp
import com.msa.domain.repository.ProductRepository
import com.msa.domain.usecase.ProductGetAllUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .baseUrl("https://fakestoreapi.com/")
            .build()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
//        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC))
        .build()

    @Singleton
    @Provides
    fun provideMovieApi(retrofit: Retrofit): ProductApi {
        return retrofit.create(ProductApi::class.java)
    }

    @Singleton
    @Provides
    fun provideProductRemoteDataSoure(productApi: ProductApi) : ProductRepository {
        return ProductRepositoryImp(productApi);
    }

    @Provides
    fun provieProducteGetAllUseCase(productRepository: ProductRepository) : ProductGetAllUseCase{
        return ProductGetAllUseCase(productRepository);
    }
}