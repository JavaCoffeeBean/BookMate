package tabian.com.actionbar.ItemsList;

import com.google.gson.annotations.SerializedName;

public class ImageLinks {

    @SerializedName("smallThumbnail")
    private String smallThumbnail;

    @SerializedName("thumbnail")
    private String thumbnail;

    public String getSmallThumbnail() {
        return smallThumbnail;
    }

    public String getThumbnail() {
        return thumbnail;
    }
}
