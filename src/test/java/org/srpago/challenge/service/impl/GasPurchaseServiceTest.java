package org.srpago.challenge.service.impl;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.srpago.challenge.client.GasolineDataClient;
import org.srpago.challenge.exception.GasolineDataClientException;
import org.srpago.challenge.exception.ResourceNotFoundException;
import org.srpago.challenge.mapper.GasPurchaseMapper;
import org.srpago.challenge.model.client.gasolineData.GasStation;
import org.srpago.challenge.model.client.gasolineData.GasStationData;
import org.srpago.challenge.model.domain.GasPurchase;
import org.srpago.challenge.model.request.InfoRQ;
import org.srpago.challenge.model.response.Response;
import org.srpago.challenge.repository.GasPurchaseRepository;
import java.util.Collections;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class GasPurchaseServiceTest {

    @Mock
    GasolineDataClient gasolineDataClient;
    @Mock
    GasPurchaseRepository gasPurchaseRepository;
    @Mock
    GasPurchaseMapper gasPurchaseMapper;

    @Test
    public void testBuyGasolineServiceOk() throws GasolineDataClientException, ResourceNotFoundException {
        String stationId = "1111";
        GasStation gasStation  = GasStation.builder().regularPrice("84").build();
        GasStationData gasStationData = GasStationData.builder().results(Collections.singletonList(gasStation)).build();
        GasPurchase gasPurchase = GasPurchase.builder().gasType(1).build();
        InfoRQ infoRq = InfoRQ.builder().gasStation(stationId).build();
        when(gasolineDataClient.getGasolineDataById(stationId)).thenReturn(gasStationData);
        when(gasPurchaseRepository.save(gasPurchase)).thenReturn(gasPurchase);
        when(gasPurchaseMapper.gasStationAndInfoRqToGasPurchase(gasStation, infoRq)).thenReturn(gasPurchase);
        GasPurchaseService gasPurchaseService  = new GasPurchaseService(gasolineDataClient, gasPurchaseRepository, gasPurchaseMapper);
        Response response = gasPurchaseService.buyGasoline(infoRq);
        assertTrue(response.getSuccess());
    }

    @Test(expected=ResourceNotFoundException.class)
    public void testBuyGasolineServiceNotFoundGasStation() throws GasolineDataClientException, ResourceNotFoundException {
        String stationId = "1111";
        GasStation gasStation  = GasStation.builder().regularPrice("84").build();
        GasStationData gasStationData = GasStationData.builder().results(Collections.emptyList()).build();
        GasPurchase gasPurchase = GasPurchase.builder().gasType(1).build();
        InfoRQ infoRq = InfoRQ.builder().gasStation(stationId).build();
        when(gasolineDataClient.getGasolineDataById(stationId)).thenReturn(gasStationData);
        GasPurchaseService gasPurchaseService  = new GasPurchaseService(gasolineDataClient, gasPurchaseRepository, gasPurchaseMapper);
        Response response = gasPurchaseService.buyGasoline(infoRq);
    }

}
