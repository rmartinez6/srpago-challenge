package org.srpago.challenge.model.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.*;

@Getter
@Setter
@Builder
public class InfoRQ{

    @NotNull(message = "Please provide a email")
    @NotEmpty(message = "Email cannot be empty")
    private String email;

    @NotNull(message = "Please provide a name")
    @NotEmpty(message = "Name cannot be empty")
    private String name;

    @NotNull(message = "Please provide a last name")
    @NotEmpty(message = "Last name cannot be empty")
    private String lastName;

    @NotNull(message = "Please provide a card number")
    @NotEmpty(message = "Card Number cannot be empty")
    @Size(min = 16, max = 16,message = "Card number must be 16 digits")
    private String cardNumber;

    @NotNull(message = "Please provide an expiration Date Year")
    private Integer expirationDateYear;

    @NotNull(message = "Please provide an expiration Date Month")
    @NotEmpty(message = "Expiration month cannot be empty")
    @Size(min=1, max=2,message = "Expiration Date Year must be 1 or 2 digits")
    @Min(value = 1, message = "Expiration date month must be equals or greater than 1")
    @Max(value = 12, message = "Expiration date month must be equals or less than 12")
    private String expirationDateMonth;

    @NotNull(message = "Please provide a gas type")
    @Min(value = 1, message = "Gas Type must be 1 or 2 (Magna/Premium)")
    @Max(value = 2, message = "Gas Type must be 1 or 2 (Magna/Premium)")
    private Integer gasType;

    @NotNull(message = "Please provide an amount")
    @DecimalMin(value = "1.00", message = "Amount must be greater than or equal to $1.00")
    private Double amount;

    @NotNull(message = "Please provide a gasStation")
    @NotEmpty(message = "Gas Station cannot be empty")
    private String gasStation;

    @NotNull(message = "Please provide Seller name")
    @NotEmpty(message = "Seller name cannot be empty")
    private String sellerName;
    
}
