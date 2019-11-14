package tk.zedlabs.ieeemadc

class Repository{

    var  jsonApi : JsonApi

    init {
        jsonApi = RetrofitService.createService(JsonApi::class.java)
    }
    var client = RetrofitService.createService(JsonApi::class.java)

    //simplified version of the retrofit call that comes from support with coroutines
    suspend fun getData(token : String) = client.getData(token)

}