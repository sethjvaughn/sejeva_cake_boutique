package com.example.sejevacakeboutique.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sejevacakeboutique.CakeModel;
import com.example.sejevacakeboutique.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class HomeFragment extends Fragment {

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private TextView tv_cake, tv_cheesecake, tv_birthday, tv_wedding;
    private RecFragment popularFragment, recommendFragment;


    //Cake Data
    private String[] cake_names = {"Red Velvet Cake ", "Rainbow Cake", "Chocolate Cake", "Caramel Cake"};
    private String[] cake_flavors = {"Red Velvet & Vanilla", "Vanilla", "Chocolate", "Caramel & Chocolate"};

    private String[] cake_desc = {"This recipe for classic red velvet cake is made completely" +
            " from scratch and features a tangy cream cheese frosting." +
            " Make this cake for Valentine’s Day, Christmas, and birthdays!",
            "This rainbow layer cake will be the star of your next celebration! " + "Each layer is tinted" +
                    " a bright and vibrant color then assembled in order " +
                    "of the rainbow for a fun and creative show stopping dessert!",
            "This malted drip cake is smothered in cream cheese icing and drizzled with a dark chocolate ganache – a stunning multi-layered centrepiece for a big occasion"
            + "Chocolate drip cakes create such a fun and impressive look, it’s no wonder they’ve become so popular." ,
            "This traditional Southern caramel cake is perfect for when you want layer cake, and you'd like it fast. " +
                    "It's light and fluffy under the sweet caramel glaze, which hardens at room temperature and shatters gently with every bite. "};
    private String[] cake_prices = {"$250.00 BBD", "$200.00 BBD", "$200.00 BBD", "$200.00 BBD"};

    private String[] cake_ratings = {"4.7", "4.6", "4.7", "4.8"};
    private int[] cake_imgs = {R.drawable.red_velvet, R.drawable.rainbow_cake,
            R.drawable.chocolate_drizzle, R.drawable.caramel_cake};


    //Cheesecake Data
    private String[] cc_names = {"Strawberry Cheesecake",
            "Chocolate Cheesecake",
            "Oreo Cheesecake", "Lemon Cheesecake"};
    private String[] cc_flavors = {"Strawberry", "Chocolate",
            "Oreo Chocolate", "Lemon"};

    private String[] cc_desc = {"This strawberry cheesecake has a light and creamy base topped with a delicious strawberry topping made of fresh strawberries and lemon juice! ",
            "This Chocolate Cheesecake Cake is a truly decadent dessert!  It’s complete with strawberries, kiwi, oreos and other chocolate treatz! It’s a chocolate cheesecake cake dream!",
            "This Oreo cheesecake or cookies and cream cheesecake is chock-full of Oreo cookies! It’s made with an Oreo crust and generously filled with Oreo pieces! To finish, it's covered in chocolate ganache, whipped cream, and even more Oreo cookies. It's the perfect dessert for fans of this popular cookies and cream sandwich cookie!" ,
            "This sweet and tangy lemon cheesecake is made with fresh lemon juice and zest, then topped with bright, citrusy lemon curd! It’s the perfect balance of creamy, tart, and sweet flavors that makes this the best lemon cheesecake!\n"
                   };
    private String[] cc_prices = {"$180.00 BBD", "$150.00 BBD", "$200.00 BBD", "$150.00 BBD"};

    private String[] cc_ratings = {"4.9", "4.8", "4.7", "4.9"};
    private int[] cc_imgs = {R.drawable.strawberry_cheesecake, R.drawable.chocolate_cheesecake,
            R.drawable.oreo_cheesecake, R.drawable.lemon_cheesecake};

    //Birthday Data
    private String[] bday_names = {"Floral Birthday Cake",
            "Chocolate Birthday Cake",
            "Socials Birthday Cake", "Football Birthday Cake"};
    private String[] bday_flavors = {"Strawberry", "Chocolate",
            "Peppermint & Strawberry", "Chocolate & Vanilla "};
    private String[] bday_desc= {"Floral birthday cakes can have endless designs with different flowers options.  With unique playful touches and joyful accessories, " +
            "flower cakes can bring joy and excitement .Choose from a variety of colors or seasons to inspire your unique flower cake selection. ",
            "This malted drip cake is smothered in cream cheese icing and drizzled with a dark chocolate ganache – a stunning multi-layered centrepiece for a big occasion" +
                    "Chocolate drip cakes create such a fun and impressive look, it’s no wonder they’ve become so popular.",
            "Take a look at this fun and colorful cake! Its covered in bright blue and pink frosting and topped off with vibrant Social Media toppings."  ,
            "Manchester United Football Cake. One of the most famous and successful football clubs in England, " +
                    "the Manchester United Football Club has truly United fans from all over the world for love of the sport and love of the club itself."};
    private String[] bday_prices = {"$250.00 BBD", "$300.00 BBD", "$300.00 BBD", "$250.00 BBD"};

    private String[] bday_ratings = {"4.9", "4.8", "4.7", "4.9"};
    private int[] bday_imgs = {R.drawable.floral_birthday, R.drawable.chocolate_birthday,
            R.drawable.socials_birthday, R.drawable.football_birthday};


    //Wedding Data
    private String[] wed_names = {"Floral Wedding Cake",
            "Rainbow Wedding Cake",
            "Heart Wedding Cake", "Crystal Wedding Cake"};
    private String[] wed_flavors = {"Chocolate & Vanilla", "Rum",
            "Rum", "Chocolate & Vanilla "};
    private String[] wed_desc= {"A stunning 3-tier cake layered with white fondant on the top and bottom  with blue flowers. In the middle, wrapped in a mahogany wood styled layer with you and you're loved one's initials",
            "This beautiful 3-tier wedding cake brings to life an array of colors ",
            "Heart shaped wedding cakes are incredibly romantic and a popular choice for the wedding couple. It's an all time favourite for many brides and grooms, being the perfect wedding cake shape to honour their love for each other."  ,
            "."};
    private String[] wed_price = {"$350.00 BBD", "$300.00 BBD", "$300.00 BBD", "$550.00 BBD"};

    private String[] wed_ratings = {"4.9", "4.8", "4.7", "4.9"};
    private int[] wed_imgs = {R.drawable.floral_wedding, R.drawable.rainbow_weddings,
            R.drawable.heart_wedding, R.drawable.glacier_wedding};

    //Recommend Data
    private String[] rec_name = {"Football Birthday",
            "Strawberry Cheesecake",
            "Chocolate Birthday", "Floral Wedding Cake"};
    private String[] rec_flavor = {"Chocolate & Vanilla", "Strawberry",
            "Chocolate", "Chocolate & Vanilla"};

    private String[] rec_desc = {"Manchester United Football Cake. One of the most famous and successful football clubs in England, " +
            "the Manchester United Football Club has truly United fans from all over the world for love of the sport and love of the club itself.",
            "This strawberry cheesecake has a light and creamy base topped with a delicious strawberry topping made of fresh strawberries and lemon juice! ",
            "This malted drip cake is smothered in cream cheese icing and drizzled with a dark chocolate ganache – a stunning multi-layered centrepiece for a big occasion"
            + "Chocolate drip cakes create such a fun and impressive look, it’s no wonder they’ve become so popular.",
            "A stunning 3-tier cake layered with white fondant on the top and bottom  with blue flowers. In the middle, wrapped in a mahogany wood styled layer with you and you're loved one's initials."};
    private String[] rec_price = {"$250.00 BBD", "$180.00 BBD", "$300.00 BBD", "$350.00 BBD"};


    private String[] rec_rating = {"4.9", "4.9", "4.9", "4.9"};
    private int[] rec_img = {R.drawable.football_birthday, R.drawable.strawberry_cheesecake,
            R.drawable.chocolate_birthday, R.drawable.floral_birthday};


    private Map<String, List<CakeModel>> map;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
            tv_cake = view.findViewById(R.id.tv_cakes);
            tv_cake.setBackgroundResource(R.drawable.border_fill);
            tv_cheesecake = view.findViewById(R.id.tv_cheese_cake);
            tv_birthday = view.findViewById(R.id.tv_birthday);
            tv_wedding = view.findViewById(R.id.tv_wedding);


        setData();
        clickEvent();
        return view;
    }


    private void setData(){
        map=new HashMap<>();
        List<CakeModel> cake_list=new ArrayList<>();
        List<CakeModel> cc_list=new ArrayList<>();
        List<CakeModel> bday_list=new ArrayList<>();
        List<CakeModel> wed_list=new ArrayList<>();

        List<CakeModel> rec_list=new ArrayList<>();

        for (int i=0;i<cake_names.length;i++){
           CakeModel bean = new CakeModel();
            bean.setName(cake_names[i]);
            bean.setFlavor("Flavor: " + cake_flavors[i]);
            bean.setPrice(cake_prices[i]);
            bean.setDescriptions(cake_desc[i]);
            bean.setRating(cake_ratings[i]);
            bean.setImg(cake_imgs[i]);
            cake_list.add(bean);
        }
        map.put("cake",cake_list);//Add the data of the cake list to the map collection

        for (int i=0;i<cc_names.length;i++){
            CakeModel bean=new CakeModel();
            bean.setName(cc_names[i]);
            bean.setFlavor("Flavor: " + cc_flavors[i]);
            bean.setDescriptions(cc_desc[i]);
            bean.setPrice(cc_prices[i]);
            bean.setRating(cc_ratings[i]);
            bean.setImg(cc_imgs[i]);
            cc_list.add(bean);
        }
        map.put("cheesecake",cc_list); //Add data from the cheesecake list to the map collection

        for (int i=0;i<bday_names.length;i++){
            CakeModel bean=new CakeModel();
            bean.setName(bday_names[i]);
            bean.setFlavor("Flavor: " + bday_flavors[i]);
            bean.setDescriptions(bday_desc[i]);
            bean.setPrice(bday_prices[i]);
            bean.setRating(bday_ratings[i]);
            bean.setImg(bday_imgs[i]);
            bday_list.add(bean);
        }
        map.put("birthday",bday_list); //Add data from the birthday list to the map collection

        for (int i=0;i<wed_names.length;i++){
            CakeModel bean=new CakeModel();
            bean.setName(wed_names[i]);
            bean.setFlavor("Flavor: " + wed_flavors[i]);
            bean.setDescriptions(wed_desc[i]);
            bean.setPrice(wed_price[i]);
            bean.setRating(wed_ratings[i]);
            bean.setImg(wed_imgs[i]);
            wed_list.add(bean);
        }
        map.put("wedding",wed_list); //Add data from the wedding list to the map collection

        for (int i=0;i<rec_name.length;i++){
            CakeModel bean=new CakeModel();
            bean.setName(rec_name[i]);
            bean.setFlavor("Flavor: " + rec_flavor[i]);
            bean.setDescriptions(rec_desc[i]);
            bean.setPrice(rec_price[i]);
            bean.setRating(rec_rating[i]);
            bean.setImg(rec_img[i]);
            rec_list.add(bean);
        }
        map.put("recommend",rec_list); //Add data from the recommended list to the map collection
    }
    private void clickEvent() {
        tv_cake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchData(map.get("cake"));
                tv_cake.setBackgroundResource(R.drawable.border_fill);
                tv_cheesecake.setBackgroundResource(R.drawable.border);
                tv_birthday.setBackgroundResource(R.drawable.border);
                tv_wedding.setBackgroundResource(R.drawable.border);
            }
        });
        tv_cheesecake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchData(map.get("cheesecake"));
                tv_cheesecake.setBackgroundResource(R.drawable.border_fill);
                tv_cake.setBackgroundResource(R.drawable.border);
                tv_birthday.setBackgroundResource(R.drawable.border);
                tv_wedding.setBackgroundResource(R.drawable.border);
            }
        });

        tv_birthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchData(map.get("birthday"));
                tv_birthday.setBackgroundResource(R.drawable.border_fill);
                tv_cake.setBackgroundResource(R.drawable.border);
                tv_cheesecake.setBackgroundResource(R.drawable.border);
                tv_wedding.setBackgroundResource(R.drawable.border);
            }
        });

        tv_wedding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchData(map.get("wedding"));
                tv_wedding.setBackgroundResource(R.drawable.border_fill);
                tv_cake.setBackgroundResource(R.drawable.border);
                tv_cheesecake.setBackgroundResource(R.drawable.border);
                tv_birthday .setBackgroundResource(R.drawable.border);
            }
        });

        //Set the default data to be displayed after entering the interface for the first time
        switchData(map.get("cake"));
        switchData2(map.get("recommend"));

    }

    public void switchData(List<CakeModel> list) {
        fragmentManager = getParentFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();//Open a transaction
        //Instantiate the popular fragment by calling the getInstance() method
        popularFragment = new RecFragment().getInstance(list);
        //Calling the replace() method
        fragmentTransaction.replace(R.id.popular, popularFragment);
        fragmentTransaction.commit();
    }

    public void switchData2(List<CakeModel> list) {
        fragmentManager = getParentFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();//Open a transaction
        //Instantiate the recommendFragment by calling the getInstance() method
        recommendFragment = new RecFragment().getInstance(list);
        //Calling the replace() method
        fragmentTransaction.replace(R.id.recommend, recommendFragment);
        fragmentTransaction.commit();
    }

}