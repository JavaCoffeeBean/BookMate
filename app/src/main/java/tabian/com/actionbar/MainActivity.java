package tabian.com.actionbar;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private SectionsPageAdapter mSectionsPageAdapter;

    private ViewPager mViewPager;

    private TabLayout tabLayout;
    private  ViewPager viewPager;
    private TabItem tab1, tab2;
    private FrameLayout homeContainer;
    public PageAdapter pagerAdapter;
    private Fragment newss;

//    private static final String TAG = "MainActivity";

    private ArrayList<String> mBookNames = new ArrayList<>();
    private ArrayList<String> mBookAuthors = new ArrayList<>();
    private ArrayList<String> mBookImages = new ArrayList<>();
    private ArrayList<ImageView> DeleteButtons = new ArrayList<>();
    private ArrayList<ImageView> AddToReturnedButtons = new ArrayList<>();

    private ArrayList<String> mBookNames2 = new ArrayList<>();
    private ArrayList<String> mBookAuthors2 = new ArrayList<>();
    private ArrayList<String> mBookImages2 = new ArrayList<>();
    private ArrayList<ImageView> DeleteButtons2 = new ArrayList<>();
    private ArrayList<ImageView> AddToReturnedButtons2 = new ArrayList<>();

    private ActionBar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(mViewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);


        tabLayout.getTabAt(0).setText("Returned");
        tabLayout.getTabAt(1).setText("Not-Returned");

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavView_Bar);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.ic_arrow:
                        tabsFunctionality();

                        break;

                    case R.id.ic_android:
                        Intent intent1 = new Intent(MainActivity.this, ActivityOne.class);
                        startActivity(intent1);
                        break;

                    case R.id.ic_books:
                        Intent intent2 = new Intent(MainActivity.this, ActivityTwo.class);
                        startActivity(intent2);
                        break;

                    case R.id.ic_center_focus:
                        Intent intent3 = new Intent(MainActivity.this, ActivityThree.class);
                        startActivity(intent3);
                        break;

                    case R.id.ic_backup:
                        Intent intent4 = new Intent(MainActivity.this, ActivityFour.class);
                        startActivity(intent4);
                        break;
                }


                return false;
            }
        });



    }

    public void tabsFunctionality() {

        Log.d(TAG, "tabsFunctionality: engaged");

        final LayoutInflater inflater2 = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater2.inflate(R.layout.activity_main,  null);




        tabLayout =  view.findViewById(R.id.tabs);
        /*tab1 =  view.findViewById(R.id.returned_Tab);
        tab2 =  view.findViewById(R.id.not_returned_Tab);*/
        viewPager =  view.findViewById(R.id.container);






        pagerAdapter = new PageAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition() == 0) {
                    pagerAdapter.notifyDataSetChanged();



                    Log.d(TAG, "onTabSelected: iq10000000! wow!");
                    Log.e(TAG, "onTabSelected: uy7uhui");





                } else if (tab.getPosition() == 1) {
                    pagerAdapter.notifyDataSetChanged();
                    initImageBitmaps2();
//                    initRecyclerView2();

                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {


            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }


    private void setupViewPager(ViewPager viewPager) {
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new Tab1Fragment());
        adapter.addFragment(new Tab2Fragment());
//        adapter.addFragment(new Tab3Fragment());
        viewPager.setAdapter(adapter);
    }

    private void initImageBitmaps(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps");





//        mImageUrls.add(/*place image url here that you got from api*/);
//        mNames.add(/*place rerecipe name here*/);


//        Example

        mBookImages.add("https://images-na.ssl-images-amazon.com/images/I/51M%2BMu05lCL._SX343_BO1,204,203,200_.jpg");
        mBookNames.add("Their Eyes Were Watching God");
        mBookAuthors.add("Zora Hurston");

        mBookImages.add("https://images-na.ssl-images-amazon.com/images/I/51rqbjzojiL._SX356_BO1,204,203,200_.jpg");
        mBookNames.add("Z for Zachariah");
        mBookAuthors.add("Robert C. O'brien");

        mBookImages.add("https://img.buzzfeed.com/buzzfeed-static/static/2013-10/enhanced/webdr01/10/10/enhanced-buzz-24944-1381414376-1.jpg?downsize=700:*&output-format=auto&output-quality=auto");
        mBookNames.add("Goosebumbs");
        mBookAuthors.add("RL Stein");

        mBookImages.add("https://images-na.ssl-images-amazon.com/images/I/511FGQPR30L._SX302_BO1,204,203,200_.jpg");
        mBookNames.add("When Things Fall Apart");
        mBookAuthors.add("Chinua Achebe");

        mBookImages.add("http://cdn.shopify.com/s/files/1/2697/1746/products/1984-book-cover-art-book-cover-prints-2_1531c558-4ea7-4a8b-95f4-1fa3534f0ee9_1200x1200.jpg?v=1571739186");
        mBookNames.add("nef");
        mBookAuthors.add("George Orwell");

        mBookImages.add("https://prodimage.images-bn.com/pimages/9781610427678_p0_v1_s550x406.jpg");
        mBookNames.add("Julius Cesar");
        mBookAuthors.add("Shakespear");




    }

    private void initImageBitmaps2(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps");





//        mImageUrls.add(/*place image url here that you got from api*/);
//        mNames.add(/*place rerecipe name here*/);


//        Example

        mBookImages2.add("https://images-na.ssl-images-amazon.com/images/I/51M%2BMu05lCL._SX343_BO1,204,203,200_.jpg");
        mBookNames2.add("Their Eyes Were Watching God");
        mBookAuthors2.add("Zora Hurston");

        mBookImages2.add("https://images-na.ssl-images-amazon.com/images/I/51rqbjzojiL._SX356_BO1,204,203,200_.jpg");
        mBookNames2.add("Z for Zachariah");
        mBookAuthors2.add("Robert C. O'brien");

        mBookImages2.add("https://img.buzzfeed.com/buzzfeed-static/static/2013-10/enhanced/webdr01/10/10/enhanced-buzz-24944-1381414376-1.jpg?downsize=700:*&output-format=auto&output-quality=auto");
        mBookNames2.add("Goosebumbs");
        mBookAuthors2.add("RL Stein");

        mBookImages2.add("https://images-na.ssl-images-amazon.com/images/I/511FGQPR30L._SX302_BO1,204,203,200_.jpg");
        mBookNames2.add("When Things Fall Apart");
        mBookAuthors2.add("Chinua Achebe");

        mBookImages2.add("http://cdn.shopify.com/s/files/1/2697/1746/products/1984-book-cover-art-book-cover-prints-2_1531c558-4ea7-4a8b-95f4-1fa3534f0ee9_1200x1200.jpg?v=1571739186");
        mBookNames2.add("nef");
        mBookAuthors2.add("George Orwell");

        mBookImages2.add("https://prodimage.images-bn.com/pimages/9781610427678_p0_v1_s550x406.jpg");
        mBookNames2.add("Julius Cesar");
        mBookAuthors2.add("Shakespear");

    }


    protected void onStart(){
        super.onStart();

        Log.d(TAG, "onStart: this method started");

        /*initRecyclerView2();*/
    }

    public void testMethod() {
        System.out.println("newborn");
    }

    /*public void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init RecyclerView.");

        LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view1 = inflater.inflate(R.layout.fragment1_layout, null);



        RecyclerView recyclerView = view1.findViewById(R.id.notReturned_recyclerview);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this,  mBookNames, mBookImages, DeleteButtons, AddToReturnedButtons, mBookAuthors);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));





    }*/

    /*public void initRecyclerView2(){
        Log.d(TAG, "initRecyclerView: init RecyclerView.");

        LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view2 = inflater.inflate(R.layout.fragment_tab2, null);

        RecyclerView recyclerView2 = view2.findViewById(R.id.returned_recyclerview2);
        ReturnedAdapter adapter2 = new ReturnedAdapter(this,  mBookNames2, mBookImages2, DeleteButtons2, AddToReturnedButtons2, mBookAuthors2);
        recyclerView2.setAdapter(adapter2);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));
    }*/

}
