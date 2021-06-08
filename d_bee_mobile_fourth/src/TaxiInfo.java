public class TaxiInfo {
    private int vehicleIdentification;
    private int triggeredEvent;
    private int runningStatus;
    private String GPSTime;
    private double GPSLng;
    private double GPSLat;
    private int speed;
    private int orientation;
    private int GPSStatus;

    public int getVehicleIdentification() {
        return vehicleIdentification;
    }

    public void setVehicleIdentification(int vehicleIdentification) {
        this.vehicleIdentification = vehicleIdentification;
    }

    public int getTriggeredEvent() {
        return triggeredEvent;
    }

    public void setTriggeredEvent(int triggeredEvent) {
        this.triggeredEvent = triggeredEvent;
    }

    public int getRunningStatus() {
        return runningStatus;
    }

    public void setRunningStatus(int runningStatus) {
        this.runningStatus = runningStatus;
    }

    public String getGPSTime() {
        return GPSTime;
    }

    public void setGPSTime(String GPSTime) {
        this.GPSTime = GPSTime;
    }

    public double getGPSLng() {
        return GPSLng;
    }

    public void setGPSLng(double GPSLng) {
        this.GPSLng = GPSLng;
    }

    public double getGPSLat() {
        return GPSLat;
    }

    public void setGPSLat(double GPSLat) {
        this.GPSLat = GPSLat;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getOrientation() {
        return orientation;
    }

    public void setOrientation(int orientation) {
        this.orientation = orientation;
    }

    public int getGPSStatus() {
        return GPSStatus;
    }

    public void setGPSStatus(int GPSStatus) {
        this.GPSStatus = GPSStatus;
    }

    @Override
    public String toString() {
        return "TaxiInfo{" +
                "vehicleIdentification=" + vehicleIdentification +
                ", triggeredEvent=" + triggeredEvent +
                ", runningStatus=" + runningStatus +
                ", GPSTime='" + GPSTime + '\'' +
                ", GPSLng=" + GPSLng +
                ", GPSLat=" + GPSLat +
                ", speed=" + speed +
                ", orientation=" + orientation +
                ", GPSStatus=" + GPSStatus +
                '}';
    }
}
