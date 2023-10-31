package co.inventorsoft.novaposhtaapifriendship.service.impl;

import co.inventorsoft.novaposhtaapifriendship.model.request.allcities.Cities;
import co.inventorsoft.novaposhtaapifriendship.service.FriendshipService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Setter
@Getter
public class FriendshipServiceImpl implements FriendshipService {

    private final WebClient webClient;
    private final ObjectMapper objectMapper;

    @Value("${uri}")
    private String uri;

    @Value("${get.cities.request}")
    private String getAllCitiesRequestJson;
    @Override
    public ResponseEntity<?> getCities(String city, String limit, String page) {
        Cities getCitiesRequest;
        try {
            getCitiesRequest = objectMapper.readValue(this.getAllCitiesRequestJson, Cities.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        if (city != null)
            getCitiesRequest.getMethodProperties().setFindByString(city);
        if (page != null)
            getCitiesRequest.getMethodProperties().setPage(page);
        if (limit != null)
            getCitiesRequest.getMethodProperties().setLimit(limit);

        Object response = webClient.post()
                .uri(uri)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(Mono.just(getCitiesRequest), Cities.class)
                .retrieve()
                .bodyToMono(Object.class).block();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
