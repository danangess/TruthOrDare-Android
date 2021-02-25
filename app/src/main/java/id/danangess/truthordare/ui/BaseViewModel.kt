package id.danangess.truthordare.ui

import androidx.lifecycle.ViewModel
import androidx.databinding.ObservableBoolean
import id.danangess.truthordare.data.DataManager
import id.danangess.truthordare.utils.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import java.lang.ref.WeakReference

abstract class BaseViewModel<N>(
    val dataManager: DataManager,
    val schedulerProvider: SchedulerProvider
) : ViewModel() {
    private lateinit var mNavigator: WeakReference<N>

    val isLoading = ObservableBoolean()
    val compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

    fun getNavigator(): N? = mNavigator.get()

    fun setNavigator(navigator: N) {
        mNavigator = WeakReference(navigator)
    }
}