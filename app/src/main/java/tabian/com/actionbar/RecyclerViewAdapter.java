package tabian.com.actionbar;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private static final String TAG = "RecyclerViewAdapter";
    private ArrayList<String> mBookNames = new ArrayList<>();
    private ArrayList<String> mBookAuthors = new ArrayList<>();
    private ArrayList<String> mBookImages = new ArrayList<>();
    private ArrayList<ImageButton> mDeleteButton = new ArrayList<>();
    private ArrayList<ImageButton> mAddToReturnedButton = new ArrayList<>();
    private Context mContext;

    public RecyclerViewAdapter(Context context, ArrayList<String> bookNames, ArrayList<String> bookImages, ArrayList<ImageButton> deleteButtons, ArrayList<ImageButton> addToReturnedButtons, ArrayList<String> bookAuthors) {
        mBookNames = bookNames;
        mBookImages = bookImages;
        mBookAuthors = bookAuthors;
        mDeleteButton = deleteButtons;
        mAddToReturnedButton = addToReturnedButtons;
        mContext = context;

    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.not_returned_listitem, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");
        System.out.println(mBookImages.size());
        Glide.with(mContext)
                .asBitmap()
                .load(mBookImages.get(position))
                .into(holder.bookImage);


        holder.bookName.setText(mBookNames.get(position));
        Log.d(TAG, "onBindViewHolder: this method has finished");

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked on: " + mBookNames.get(position));

                Toast.makeText(mContext, mBookNames.get(position), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return mBookNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        RelativeLayout parentLayout;
        TextView bookName;
        TextView author;
        ImageButton deleteButton;
        ImageButton addToReturnedButton;
        ImageView bookImage;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            parentLayout = itemView.findViewById(R.id.notReturned_parent_layout);
            bookName = itemView.findViewById(R.id.bookname_listview);
            author = itemView.findViewById(R.id.bookauthor_listview);
            deleteButton = itemView.findViewById(R.id.delete_button);
            addToReturnedButton = itemView.findViewById(R.id.add_to_returned_button);
            bookImage = itemView.findViewById(R.id.bookcover_listview);
        }
    }
}
