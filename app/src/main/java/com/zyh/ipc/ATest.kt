package com.zyh.ipc

import android.os.Parcel
import android.os.Parcelable
import java.io.ObjectOutputStream
import java.io.Serializable


class ATest() : Serializable {
    var test: String? = null

    var bTest: BTest? = null

}