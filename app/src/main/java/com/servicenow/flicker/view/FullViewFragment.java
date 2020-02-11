package com.servicenow.flicker.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.servicenow.flicker.R;
import com.servicenow.flicker.databinding.FragmentFullViewBinding;
import com.servicenow.flicker.di.Injectable;

public class FullViewFragment extends Fragment implements Injectable {

    private FragmentFullViewBinding binding;

    public static FullViewFragment getInstance(Bundle args) {
        FullViewFragment fullViewFragment = new FullViewFragment();
        fullViewFragment.setArguments(args);
        return fullViewFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_full_view, container, false);

        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String url = getArguments().getString("image_url");
        Glide
                .with(getContext())
                .load(url)
                .placeholder(R.mipmap.ic_launcher)
                .into(binding.snImageFullPhoto);
    }

}
