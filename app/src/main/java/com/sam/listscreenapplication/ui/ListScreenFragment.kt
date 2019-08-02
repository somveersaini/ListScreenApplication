package com.sam.listscreenapplication.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.sam.listscreenapplication.R
import com.sam.listscreenapplication.databinding.ListScreenFragmentBinding
import com.sam.listscreenapplication.ui.adapter.ListScreenAdapter
import com.sam.listscreenapplication.viewmodel.*
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class ListScreenFragment : Fragment() {

    companion object {
        fun newInstance() = ListScreenFragment()
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var adapter: ListScreenAdapter

    private lateinit var viewModel: ListScreenViewModel
    private lateinit var binding: ListScreenFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding  = DataBindingUtil.inflate(inflater, R.layout.list_screen_fragment, container, false)
        return binding.root
    }

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ListScreenViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecylerView()
        observeForcastViewModel()
    }

    private fun initRecylerView() {
        with(binding.content.listRecyclerView) {
            layoutManager = LinearLayoutManager(activity)
            adapter = this@ListScreenFragment.adapter
        }
    }

    private fun observeForcastViewModel() {
        viewModel.getListScreenViewState().observe(this, Observer<ListScreenViewState> { state -> render(state) })
        viewModel.fetchListScreenData()
    }

    private fun render(viewState: ListScreenViewState) {
        binding.viewState = viewState
        if (viewState is SuccessState) renderList(viewState)
    }

    private fun renderList(viewState: SuccessState) {
        Log.d("ListData", viewState.listScreenData.toString())
        adapter.update(viewState.listScreenData)
    }


}