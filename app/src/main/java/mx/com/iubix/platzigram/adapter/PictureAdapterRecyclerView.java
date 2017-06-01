package mx.com.iubix.platzigram.adapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.transition.Explode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import mx.com.iubix.platzigram.R;
import mx.com.iubix.platzigram.model.Picture;
import mx.com.iubix.platzigram.view.PictureDetallActivity;

public class PictureAdapterRecyclerView extends RecyclerView.Adapter<PictureAdapterRecyclerView.PictureViewHolder>{
    /*
    *Esta clase se encarga de sincronizar una lista, un Array
    * Se encargara esta clase de estar utilizando estas tarjetas
    * */

    private ArrayList<Picture> pictures; //No importa de donde vengan
    private int resource; //El recurso sera la cardView
    private Activity activity; //Donde se esta llamando esta clase, es bueno tenerlo para poner la imagen

    public PictureAdapterRecyclerView(ArrayList<Picture> pictures, int resource, Activity activity) {
        this.pictures = pictures;
        this.resource = resource;
        this.activity = activity;
    }

    @Override
    public PictureViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
        return new PictureViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PictureViewHolder holder, int position) {
        //se trabajara la lista de elementos, es paso de elementos
        /*
        * Atravez del holder vamos a tener acceso a los views osea a las cardviews
        *
        * */

        final Picture picture = pictures.get(position);

        Picasso.with(activity).load(picture.getPicture()).into(holder.pictureCard);
        holder.usernameCard.setText(pictures.get(position).getUserName());
        holder.timeCard.setText(picture.getTime());
        holder.likeNumberCard.setText(picture.getLikeNumber());

        holder.pictureCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, PictureDetallActivity.class);
                activity.startActivity(intent);

                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                    Explode explode = new Explode();
                    explode.setDuration(1000);
                    activity.getWindow().setExitTransition(explode);
                    activity.startActivity( intent , ActivityOptionsCompat.makeSceneTransitionAnimation( activity , view , activity.getString(R.string.transitionname_picture ) ).toBundle());
                }else{
                    activity.startActivity(intent);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return pictures.size();
    }




    public class PictureViewHolder extends RecyclerView.ViewHolder{
        /*
        * Lo que va a hacer el View holder es que se va a enfocar en la cardView
        * para utilizarlo las veces que sean necesarias
        *
        * */
        private ImageView pictureCard;

        private TextView usernameCard;
        private TextView firstWordCard;
        private TextView timeCard;

        private CheckBox likeCheckCard;
        private TextView likeNumberCard;

        public PictureViewHolder(View itemView) {
            super(itemView);

            pictureCard     = (ImageView) itemView.findViewById(R.id.pictureCard);
            usernameCard    = (TextView) itemView.findViewById(R.id.usernameCard);
            timeCard        = (TextView) itemView.findViewById(R.id.timeCard);
            likeCheckCard   = (CheckBox) itemView.findViewById(R.id.likeCheckCard);
            likeNumberCard  = (TextView) itemView.findViewById(R.id.likeNumberCard);
        }
    }
}
