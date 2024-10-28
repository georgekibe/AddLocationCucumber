package resources;

import pojo.serialization.Location;
import pojo.serialization.LocationDetails;

import java.util.ArrayList;
import java.util.List;

public class TestDataBuild {

    public LocationDetails addPlacePayload(){
        LocationDetails locationDetails = new LocationDetails();

        Location location = new Location();

        location.setLat(-31.48488);
        location.setLng(75.51515);
        locationDetails.setLocation(location);

        locationDetails.setAccuracy(50);
        locationDetails.setName("Nairobi Kenya");
        locationDetails.setPhone_number("+254728852318");
        locationDetails.setAddress("Parklands, Nairobi");
        locationDetails.setWebsite("https://google.com");
        locationDetails.setLanguage("Kiswahili");

        List types = new ArrayList();
        types.add("shoe park");
        types.add("shop");
        locationDetails.setTypes(types);

        return locationDetails;
    }
}
