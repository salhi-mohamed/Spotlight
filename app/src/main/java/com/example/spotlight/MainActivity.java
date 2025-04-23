package com.example.spotlight;
import android.widget.Toast;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spotlight.adapter.SpectacleAdapter;
import com.example.spotlight.api.ApiClient;
import com.example.spotlight.api.ApiInterface;
import com.example.spotlight.model.SpectacleDTO;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private SpectacleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        loadSpectacles();
    }

    // Dans MainActivity
    private void loadSpectacles() {
        ApiInterface apiService = ApiClient.getApiService();
        Call<List<SpectacleDTO>> call = apiService.getAllSpectacles();
        call.enqueue(new Callback<List<SpectacleDTO>>() {
            @Override
            public void onResponse(Call<List<SpectacleDTO>> call, Response<List<SpectacleDTO>> response) {
                if (response.isSuccessful()) {
                    List<SpectacleDTO> spectacles = response.body();
                    adapter = new SpectacleAdapter(MainActivity.this, spectacles);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<SpectacleDTO>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Erreur de chargement", Toast.LENGTH_SHORT).show();
            }
        });
    }
}