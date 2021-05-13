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
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;

import com.example.ytmusic.R;
import com.example.ytmusic.adapters.VideoAdapter;
import com.example.ytmusic.models.Video;
import com.example.ytmusic.ui.viewModels.MainViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends Fragment {
    private MainViewModel mViewModel;
    private View root;
    private RecyclerView recyclerView;
    private VideoAdapter videoAdapter;
    private List<Video> videos = new ArrayList<>();
    private SearchView searchView;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.main_fragment, container, false);
        searchView = root.findViewById(R.id.search_view);
        recyclerView = root.findViewById(R.id.video_recycler_view);

        setSearchView();
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        videoAdapter = new VideoAdapter(getContext(), videos);
        recyclerView.setAdapter(videoAdapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemViewCacheSize(25);
    }


    private void setSearchView() {
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
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
}