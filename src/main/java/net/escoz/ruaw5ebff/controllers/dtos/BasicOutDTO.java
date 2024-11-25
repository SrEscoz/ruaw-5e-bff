package net.escoz.ruaw5ebff.controllers.dtos;

import lombok.Builder;

@Builder
public record BasicOutDTO(int status, String message) {
}
