package tk.zedlabs.ieeemadc.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Status {

    @SerializedName("status")
    @Expose
    var status : String?= null

    @SerializedName("data")
    @Expose
    var data : Data?= null
}