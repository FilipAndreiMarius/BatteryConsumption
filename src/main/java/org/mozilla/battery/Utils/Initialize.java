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

        Amazon amazon = new Amazon();
        amazon.runAllFlows();

        Facebook facebook = new Facebook();
        facebook.runAllFlows();

        GMail gmail = new GMail();
        gmail.runAllFlows();

        GoogleSearch google = new GoogleSearch();
        google.runAllFlows();

        Imdb imdb = new Imdb();
        imdb.runAllScenarious();

        Twitter twitter = new Twitter();
        twitter.runAllFlows();

        Wikipedia wiki = new Wikipedia();
        wiki.runAllFlows();

        YouTube youtube = new YouTube();
        youtube.runAllScenarious();

    }
}

