package org.srpago.challenge.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.srpago.challenge.exception.GasolineDataClientException;
import org.srpago.challenge.exception.PurchaseConstraintException;
import org.srpago.challenge.exception.ResourceNotFoundException;
import org.srpago.challenge.model.request.InfoRQ;
import org.srpago.challenge.service.GasPurchaseServiceInterface;
import javax.validation.Valid;


@Controller
public class GasPurchaseController {

    private Logger logger = Logger.getLogger(GasPurchaseController.class);
    @Autowired
    private GasPurchaseServiceInterface gasPurchaseService;

    @PostMapping("/gaspurchase")
    public ResponseEntity makeGasPurchase(@Valid @RequestBody InfoRQ infoRQ, BindingResult bindingResult) throws ResourceNotFoundException, PurchaseConstraintException, GasolineDataClientException {
        logger.info("Making gas purchase");
        logger.info("Making gasoline purchase by " + infoRQ.getName());
        if (bindingResult.hasErrors()) {
            throw new PurchaseConstraintException(bindingResult.getAllErrors(), "Contract Error Validations");
        }
        return ResponseEntity.ok(this.gasPurchaseService.buyGasoline(infoRQ));
    }

}
