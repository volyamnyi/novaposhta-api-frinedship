
package co.inventorsoft.novaposhtaapifriendship.model.response.cities;

import lombok.Data;
import lombok.ToString;

import java.util.List;


@Data
@ToString
public class CitiesResponse {
    private List<Datum> data;
    private List<Object> errorCodes;
    private List<Object> errors;
    private Info info;
    private List<Object> infoCodes;
    private List<Object> messageCodes;
    private Boolean success;
    private List<Object> warningCodes;
    private List<Object> warnings;
}
