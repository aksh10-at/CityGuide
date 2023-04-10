package com.akshdev.cityguide.HelperClasses.HomeAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.akshdev.cityguide.R;

import java.util.ArrayList;

//Adapter works as a bridge between Value(Data) and Design(View).
public class FeaturedAdapter extends RecyclerView.Adapter<FeaturedAdapter.FeaturedViewHolder> {


    ArrayList<FeaturedHelperClass> featuredLocation;//Values

    public FeaturedAdapter(ArrayList<FeaturedHelperClass> featuredLocation) {
        this.featuredLocation = featuredLocation;
    }

    @NonNull
    @Override
    public FeaturedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //creating a view pointing to our created layout
        //parent -- is viewGroup ????
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.featured_card_design,parent,false);
        //return featuredViewHolder
        return new FeaturedViewHolder(view);
    }

    @Override// bind view and data
    public void onBindViewHolder(@NonNull FeaturedViewHolder holder, int position) {
        FeaturedHelperClass featuredHelperClass = featuredLocation.get(position);

        holder.image.setImageResource(featuredHelperClass.getImage());
        holder.title.setText(featuredHelperClass.getTitle());
        holder.desc.setText(featuredHelperClass.getDescription());
    }

    @Override
    public int getItemCount() {
        return featuredLocation.size();
    }


    //Views--
    public static class FeaturedViewHolder extends RecyclerView.ViewHolder {

        AppCompatImageView image;
        AppCompatTextView title, desc;

        public FeaturedViewHolder(@NonNull View itemView) {
            super(itemView);

            //Hooks
            //itemView (to get view then findViewById()) as we don't have any resource file linked to this class (( basically,, Don't have any view here))
            image = itemView.findViewById(R.id.featured_image);
            title = itemView.findViewById(R.id.featured_title);
            desc = itemView.findViewById(R.id.featured_desc);

        }
    }


}
