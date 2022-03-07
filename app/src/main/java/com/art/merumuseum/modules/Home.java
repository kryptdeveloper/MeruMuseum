package com.art.merumuseum.modules;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.art.merumuseum.Finance.ReportsModulesFinance;
import com.art.merumuseum.LinksModel;
import com.art.merumuseum.Main;
import com.art.merumuseum1.R;
import com.art.merumuseum.UserInfo.Model;
import com.art.merumuseum.modules.ModelMyActivitys.MyActivitys;
import com.art.merumuseum.modules.VrModule.ViewData2;
import com.google.android.material.navigation.NavigationView;

public class Home extends Fragment implements View.OnClickListener{

    CardView buyticket,myactivities,feedback,help,vr,learn;
    Toolbar toolbar;
    DrawerLayout drawerLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.homelayout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        buyticket = view.findViewById(R.id.buyaticketcard);
        myactivities = view.findViewById(R.id.myActivitiesCard);

        feedback = view.findViewById(R.id.feedbackcard);
        help = view.findViewById(R.id.helpcard);
        vr = view.findViewById(R.id.vrcardview);
        learn = view.findViewById(R.id.learncard);

        toolbar=view.findViewById(R.id.toolbar);

        buyticket.setOnClickListener(this);
        myactivities.setOnClickListener(this);
        feedback.setOnClickListener(this);
        help.setOnClickListener(this);

        vr.setOnClickListener(this);
        learn.setOnClickListener(this);




    }

    @Override
    public void onClick(View view) {
        if (view==buyticket){


            getFragmentManager().beginTransaction().replace(R.id.content, new BuyATicket()).addToBackStack(null).commit();
        } else if (view==myactivities){


            getFragmentManager().beginTransaction().replace(R.id.content, new MyActivitys()).addToBackStack("").commit();
        }
        else if (view==feedback){


            getFragmentManager().beginTransaction().replace(R.id.content, new Feedback()).addToBackStack("").commit();
        }
        else if (view==help){


            getFragmentManager().beginTransaction().replace(R.id.content, new Help()).addToBackStack("").commit();
        }
        else if (view==vr){


            startActivity(new Intent(getContext(),ViewData2.class));
        }
        else if (view==learn){


            getFragmentManager().beginTransaction().replace(R.id.content, new Learn()).addToBackStack("").commit();
        }

    }


}

