package com.bo.maccore.ui

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bo.maccore.R
import com.bo.maccore.repository.MacPostRepository

class MacActivity : AppCompatActivity() {+
    companion object {
        const val KEY_SUBREDDIT = "subreddit"
        const val DEFAULT_SUBREDDIT = "androiddev"
        const val KEY_REPOSITORY_TYPE = "repository_type"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mac)
        getViewModel()
    }

    private fun getViewModel(): MacViewModel {
        return ViewModelProviders.of(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                val repoTypeParam = intent.getIntExtra(KEY_REPOSITORY_TYPE,0)
                val repoType = MacPostRepository.Type.values()[repoTypeParam]

            }
        })[MacViewModel::class.java]
    }
}
