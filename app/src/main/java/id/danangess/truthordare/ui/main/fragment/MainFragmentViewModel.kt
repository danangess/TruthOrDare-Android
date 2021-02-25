package id.danangess.truthordare.ui.main.fragment

import id.danangess.truthordare.data.DataManager
import id.danangess.truthordare.ui.BaseViewModel
import id.danangess.truthordare.utils.SchedulerProvider

class MainFragmentViewModel(dataManager: DataManager, schedulerProvider: SchedulerProvider) :
    BaseViewModel<MainFragmentNavigator>(dataManager, schedulerProvider) {

    fun play() {
        getNavigator()?.openPlayerFragment()
    }

    fun exit() {
        getNavigator()?.closeApplication()
    }
}