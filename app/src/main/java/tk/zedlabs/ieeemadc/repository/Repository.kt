package tk.zedlabs.ieeemadc.repository

import tk.zedlabs.ieeemadc.JsonApi

class Repository{

    var client = RetrofitService.createService(JsonApi::class.java)

    //simplified version of the retrofit call that comes from support with coroutines
    //Note that this does NOT handle errors, to be added
    suspend fun getData(token : String) = client.getData(token)

}