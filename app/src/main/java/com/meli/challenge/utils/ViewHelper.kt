package com.meli.challenge.utils

import android.app.Activity
import com.meli.challenge.R
import java.net.HttpURLConnection.HTTP_UNAVAILABLE

class ViewHelper(activity: Activity) {

    private var mActivity: Activity? = activity

    init {
        mActivity = activity
    }

    fun processMsgError(code: Int): String {
        return when (code) {
            HTTP_UNAVAILABLE -> mActivity!!.getString(R.string.error_internet)
            else -> {
                mActivity!!.getString(R.string.error_server)
            }
        }
    }

}