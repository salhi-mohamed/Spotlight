package com.example.spotlight.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.spotlight.R;
import com.example.spotlight.model.SpectacleDTO;

import java.math.BigDecimal;
import java.util.List;

public class SpectacleAdapter extends RecyclerView.Adapter<SpectacleAdapter.ViewHolder> {
    private final List<SpectacleDTO> spectacles;
    private final Context context;

    public SpectacleAdapter(Context context, List<SpectacleDTO> spectacles) {
        this.context = context;
        this.spectacles = spectacles;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_spectacle, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SpectacleDTO spectacle = spectacles.get(position);

        holder.titre.setText(spectacle.getTitre());
        holder.date.setText(DateUtils.formatDate(spectacle.getDate()));
        holder.lieu.setText(spectacle.getNomLieu());

        if (spectacle.getHeureDebut() != null) {
            holder.heure.setText(formatHeure(spectacle.getHeureDebut()));
        }

        Glide.with(context)
                .load(spectacle.getImageUrl())
                .placeholder(R.drawable.placeholder_concert)
                .error(R.drawable.placeholder_concert)
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return spectacles.size(); // Ajout de la méthode manquante
    }

    private String formatHeure(BigDecimal heureDebut) {
        // Implémentez votre logique de formatage d'heure ici
        return heureDebut + "h";
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView image;
        final TextView titre, date, lieu, heure;

        public ViewHolder(View view) {
            super(view);
            image = view.findViewById(R.id.iv_spectacle);
            titre = view.findViewById(R.id.tv_titre);
            date = view.findViewById(R.id.tv_date);
            lieu = view.findViewById(R.id.tv_lieu);
            heure = view.findViewById(R.id.tv_heure);
        }
    }
}