package coms.example.k00na.radiobuttonsvaja;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

/**
 * Created by k00na on 17.5.2015.
 */
public class ColorFragment extends Fragment {

    RadioGroup colorButtons;
    colorChangedListener interfaceObject;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view;
            view = inflater.inflate(R.layout.radio_group_layout, container, false);


        colorButtons = (RadioGroup)view.findViewById(R.id.buttonsGroup);

        colorButtons.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch(checkedId){

                    case R.id.red_button:
                        interfaceObject.getThatColor("RED");
                        break;

                    case R.id.blue_button:
                        interfaceObject.getThatColor("BLUE");
                        break;

                    case R.id.green_button:
                        interfaceObject.getThatColor("GREEN");
                        break;


                }

            }
        });


        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try{
            interfaceObject = (colorChangedListener)activity;
        } catch (Exception e){

        }
    }

    public interface colorChangedListener{

        public void getThatColor(String colorName);
    }
}
