package mx.com.iubix.platzigram.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import mx.com.iubix.platzigram.R;
import mx.com.iubix.platzigram.adapter.PictureAdapterRecyclerView;
import mx.com.iubix.platzigram.model.Picture;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {


    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        showToolbar("",false,view);

        RecyclerView pictureProfileRecyclerView = (RecyclerView) view.findViewById(R.id.pictureProfileRecycler);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        pictureProfileRecyclerView.setLayoutManager(linearLayoutManager);

        PictureAdapterRecyclerView pictureAdapterRecyclerView = new PictureAdapterRecyclerView(buildPictures(),R.layout.cardview_picture,getActivity());

        pictureProfileRecyclerView.setAdapter(pictureAdapterRecyclerView);


        return view;
    }

    public ArrayList<Picture> buildPictures(){
        ArrayList<Picture> pictures = new ArrayList<>();
        pictures.add(new Picture("http://euw.leagueoflegends.com/sites/default/files/styles/scale_xlarge/public/upload/add_friend_article_banner.jpg?itok=mwPh7hnS","Luis Antoncio Carmona Espionsa","4 días","100 " + getResources().getString(R.string.liked)));
        pictures.add(new Picture("https://pbs.twimg.com/media/CShgHLoUYAEMZaH.jpg","Jose Alfredo Carmona Espinosa","20 Días","1 "+ getResources().getString(R.string.liked)));
        pictures.add(new Picture("http://euw.leagueoflegends.com/sites/default/files/styles/scale_xlarge/public/upload/add_friend_article_banner.jpg?itok=mwPh7hnS","Luis Antoncio Carmona Espionsa","4 días","100 " + getResources().getString(R.string.liked)));
        pictures.add(new Picture("https://pbs.twimg.com/media/CShgHLoUYAEMZaH.jpg","Jose Alfredo Carmona Espinosa","20 Días","1 "+ getResources().getString(R.string.liked)));
        pictures.add(new Picture("http://euw.leagueoflegends.com/sites/default/files/styles/scale_xlarge/public/upload/add_friend_article_banner.jpg?itok=mwPh7hnS","Luis Antoncio Carmona Espionsa","4 días","100 " + getResources().getString(R.string.liked)));
        pictures.add(new Picture("http://oce.leagueoflegends.com/sites/default/files/styles/scale_xlarge/public/upload/mystery_champion_2.jpg?itok=7U2wZHqP","Aaron Adrian Carmona Espinosa","10 días","265 "+ getResources().getString(R.string.liked)));
        pictures.add(new Picture("https://pbs.twimg.com/media/CShgHLoUYAEMZaH.jpg","Jose Alfredo Carmona Espinosa","20 Días","1 "+ getResources().getString(R.string.liked)));
        pictures.add(new Picture("http://euw.leagueoflegends.com/sites/default/files/styles/scale_xlarge/public/upload/add_friend_article_banner.jpg?itok=mwPh7hnS","Rafaela Luz Espinosa Belmont","1 mes","10 "+ getResources().getString(R.string.liked)));
        pictures.add(new Picture("https://pbs.twimg.com/media/CShgHLoUYAEMZaH.jpg","Jose Alfredo Carmona Espinosa","20 Días","1 "+ getResources().getString(R.string.liked)));

        return pictures;
    }


    public void showToolbar(String tittle, boolean upButton , View view){
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(tittle);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

}
