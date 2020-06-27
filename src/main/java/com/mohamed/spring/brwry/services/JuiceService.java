package com.mohamed.spring.brwry.services;

import com.mohamed.spring.brwry.web.model.JuiceDTO;

import java.util.UUID;

public interface JuiceService {
    JuiceDTO getJuiceById(UUID juiceId);

    JuiceDTO saveJuice(JuiceDTO juiceToSave);

    void updateJuice(UUID juiceId, JuiceDTO juiceDTO);

    void deleteById(UUID juiceId);
}
