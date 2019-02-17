package com.iessaladillo.alejandro.retrofityandex.ui;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.iessaladillo.alejandro.retrofityandex.R;
import com.iessaladillo.alejandro.retrofityandex.base.EventObserver;
import com.iessaladillo.alejandro.retrofityandex.data.RepositoryImpl;
import com.iessaladillo.alejandro.retrofityandex.data.remote.YandexApiImpl;
import com.iessaladillo.alejandro.retrofityandex.di.Injector;


public class MainFragment extends Fragment {

    private EditText txtText;
    private Button btnTranslate;
    private MainFragmentViewModel viewModel;
    private TextView lblTranslation;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = ViewModelProviders.of(this, Injector.provideMainFragmentViewModelFactory()).get(
                        MainFragmentViewModel.class);
        setupViews(getView());
        observe();
    }

    private void observe() {
        viewModel.getMessage().observe(this, new EventObserver<>(this::showError));
        viewModel.getTranslatedText().observe(this, this::showTranslation);
    }

    private void showError(String message) {
        Log.d("Er", message);
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show();
    }

    private void showTranslation(String translation) {
        lblTranslation.setText(translation);
    }

    private void setupViews(View view) {
        txtText = ViewCompat.requireViewById(view, R.id.txtText);
        lblTranslation = ViewCompat.requireViewById(view, R.id.lblTranslation);
        btnTranslate = ViewCompat.requireViewById(view, R.id.btnTranslate);

        btnTranslate.setOnClickListener(v -> translate());
    }

    private void translate() {
        viewModel.translate(txtText.getText().toString());
    }
}
