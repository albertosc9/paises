package com.asc.paises3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.asc.paises3.databinding.FragmentDetallesPaisesBinding;
import com.asc.paises3.placeholder.PlaceholderContent;


public class DetallesPaisesFragment extends Fragment {

  private FragmentDetallesPaisesBinding binding;
  private PlaceholderContent.Pais mPais;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
           mPais = getArguments().getParcelable("pais");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentDetallesPaisesBinding.inflate(inflater,container,false);
        ImageView iv = binding.foto;
        iv.setImageResource(getImageId(mPais.foto));
        TextView tv = binding.descripciN;
        tv.setText(mPais.detalles);
        return binding.getRoot();
    }
    private int getImageId(String imagePath){
        String imageName = imagePath.substring(imagePath.lastIndexOf("/")+1,imagePath.lastIndexOf("."));
        return getResources().getIdentifier(imageName, "drawable",getContext().getPackageName());

    }
}