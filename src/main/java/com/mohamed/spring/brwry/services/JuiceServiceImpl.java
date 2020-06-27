package com.mohamed.spring.brwry.services;

import com.mohamed.spring.brwry.web.model.JuiceDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class JuiceServiceImpl implements JuiceService {

    private List<JuiceDTO> juiceList = new ArrayList<>();

    @Override
    public JuiceDTO getJuiceById(UUID juiceId) {
        return JuiceDTO
                .builder()
                .uuid(UUID.randomUUID())
                .juiceName("Apple Juice")
                .juiceStyle("Apple Company")
                .build();
    }

    @Override
    public JuiceDTO saveJuice(JuiceDTO juiceToSave) {
        return JuiceDTO.builder().uuid(UUID.randomUUID()).build();
    }

    @Override
    public void updateJuice(UUID juiceId, JuiceDTO juiceDTO) {

    }

    @Override
    public void deleteById(UUID juiceId) {

    }
}
