package com.mohamed.spring.brwry.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JuiceDTO {

    @Null
    private UUID uuid;

    @NotBlank
    private String juiceName;

    @NotBlank
    private String juiceStyle;

    @Positive
    private Long upc;
}
