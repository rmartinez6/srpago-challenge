package org.srpago.challenge.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.srpago.challenge.exception.GasolineDataClientException;
import org.srpago.challenge.model.client.gasolineData.GasStationData;

@Component
public class GasolineDataClient {

    @Autowired
    RestTemplate restTemplate;

    private static final String GASOLINE_DATA_URL
            = "https://api.datos.gob.mx/v1/precio.gasolina.publico";
    private static final String ERROR_GET_GASOLINE_DATA_MESSAGE = "Error al obtener datos de Estaciones de Gasolina";


    public GasStationData getGasolineDataById(String gasStationId) throws GasolineDataClientException {
        try {
            return restTemplate.getForEntity(GASOLINE_DATA_URL + "?_id=" + gasStationId, GasStationData.class).getBody();
        }catch(Exception ex){
            throw new GasolineDataClientException(ERROR_GET_GASOLINE_DATA_MESSAGE);
        }
    }

}
