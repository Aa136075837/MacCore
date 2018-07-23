package com.bo.maccore.repository

import android.arch.lifecycle.LiveData
import android.arch.paging.PagedList

/**
 * @author ex-yangjb001
 * @date 2018/7/23.
 */
data class Listing<T>(
        val pageList: LiveData<PagedList<T>>,
        val netWorkState: LiveData<NetWorkState>,
        val refreshState: LiveData<NetWorkState>,
        val refresh: () -> Unit,
        val retry: () -> Unit
)