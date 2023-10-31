package co.inventorsoft.novaposhtaapifriendship.model.request.allcities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class MethodProperties {

    @JsonProperty("Limit")
    private String limit;

    @JsonProperty("Page")
    private String page;

    @JsonProperty("FindByString")
    private String findByString;

}
