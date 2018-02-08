package org.mozilla.battery.Utils;

import org.mozilla.battery.PageObjects.*;


/**
 * Created by ionut.budeanu on 1/30/2018.
 */
public class Initialize extends Thread {

    public Initialize() {
        initiateObjects();
    }


    public void initiateObjects() {


        /*Facebook facebook = new Facebook();
        facebook.runAllFlows();*/

        Amazon amazon = new Amazon();
        amazon.runAllFlows();

        Imdb imdb = new Imdb();
        imdb.runAllScenarious();

        Wikipedia wiki = new Wikipedia();
        wiki.runAllFlows();

        YouTube youtube = new YouTube();
        youtube.runAllScenarious();


    }
}

