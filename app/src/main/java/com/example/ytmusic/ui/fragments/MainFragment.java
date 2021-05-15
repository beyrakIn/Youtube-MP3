package com.example.ytmusic.ui.fragments;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;

import com.example.ytmusic.R;
import com.example.ytmusic.adapters.VideoAdapter;
import com.example.ytmusic.databinding.MainFragmentBinding;
import com.example.ytmusic.models.Video;
import com.example.ytmusic.ui.viewModels.MainViewModel;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends Fragment {
    private MainFragmentBinding binding;
    private MainViewModel mViewModel;
    private View root;
    private VideoAdapter videoAdapter;
    private List<Video> videos = new ArrayList<>();

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = MainFragmentBinding.inflate(inflater, container, false);
        root = binding.getRoot();

        setSearchView();
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        videoAdapter = new VideoAdapter(getContext(), videos);
        binding.videoRecyclerView.setAdapter(videoAdapter);
        binding.videoRecyclerView.setHasFixedSize(true);
        binding.videoRecyclerView.setItemViewCacheSize(25);

        loadBanner();
    }

    private void loadBanner() {
        MobileAds.initialize(getContext(), initializationStatus -> {

        });

        AdRequest adRequest = new AdRequest.Builder().build();
        binding.adView.loadAd(adRequest);

        binding.adView.setAdListener(new AdListener() {
            @Override
            public void onAdFailedToLoad(@NonNull @NotNull LoadAdError loadAdError) {
                super.onAdFailedToLoad(loadAdError);
                new Handler().postDelayed(() -> {
                    loadBanner();
                }, 3000);
            }
        });
    }


    private void setSearchView() {
        binding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                mViewModel.setQuery(query);
//                videoAdapter.setData(new ArrayList<>());
//                editText.getText().clear();
                loadData();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    void loadData() {
        mViewModel.getBaseResponse().observe(this, baseResponse -> {
            videos = baseResponse.getVideos();
            videoAdapter.setData(videos);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}