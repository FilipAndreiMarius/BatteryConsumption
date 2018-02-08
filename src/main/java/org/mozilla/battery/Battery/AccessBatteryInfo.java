package org.mozilla.battery.Battery;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.TimerTask;

public class AccessBatteryInfo extends TimerTask {

    public static final String AC_LINE = "ac_line_status";
    public static final String BATTERY_PERCENT = "battery_percent";
    private static final Logger logger = LogManager.getLogger(AccessBatteryInfo.class.getName());


    public static String batteryInfo(String info) {
        String batteryInfo = "";
        Battery.Kernel32.SYSTEM_POWER_STATUS batteryStatus = new Battery.Kernel32.SYSTEM_POWER_STATUS();
        Battery.Kernel32.INSTANCE.GetSystemPowerStatus(batteryStatus);

        switch (info) {
            case AC_LINE:
                batteryInfo = batteryStatus.getACLineStatusString();
                break;
            case BATTERY_PERCENT:
                batteryInfo = batteryStatus.getBatteryLifePercent();
                break;
        }

        return batteryInfo;
    }

    public void run() {
        logger.info("Battery percentage: " + batteryInfo(BATTERY_PERCENT) + "%");
        logger.info("Battery status: " + batteryInfo(AC_LINE));
    }
}
