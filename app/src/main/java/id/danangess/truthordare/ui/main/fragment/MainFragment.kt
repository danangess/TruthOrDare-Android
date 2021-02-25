package id.danangess.truthordare.ui.main.fragment

import android.os.Bundle
import id.danangess.truthordare.BR
import id.danangess.truthordare.R
import id.danangess.truthordare.databinding.FragmentMainBinding
import id.danangess.truthordare.ui.BaseFragment
import id.danangess.truthordare.ui.player.PlayerFragment
import javax.inject.Inject
import kotlin.system.exitProcess

class MainFragment : BaseFragment<FragmentMainBinding, MainFragmentViewModel>(),
    MainFragmentNavigator {

    companion object {
        val TAG: String = "Main/Main"

        fun newFragment(): MainFragment {
            val args = Bundle()
            val fragment = MainFragment()
            fragment.arguments = args
            return fragment
        }
    }

    @Inject
    lateinit var mMainFragmentViewModel: MainFragmentViewModel

    override val bindingVariable: Int = BR.viewModel

    override fun getLayoutId(): Int = R.layout.fragment_main

    override fun getViewModel(): MainFragmentViewModel = mMainFragmentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mMainFragmentViewModel.setNavigator(this)

        mMainFragmentViewModel.isLoading.set(false)
    }


    override fun openPlayerFragment() {
        activity!!.supportFragmentManager
            .beginTransaction()
            .disallowAddToBackStack()
            .setCustomAnimations(R.anim.slide_left, R.anim.slide_right)
            .replace(R.id.contentFragment, PlayerFragment.newFragment(), PlayerFragment.TAG)
//            .add(R.id.clRootView, PlayerFragment.newFragment(), PlayerFragment.TAG)
            .commit()
    }

    override fun showDareFragment() {
        TODO("add dare fragment")
        activity!!.supportFragmentManager
            .beginTransaction()
            .disallowAddToBackStack()
            .setCustomAnimations(R.anim.slide_left, R.anim.slide_right)
            .replace(R.id.contentFragment, PlayerFragment.newFragment(), PlayerFragment.TAG)
            .commit()
    }

    override fun showTruthFragment() {
        TODO("add truth fragment")
        activity!!.supportFragmentManager
            .beginTransaction()
            .disallowAddToBackStack()
            .setCustomAnimations(R.anim.slide_left, R.anim.slide_right)
            .replace(R.id.contentFragment, PlayerFragment.newFragment(), PlayerFragment.TAG)
            .commit()
    }

    override fun closeApplication() {
        activity?.finish()
        exitProcess(0)
    }
}