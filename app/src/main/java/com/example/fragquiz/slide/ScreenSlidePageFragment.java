package com.example.fragquiz.slide;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.fragquiz.Country.Country;
import com.example.fragquiz.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Random;


public class ScreenSlidePageFragment extends Fragment {

    ArrayList<Country> listCountry;
    public  static final String ARG_PAGE = "page";
    private int mPageNumber; //trang hien tai

    TextView tvNum;
    ImageView imageView_Frag;
    RadioGroup radioGroup_Ans;
    RadioButton radioButton_A;
    RadioButton radioButton_B;
    RadioButton radioButton_C;
    RadioButton radioButton_D;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_screen_slide_page, container, false);

        tvNum = (TextView) rootView.findViewById(R.id.tvNum);
        imageView_Frag = (ImageView) rootView.findViewById(R.id.imageView_Frag);
        radioGroup_Ans = (RadioGroup) rootView.findViewById(R.id.radioGroup_Ans);
        radioButton_A = (RadioButton) rootView.findViewById(R.id.rad_A);
        radioButton_B = (RadioButton) rootView.findViewById(R.id.rad_B);
        radioButton_C = (RadioButton) rootView.findViewById(R.id.rad_C);
        radioButton_D = (RadioButton) rootView.findViewById(R.id.rad_D);
        return rootView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listCountry = new ArrayList<Country>();
        ScreenSlideActivity slideActivity = (ScreenSlideActivity) getActivity();
        listCountry = slideActivity.getData();
        mPageNumber = getArguments().getInt(ARG_PAGE);
    }

    public static ScreenSlidePageFragment create(int pageNumber)
    {
        ScreenSlidePageFragment fragment = new ScreenSlidePageFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, pageNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tvNum.setText("Câu" + (mPageNumber +1));
        String imgURL = listCountry.get(mPageNumber).getImgURL();
        Picasso.get().load(imgURL).into(imageView_Frag);
        CreateAnswersABCD();

    }
    void CreateAnswersABCD()
    {
        int randABCD =(int) Math.round( Math.random() * 3 +1);
        int sizeArr = listCountry.size();
        //ArrayList <String> arrAnsw = new ArrayList<String>();
        int[] arrAnsw = new int[3];
        arrAnsw[0] = arrAnsw[1] = arrAnsw[2] = -1;
        int i = 0;
        switch (randABCD){
            case 1:
                radioButton_A.setText(listCountry.get(mPageNumber).getCountryName());

                do {
                    int CountryNum = (int) Math.round(Math.random() * (sizeArr-1) + 1);
                    if (CountryNum != arrAnsw[0] && CountryNum != arrAnsw[1] && CountryNum != arrAnsw[2] && CountryNum != mPageNumber)
                    {
                        arrAnsw[i] = CountryNum;
                        i++;
                    }
                }while (arrAnsw[0] == -1 || arrAnsw[1] == -1 || arrAnsw[2] == -1);
                radioButton_B.setText(listCountry.get(arrAnsw[0]).getCountryName());
                radioButton_C.setText(listCountry.get(arrAnsw[1]).getCountryName());
                radioButton_D.setText(listCountry.get(arrAnsw[2]).getCountryName());
                break;
            case 2:
                radioButton_B.setText(listCountry.get(mPageNumber).getCountryName());

                do {
                    int CountryNum = (int) Math.round(Math.random() * (sizeArr-1) + 1);
                    if (CountryNum != arrAnsw[0] && CountryNum != arrAnsw[1] && CountryNum != arrAnsw[2] && CountryNum != mPageNumber)
                    {
                        arrAnsw[i] = CountryNum;
                        i++;
                    }
                }while (arrAnsw[0] == -1 || arrAnsw[1] == -1 || arrAnsw[2] == -1);
                radioButton_A.setText(listCountry.get(arrAnsw[0]).getCountryName());
                radioButton_C.setText(listCountry.get(arrAnsw[1]).getCountryName());
                radioButton_D.setText(listCountry.get(arrAnsw[2]).getCountryName());
                break;
            case 3:
                radioButton_C.setText(listCountry.get(mPageNumber).getCountryName());

                do {
                    int CountryNum = (int) Math.round(Math.random() * (sizeArr-1) + 1 );
                    if (CountryNum != arrAnsw[0] && CountryNum != arrAnsw[1] && CountryNum != arrAnsw[2] && CountryNum != mPageNumber)
                    {
                        arrAnsw[i] = CountryNum;
                        i++;
                    }
                }while (arrAnsw[0] == -1 || arrAnsw[1] == -1 || arrAnsw[2] == -1);
                radioButton_A.setText(listCountry.get(arrAnsw[0]).getCountryName());
                radioButton_B.setText(listCountry.get(arrAnsw[1]).getCountryName());
                radioButton_D.setText(listCountry.get(arrAnsw[2]).getCountryName());
                break;
            case 4:
                radioButton_D.setText(listCountry.get(mPageNumber).getCountryName());

                do {
                    int CountryNum = (int) Math.round(Math.random() * (sizeArr-1) + 1 );
                    if (CountryNum != arrAnsw[0] && CountryNum != arrAnsw[1] && CountryNum != arrAnsw[2] && CountryNum != mPageNumber)
                    {
                        arrAnsw[i] = CountryNum;
                        i++;
                    }
                }while (arrAnsw[0] == -1 || arrAnsw[1] == -1 || arrAnsw[2] == -1);
                radioButton_A.setText(listCountry.get(arrAnsw[0]).getCountryName());
                radioButton_B.setText(listCountry.get(arrAnsw[1]).getCountryName());
                radioButton_C.setText(listCountry.get(arrAnsw[2]).getCountryName());
                break;
        }
    }

    
}


