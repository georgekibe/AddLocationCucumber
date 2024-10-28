package resources;

import pojo.serialization.Location;
import pojo.serialization.LocationDetails;

import java.util.ArrayList;
import java.util.List;

public class TestDataBuild {

    public LocationDetails addPlacePayload(String name, String langugage, String address){
        LocationDetails locationDetails = new LocationDetails();

        Location location = new Location();

        location.setLat(-31.48488);
        location.setLng(75.51515);
        locationDetails.setLocation(location);

        locationDetails.setAccuracy(50);
        locationDetails.setName(name);
        locationDetails.setPhone_number("+254728852318");
        locationDetails.setAddress(address);
        locationDetails.setWebsite("https://google.com");
        locationDetails.setLanguage(langugage);

        List types = new ArrayList();
        types.add("shoe park");
        types.add("shop");
        locationDetails.setTypes(types);

        return locationDetails;
    }
}
