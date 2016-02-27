package sweetandsimple.com.androidwearsample;

import android.app.Activity;
import android.os.Bundle;

import com.microsoft.band.BandClient;
import com.microsoft.band.BandClientManager;
import com.microsoft.band.BandException;
import com.microsoft.band.BandIOException;
import com.microsoft.band.InvalidBandVersionException;
import com.microsoft.band.sensors.*;


public class MainActivity extends Activity {

    UserData user = new UserData();

;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        BandClient client;
        BandHeartRateEvent heart;
        BandAmbientLightEvent light;
        BandCaloriesEvent cal;
        BandPedometerEvent ped;
        BandBarometerEvent bar;
        BandSkinTemperatureEvent skinTemp;
        BandUVEvent UV;
        DataCollection dc = new DataCollection(user);


        try {
            client.getSensorManager().registerCaloriesEventListener(dc);
            client.getSensorManager().registerHeartRateEventListener(dc);
            client.getSensorManager().registerPedometerEventListener(dc);
            client.getSensorManager().registerBarometerEventListener(dc);
            client.getSensorManager().registerSkinTemperatureEventListener(dc);
            client.getSensorManager().registerUVEventListener(dc);
            client.getSensorManager().registerAmbientLightEventListener(dc);

        } catch (BandIOException e) {
            e.printStackTrace();
        } catch (InvalidBandVersionException e) {
            e.printStackTrace();
        } catch (BandException e) {
            e.printStackTrace();
        }


    }



}
