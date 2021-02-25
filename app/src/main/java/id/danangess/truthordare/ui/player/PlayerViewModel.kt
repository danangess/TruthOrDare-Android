package id.danangess.truthordare.ui.player

import id.danangess.truthordare.data.DataManager
import id.danangess.truthordare.ui.BaseViewModel
import id.danangess.truthordare.utils.SchedulerProvider

class PlayerViewModel(dataManager: DataManager, schedulerProvider: SchedulerProvider) :
    BaseViewModel<PlayerNavigator>(dataManager, schedulerProvider) {

    fun addPlayer(name: String) {
        dataManager.addUser(name)
    }

    fun play() {
        getNavigator()?.openPlayActivity()
    }

    fun removePlayer(name: String) {
        dataManager.removeUser(name)
    }
}