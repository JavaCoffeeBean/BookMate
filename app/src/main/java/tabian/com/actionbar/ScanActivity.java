package tabian.com.actionbar;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.zxing.Result;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import me.dm7.barcodescanner.zxing.ZXingScannerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ScanActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    private ZXingScannerView scannerView;
    private TextView txtResult;
    public static final String SCAN_TEXT = "tabian.com.actionbar";
    private static final String TAG = "MainActivity";

    private TextView book_title;
    private TextView book_author;
    private ImageView book_cover;

    ScanResult scanResult = new ScanResult();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);

        //init
        scannerView = (ZXingScannerView) findViewById(R.id.zxscan);
        txtResult = (TextView) findViewById(R.id.txt_result);

        scannerView.setResultHandler(ScanActivity.this);
        scannerView.startCamera();
    }

    @Override
    protected void onDestroy() {
        scannerView.stopCamera();
        super.onDestroy();
    }

    @Override
    public void handleResult(Result rawResult) {
        //Here we can receive raw result
        long scann = rawResult.getTimestamp();

        txtResult.setText(rawResult.getText());



        setContentView(R.layout.activity_scan_result);

        /*Intent intent = new Intent(this, ScanResult.class );
        intent.putExtra(SCAN_TEXT, scann);
        startActivity(intent);*/


        /*scannerView.startCamera();*/

        book_title = findViewById(R.id.book_title);

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
        });

    }

}
