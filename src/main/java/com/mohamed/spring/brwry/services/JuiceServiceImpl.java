package com.mohamed.spring.brwry.services;

import com.mohamed.spring.brwry.web.model.JuiceDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class JuiceServiceImpl implements JuiceService {
    @Override
    public JuiceDTO getJuiceById(UUID juiceId) {
        return JuiceDTO
                .builder()
                .uuid(UUID.randomUUID())
                .juiceName("Apple Juice")
                .juiceStyle("Apple Company")
                .build();
    }
}
