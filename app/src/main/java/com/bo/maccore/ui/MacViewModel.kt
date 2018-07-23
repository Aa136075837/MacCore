package com.bo.maccore.ui

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import com.bo.maccore.repository.MacPostRepository

/**
 * @author ex-yangjb001
 * @date 2018/7/23.
 */
class MacViewModel(private val repository: MacPostRepository) : ViewModel() {
    private val names = MutableLiveData<String>()
    private val responResult = Transformations.map(names, {
        repository.postsOfSubreddit(it, 30)
    })

    val posts = Transformations.switchMap(responResult, { it.pageList })!!
    val netWorkState = Transformations.switchMap(responResult, { it.netWorkState })!!
    val refreshState = Transformations.switchMap(responResult, { it.refreshState })!!

    fun refresh() {
        responResult.value?.refresh?.invoke()
    }

    fun showNames(name: String): Boolean {
        if (names.value == name) {
            return false
        }
        names.value = name
        return true
    }

    fun retry() {
        val listing = responResult?.value
        listing?.retry?.invoke()
    }

    fun currentName(): String? = names.value
}