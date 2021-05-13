package com.example.ytmusic.ui.fragments;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ytmusic.R;
import com.example.ytmusic.ui.viewModels.MainViewModel;

public class MainFragment extends Fragment {
    private MainViewModel mViewModel;
    private View root;
    private RecyclerView recyclerView;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.main_fragment, container, false);

        recyclerView = root.findViewById(R.id.video_recycler_view);

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        mViewModel.setQuery("Rasputin");
        mViewModel.getBaseResponse().observe(this, baseResponse -> {
            System.out.println(baseResponse.toString());
        });
    }

}