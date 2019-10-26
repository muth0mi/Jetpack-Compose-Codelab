package io.muth0mi.bruh

import android.os.Parcel
import android.os.Parcelable
import androidx.compose.Model

@Model
class CounterState(var count: Int = 0) : Parcelable {
    constructor(parcel: Parcel) : this(parcel.readInt()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(count)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CounterState> {
        override fun createFromParcel(parcel: Parcel): CounterState {
            return CounterState(parcel)
        }

        override fun newArray(size: Int): Array<CounterState?> {
            return arrayOfNulls(size)
        }
    }
}