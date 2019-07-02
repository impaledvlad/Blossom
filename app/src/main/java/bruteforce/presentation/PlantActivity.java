package bruteforce.presentation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.view.View;
import  android.content.res.TypedArray;
import com.bruteforce.blossom.R;
import  bruteforce.business.AccessAccount;
import  bruteforce.business.AccessPlant;

public class PlantActivity extends AppCompatActivity {
    AccessAccount myAccount;
    AccessPlant myPlant;
    ProgressBar myBar;
    ImageView plantImg;
    TypedArray plantArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_plant);
        myAccount = new AccessAccount("username1");
        myPlant = new AccessPlant(myAccount.getCurrentAccount().getPlant());
        setPlantImg();
        setWaterBar();
    }
    private void setPlantImg(){
        plantArray = getResources().obtainTypedArray(R.array.plant_imgs);
        plantImg = findViewById(R.id.plant_img_view);
        int plantIndex = myPlant.getCurrentPlant().getGrowthLevel();
        plantImg.setImageResource(plantArray.getResourceId(plantIndex, -1));

    }
    private  void setWaterBar(){
        myBar = findViewById(R.id.water_bar);
        myBar.setProgress(myAccount.getCurrentAccount().getPoints());
    }

    public void waterButtonOnClick(View v){
        int currProgress = myBar.getProgress();
        this.myPlant.getCurrentPlant().addWaterLevel(currProgress);
        myBar.setProgress(myPlant.getCurrentPlant().getWaterLevel());
        setPlantImg();
        setWaterBar();
    }

    }
