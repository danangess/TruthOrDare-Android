package id.danangess.truthordare.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import dagger.android.support.AndroidSupportInjection
import id.danangess.truthordare.BR

abstract class BaseFragment<T : ViewDataBinding, V : BaseViewModel<*>> : Fragment() {
    private var mActivity: BaseActivity<*, *>? = null
    private lateinit var mViewModel: V
    private lateinit var mRootView: View
    private lateinit var mViewDataBinding: T

    val activity = mActivity
    val viewDataBinding = mViewDataBinding

    @LayoutRes
    abstract fun getLayoutId(): Int
    abstract fun getViewModel(): V
    val bindingVariable: Int = BR.viewModel // abstract?

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is BaseActivity<*, *>) {
            mActivity = context
            context.onFragmentAttached()
        }
    }

    override fun onDetach() {
        mActivity = null
        super.onDetach()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        performDependencyInjection()
        super.onCreate(savedInstanceState)
        mViewModel = getViewModel()
        setHasOptionsMenu(false)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mViewDataBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        mRootView = mViewDataBinding.root
        return mRootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mViewDataBinding.setVariable(bindingVariable, mViewModel)
        mViewDataBinding.lifecycleOwner = this
        mViewDataBinding.executePendingBindings()
    }

    fun hideKeyboard() {
        activity?.hideKeyboard()
    }

    private fun performDependencyInjection() {
        AndroidSupportInjection.inject(this)
    }

    interface Callback {
        fun onFragmentAttached()

        fun onFragmentDetached(tag: String)
    }
}