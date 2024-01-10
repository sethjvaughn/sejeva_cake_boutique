package com.example.sejevacakeboutique.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sejevacakeboutique.CakeModel;
import com.example.sejevacakeboutique.R;
import com.example.sejevacakeboutique.SearchAdapter;

import java.io.Serializable;
import java.util.List;


public class SearchRecFragment extends Fragment {

    private RecyclerView rec_list;

    public SearchRecFragment() {
    }
    public SearchRecFragment getInstance(List<CakeModel> list) {
        SearchRecFragment recFragment = new SearchRecFragment();
        //Passing data through Bundle object can ensure that the data passed will not be lost when the device is switched between horizontal and vertical screens
        Bundle bundle = new Bundle();
        //Pass the string to be passed as a key-value pair into the bundle object
        bundle.putSerializable("list", (Serializable) list);
        recFragment.setArguments(bundle);
        return recFragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search_rec, container, false);
        rec_list = view.findViewById(R.id.rec_list);

        if (getArguments() != null) {
            List<CakeModel> list = (List<CakeModel>) getArguments().getSerializable("list");
            rec_list.setLayoutManager(new LinearLayoutManager(getContext()));
            SearchAdapter adapter = new SearchAdapter(getActivity(), list);
            rec_list.setAdapter(adapter);
        }
        return view;
    }

}