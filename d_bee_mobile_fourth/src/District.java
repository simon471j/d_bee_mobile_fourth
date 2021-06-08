public class District {
    private String name;
    private double locationLng;
    private double locationLat;
    private double radius = 2.5;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLocationLng() {
        return locationLng;
    }

    public void setLocationLng(double locationLng) {
        this.locationLng = locationLng;
    }

    public double getLocationLat() {
        return locationLat;
    }

    public void setLocationLat(double locationLat) {
        this.locationLat = locationLat;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "District{" +
                "name='" + name + '\'' +
                ", locationLng=" + locationLng +
                ", locationLat=" + locationLat +
                ", radius=" + radius +
                '}';
    }
}
