package com.leb.jet.modules.test.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.leb.jet.modules.test.paging.ExPagingSource

class TestPagingViewModel:ViewModel() {

    val flow = Pager(
        // Configure how data is loaded by passing additional properties to
        // PagingConfig, such as prefetchDistance.
        PagingConfig(pageSize = 20)
    ) {
        ExPagingSource()
    }.flow
        .cachedIn(viewModelScope)
}