package tk.zedlabs.ieeemadc.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Iaqi {

    @SerializedName("pm25")
    @Expose
    var pm25: PmTwoFive? = null
    @SerializedName("w")
    @Expose
    var w: W? = null

}