package com.mohamed.spring.brwry.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JuiceDTO {

    private UUID uuid;
    private String juiceName;
    private String juiceStyle;
    private Long upc;
}
