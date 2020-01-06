package tasnuvaoshin.com.allaboutretrofit;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import tasnuvaoshin.com.allaboutretrofit.API.RetrofitInterface;
import tasnuvaoshin.com.allaboutretrofit.Model.PostDataClass;
import tasnuvaoshin.com.allaboutretrofit.Model.PostDataCommentClass;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textview);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        //this is the retrofit initialization

        RetrofitInterface retrofitInterface = retrofit.create(RetrofitInterface.class);
        Call<List<PostDataClass>> call = retrofitInterface.getPostData();
        Call<List<PostDataCommentClass>> callForComment = retrofitInterface.getPostCommentData(3);

        callForComment.enqueue(new Callback<List<PostDataCommentClass>>() {
            @Override
            public void onResponse(Call<List<PostDataCommentClass>> call, Response<List<PostDataCommentClass>> response) {
                if (!response.isSuccessful()) {
                    Log.d("error", String.valueOf(response.code()));
                    return;
                } else {

                    List<PostDataCommentClass> commentClasses = response.body();

                    for (PostDataCommentClass commentClasses1 : commentClasses) {
                        String content = "";
                        content += "ID: " + commentClasses1.getId() + "\n";
                        content += "ID: " + commentClasses1.getEmail() + "\n";
                        content += "ID: " + commentClasses1.getName() + "\n";
                        content += "ID: " + commentClasses1.getBody() + "\n";
                        content += "ID: " + commentClasses1.getPostId() + "\n";
                        Log.d("Only Post Data", content); //just for checking issue
                        textView.append(content);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<PostDataCommentClass>> call, Throwable t) {
                Log.d("error", String.valueOf(t.getMessage()));

            }
        });

        call.enqueue(new Callback<List<PostDataClass>>() {
            @Override
            public void onResponse(Call<List<PostDataClass>> call, Response<List<PostDataClass>> response) {

                if (!response.isSuccessful()) {
                    Log.d("error", String.valueOf(response.code()));
                    return;
                } else {

                    List<PostDataClass> postDataClasses = response.body();

                    for (PostDataClass postDataClass : postDataClasses) {
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
            public void onFailure(Call<List<PostDataClass>> call, Throwable t) {
                Log.d("error", "Something Went Wrong"
                );
            }
        });
    }
}
