package org.srpago.challenge.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.srpago.challenge.model.client.gasolineData.GasStation;
import org.srpago.challenge.model.domain.GasPurchase;
import org.srpago.challenge.model.request.InfoRQ;

@Mapper(componentModel = "spring")
public interface GasPurchaseMapper {

    GasPurchaseMapper INSTANCE = Mappers.getMapper(GasPurchaseMapper.class);


    @Mappings({
            @Mapping(target = "customerEmail", source = "infoRq.email"),
            @Mapping(target = "customerName", source = "infoRq.name"),
            @Mapping(target = "customerLastName", source = "infoRq.lastName"),
            @Mapping(target = "cardNumber", source = "infoRq.cardNumber"),
            @Mapping(target = "cardExpirationDateYear", source = "infoRq.expirationDateYear"),
            @Mapping(target = "cardExpirationDateMonth", source = "infoRq.expirationDateMonth"),
            @Mapping(target = "gasType", source = "infoRq.gasType"),
            @Mapping(target = "amount", source = "infoRq.amount"),
            @Mapping(target = "gasStation", source = "infoRq.gasStation"),
            @Mapping(target = "sellerName", source = "infoRq.sellerName"),
            @Mapping(target = "gasStationAddress", source = "gasStation.address"),
            @Mapping(target = "gasStationRfc", source = "gasStation.rfc"),
            @Mapping(target = "purchaseDateInsert", source = "gasStation.dateInsert"),
            @Mapping(target = "regularPrice", source = "gasStation.regularPrice"),
            @Mapping(target = "cologne", source = "gasStation.cologne"),
            @Mapping(target = "licenceNumber", source = "gasStation.licenceNumber"),
            @Mapping(target = "licenceId", source = "gasStation.licenceId"),
            @Mapping(target = "applicationDate", source = "gasStation.applicationDate"),
            @Mapping(target = "longitude", source = "gasStation.longitude"),
            @Mapping(target = "latitude", source = "gasStation.latitude"),
            @Mapping(target = "premiumPrice", source = "gasStation.premiumPrice"),
            @Mapping(target = "businessName", source = "gasStation.businessName"),
            @Mapping(target = "postalCode", source = "gasStation.postalCode"),
            @Mapping(target = "dieasel", source = "gasStation.dieasel"),
    })
    public GasPurchase gasStationAndInfoRqToGasPurchase(GasStation gasStation, InfoRQ infoRq);

}
