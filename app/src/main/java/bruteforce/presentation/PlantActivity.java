package bruteforce.presentation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.view.View;
import  android.content.res.TypedArray;
import com.bruteforce.blossom.R;

import bruteforce.application.Services;
import  bruteforce.business.AccessAccount;
import  bruteforce.business.AccessPlant;

/**
 Class: PlantActivity
 Author: John Manning
 Purpose: Logic for the PlantView UI
 */

public class PlantActivity extends AppCompatActivity {
    private String userNameLogIn;

    AccessAccount myAccount;
    AccessPlant myPlant;

    ProgressBar myBar;
    ImageView plantImg;
    TypedArray plantArray;
    @Override
    /**
     onCreate

     Purpose: Runs when the view is changed to this screen. Sets up the water bar, the button, and the plant image view.
     Parameters: Bundle SavedInstanceState
     Returns: void
     */
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_plant);
        userNameLogIn = Services.getAccount().getUsername();

        myAccount = new AccessAccount(userNameLogIn);
        myPlant = new AccessPlant(myAccount.getCurrentAccount().getPlant());
        System.out.println("waterlevel: "+myPlant.getCurrentPlant().getWaterLevel());
        System.out.println("Growthlevel: " + myPlant.getCurrentPlant().getGrowthLevel());
        setPlantImg();
        setWaterBar();
    }
    /**
     setPlantImg

     Purpose: to called whenever the plant needs to be updated. It checks the current growth level and
                accesses an array of images. Changes the img view resource when the growth level changes.
     Parameters: void
     Returns: void
     */
    private void setPlantImg(){
        plantArray = getResources().obtainTypedArray(R.array.plant_imgs);
        plantImg = findViewById(R.id.plant_img_view);
        int plantIndex = myPlant.getCurrentPlant().getGrowthLevel();
        plantImg.setImageResource(plantArray.getResourceId(plantIndex, -1));

    }
    /**
     setWaterBar

     Purpose: sets the water bar to the current point level of the user.
     Parameters: void
     Returns: void
     */
    private  void setWaterBar(){
        myBar = findViewById(R.id.water_bar);
        myBar.setProgress(myAccount.getCurrentAccount().getPoints());
    }
    /**
     waterButtonOnClick

     Purpose:Called when the "water plant" button is clicked. takes the user points and converts them into water point for the plant.
                then updates the plant image and water bar
     Parameters: view v
     Returns: void
     */
    public void waterButtonOnClick(View v){
        int currProgress = myBar.getProgress();
        this.myPlant.addWaterLevel(currProgress);

        myAccount.updatePlant(myPlant.getCurrentPlant().getWaterLevel(), myPlant.getCurrentPlant().getGrowthLevel());

        myAccount.getCurrentAccount().setPoints(0);
        myAccount.updatePoints(myAccount.getCurrentAccount().getPoints());
        setPlantImg();
        setWaterBar();
    }

    }
