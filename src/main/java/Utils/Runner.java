package Utils;

import PageObjects.*;

/**
 * Created by ionut.budeanu on 1/30/2018.
 */
public class Runner {

    public static void main(String[] args) throws InterruptedException {
      /*  Amazon amazon = new Amazon();
        amazon.runAllFlows();
*/

        /*Facebook facebook = new Facebook();
        facebook.runAllFlows();*/

        /*Imdb imdb = new Imdb();
        imdb.runAllScenarious();*/

        Wikipedia wiki = new Wikipedia();
        wiki.runAllFlows();

       /* YouTube youtube = new YouTube();
        youtube.runAllScenarious();*/
    }

}

