package com.example.healthcare_app.ui.home;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.example.healthcare_app.AutoScrollAdapter;
import com.example.healthcare_app.databinding.FragmentHomeBinding;

import java.util.Timer;
import java.util.TimerTask;

public class HomeFragment extends Fragment {
    AutoScrollAdapter autoScrollAdapter;
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        final SearchView searchView= binding.searchview1;
        int id = searchView.getContext()
                .getResources()
                .getIdentifier("android:id/search_src_text", null, null);
        final TextView textViewSV = (TextView) searchView.findViewById(id);
        textViewSV.setTextColor(Color.rgb(0,66,85));
        textViewSV.setHintTextColor(Color.rgb(0,66,85));

        recyclerView=binding.RVPopular;
        setRV();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void setRV() {
        layoutManager=new LinearLayoutManager(this.requireContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        autoScrollAdapter= new AutoScrollAdapter(this.requireContext());
        recyclerView.setAdapter(autoScrollAdapter);
        LinearSnapHelper snapHelper=new LinearSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);

        Timer timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (layoutManager.findLastCompletelyVisibleItemPosition()< (autoScrollAdapter.getItemCount() - 1)){
                    layoutManager.smoothScrollToPosition(recyclerView, new RecyclerView.State(), layoutManager.findLastCompletelyVisibleItemPosition() + 1);
                } else{
                    layoutManager.smoothScrollToPosition(recyclerView, new RecyclerView.State(), 0);
                }
            }
        }, 0, 3000);
    }
}