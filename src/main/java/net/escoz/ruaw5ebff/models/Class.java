package net.escoz.ruaw5ebff.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "classes")
public class Class {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true, nullable = false)
	private String name;

	@OrderBy("name ASC")
	@ManyToMany(mappedBy = "classes")
	private Set<Spell> spells = new LinkedHashSet<>();

	@OrderBy("level ASC")
	@OneToMany(mappedBy = "clazz", orphanRemoval = true)
	private Set<ClassLevel> classLevels = new LinkedHashSet<>();

}