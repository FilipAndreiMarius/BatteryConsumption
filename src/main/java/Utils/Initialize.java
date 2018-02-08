package Utils;

import Battery.AccessBatteryInfo;
import PageObjects.*;

import java.util.Timer;

/**
 * Created by ionut.budeanu on 1/30/2018.
 */
public class Runner {

    public static void main(String[] args) throws InterruptedException {


        /*Facebook facebook = new Facebook();
        facebook.runAllFlows();*/

        /*Imdb imdb = new Imdb();
        imdb.runAllScenarious();*/

       /* Wikipedia wiki = new Wikipedia();
        wiki.runAllFlows();*/

       /* YouTube youtube = new YouTube();
        youtube.runAllScenarious();*/

        Timer timer = new Timer();

        if(AccessBatteryInfo.batteryInfo(AccessBatteryInfo.AC_LINE) == "Offline") {
            timer.schedule(new AccessBatteryInfo(), 0, 5000);
        }else{
            System.out.println("Battery is charging");

        }

    }

}

