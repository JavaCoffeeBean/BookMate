package tabian.com.actionbar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ScanResult extends AppCompatActivity {

    private TextView book_title;
    private TextView book_author;
    private ImageView book_cover;

    private static final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_result);

        /*book_title = findViewById(R.id.book_title);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.googleapis.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        OpenLibraryApi openLibraryApi = retrofit.create(OpenLibraryApi.class);

        Call<Post> call = openLibraryApi.getPosts(9781586638474L);

        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                Log.d(TAG, "onResponse: You got a response, and it was Gucci");

                if (!response.isSuccessful()) {
                    Log.d(TAG, "onResponse:Server was contacted, but could not find what you wanted. ");
                    book_title.setText("Code: " + response.code());
                    return;
                }

                try {

                    book_title.setText(response.body().getItems().get(0).getVolumeInfo().getTitle());
                }
                catch (Exception e) {
                    book_title.setText("Error retrieviing Book name");
                }

                book_cover = findViewById(R.id.book_Cover);

                try {

                    Glide.with(book_cover).load(response.body().getItems().get(0).getVolumeInfo().getImageLinks().getThumbnail()).into(book_cover);
                }
                catch (Exception e) {
                    book_cover.setImageResource(R.drawable.noimage);
                }

            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                book_title.setText(t.getMessage());
            }
        });*/
    }


}




