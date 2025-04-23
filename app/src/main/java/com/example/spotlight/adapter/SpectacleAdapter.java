package com.example.spotlight.adapter;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
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
import java.util.List;
import java.util.Locale;

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
        holder.date.setText(DateUtils.formatDate(spectacle.getDate())); // Utilisez votre formatter
        holder.lieu.setText(spectacle.getNomLieu());

        Glide.with(context)
                .load(spectacle.getImageUrl())
                .into(holder.image);
        try {
            // Méthode 1 : Depuis les ressources

            // OU Méthode 2 : Avec Glide (plus fiable)
            Glide.with(holder.itemView.getContext())
                    .load(R.drawable.ac)
                    .error(R.drawable.error_image) // Image de remplacement
                    .into(holder.image);

        } catch (Exception e) {
            Log.e("IMAGE_ERROR", "Erreur de chargement: " + e.getMessage());
            holder.image.setBackgroundColor(Color.RED); // Visualiser l'erreur
        }
    }
    @Override
    public int getItemCount() {
        return spectacles.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView image;
        final TextView titre, date, lieu;

        public ViewHolder(View view) {
            super(view);
            image = view.findViewById(R.id.iv_spectacle);
            titre = view.findViewById(R.id.tv_titre);
            date = view.findViewById(R.id.tv_date);
            lieu = view.findViewById(R.id.tv_lieu);
        }
    }
}