package com.boringapps.autodeal.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseDataBindingFragment<BINDING : ViewDataBinding>(@LayoutRes private val layoutId: Int) : Fragment() {

    protected var _binding: BINDING? = null
    protected val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        DataBindingUtil.inflate<BINDING>(inflater, layoutId, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
            _binding = this
        }.root

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}