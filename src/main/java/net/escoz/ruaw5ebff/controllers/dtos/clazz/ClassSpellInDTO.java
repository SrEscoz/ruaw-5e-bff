package net.escoz.ruaw5ebff.controllers.dtos.clazz;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public final class ClassSpellInDTO {

	private List<Long> spellIds;
}
