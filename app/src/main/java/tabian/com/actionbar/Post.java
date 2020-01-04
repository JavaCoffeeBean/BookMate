package tabian.com.actionbar;

import com.example.android.realapitest.ItemsList.Items;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import tabian.com.actionbar.ItemsList.Items;

public class Post {




    @SerializedName("items")
    private ArrayList<Items> items;

    public ArrayList<Items> getItems() {
        return items;
    }
}
