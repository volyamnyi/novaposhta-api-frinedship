package co.inventorsoft.novaposhtaapifriendship.service;

import co.inventorsoft.novaposhtaapifriendship.TestDataUtils;
import co.inventorsoft.novaposhtaapifriendship.model.response.cities.CitiesResponse;
import co.inventorsoft.novaposhtaapifriendship.service.impl.FriendshipServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;
import java.util.stream.Stream;


import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class FriendshipServiceTest {
    private static MockWebServer mockWebServer;
    private static FriendshipServiceImpl friendshipService;
    private static ObjectMapper objectMapper;

    @Value("${get.cities.request}")
    private String getAllCitiesRequestJson;

    @BeforeAll
    public static void setUp() throws IOException {
        mockWebServer = new MockWebServer();
        mockWebServer.start();

        String baseUrl = String.format("http://localhost:%s",
                mockWebServer.getPort());

        WebClient testWebClient = WebClient.create(baseUrl);

        objectMapper = new ObjectMapper();
        friendshipService = new FriendshipServiceImpl(testWebClient, objectMapper);
    }

    @AfterAll
    public static void tearDown() throws IOException {
        mockWebServer.shutdown();
    }

    @ParameterizedTest
    @MethodSource("provideScenariosResponses")
    public void testThatGetCitiesScenariosResponses(CitiesResponse citiesResponseMock) throws IOException {
        friendshipService.setGetAllCitiesRequestJson(getAllCitiesRequestJson);

        mockWebServer.enqueue(new MockResponse()
                .setBody(objectMapper.writeValueAsString(citiesResponseMock))
                .addHeader("Content-Type", "application/json"));

        ResponseEntity<?> response = friendshipService.getCities("","", "");
        String responseString = objectMapper.writeValueAsString(response.getBody());
        CitiesResponse citiesResponseActual = objectMapper.readValue(responseString,CitiesResponse.class);
        assertEquals(citiesResponseMock, citiesResponseActual);

    }
    private static Stream<Arguments> provideScenariosResponses() throws IOException {
        return Stream.of(
                Arguments.of(TestDataUtils.getDefaultScenarioResponseMock(objectMapper)),
                Arguments.of(TestDataUtils.get10PageScenarioResponseMock(objectMapper)),
                Arguments.of(TestDataUtils.get5Limit10PageScenarioResponseMock(objectMapper))
        );
    }
}