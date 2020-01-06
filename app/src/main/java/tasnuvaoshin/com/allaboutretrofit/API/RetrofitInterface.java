package tasnuvaoshin.com.allaboutretrofit.API;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import tasnuvaoshin.com.allaboutretrofit.Model.GetDataClass;
import tasnuvaoshin.com.allaboutretrofit.Model.GetDataCommentClass;
import tasnuvaoshin.com.allaboutretrofit.Model.PostDataClass;

public interface RetrofitInterface {

    @GET("posts")
    Call<List<GetDataClass>> getPostData();


    //thsi is for path wise data passing
    @GET("posts/{id}/comments")
    Call<List<GetDataCommentClass>> getPostCommentData(@Path("id") int id);


//    //this is for query data passing (Single Query)
//    @GET("posts")
//    Call<List<PostDataCommentClass>> PostComment(
//            @Query("userId") int id
//
//    );
//

    //this is for query data passing (Multiple  Query)
    @GET("posts")
    Call<List<GetDataCommentClass>> PostComment(
            @Query("userId") int id,
            @Query("userId") int id2, //for mulitple user id fetching
            @Query("_sort") String sort,
            @Query("_order") String order

    );

    //querymap
    @GET("posts")
    Call<List<GetDataCommentClass>> PostCommentMap(
            @QueryMap Map<String,String> OurParameter
            );






    //Post method starts from here


    @POST("posts")
    Call<PostDataClass> setPostData(@Body PostDataClass postDataClass);





}
