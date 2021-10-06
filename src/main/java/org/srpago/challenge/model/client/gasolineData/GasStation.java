package org.srpago.challenge.model.client.gasolineData;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GasStation {

    @JsonProperty("_id")
    private String id;
    @JsonProperty("calle")
    private String address;
    private String rfc;
    @JsonProperty("date_insert")
    private String dateInsert;
    @JsonProperty("regular")
    private String regularPrice;
    @JsonProperty("colonia")
    private String cologne;
    @JsonProperty("numeropermiso")
    private String licenceNumber;
    @JsonProperty("permisoid")
    private String licenceId;
    @JsonProperty("fechaaplicacion")
    private String applicationDate;
    private String longitude;
    private String latitude;
    @JsonProperty("premium")
    private String premiumPrice;
    @JsonProperty("razonsocial")
    private String businessName;
    @JsonProperty("codigopostal")
    private String postalCode;
    @JsonProperty("dieasel")
    private String dieasel;

}
