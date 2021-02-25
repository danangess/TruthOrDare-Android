package id.danangess.truthordare.ui.player

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class PlayerFragmentProvider {
    @ContributesAndroidInjector(
        modules = [
            PlayerFragmentModule::class]
    )
    abstract fun providePlayerFragmentFactory(): PlayerFragment
}