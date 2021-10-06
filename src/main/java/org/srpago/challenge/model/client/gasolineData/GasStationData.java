package org.srpago.challenge.model.client.gasolineData;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class GasStationData {
    private Pagination pagination;
    private List<GasStation> results;

    }
