package org.mozilla.battery.Utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mozilla.battery.Battery.AccessBatteryInfo;

import java.util.Timer;

public class Runner {

    private static final Logger logger = LogManager.getLogger(Runner.class.getName());

    public static void main(String[] args) {

        int percent = Integer.parseInt(AccessBatteryInfo.batteryInfo(AccessBatteryInfo.BATTERY_PERCENT));
        logger.info("Starting timer ...");
        Timer timer = new Timer();
        logger.info("Checking battery status ...");
        while (percent > 5) {
            if (("Offline").equals(AccessBatteryInfo.batteryInfo(AccessBatteryInfo.AC_LINE))) {
                logger.info("Status is offline, continuing running process");
                timer.schedule(new AccessBatteryInfo(), 0, 5000);
                Thread a = new Initialize();
                a.start();
            } else {
                logger.error("Please unplug power cable and restart the tests");
                System.exit(1);
            }
        }
    }
}
