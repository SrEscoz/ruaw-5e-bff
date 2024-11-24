package net.escoz.ruaw5ebff.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "spells")
public class Spell {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@Column(length = 50)
	@Enumerated(EnumType.STRING)
	private MagicSchool magicSchool;

	private Integer level;

	@Column(length = 4000)
	private String description;

	private String castingTime;

	private String range;

	@Column(length = 10)
	private String components; // Los componentes puedes ser Verbal (V), Somático (S) o Material (M)

	@Column(length = 1000)
	private String materials;

	private String duration;

	private Boolean ritual;

	private Boolean concentration;

	@Column(length = 4000)
	private String highLevelsDescription;

	private String source;

	/* Relaciones muchos a muchos */
	@ManyToMany
	@JoinTable(name = "spells_classes",
			joinColumns = @JoinColumn(name = "spell_id"),
			inverseJoinColumns = @JoinColumn(name = "class_id"))
	private Set<Class> classes = new LinkedHashSet<>();

}