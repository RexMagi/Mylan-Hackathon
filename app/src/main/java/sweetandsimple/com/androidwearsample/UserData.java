package sweetandsimple.com.androidwearsample;

import com.microsoft.band.sensors.UVIndexLevel;

import java.io.Serializable;
import java.lang.Integer;
import java.util.ArrayList;


public class UserData implements Serializable {
    private ArrayList<Integer> DailyHeartRate;
    private ArrayList<Long> DailySteps;
    private ArrayList<Float> DailySkinTemp;
    private ArrayList<UVIndexLevel> DailyUVExposer ;
    private ArrayList<Long> DailyCalorie;
    private ArrayList<Double> DailyTemp ;
    private ArrayList<Integer> DailyAmbientLight ;

    public ArrayList<Integer> getDailyHeartRate() {
        return DailyHeartRate;
    }

    public void setDailyHeartRate(ArrayList<Integer> dailyHeartRate) {
        DailyHeartRate = dailyHeartRate;
    }

    public ArrayList<Long> getDailySteps() {
        return DailySteps;
    }

    public void setDailySteps(ArrayList<Long> dailySteps) {
        DailySteps = dailySteps;
    }

    public ArrayList<Float> getDailySkinTemp() {
        return DailySkinTemp;
    }

    public void setDailySkinTemp(ArrayList<Float> dailySkinTemp) {
        DailySkinTemp = dailySkinTemp;
    }

    public ArrayList<UVIndexLevel> getDailyUVExposer() {
        return DailyUVExposer;
    }

    public void setDailyUVExposer(ArrayList<UVIndexLevel> dailyUVExposer) {
        DailyUVExposer = dailyUVExposer;
    }

    public ArrayList<Long> getDailyCalorie() {
        return DailyCalorie;
    }

    public void setDailyCalorie(ArrayList<Long> dailyCalorie) {
        DailyCalorie = dailyCalorie;
    }

    public ArrayList<Double> getDailyTemp() {
        return DailyTemp;
    }

    public void setDailyTemp(ArrayList<Double> dailyTemp) {
        DailyTemp = dailyTemp;
    }

    public ArrayList<Integer> getDailyAmbientLight() {
        return DailyAmbientLight;
    }

    public void setDailyAmbientLight(ArrayList<Integer> dailyAmbientLight) {
        DailyAmbientLight = dailyAmbientLight;
    }

    public UserData() {
        DailyHeartRate = new ArrayList();

        DailySteps = new ArrayList();
        DailySkinTemp = new ArrayList();
        DailyUVExposer = new ArrayList();
        DailyCalorie = new ArrayList();
        DailySkinResistance = new ArrayList();
        DailyAmbientLight = new ArrayList();
    }


}