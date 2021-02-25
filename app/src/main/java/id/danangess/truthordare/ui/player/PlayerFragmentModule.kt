package id.danangess.truthordare.ui.player

import dagger.Module
import dagger.Provides
import id.danangess.truthordare.data.DataManager
import id.danangess.truthordare.utils.SchedulerProvider

@Module
class PlayerFragmentModule {
    @Provides
    fun providePlayerViewModel(
        dataManager: DataManager,
        schedulerProvider: SchedulerProvider
    ): PlayerViewModel {
        return PlayerViewModel(dataManager, schedulerProvider)
    }
}