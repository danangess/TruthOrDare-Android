package id.danangess.truthordare.di.builder

import dagger.Module
import dagger.android.ContributesAndroidInjector
import id.danangess.truthordare.ui.main.MainActivity
import id.danangess.truthordare.ui.main.MainActivityModule
import id.danangess.truthordare.ui.player.PlayerFragmentModule
import id.danangess.truthordare.ui.player.PlayerFragmentProvider

@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector(
        modules = [
            MainActivityModule::class,
            PlayerFragmentModule::class,
            PlayerFragmentProvider::class
        ]
    )
    abstract fun bindMainActivity(): MainActivity
}