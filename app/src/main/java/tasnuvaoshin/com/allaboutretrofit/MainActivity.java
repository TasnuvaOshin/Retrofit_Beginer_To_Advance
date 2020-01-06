package tasnuvaoshin.com.allaboutretrofit;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import tasnuvaoshin.com.allaboutretrofit.API.RetrofitInterface;
import tasnuvaoshin.com.allaboutretrofit.Model.GetDataClass;
import tasnuvaoshin.com.allaboutretrofit.Model.GetDataCommentClass;
import tasnuvaoshin.com.allaboutretrofit.Model.PostDataClass;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Map<String, String> myParameter;
    private PostDataClass postDataClass; //for post method work

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textview);
        myParameter = new HashMap<>();

        myParameter.put("userId", "1");
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        postDataClass = new PostDataClass(5, "oshin", "tasnuva oshin");

        //this is the retrofit initialization

        RetrofitInterface retrofitInterface = retrofit.create(RetrofitInterface.class);
        Call<List<GetDataClass>> call = retrofitInterface.getPostData();
        // Call<List<PostDataCommentClass>> callForComment = retrofitInterface.getPostCommentData(3); //this is for path wise data fetching
        // Call<List<PostDataCommentClass>> callForComment = retrofitInterface.PostComment(3);         //this is for query wise data fetching for single query

        //mulitple query calling
        //   Call<List<GetDataCommentClass>> callForComment = retrofitInterface.PostCommentMap(myParameter);
        Call<PostDataClass> callForComment = retrofitInterface.setPostData(postDataClass); //this is for post method


        callForComment.enqueue(new Callback<PostDataClass>() {
            @Override
            public void onResponse(Call<PostDataClass> call, Response<PostDataClass> response) {
                if (!response.isSuccessful()) {
                    Log.d("error", String.valueOf(response.code()));
                    return;
                }
                PostDataClass postResponse = response.body();
                String content = "";

                        content += "ID: " + postResponse.getTitle() + "\n";
                        content += "ID: " + postResponse.getUserId() + "\n";
                        content += "ID: " + postResponse.getBody() + "\n";

                        Log.d("response", String.valueOf(response.code()));
                textView.setText(content);

            }

            @Override
            public void onFailure(Call<PostDataClass> call, Throwable t) {

            }
        });

//       callForComment.enqueue(new Callback<List<GetDataCommentClass>>() {
//            @Override
//            public void onResponse(Call<List<GetDataCommentClass>> call, Response<List<GetDataCommentClass>> response) {
//                if (!response.isSuccessful()) {
//                    Log.d("error", String.valueOf(response.code()));
//                    return;
//                } else {
//
//                    List<GetDataCommentClass> commentClasses = response.body();
//
//                    for (GetDataCommentClass commentClasses1 : commentClasses) {
//                        String content = "";
//                        content += "ID: " + commentClasses1.getId() + "\n";
//                        content += "ID: " + commentClasses1.getEmail() + "\n";
//                        content += "ID: " + commentClasses1.getName() + "\n";
//                        content += "ID: " + commentClasses1.getBody() + "\n";
//                        content += "ID: " + commentClasses1.getPostId() + "\n";
//                        Log.d("Only Post Data", content); //just for checking issue
//                        textView.append(content);
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<GetDataCommentClass>> call, Throwable t) {
//                Log.d("error", String.valueOf(t.getMessage()));
//
//            }
//        });

        call.enqueue(new Callback<List<GetDataClass>>() {
            @Override
            public void onResponse(Call<List<GetDataClass>> call, Response<List<GetDataClass>> response) {

                if (!response.isSuccessful()) {
                    Log.d("error", String.valueOf(response.code()));
                    return;
                } else {

                    List<GetDataClass> postDataClasses = response.body();

                    for (GetDataClass postDataClass : postDataClasses) {
                        String content = "";
                        content += "ID: " + postDataClass.getId() + "\n";
                        content += "ID: " + postDataClass.getUserId() + "\n";
                        content += "ID: " + postDataClass.getTitle() + "\n";
                        content += "ID: " + postDataClass.getBody() + "\n";
                        Log.d("Only Post Data", content); //just for checking issue
                        //  textView.append(content);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<GetDataClass>> call, Throwable t) {
                Log.d("error", "Something Went Wrong"
                );
            }
        });
    }
}
