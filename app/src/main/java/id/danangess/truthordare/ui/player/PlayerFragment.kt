package id.danangess.truthordare.ui.player

import android.os.Bundle
import id.danangess.truthordare.BR
import id.danangess.truthordare.R
import id.danangess.truthordare.databinding.FragmentPlayerBinding
import id.danangess.truthordare.ui.BaseFragment

class PlayerFragment : BaseFragment<FragmentPlayerBinding, PlayerViewModel>(), PlayerNavigator {
    companion object {
        const val TAG: String = "Main/Player"

        fun newFragment(): PlayerFragment {
            val args = Bundle()
            val fragment = PlayerFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun getLayoutId(): Int = R.layout.fragment_player

    override fun getViewModel(): PlayerViewModel {
        TODO("Not yet implemented")
    }

    override val bindingVariable: Int = BR.viewModel

    override fun openPlayActivity() {
        TODO("Not yet implemented")
    }
}