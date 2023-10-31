package co.inventorsoft.novaposhtaapifriendship;

import co.inventorsoft.novaposhtaapifriendship.model.response.cities.CitiesResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class TestDataUtils {

    private TestDataUtils() {
    }

    public static CitiesResponse getDefaultScenarioResponseMock(ObjectMapper objectMapper) throws IOException {
        return objectMapper.readValue(new File(
                        System.getProperty("user.dir") + "\\src\\test\\resources\\defaultScenarioResponseMock.json"),
                CitiesResponse.class);
    }

    public static CitiesResponse get10PageScenarioResponseMock(ObjectMapper objectMapper) throws IOException {
        return objectMapper.readValue(new File(
                        System.getProperty("user.dir") + "\\src\\test\\resources\\10PageScenarioResponseMock.json"),
                CitiesResponse.class);
    }

    public static CitiesResponse get5Limit10PageScenarioResponseMock(ObjectMapper objectMapper) throws IOException {
        return objectMapper.readValue(new File(
                        System.getProperty("user.dir") + "\\src\\test\\resources\\5Limit10PageScenarioResponseMock.json"),
                CitiesResponse.class);
    }
}
