package sweetandsimple.com.androidwearsample;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;

import com.microsoft.band.BandClient;
import com.microsoft.band.BandClientManager;
import com.microsoft.band.BandException;
import com.microsoft.band.BandIOException;
import com.microsoft.band.BandInfo;
import com.microsoft.band.BandPendingResult;
import com.microsoft.band.ConnectionState;
import com.microsoft.band.InvalidBandVersionException;
import com.microsoft.band.sensors.*;

import com.microsoft.band.BandClient;
import com.microsoft.band.BandException;
import com.microsoft.band.tiles.BandIcon;
import com.microsoft.band.tiles.BandTile;

import java.util.List;
import java.util.UUID;


public class MainActivity extends Activity {

    UserData user = new UserData();

    public BandClient bandClient;

    ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        BandInfo[] pairedBands = BandClientManager.getInstance().getPairedBands();
        BandClient client = BandClientManager.getInstance().create(this, pairedBands[0]);
        // Note: The BandPendingResult.await()
        // method must be called from a background thread.
        // An exception will be thrown if called from the UI thread.
        BandPendingResult<ConnectionState> pendingResult = bandClient.connect();
        try { ConnectionState state = pendingResult.await(); if(state == ConnectionState.CONNECTED) {
                    // do work on success
                    } else {
                    // do work on failure
                    }
        } catch(InterruptedException ex) {
                     // handle InterruptedException
                     }
        catch(BandException ex) {
                     // handle BandException
                      }

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


        try {

            List<BandTile> tiles;
            tiles = bandClient.getTileManager().getTiles().await();

        } catch (BandException e) {

        } catch (InterruptedException e) {

        }

        try {

            List<BandTile> tiles = bandClient.getTileManager().getTiles().await();
        } catch (BandException e) {


        } catch (InterruptedException e) {

        }

        Bitmap smalliconbitmap = Bitmap.createBitmap(24, 24, null);
        BandIcon smallicon = BandIcon.toBandIcon(smalliconbitmap);
        Bitmap titleiconbitmap = Bitmap.createBitmap(46, 46, null);
        BandIcon tileicon = BandIcon.toBandIcon(titleiconbitmap);
        super.onCreate(savedInstanceState);
        UUID tileuuid = UUID.randomUUID();
        BandTile tile = new BandTile.Builder(tileuuid, "MHB", tileicon).setTileSmallIcon(smallicon, true).build();
        try {
            if (bandClient.getTileManager().addTile(this, tile).await()) {

            }
        } catch (BandException e) {

        } catch (InterruptedException e) {

        }
    }

}

