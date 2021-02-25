package id.danangess.truthordare.ui.main.fragment

import dagger.Module
import dagger.Provides
import id.danangess.truthordare.data.DataManager
import id.danangess.truthordare.utils.SchedulerProvider

@Module
class MainFragmentModule {
    @Provides
    fun provideMainFragmentViewModel(
        dataManager: DataManager,
        schedulerProvider: SchedulerProvider
    ): MainFragmentViewModel {
        return MainFragmentViewModel(dataManager, schedulerProvider)
    }
}