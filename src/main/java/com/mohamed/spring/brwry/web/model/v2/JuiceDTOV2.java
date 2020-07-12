package com.mohamed.spring.brwry.web.model.v2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JuiceDTOV2 {

    private UUID uuid;
    private String juiceName;
    private JuiceStyleEnum juiceStyle;
    private Long upc;

}
