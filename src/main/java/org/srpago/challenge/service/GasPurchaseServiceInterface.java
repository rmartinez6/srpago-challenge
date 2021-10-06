package org.srpago.challenge.service;

import org.srpago.challenge.exception.GasolineDataClientException;
import org.srpago.challenge.exception.ResourceNotFoundException;
import org.srpago.challenge.model.request.InfoRQ;
import org.srpago.challenge.model.response.Response;

public interface GasPurchaseServiceInterface {
    Response buyGasoline(InfoRQ infoRQ) throws ResourceNotFoundException, GasolineDataClientException;
}
