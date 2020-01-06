package tasnuvaoshin.com.allaboutretrofit.API;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import tasnuvaoshin.com.allaboutretrofit.Model.PostDataClass;
import tasnuvaoshin.com.allaboutretrofit.Model.PostDataCommentClass;

public interface RetrofitInterface {

    @GET("posts")
    Call<List<PostDataClass>> getPostData();


      //thsi is for path wise data passing
    @GET("posts/{id}/comments")
    Call<List<PostDataCommentClass>> getPostCommentData(@Path("id") int id);


//    //this is for query data passing (Single Query)
//    @GET("posts")
//    Call<List<PostDataCommentClass>> PostComment(
//            @Query("userId") int id
//
//    );
//

    //this is for query data passing (Multiple  Query)
    @GET("posts")
    Call<List<PostDataCommentClass>> PostComment(
            @Query("userId") int id,
            @Query("_sort") String sort,
            @Query("_order") String order

    );
}
