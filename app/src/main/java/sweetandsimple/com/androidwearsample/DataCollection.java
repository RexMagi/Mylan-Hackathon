package sweetandsimple.com.androidwearsample;

import com.microsoft.band.InvalidBandVersionException;
import com.microsoft.band.sensors.BandAmbientLightEvent;
import com.microsoft.band.sensors.BandAmbientLightEventListener;
import com.microsoft.band.sensors.BandBarometerEvent;
import com.microsoft.band.sensors.BandBarometerEventListener;
import com.microsoft.band.sensors.BandCaloriesEvent;
import com.microsoft.band.sensors.BandCaloriesEventListener;
import com.microsoft.band.sensors.BandHeartRateEvent;
import com.microsoft.band.sensors.BandHeartRateEventListener;
import com.microsoft.band.sensors.BandPedometerEvent;
import com.microsoft.band.sensors.BandPedometerEventListener;
import com.microsoft.band.sensors.BandSkinTemperatureEvent;
import com.microsoft.band.sensors.BandSkinTemperatureEventListener;
import com.microsoft.band.sensors.BandUVEvent;
import com.microsoft.band.sensors.BandUVEventListener;

/**
 * Created by trae on 2/27/2016.
 */
public class DataCollection implements BandAmbientLightEventListener,BandCaloriesEventListener,BandHeartRateEventListener,BandPedometerEventListener,BandBarometerEventListener,BandSkinTemperatureEventListener,BandUVEventListener {
    UserData user;
    public DataCollection(UserData u) {
        user = u;
    }

    @Override
    public void onBandAmbientLightChanged(BandAmbientLightEvent bandAmbientLightEvent) {
        user.getDailyAmbientLight().add(bandAmbientLightEvent.getBrightness());
    }

    @Override
    public void onBandBarometerChanged(BandBarometerEvent bandBarometerEvent) {
        user.getDailyTemp().add(bandBarometerEvent.getTemperature());

    }

    @Override
    public void onBandCaloriesChanged(BandCaloriesEvent bandCaloriesEvent) {
                user.getDailyCalorie().add(bandCaloriesEvent.getCalories());
    }

    @Override
    public void onBandHeartRateChanged(BandHeartRateEvent bandHeartRateEvent) {
        user.getDailyHeartRate().add(bandHeartRateEvent.getHeartRate());
    }

    @Override
    public void onBandPedometerChanged(BandPedometerEvent bandPedometerEvent) {
        try {
            user.getDailySteps().add(bandPedometerEvent.getStepsToday());
        } catch (InvalidBandVersionException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onBandSkinTemperatureChanged(BandSkinTemperatureEvent bandSkinTemperatureEvent) {
        user.getDailySkinTemp().add(bandSkinTemperatureEvent.getTemperature());
    }

    @Override
    public void onBandUVChanged(BandUVEvent bandUVEvent) {
        user.getDailyUVExposer().add(bandUVEvent.getUVIndexLevel());
    }
}
