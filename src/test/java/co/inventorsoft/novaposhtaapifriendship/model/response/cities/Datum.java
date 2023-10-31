
package co.inventorsoft.novaposhtaapifriendship.model.response.cities;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Datum {

    @JsonProperty("Description")
    public String description;
    @JsonProperty("DescriptionRu")
    public String descriptionRu;
    @JsonProperty("Ref")
    public String ref;
    @JsonProperty("Delivery1")
    public String delivery1;
    @JsonProperty("Delivery2")
    public String delivery2;
    @JsonProperty("Delivery3")
    public String delivery3;
    @JsonProperty("Delivery4")
    public String delivery4;
    @JsonProperty("Delivery5")
    public String delivery5;
    @JsonProperty("Delivery6")
    public String delivery6;
    @JsonProperty("Delivery7")
    public String delivery7;
    @JsonProperty("Area")
    public String area;
    @JsonProperty("SettlementType")
    public String settlementType;
    @JsonProperty("IsBranch")
    public String isBranch;
    @JsonProperty("PreventEntryNewStreetsUser")
    public String preventEntryNewStreetsUser;
    @JsonProperty("CityID")
    public String cityID;
    @JsonProperty("SettlementTypeDescriptionRu")
    public String settlementTypeDescriptionRu;
    @JsonProperty("SettlementTypeDescription")
    public String settlementTypeDescription;
    @JsonProperty("SpecialCashCheck")
    public int specialCashCheck;
    @JsonProperty("AreaDescription")
    public String areaDescription;
    @JsonProperty("AreaDescriptionRu")
    public String areaDescriptionRu;
}
