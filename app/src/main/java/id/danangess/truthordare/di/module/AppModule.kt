package id.danangess.truthordare.di.module

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import id.danangess.truthordare.data.AppDataManager
import id.danangess.truthordare.data.DataManager
import id.danangess.truthordare.data.local.db.AppBaseRepository
import id.danangess.truthordare.data.local.db.AppDatabase
import id.danangess.truthordare.data.local.db.BaseRepository
import id.danangess.truthordare.data.local.db.dao.DareDao
import id.danangess.truthordare.data.local.db.dao.TruthDao
import id.danangess.truthordare.data.local.prefs.AppPreferencesHelper
import id.danangess.truthordare.data.local.prefs.PreferencesHelper
import id.danangess.truthordare.data.model.db.Dare
import id.danangess.truthordare.data.model.db.Truth
import id.danangess.truthordare.di.DatabaseInfo
import id.danangess.truthordare.di.PreferenceInfo
import id.danangess.truthordare.utils.AppConstants
import id.danangess.truthordare.utils.SchedulerProvider
import id.danangess.truthordare.utils.rx.AppSchedulerProvider
import javax.inject.Singleton

@Module
class AppModule {
    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    @DatabaseInfo
    fun provideDatabaseName(): String {
        return AppConstants.DB_NAME
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@DatabaseInfo dbName: String, context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, dbName)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideTruthRepository(appDatabase: AppDatabase): BaseRepository<Truth> {
        return AppBaseRepository(appDatabase.truthDao)
    }

    @Provides
    @Singleton
    fun provideDareRepository(appDatabase: AppDatabase): BaseRepository<Dare> {
        return AppBaseRepository(appDatabase.dareDao)
    }

    @Provides
    @Singleton
    fun providerAppPreferencesHelper(appPreferencesHelper: AppPreferencesHelper): PreferencesHelper {
        return appPreferencesHelper
    }

    @Provides
    @PreferenceInfo
    fun providePreferenceName(): String {
        return AppConstants.PREF_NAME
    }

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
    }

    @Provides
    @Singleton
    fun provideDataManager(appDataManager: AppDataManager): DataManager {
        return appDataManager
    }

    @Provides
    fun provideSchedulerProvider(): SchedulerProvider {
        return AppSchedulerProvider()
    }
}