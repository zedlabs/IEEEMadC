package tk.zedlabs.ieeemadc.model

import android.os.Debug
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Data {

    @SerializedName("aqi")
    @Expose
    var aqi: Int? = null
    @SerializedName("idx")
    @Expose
    var idx: Int? = null
    @SerializedName("city")
    @Expose
    var city: City? = null
    @SerializedName("dominentpol")
    @Expose
    var dominentpol: String? = null
    @SerializedName("iaqi")
    @Expose
    var iaqi: Iaqi? = null
    @SerializedName("debug")
    @Expose
    var debug: Debug? = null

}