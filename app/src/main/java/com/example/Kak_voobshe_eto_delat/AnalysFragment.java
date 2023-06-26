package com.example.Kak_voobshe_eto_delat;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AnalysFragment extends Fragment {

    RecyclerView viewNews, viewCatalog;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_analys, container, false);
        viewNews = rootView.findViewById(R.id.viewNews);
        viewCatalog = rootView.findViewById(R.id.viewCatalog);
        viewNews.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        viewCatalog.setLayoutManager(new LinearLayoutManager(getContext()));
        getnews();
        getcatalog();
        return rootView;
    }

    private void getnews() {
        MedAPI api = MedAPI.retrofit.create(MedAPI.class);
        Call<List<News>> call = api.getNews();
        call.enqueue(new Callback<List<News>>() {
            @Override
            public void onResponse(Call<List<News>> call, Response<List<News>> response) {
                List<News> news = response.body();
                if (response.isSuccessful()) {
                    assert news != null;
                    NewsAdapter adapter = new NewsAdapter(getContext(), news);
                    viewNews.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<News>> call, Throwable t) {
            }
        });
    }
    private void getcatalog() {
        MedAPI api = MedAPI.retrofit.create(MedAPI.class);
        Call<List<Catalog>> call = api.getCatalog();
        call.enqueue(new Callback<List<Catalog>>() {
            @Override
            public void onResponse(Call<List<Catalog>> call, Response<List<Catalog>> response) {
                List<Catalog> catalog = response.body();
                if (response.isSuccessful()) {
                    assert catalog != null;
                    CatalogAdapter adapter = new CatalogAdapter(getContext(), catalog);
                    viewCatalog.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<Catalog>> call, Throwable t) {
            }
        });
    }
}