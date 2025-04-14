package com.mystic.zenith.shared.mapper;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class Mapper {

    private final ModelMapper modelMapper;

    public <T, S> S mapToResponse (T source, Class<S> type) {
        return modelMapper.map(source, type);
    }
}
