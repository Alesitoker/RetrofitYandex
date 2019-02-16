package com.iessaladillo.alejandro.retrofityandex.ui;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.iessaladillo.alejandro.retrofityandex.R;
import com.iessaladillo.alejandro.retrofityandex.data.remote.YandexApiImpl;


public class MainFragment extends Fragment {

    private EditText txtText;
    private Button btnTranslate;
    private MainFragmentViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = ViewModelProviders.of(this,
                new MainFragmentViewModelFactory(YandexApiImpl.getInstance())).get(
                        MainFragmentViewModel.class);
        setupViews(getView());
    }

    private void setupViews(View view) {
        txtText = ViewCompat.requireViewById(view, R.id.txtText);
        btnTranslate = ViewCompat.requireViewById(view, R.id.btnTranslate);

        btnTranslate.setOnClickListener(v -> translate());
    }

    private void translate() {

    }
}
