package tk.zedlabs.ieeemadc

import retrofit2.http.GET
import retrofit2.http.Query
import tk.zedlabs.ieeemadc.model.Status

interface JsonApi {

    @GET("/feed/here/")
    suspend fun getData(@Query("token") token : String) : Status
}