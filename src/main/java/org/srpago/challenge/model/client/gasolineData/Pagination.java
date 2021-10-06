package org.srpago.challenge.model.client.gasolineData;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Pagination {
    private Integer pageSize;
    private Integer page;
    private Integer total;

}
