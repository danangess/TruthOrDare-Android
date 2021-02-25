package id.danangess.truthordare.ui.main

import id.danangess.truthordare.data.DataManager
import id.danangess.truthordare.ui.BaseViewModel
import id.danangess.truthordare.utils.SchedulerProvider

class MainViewModel(dataManager: DataManager, schedulerProvider: SchedulerProvider) :
    BaseViewModel<MainNavigator>(dataManager, schedulerProvider) {
}