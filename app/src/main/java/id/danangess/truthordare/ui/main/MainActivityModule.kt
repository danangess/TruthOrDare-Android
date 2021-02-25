package id.danangess.truthordare.ui.main

import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import id.danangess.truthordare.ViewModelProviderFactory
import id.danangess.truthordare.data.DataManager
import id.danangess.truthordare.utils.SchedulerProvider

@Module
class MainActivityModule {
    @Provides
    internal fun mainViewModelProvider(mainViewModel: MainViewModel): ViewModelProvider.Factory {
        return ViewModelProviderFactory<MainViewModel>(mainViewModel)
    }

    @Provides
    internal fun provideMainViewModel(
        dataManager: DataManager,
        schedulerProvider: SchedulerProvider
    ): MainViewModel {
        return MainViewModel(dataManager, schedulerProvider)
    }
}