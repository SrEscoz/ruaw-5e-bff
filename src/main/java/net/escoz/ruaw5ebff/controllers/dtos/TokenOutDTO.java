package net.escoz.ruaw5ebff.controllers.dtos;

import lombok.Builder;

@Builder
public record TokenOutDTO(int status, String token, String expiration) {
}
