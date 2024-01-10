package com.example.sejevacakeboutique.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import com.example.sejevacakeboutique.CakeModel;
import com.example.sejevacakeboutique.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SearchFragment extends Fragment {
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private SearchRecFragment searchFragment;

    private Map<String, List<CakeModel>> map;
    private SearchView searchView;

    //Cake Data
    private String[] names = {"Red Velvet Cake ", "Rainbow Cake",
            "Chocolate Cake", "Caramel Cake", "Strawberry Cheesecake","Chocolate Cheesecake","Oreo Cheesecake",
            "Lemon Cheesecake","Floral Birthday", "Chocolate Birthday","Socials Birthday", "Football Birthday","Floral Wedding Cake",
            "Rainbow Wedding Cake",
            "Heart Wedding Cake", "Crystal Wedding Cake"};
    private String[] flavors = {"Red Velvet & Vanilla", "Vanilla",
            "Chocolate", "Caramel & Chocolate","Strawberry","Chocolate",
            "Oreo Chocolate", "Lemon","Strawberry", "Chocolate",
            "Peppermint & Strawberry", "Chocolate & Vanilla","Chocolate & Vanilla", "Rum",
            "Rum", "Chocolate & Vanilla "};

    private String[] desc ={"This recipe for classic red velvet cake is made completely" +
            " from scratch and features a tangy cream cheese frosting." +
            " Make this cake for Valentine’s Day, Christmas, and birthdays!",
            "This rainbow layer cake will be the star of your next celebration! " + "Each layer is tinted" +
                    " a bright and vibrant color then assembled in order " +
                    "of the rainbow for a fun and creative show stopping dessert!",
            "This malted drip cake is smothered in cream cheese icing and drizzled with a dark chocolate ganache – a stunning multi-layered centrepiece for a big occasion"
                    + "Chocolate drip cakes create such a fun and impressive look, it’s no wonder they’ve become so popular." ,
            "This traditional Southern caramel cake is perfect for when you want layer cake, and you'd like it fast. " +
                    "It's light and fluffy under the sweet caramel glaze, which hardens at room temperature and shatters gently with every bite. ",
            "This strawberry cheesecake has a light and creamy base topped with a delicious strawberry topping made of fresh strawberries and lemon juice! ",
            "This Chocolate Cheesecake Cake is a truly decadent dessert!  It’s complete with strawberries, kiwi, oreos and other chocolate treatz! It’s a chocolate cheesecake cake dream!",
            "This Oreo cheesecake or cookies and cream cheesecake is chock-full of Oreo cookies! It’s made with an Oreo crust and generously filled with Oreo pieces! To finish, it's covered in chocolate ganache, whipped cream, and even more Oreo cookies. It's the perfect dessert for fans of this popular cookies and cream sandwich cookie!" ,
            "This sweet and tangy lemon cheesecake is made with fresh lemon juice and zest, then topped with bright, citrusy lemon curd! It’s the perfect balance of creamy, tart, and sweet flavors that makes this the best lemon cheesecake!",
            "Floral birthday cakes can have endless designs with different flowers options.  With unique playful touches and joyful accessories, " +
                    "flower cakes can bring joy and excitement .Choose from a variety of colors or seasons to inspire your unique flower cake selection. ",
            "This malted drip cake is smothered in cream cheese icing and drizzled with a dark chocolate ganache – a stunning multi-layered centrepiece for a big occasion" +
            "Chocolate drip cakes create such a fun and impressive look, it’s no wonder they’ve become so popular.",
            "Take a look at this fun and colorful cake! Its covered in bright blue and pink frosting and topped off with vibrant Social Media toppings." ,
            "Manchester United Football Cake. One of the most famous and successful football clubs in England, " +
                    "the Manchester United Football Club has truly United fans from all over the world for love of the sport and love of the club itself.","A stunning 3-tier cake layered with white fondant on the top and bottom  with blue flowers. In the middle, wrapped in a mahogany wood styled layer with you and you're loved one's initials",
            "This beautiful 3-tier wedding cake brings to life an array of colors ",
            "Heart shaped wedding cakes are incredibly romantic and a popular choice for the wedding couple. It's an all time favourite for many brides and grooms, being the perfect wedding cake shape to honour their love for each other."  ,
            "."};
    private String[] prices = {"$250.00 BBD", "$200.00 BBD", "$200.00 BBD", "$200.00 BBD","$250.00 BBD", "$300.00 BBD", "$300.00 BBD", "$400.00 BBD","$250.00 BBD", "$300.00 BBD", "$300.00 BBD", "$250.00 BBD", "$350.00 BBD", "$300.00 BBD", "$300.00 BBD", "$550.00 BBD"};

    private String[] ratings = {"4.7", "4.6", "4.7", "4.8","4.9", "4.8", "4.7", "4.6","4.9", "4.8", "4.7", "4.9","4.9", "4.8", "4.7", "4.9"};
    private int[] imgs = {R.drawable.red_velvet, R.drawable.rainbow_cake,
            R.drawable.chocolate_drizzle, R.drawable.caramel_cake,R.drawable.strawberry_cheesecake, R.drawable.chocolate_cheesecake,
            R.drawable.oreo_cheesecake, R.drawable.lemon_cheesecake,R.drawable.floral_birthday, R.drawable.chocolate_birthday,
            R.drawable.socials_birthday, R.drawable.football_birthday,R.drawable.floral_wedding, R.drawable.rainbow_weddings,
            R.drawable.heart_wedding, R.drawable.glacier_wedding};


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        searchView = view.findViewById(R.id.searchView);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return true;
            }
        });

        setData();
        return view;
    }

    private void filterList(String newText) {
        map = new HashMap<>();
        List<CakeModel> filteredList = new ArrayList<>();

        for (int i = 0; i < names.length; i++) {
            CakeModel bean = new CakeModel();
            bean.setName(names[i]);
            bean.setFlavor("Flavor: " + flavors[i]);
            bean.setDescriptions(desc[i]);
            bean.setPrice(prices[i]);
            bean.setRating(ratings[i]);
            bean.setImg(imgs[i]);
            if (bean.getName().toLowerCase().contains((newText.toLowerCase()))) {
                filteredList.add(bean);
                map.put("filter", filteredList);
                switchData(map.get("filter"));
            }
//            else{
//                Toast.makeText(getActivity(), "No data found.", Toast.LENGTH_SHORT).show();
//            }
        }

    }

    private void setData() {
        map = new HashMap<>();
        List<CakeModel> search_list = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            CakeModel bean = new CakeModel();
            bean.setName(names[i]);
            bean.setFlavor("Flavor: " + flavors[i]);
            bean.setDescriptions(desc[i]);
            bean.setPrice(prices[i]);
            bean.setRating(ratings[i]);
            bean.setImg(imgs[i]);
            search_list.add(bean);
        }
        map.put("search", search_list);//Add the data of the searchlist to the map collection
        //Set the default data to be displayed after entering the interface for the first time
        switchData(map.get("search"));
    }

    public void switchData(List<CakeModel> list) {
        fragmentManager = getParentFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();//Open a transaction
        //Instantiate the searchFragment by calling the getInstance() method
        searchFragment = new SearchRecFragment().getInstance(list);
        //Calling the replace() method
        fragmentTransaction.replace(R.id.search, searchFragment);
        fragmentTransaction.commit();
    }

}