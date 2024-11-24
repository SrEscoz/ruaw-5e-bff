package net.escoz.ruaw5ebff.controllers.dtos;

import lombok.Builder;

@Builder
public record ErrorDTO(String timestamp, int status, String error) {
}
