package com.leb.jet.modules.test.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.leb.jet.model.test.TestUser

class ExPagingSource : PagingSource<Int, TestUser>() {

    override fun getRefreshKey(state: PagingState<Int, TestUser>): Int? {
        return state.anchorPosition?.let { anchorPosition->
            val anchorpage = state.closestPageToPosition(anchorPosition);
            anchorpage?.prevKey?.plus(1) ?: anchorpage?.nextKey?.minus(1);
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, TestUser> {
        val nextPageNumber = params.key ?: 1;
        //模拟一步任务，加载数据。
        val list = mutableListOf<TestUser>();
        for(i in 1..20) {
            list.add(TestUser("ZhanSan-->$i","LastName-->$i",i));
        }
        return LoadResult.Page(list,prevKey =  null,nextKey = nextPageNumber+1);
    }
}