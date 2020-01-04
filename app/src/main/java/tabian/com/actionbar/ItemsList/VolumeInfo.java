package tabian.com.actionbar.ItemsList;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class VolumeInfo {

    @SerializedName("title")
    private String title;

    @SerializedName("imageLinks")
    private ImageLinks imageLinks;

    @SerializedName("industryIdentifiers")
    private ArrayList<IndustryIdentifiers> industryIdentifiers;

    @SerializedName("authors")
    private ArrayList<Author> authors;


    public String getTitle() {
        return title;
    }

    public ImageLinks getImageLinks() {
        return imageLinks;
    }

    public ArrayList<IndustryIdentifiers> getIndustryIdentifiers() {
        return industryIdentifiers;
    }

    public ArrayList<Author> getAuthors() {
        return authors;
    }
}
