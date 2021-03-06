package tasnuvaoshin.com.allaboutretrofit.API;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
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



    @FormUrlEncoded
    @POST("posts")
    Call<PostDataClass> SetPostFromUrl(
            @Field("userId") int userId,
            @Field("title") String title,
            @Field("body") String body

    );



    @FormUrlEncoded
    @POST("posts")
    Call<PostDataClass> SetPostFromUrlMap(
         @FieldMap Map<String,String> parameter   //post data parameter


    );

    //put data work here

    @PUT("posts/{id}")
    Call<PostDataClass> PutData(@Path("id") int id,@Body PostDataClass postDataClass);

    //pathc data work
    @PATCH("posts/{id}")
    Call<PostDataClass> PatchData(@Path("id") int id,@Body PostDataClass postDataClass);


    //delete data

    @DELETE("posts/{id}")
    Call<Void> DeleteData(@Path("id")int id);


}
