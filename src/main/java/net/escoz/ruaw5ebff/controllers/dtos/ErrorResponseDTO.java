package net.escoz.ruaw5ebff.controllers.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

import java.util.List;

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ErrorResponseDTO(String timestamp, int status, String error, List<String> errors) {
}
