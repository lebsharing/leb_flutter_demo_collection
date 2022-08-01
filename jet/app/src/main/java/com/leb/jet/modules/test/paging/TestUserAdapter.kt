package com.leb.jet.modules.test.paging

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.leb.jet.model.test.TestUser

class TestUserAdapter(diffCallback:DiffUtil.ItemCallback<TestUser>) :
    PagingDataAdapter<TestUser, TestUserViewHolder>(diffCallback) {
    override fun onBindViewHolder(holder: TestUserViewHolder, position: Int) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestUserViewHolder {
        TODO("Not yet implemented")
    }
}


