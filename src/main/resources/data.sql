INSERT INTO classes (name) VALUES ('Mago');
INSERT INTO classes (name) VALUES ('Clérigo');
INSERT INTO classes (name) VALUES ('Bardo');
INSERT INTO classes (name) VALUES ('Guerrero');
INSERT INTO classes (name) VALUES ('Pícaro');
INSERT INTO classes (name) VALUES ('Hechicero');
INSERT INTO classes (name) VALUES ('Druida');
INSERT INTO classes (name) VALUES ('Paladín');
INSERT INTO classes (name) VALUES ('Monje');

INSERT INTO spells (name, magic_school, level, description, casting_time, range, components, materials, duration, ritual, concentration, high_levels_description, source)
VALUES ('Bola de Fuego', 'EVOCACION', 3, 'Un hechizo de daño masivo en un área', '1 acción', '40 pies', 'V, S', 'azufre', 'Instantáneo', TRUE, FALSE, 'Descripción adicional para niveles superiores', 'SRD');

INSERT INTO spells (name, magic_school, level, description, casting_time, range, components, materials, duration, ritual, concentration, high_levels_description, source)
VALUES ('Curar Heridas', 'NIGROMANCIA', 1, 'Restaura puntos de vida a una criatura', '1 acción', 'Toque', 'V, S', 'hierbas curativas', 'Instantáneo', FALSE, TRUE, 'Descripción adicional para niveles superiores', 'SRD');

INSERT INTO spells (name, magic_school, level, description, casting_time, range, components, materials, duration, ritual, concentration, high_levels_description, source)
VALUES ('Rayo de Escarcha', 'EVOCACION', 1, 'Un rayo de energía fría que congela a la víctima', '1 acción', '60 pies', 'V, S', 'ninguno', 'Instantáneo', FALSE, TRUE, 'Descripción adicional para niveles superiores', 'SRD');

INSERT INTO spells (name, magic_school, level, description, casting_time, range, components, materials, duration, ritual, concentration, high_levels_description, source)
VALUES ('Escudo', 'ABJURACION', 1, 'Crea una barrera mágica que aumenta la defensa', '1 acción', 'Personal', 'V, S', 'ninguno', '1 minuto', FALSE, FALSE, 'Descripción adicional para niveles superiores', 'SRD');

INSERT INTO spells (name, magic_school, level, description, casting_time, range, components, materials, duration, ritual, concentration, high_levels_description, source)
VALUES ('Luz', 'ILUSION', 0, 'Hace brillar una pequeña esfera de luz', '1 acción', 'Personal', 'V, S', 'ninguno', '1 minuto', FALSE, FALSE, 'Descripción adicional para niveles superiores', 'SRD');

INSERT INTO spells (name, magic_school, level, description, casting_time, range, components, materials, duration, ritual, concentration, high_levels_description, source)
VALUES ('Truco', 'ILUSION', 0, 'Un hechizo menor que causa una ilusión simple', '1 acción', 'Personal', 'V, S', 'ninguno', 'Instantáneo', FALSE, FALSE, 'Descripción adicional para niveles superiores', 'SRD');

INSERT INTO spells (name, magic_school, level, description, casting_time, range, components, materials, duration, ritual, concentration, high_levels_description, source)
VALUES ('Invocar Elemental de Fuego', 'EVOCACION', 4, 'Invoca un elemental de fuego para que luche a tu lado', '1 acción', '30 pies', 'V, S, M', 'un pequeño trozo de carbón', 'Concentración, hasta 1 hora', FALSE, TRUE, 'Descripción adicional para niveles superiores', 'SRD');

INSERT INTO spells (name, magic_school, level, description, casting_time, range, components, materials, duration, ritual, concentration, high_levels_description, source)
VALUES ('Maldición', 'NIGROMANCIA', 3, 'Causa sufrimiento y maldición a la víctima', '1 acción', '30 pies', 'V, S', 'sangre de criatura muerta', '1 minuto', TRUE, TRUE, 'Descripción adicional para niveles superiores', 'SRD');

INSERT INTO spells (name, magic_school, level, description, casting_time, range, components, materials, duration, ritual, concentration, high_levels_description, source)
VALUES ('Teletransportación', 'CONJURACION', 7, 'Transporta al lanzador a cualquier lugar que haya visitado previamente', '1 acción', '10 pies', 'V, S, M', 'un pedazo de vidrio y una gema', 'Instantáneo', FALSE, FALSE, 'Descripción adicional para niveles superiores', 'SRD');

INSERT INTO spells (name, magic_school, level, description, casting_time, range, components, materials, duration, ritual, concentration, high_levels_description, source)
VALUES ('Protección contra el Mal y el Bien', 'ABJURACION', 1, 'Protege a una criatura contra seres malignos', '1 acción', 'Toque', 'V, S', 'ninguno', '10 minutos', FALSE, FALSE, 'Descripción adicional para niveles superiores', 'SRD');

INSERT INTO spells (name, magic_school, level, description, casting_time, range, components, materials, duration, ritual, concentration, high_levels_description, source)
VALUES ('Conjurar Rayo', 'EVOCACION', 2, 'Un rayo de energía eléctrica que inflige daño a una criatura', '1 acción', '60 pies', 'V, S', 'un pedazo de vidrio', 'Instantáneo', FALSE, TRUE, 'Descripción adicional para niveles superiores', 'SRD');

INSERT INTO spells (name, magic_school, level, description, casting_time, range, components, materials, duration, ritual, concentration, high_levels_description, source)
VALUES ('Rayo en Cadena', 'EVOCACION', 6, 'Causa daño a una criatura y salta a otras cercanas', '1 acción', '150 pies', 'V, S', 'un trozo de hierro', 'Instantáneo', FALSE, TRUE, 'Descripción adicional para niveles superiores', 'SRD');

INSERT INTO spells (name, magic_school, level, description, casting_time, range, components, materials, duration, ritual, concentration, high_levels_description, source)
VALUES ('Piedra de Fuego', 'EVOCACION', 4, 'Causa una explosión de fuego en un área', '1 acción', '60 pies', 'V, S', 'azufre', 'Instantáneo', FALSE, TRUE, 'Descripción adicional para niveles superiores', 'SRD');

INSERT INTO spells (name, magic_school, level, description, casting_time, range, components, materials, duration, ritual, concentration, high_levels_description, source)
VALUES ('Llama Eterna', 'EVOCACION', 3, 'Invoca una llama mágica que nunca se apaga', '1 acción', 'Toque', 'V, S', 'una pequeña bola de cera', '1 hora', FALSE, TRUE, 'Descripción adicional para niveles superiores', 'SRD');

INSERT INTO spells (name, magic_school, level, description, casting_time, range, components, materials, duration, ritual, concentration, high_levels_description, source)
VALUES ('Llamado del Guardián', 'CONJURACION', 5, 'Invoca un guardián elemental para proteger el área', '1 acción', '60 pies', 'V, S, M', 'un cristal', 'Concentración, hasta 1 hora', FALSE, TRUE, 'Descripción adicional para niveles superiores', 'SRD');

-- Relaciones spells_classes
INSERT INTO spells_classes (spell_id, class_id) VALUES (1, 1); -- Bola de Fuego con Mago
INSERT INTO spells_classes (spell_id, class_id) VALUES (1, 3); -- Bola de Fuego con Bardo
INSERT INTO spells_classes (spell_id, class_id) VALUES (2, 2); -- Curar Heridas con Clérigo
INSERT INTO spells_classes (spell_id, class_id) VALUES (3, 1); -- Rayo de Escarcha con Mago
INSERT INTO spells_classes (spell_id, class_id) VALUES (3, 6); -- Rayo de Escarcha con Hechicero
INSERT INTO spells_classes (spell_id, class_id) VALUES (4, 1); -- Escudo con Mago
INSERT INTO spells_classes (spell_id, class_id) VALUES (5, 1); -- Luz con Mago
INSERT INTO spells_classes (spell_id, class_id) VALUES (6, 1); -- Truco con Mago
INSERT INTO spells_classes (spell_id, class_id) VALUES (7, 1); -- Invocar Elemental de Fuego con Mago
INSERT INTO spells_classes (spell_id, class_id) VALUES (8, 2); -- Maldición con Clérigo
INSERT INTO spells_classes (spell_id, class_id) VALUES (9, 1); -- Teletransportación con Mago
INSERT INTO spells_classes (spell_id, class_id) VALUES (10, 1); -- Protección contra el Mal y el Bien con Mago
INSERT INTO spells_classes (spell_id, class_id) VALUES (11, 1); -- Conjurar Rayo con Mago
INSERT INTO spells_classes (spell_id, class_id) VALUES (12, 1); -- Rayo en Cadena con Mago
INSERT INTO spells_classes (spell_id, class_id) VALUES (13, 1); -- Piedra de Fuego con Mago
INSERT INTO spells_classes (spell_id, class_id) VALUES (14, 1); -- Llama Eterna con Mago
INSERT INTO spells_classes (spell_id, class_id) VALUES (15, 1); -- Llamado del Guardián con Mago
