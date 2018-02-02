package Battery;


import com.sun.jna.Structure;
import java.util.ArrayList;
import java.util.List;
import com.sun.jna.Native;
import com.sun.jna.win32.StdCallLibrary;

/**
 * Created by ionut.budeanu on 1/31/2018.
 */

interface Kernel32 extends StdCallLibrary {

    Kernel32 INSTANCE = (Kernel32) Native.loadLibrary("Kernel32", Kernel32.class);

    class BATTERY_STATUS extends Structure{

        public long Capacity;
        public long DesignVoltage;
        public long Rate;
        public byte ACLineStatus;
        public byte BatteryFlag;
        public byte BatteryLifePercent;
        public int BatteryLifeTime;
        public int BatteryFullLifeTime;


        @Override
        protected List<String> getFieldOrder() {
            ArrayList<String> fields = new ArrayList<String>();
            fields.add("ACLineStatus");
            fields.add("BatteryFlag");
            fields.add("BatteryLifePercent");
            fields.add("BatteryLifeTime");
            fields.add("BatteryFullLifeTime");
            fields.add("Capacity");
            fields.add("DesignVoltage");
            fields.add("Rate");


            return fields;
        }

        /**
         * The AC power status
         */
        public String getACLineStatusString() {
            switch (ACLineStatus) {
                case (0): return "Offline";
                case (1): return "Online";
                default: return "Unknown";
            }
        }
        /**
         * The battery charge status
         */
        public String getBatteryFlagString() {
            switch (BatteryFlag) {
                case (1): return "High, more than 66 percent";
                case (2): return "Low, less than 33 percent";
                case (4): return "Critical, less than five percent";
                case (8): return "Charging";
                case ((byte) 128): return "No system battery";
                default: return "Unknown";
            }
        }
        /**
         * The battery Capacity
         * */
        public String getCapacity(){
            return (Capacity == (long) 5) ? "Low Remaining Capacity" : Capacity + "mWh";
        }

        /**
         * The percentage of full battery charge remaining
         */
        public String getBatteryLifePercent() {
            return (BatteryLifePercent == (byte) 255) ? "Unknown" : BatteryLifePercent + "%";
        }

        /**
         * The number of seconds of battery life remaining
         */
        public String getBatteryLifeTime() {
            return (BatteryLifeTime == -1) ? "Unknown" : BatteryLifeTime + " seconds";
        }

        /**
         * The number of seconds of battery life when at full charge
         */
        public String getBatteryFullLifeTime() {
            return (BatteryFullLifeTime == -1) ? "Unknown" : BatteryFullLifeTime + " seconds";
        }

        public String getVoltage(){
            return  (DesignVoltage == 0) ? "Unknown Voltage" : DesignVoltage + "mv";
        }

        public String getRate(){
            return (Rate < 0) ? "Battery discharging rate is: " + Rate : Rate + "mWh";
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("ACLineStatus: " + getACLineStatusString() + "\n");
            sb.append("Battery Flag: " + getBatteryFlagString() + "\n");
            sb.append("Battery Life: " + getBatteryLifePercent() + "\n");
            sb.append("Battery Left: " + getBatteryLifeTime() + "\n");
            sb.append("Battery Full: " + getBatteryFullLifeTime() + "\n");
            sb.append("Battery Capacity: " + getCapacity() + "\n");
            sb.append("Battery Voltage: " + getVoltage() + "\n");
            sb.append("Battery Rate: " + getRate() + "\n");
            return sb.toString();
        }

    }

    static void main(String[] args) {
        Kernel32.BATTERY_STATUS batteryStatus = new Kernel32.BATTERY_STATUS();
        Kernel32.INSTANCE.GetSystemPowerStatus(batteryStatus);

        System.out.println(batteryStatus);
    }

    /**
     * Fill the structure.
     * @param result
     */
    int GetSystemPowerStatus(BATTERY_STATUS result);

}
