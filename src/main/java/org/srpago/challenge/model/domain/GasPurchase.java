package org.srpago.challenge.model.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "GAS_PURCHASE")
public class GasPurchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchase_id")
    private Long purchaseId;
    @Column(name = "customer_email")
    private String customerEmail;
    @Column(name = "customer_name")
    private String customerName;
    @Column(name = "customer_last_name")
    private String customerLastName;
    @Column(name = "card_number")
    private String cardNumber;
    @Column(name = "card_expiration_date_year")
    private Integer cardExpirationDateYear;
    @Column(name = "card_expiration_date_month")
    private String cardExpirationDateMonth;
    @Column(name = "gas_type")
    private Integer gasType;
    private Double amount;
    @Column(name = "gas_station")
    private String gasStation;
    @Column(name = "seller_name")
    private String sellerName;
    @Column(name = "gas_station_address")
    private String gasStationAddress;
    @Column(name = "gas_station_rfc")
    private String gasStationRfc;
    @Column(name = "purchase_date_insert")
    private String purchaseDateInsert;
    @Column(name = "regular_price")
    private String regularPrice;
    private String cologne;
    @Column(name = "licence_number")
    private String licenceNumber;
    @Column(name = "licence_id")
    private String licenceId;
    @Column(name = "application_date")
    private String applicationDate;
    private String longitude;
    private String latitude;
    @Column(name = "premium_price")
    private String premiumPrice;
    @Column(name = "business_name")
    private String businessName;
    @Column(name = "postal_code")
    private String postalCode;
    private String dieasel;

}
