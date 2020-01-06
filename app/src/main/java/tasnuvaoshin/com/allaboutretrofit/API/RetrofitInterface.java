package tasnuvaoshin.com.allaboutretrofit.API;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import tasnuvaoshin.com.allaboutretrofit.Model.PostDataClass;
import tasnuvaoshin.com.allaboutretrofit.Model.PostDataCommentClass;

public interface RetrofitInterface {

    @GET("posts")
    Call<List<PostDataClass>> getPostData();

    @GET("posts/{id}/comments")
    Call<List<PostDataCommentClass>> getPostCommentData(@Path("id") int id);


}
