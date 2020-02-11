package com.servicenow.flicker.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.servicenow.flicker.R;
import com.servicenow.flicker.databinding.FragmentPhotosBinding;
import com.servicenow.flicker.di.Injectable;
import com.servicenow.flicker.network.model.ImagesModel;
import com.servicenow.flicker.viewmodel.PhotosListViewModel;

import javax.inject.Inject;

public class PhotosListFragment extends Fragment implements Injectable, PhotosAdapter.ClickListener {

    public static final String TAG = "ProjectListFragment";
    private FragmentPhotosBinding binding;

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    private PhotosAdapter photosAdapter;

    private PhotosListViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_photos, container, false);
        binding.setIsLoading(true);

        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        photosAdapter = new PhotosAdapter(getContext(), this);
        binding.photosList.setAdapter(photosAdapter);
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(PhotosListViewModel.class);


        binding.snEtSearch.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                observeViewModel(viewModel, v.getText().toString());
                hideKeyboard();
                return true;
            }
            return false;
        });
    }

    private void hideKeyboard() {
        final InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getView().getWindowToken(), 0);
    }

    private void observeViewModel(PhotosListViewModel viewModel, String text) {

        viewModel.getPhotosListObservable(text).observe(this, new Observer<ImagesModel>() {
            @Override
            public void onChanged(ImagesModel imagesModel) {
                photosAdapter.setProjectList(imagesModel.getPhotos().getPhoto());
            }
        });
    }

    @Override
    public void onClick(String url) {
        Bundle bundle = new Bundle();
        bundle.putString("image_url", url);
        getActivity().getSupportFragmentManager().beginTransaction()
                .addToBackStack(FullViewFragment.class.getSimpleName())
                .add(R.id.fragment_container, FullViewFragment.getInstance(bundle),
                FullViewFragment.class.getSimpleName()).commit();
    }
}
