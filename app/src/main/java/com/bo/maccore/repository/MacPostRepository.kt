package com.bo.maccore.repository

import com.bo.maccore.vo.RedditPost

/**
 * @author ex-yangjb001
 * @date 2018/7/23.
 */
interface MacPostRepository {
    fun postsOfSubreddit(subReddit: String, pageSize: Int): Listing<RedditPost>

    enum class Type {
        MEMORY_ITEM,
        MEMORY_PAGE,
        DB
    }
}