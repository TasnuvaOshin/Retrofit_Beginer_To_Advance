package tasnuvaoshin.com.allaboutretrofit.API;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import tasnuvaoshin.com.allaboutretrofit.Model.PostDataClass;

public interface RetrofitInterface {

    @GET("posts")
    Call<List<PostDataClass>> getPostData();


}
