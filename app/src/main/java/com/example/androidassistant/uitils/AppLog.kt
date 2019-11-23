package com.example.androidassistant.uitils

import android.util.Log

// used for log  also have disable or enable log at one point function
object AppLog {

    val ENABLE_LOG = false              //true

    fun d(tag: String, msg: String) {
        if (ENABLE_LOG) {
            Log.d(tag, msg)
        }
    }

    fun d(tag: String, msg: String, tr: Throwable) {
        if (ENABLE_LOG) {
            Log.d(tag, msg, tr)
        }
    }

    fun e(tag: String, msg: String) {
        if (ENABLE_LOG) {
            Log.e(tag, msg)
        }
    }

    fun e(tag: String, msg: String, tr: Throwable) {
        if (ENABLE_LOG) {
            Log.e(tag, msg, tr)
        }
    }

    fun printStackTrace(e: Exception) {
        if (ENABLE_LOG) {
            e.printStackTrace()
        }
    }

    fun i(tag: String, msg: String) {
        if (ENABLE_LOG) {
            Log.i(tag, msg)
        }
    }

    fun i(tag: String, msg: String, tr: Throwable) {
        if (ENABLE_LOG) {
            Log.i(tag, msg, tr)
        }
    }

    fun v(tag: String, msg: String) {
        if (ENABLE_LOG) {
            Log.v(tag, msg)
        }
    }

    fun v(tag: String, msg: String, tr: Throwable) {
        if (ENABLE_LOG) {
            Log.v(tag, msg, tr)
        }
    }

    fun w(tag: String, msg: String) {
        if (ENABLE_LOG) {
            Log.w(tag, msg)
        }
    }

    fun w(tag: String, msg: String, tr: Throwable) {
        if (ENABLE_LOG) {
            Log.w(tag, msg, tr)
        }
    }

}
