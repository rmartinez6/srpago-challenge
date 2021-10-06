package org.srpago.challenge.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.srpago.challenge.client.GasolineDataClient;
import org.srpago.challenge.exception.GasolineDataClientException;
import org.srpago.challenge.exception.ResourceNotFoundException;
import org.srpago.challenge.mapper.GasPurchaseMapper;
import org.srpago.challenge.model.client.gasolineData.GasStation;
import org.srpago.challenge.model.request.InfoRQ;
import org.srpago.challenge.model.response.Response;
import org.srpago.challenge.model.client.gasolineData.GasStationData;
import org.srpago.challenge.model.domain.GasPurchase;
import org.srpago.challenge.repository.GasPurchaseRepository;
import org.srpago.challenge.service.GasPurchaseServiceInterface;

@Service
public class GasPurchaseService implements GasPurchaseServiceInterface {

    @Autowired
    GasolineDataClient gasolineDataClient;
    @Autowired
    GasPurchaseRepository gasPurchaseRepository;
    @Autowired
    GasPurchaseMapper gasPurchaseMapper;

    public Response buyGasoline(InfoRQ infoRQ) throws ResourceNotFoundException, GasolineDataClientException {

        GasStationData gasStationData = gasolineDataClient.getGasolineDataById(infoRQ.getGasStation());
        if (gasStationData.getResults().isEmpty())
            throw new ResourceNotFoundException("GasStation with id : ".concat(infoRQ.getGasStation()).concat(" not found"));
        GasStation gasStation = gasStationData.getResults().get(0);
        GasPurchase gasPurchase = gasPurchaseMapper.gasStationAndInfoRqToGasPurchase(gasStation, infoRQ);
        gasPurchaseRepository.save(gasPurchase);
        return Response.builder().success(Boolean.TRUE).message("Informacion correcta").build();

    }



}
