package id.danangess.truthordare.ui.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import id.danangess.truthordare.BR
import id.danangess.truthordare.R
import id.danangess.truthordare.ui.BaseActivity
import id.danangess.truthordare.databinding.ActivityMainBinding
import javax.inject.Inject

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(), MainNavigator {
    companion object {
        const val TAG = "Main"

        fun newIntent(context: Context): Intent {
            return Intent(context, MainActivity::class.java)
        }
    }

    @Inject
    lateinit var mViewModelFactory: ViewModelProvider.Factory

    private var doubleBackToExitPressedOnce = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getViewModel().setNavigator(this)
    }

    override fun onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed()
            return
        }
        doubleBackToExitPressedOnce = true
        Toast.makeText(this, "Press again to exit", Toast.LENGTH_SHORT).show()
        Handler().postDelayed({ doubleBackToExitPressedOnce = false }, 2000)
    }

    override fun onFragmentAttached() {
        TODO("Not yet implemented")
    }

    override fun onFragmentDetached(tag: String) {
        val fragment = supportFragmentManager.findFragmentByTag(tag)
        if (fragment != null) {
            supportFragmentManager
                .beginTransaction()
                .disallowAddToBackStack()
                .setCustomAnimations(R.anim.slide_left, R.anim.slide_right)
                .remove(fragment)
                .commitNow()
//            unlockDrawer()
        }
    }

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun getViewModel(): MainViewModel =
        ViewModelProviders.of(this, mViewModelFactory).get(MainViewModel::class.java)

    override val bindingVariable: Int = BR.viewModel

//    private fun lockDrawer() {
//        viewDataBinding.drawerView.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
//    }
//
//    private fun unlockDrawer() {
//        viewDataBinding.drawerView.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
//    }
}