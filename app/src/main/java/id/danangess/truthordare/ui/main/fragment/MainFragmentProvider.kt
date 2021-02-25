package id.danangess.truthordare.ui.main.fragment

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainFragmentProvider {
    @ContributesAndroidInjector(
        modules = [
            MainFragmentModule::class
        ]
    )
    abstract fun provideMainFragmentFactory(): MainFragment
}