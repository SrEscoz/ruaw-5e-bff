package net.escoz.ruaw5ebff.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@Entity
@Table(name = "class_levels", uniqueConstraints = {
		@UniqueConstraint(columnNames = {"class_id", "level"})
})
public class ClassLevel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Min(1)
	@NotNull
	private Integer level;

	@Min(2)
	@Max(6)
	private Integer proficiencyBonus;

	private Integer knownCantrips;

	private String features;

	@ElementCollection
	@CollectionTable(name = "spell_slots", joinColumns = @JoinColumn(name = "class_level_id"))
	@MapKeyColumn(name = "spell_level")
	@Column(name = "slots")
	private Map<Integer, Integer> spellSlots;

	@ManyToOne
	@JoinColumn(name = "class_id")
	private Class clazz;

}