package com.bo.maccore.repository

/**
 * @author ex-yangjb001
 * @date 2018/7/23.
 */
@Suppress("DataClassPrivateConstructor")
data class NetWorkState private constructor(
        val status: Status,
        val msg: String? = null) {
    companion object {
        val LOADED = NetWorkState(Status.SUCCESS)
        val LOADING = NetWorkState(Status.RUNNING)
        fun error(msg: String?) = NetWorkState(Status.FAILED, msg)
    }
}

enum class Status {
    RUNNING,
    SUCCESS,
    FAILED
}
