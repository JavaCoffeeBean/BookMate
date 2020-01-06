package tabian.com.actionbar;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface OpenLibraryApi {

    @GET("books/v1/volumes?key=AIzaSyDG6IF6-n0EDhvSfac4OYNqtU520xQUqzQ&")
    Call<Post> getPosts(@Query("q") long isbnCode);

}
