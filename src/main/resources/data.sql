INSERT INTO classes (name) VALUES ('Mago');
INSERT INTO classes (name) VALUES ('Clérigo');
INSERT INTO classes (name) VALUES ('Bardo');

INSERT INTO spells (name, magic_school, level, description, casting_time, range, components, materials, duration, ritual, concentration, high_levels_description, source)
VALUES ('Bola de Fuego', 'EVOCACION', 3, 'Un hechizo de daño masivo en un área', '1 acción', '40 pies', 'V, S', 'azufre', 'Instantáneo', TRUE, FALSE, 'Descripción adicional para niveles superiores', 'SRD');
INSERT INTO spells (name, magic_school, level, description, casting_time, range, components, materials, duration, ritual, concentration, high_levels_description, source)
VALUES ('Curar Heridas', 'NIGROMANCIA', 1, 'Restaura puntos de vida a una criatura', '1 acción', 'Toque', 'V, S', 'hierbas curativas', 'Instantáneo', FALSE, TRUE, 'Descripción adicional para niveles superiores', 'SRD');


INSERT INTO spells_classes (spell_id, class_id) VALUES (1, 1); -- Mago
INSERT INTO spells_classes (spell_id, class_id) VALUES (1, 3); -- Bardo

INSERT INTO spells_classes (spell_id, class_id) VALUES (2, 2); -- Clérigo
