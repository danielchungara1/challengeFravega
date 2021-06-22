package com.danisoft.challengeFravega.layers.access;

import lombok.*;
import org.modelmapper.ModelMapper;

@Builder
@Getter
@Setter
public class ResponseDto {

    private String message;
    private String details;
    private Object data;

    // Custom Setter for Builder
    public static class ResponseDtoBuilder {

        private static final ModelMapper modelMapper = new ModelMapper();

        public ResponseDtoBuilder data(Object data, Class dto){
            this.data = modelMapper.map(data, dto);
            return this;
        }

    }
}
