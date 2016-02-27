package sweetandsimple.com.androidwearsample;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.wearable.view.WatchViewStub;
import android.widget.TextView;

import com.microsoft.band.BandClient;
import com.microsoft.band.BandException;
import com.microsoft.band.tiles.BandIcon;
import com.microsoft.band.tiles.BandTile;

import java.util.List;
import java.util.UUID;


public class MainActivity extends Activity {

    private TextView mTextView;
    public BandClient bandClient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {

            List<BandTile> tiles;
            tiles = bandClient.getTileManager().getTiles().await();

        }

        catch (BandException e) {

        }
        catch (InterruptedException e) {

        }

        try {

            List<BandTile> tiles = bandClient.getTileManager().getTiles().await();
        }

        catch (BandException e) {


        }

        catch (InterruptedException e) {

        }

        Bitmap smalliconbitmap = Bitmap.createBitmap(24, 24, null);
        BandIcon smallicon = BandIcon.toBandIcon(smalliconbitmap);
        Bitmap titleiconbitmap = Bitmap.createBitmap(46, 46, null);
        BandIcon tileicon = BandIcon.toBandIcon(titleiconbitmap);
        super.onCreate(savedInstanceState);
        UUID tileuuid = UUID.randomUUID();
        BandTile tile = new BandTile.Builder(tileuuid, "MHB", tileicon) .setTileSmallIcon(smallicon, true).build();
        try {
            if (bandClient.getTileManager().addTile(this, tile).await()) {

            }
        } catch (BandException e) {

        } catch (InterruptedException e) {

        }
    }


    final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);
    public void onLayoutInflated(WatchViewStub stub){
        mTextView = (TextView) stub.findViewById(R.id.text);
    {

    }
    }



}