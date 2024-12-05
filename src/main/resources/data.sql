INSERT INTO classes (name, description, simple_description)
VALUES ('Mago',
        'Los magos son los practicantes supremos de la magia, definidos y unidos como una clase por los hechizos que conjuran. A partir de la sutil onda de la magia que impregna el cosmos, los magos lanzan explosivos hechizos de fuego, arcos voltaicos, sutiles engaños y brutales formas de control mental.',
        'Los magos son los practicantes supremos de la magia, definidos y unidos como una clase por los hechizos que conjuran. A partir de la sutil onda de la magia que impregna el cosmos, los magos lanzan explosivos hechizos de fuego, arcos voltaicos, sutiles engaños y brutales formas de control mental.');

INSERT INTO classes (name, description, simple_description)
VALUES ('Clérigo',
        'Los clérigos son intermediarios entre el mundo mortal y las distantes esferas de los dioses. A través de la devoción a una deidad o un ideal divino, canalizan poderosas energías mágicas para curar, proteger y destruir.',
        'Intermediarios entre los dioses y los mortales, canalizan magia divina para curar, proteger y combatir.');

INSERT INTO classes (name, description, simple_description)
VALUES ('Bardo',
        'Los bardos son músicos, poetas y artistas consumados que canalizan la magia a través de su creatividad. Ya sea inspirando aliados, desmoralizando enemigos o desatando hechizos, los bardos son tan versátiles como encantadores.',
        'Músicos mágicos y artistas versátiles que inspiran aliados y lanzan hechizos.');

INSERT INTO classes (name, description, simple_description)
VALUES ('Guerrero',
        'Los guerreros son maestros del combate, capaces de manejar cualquier tipo de arma o armadura con destreza. En la batalla, su entrenamiento y habilidades los convierten en una fuerza imparable.',
        'Maestros del combate y las armas, letales en cualquier enfrentamiento.');

INSERT INTO classes (name, description, simple_description)
VALUES ('Pícaro',
        'Los pícaros son expertos en habilidades y engaños, capaces de moverse sigilosamente, desactivar trampas y encontrar debilidades en sus enemigos. Su astucia y precisión los convierten en adversarios formidables.',
        'Expertos en habilidades y engaños, letales con precisión y astucia.');

INSERT INTO classes (name, description, simple_description)
VALUES ('Hechicero',
        'Los hechiceros son individuos bendecidos (o maldecidos) con una conexión innata con la magia. Canalizan poderes arcanos a través de su voluntad, liberando energías mágicas con un estilo único.',
        'Portadores innatos de magia, liberan poder arcano con pura voluntad.');

INSERT INTO classes (name, description, simple_description)
VALUES ('Druida',
        'Los druidas son guardianes de la naturaleza, capaces de transformarse en animales, controlar los elementos y sanar a los heridos. Su magia fluye desde el propio equilibrio del mundo natural.',
        'Guardianes de la naturaleza, transforman cuerpos y controlan elementos.');

INSERT INTO classes (name, description, simple_description)
VALUES ('Paladín',
        'Los paladines son campeones sagrados de la justicia, juramentados a defender los ideales de su fe. Combinan habilidades marciales y magia divina para derrotar al mal.',
        'Campeones sagrados que combinan combate y magia divina.');

INSERT INTO classes (name, description, simple_description)
VALUES ('Monje',
        'Los monjes son maestros de la disciplina corporal y espiritual, canalizando una energía mágica conocida como ki para realizar hazañas sobrehumanas en combate y más allá.',
        'Maestros de la disciplina y el ki, con habilidades sobrehumanas.');


INSERT INTO spells (name, magic_school, level, description, casting_time, spell_range, components, materials, duration, ritual, concentration, high_levels_description, source)
VALUES ('Bola de Fuego', 'EVOCACION', 3, 'Un hechizo de daño masivo en un área', '1 acción', '40 pies', 'V, S', 'azufre', 'Instantáneo', TRUE, FALSE, 'Descripción adicional para niveles superiores', 'SRD');

INSERT INTO spells (name, magic_school, level, description, casting_time, spell_range, components, materials, duration, ritual, concentration, high_levels_description, source)
VALUES ('Curar Heridas', 'NIGROMANCIA', 1, 'Restaura puntos de vida a una criatura', '1 acción', 'Toque', 'V, S', 'hierbas curativas', 'Instantáneo', FALSE, TRUE, 'Descripción adicional para niveles superiores', 'SRD');

INSERT INTO spells (name, magic_school, level, description, casting_time, spell_range, components, materials, duration, ritual, concentration, high_levels_description, source)
VALUES ('Rayo de Escarcha', 'EVOCACION', 1, 'Un rayo de energía fría que congela a la víctima', '1 acción', '60 pies', 'V, S', 'ninguno', 'Instantáneo', FALSE, TRUE, 'Descripción adicional para niveles superiores', 'SRD');

INSERT INTO spells (name, magic_school, level, description, casting_time, spell_range, components, materials, duration, ritual, concentration, high_levels_description, source)
VALUES ('Escudo', 'ABJURACION', 1, 'Crea una barrera mágica que aumenta la defensa', '1 acción', 'Personal', 'V, S', 'ninguno', '1 minuto', FALSE, FALSE, 'Descripción adicional para niveles superiores', 'SRD');

INSERT INTO spells (name, magic_school, level, description, casting_time, spell_range, components, materials, duration, ritual, concentration, high_levels_description, source)
VALUES ('Luz', 'ILUSION', 0, 'Hace brillar una pequeña esfera de luz', '1 acción', 'Personal', 'V, S', 'ninguno', '1 minuto', FALSE, FALSE, 'Descripción adicional para niveles superiores', 'SRD');

INSERT INTO spells (name, magic_school, level, description, casting_time, spell_range, components, materials, duration, ritual, concentration, high_levels_description, source)
VALUES ('Truco', 'ILUSION', 0, 'Un hechizo menor que causa una ilusión simple', '1 acción', 'Personal', 'V, S', 'ninguno', 'Instantáneo', FALSE, FALSE, 'Descripción adicional para niveles superiores', 'SRD');

INSERT INTO spells (name, magic_school, level, description, casting_time, spell_range, components, materials, duration, ritual, concentration, high_levels_description, source)
VALUES ('Invocar Elemental de Fuego', 'EVOCACION', 4, 'Invoca un elemental de fuego para que luche a tu lado', '1 acción', '30 pies', 'V, S, M', 'un pequeño trozo de carbón', 'Concentración, hasta 1 hora', FALSE, TRUE, 'Descripción adicional para niveles superiores', 'SRD');

INSERT INTO spells (name, magic_school, level, description, casting_time, spell_range, components, materials, duration, ritual, concentration, high_levels_description, source)
VALUES ('Maldición', 'NIGROMANCIA', 3, 'Causa sufrimiento y maldición a la víctima', '1 acción', '30 pies', 'V, S', 'sangre de criatura muerta', '1 minuto', TRUE, TRUE, 'Descripción adicional para niveles superiores', 'SRD');

INSERT INTO spells (name, magic_school, level, description, casting_time, spell_range, components, materials, duration, ritual, concentration, high_levels_description, source)
VALUES ('Teletransportación', 'CONJURACION', 7, 'Transporta al lanzador a cualquier lugar que haya visitado previamente', '1 acción', '10 pies', 'V, S, M', 'un pedazo de vidrio y una gema', 'Instantáneo', FALSE, FALSE, 'Descripción adicional para niveles superiores', 'SRD');

INSERT INTO spells (name, magic_school, level, description, casting_time, spell_range, components, materials, duration, ritual, concentration, high_levels_description, source)
VALUES ('Protección contra el Mal y el Bien', 'ABJURACION', 1, 'Protege a una criatura contra seres malignos', '1 acción', 'Toque', 'V, S', 'ninguno', '10 minutos', FALSE, FALSE, 'Descripción adicional para niveles superiores', 'SRD');

INSERT INTO spells (name, magic_school, level, description, casting_time, spell_range, components, materials, duration, ritual, concentration, high_levels_description, source)
VALUES ('Conjurar Rayo', 'EVOCACION', 2, 'Un rayo de energía eléctrica que inflige daño a una criatura', '1 acción', '60 pies', 'V, S', 'un pedazo de vidrio', 'Instantáneo', FALSE, TRUE, 'Descripción adicional para niveles superiores', 'SRD');

INSERT INTO spells (name, magic_school, level, description, casting_time, spell_range, components, materials, duration, ritual, concentration, high_levels_description, source)
VALUES ('Rayo en Cadena', 'EVOCACION', 6, 'Causa daño a una criatura y salta a otras cercanas', '1 acción', '150 pies', 'V, S', 'un trozo de hierro', 'Instantáneo', FALSE, TRUE, 'Descripción adicional para niveles superiores', 'SRD');

INSERT INTO spells (name, magic_school, level, description, casting_time, spell_range, components, materials, duration, ritual, concentration, high_levels_description, source)
VALUES ('Piedra de Fuego', 'EVOCACION', 4, 'Causa una explosión de fuego en un área', '1 acción', '60 pies', 'V, S', 'azufre', 'Instantáneo', FALSE, TRUE, 'Descripción adicional para niveles superiores', 'SRD');

INSERT INTO spells (name, magic_school, level, description, casting_time, spell_range, components, materials, duration, ritual, concentration, high_levels_description, source)
VALUES ('Llama Eterna', 'EVOCACION', 3, 'Invoca una llama mágica que nunca se apaga', '1 acción', 'Toque', 'V, S', 'una pequeña bola de cera', '1 hora', FALSE, TRUE, 'Descripción adicional para niveles superiores', 'SRD');

INSERT INTO spells (name, magic_school, level, description, casting_time, spell_range, components, materials, duration, ritual, concentration, high_levels_description, source)
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


-- Inserts para los niveles del Clérigo
INSERT INTO class_levels (class_id, level, proficiency_bonus, known_cantrips, features)
VALUES (2, 1, 2, 3, NULL);
-- Agregar características según sea necesario
-- Agregar espacios de conjuro para el nivel 1
INSERT INTO spell_slots (class_level_id, spell_level, slots)
VALUES (1, 2, 1);
INSERT INTO class_levels (class_id, level, proficiency_bonus, known_cantrips, features)
VALUES (2, 2, 2, 3, NULL);
-- Agregar características según sea necesario
-- Agregar espacios de conjuro para el nivel 2
INSERT INTO spell_slots (class_level_id, spell_level, slots)
VALUES (1, 3, 1);
INSERT INTO class_levels (class_id, level, proficiency_bonus, known_cantrips, features)
VALUES (2, 3, 2, 3, NULL);
-- Agregar características según sea necesario
-- Agregar espacios de conjuro para el nivel 3

INSERT INTO class_levels (class_id, level, proficiency_bonus, known_cantrips, features)
VALUES (2, 4, 2, 4, NULL);
-- Agregar características según sea necesario
-- Agregar espacios de conjuro para el nivel 4

INSERT INTO class_levels (class_id, level, proficiency_bonus, known_cantrips, features)
VALUES (2, 5, 3, 4, NULL);
-- Agregar características según sea necesario
-- Agregar espacios de conjuro para el nivel 5

INSERT INTO class_levels (class_id, level, proficiency_bonus, known_cantrips, features)
VALUES (2, 6, 3, 4, NULL);
-- Agregar características según sea necesario
-- Agregar espacios de conjuro para el nivel 6

INSERT INTO class_levels (class_id, level, proficiency_bonus, known_cantrips, features)
VALUES (2, 7, 3, 4, NULL);
-- Agregar características según sea necesario
-- Agregar espacios de conjuro para el nivel 7

INSERT INTO class_levels (class_id, level, proficiency_bonus, known_cantrips, features)
VALUES (2, 8, 3, 4, NULL);
-- Agregar características según sea necesario
-- Agregar espacios de conjuro para el nivel 8

INSERT INTO class_levels (class_id, level, proficiency_bonus, known_cantrips, features)
VALUES (2, 9, 4, 4, NULL);
-- Agregar características según sea necesario
-- Agregar espacios de conjuro para el nivel 9

INSERT INTO class_levels (class_id, level, proficiency_bonus, known_cantrips, features)
VALUES (2, 10, 4, 5, NULL);
-- Agregar características según sea necesario
-- Agregar espacios de conjuro para el nivel 10

INSERT INTO class_levels (class_id, level, proficiency_bonus, known_cantrips, features)
VALUES (2, 11, 4, 5, NULL);
-- Agregar características según sea necesario
-- Agregar espacios de conjuro para el nivel 11

INSERT INTO class_levels (class_id, level, proficiency_bonus, known_cantrips, features)
VALUES (2, 12, 4, 5, NULL);
-- Agregar características según sea necesario
-- Agregar espacios de conjuro para el nivel 12

INSERT INTO class_levels (class_id, level, proficiency_bonus, known_cantrips, features)
VALUES (2, 13, 5, 5, NULL);
-- Agregar características según sea necesario
-- Agregar espacios de conjuro para el nivel 13

INSERT INTO class_levels (class_id, level, proficiency_bonus, known_cantrips, features)
VALUES (2, 14, 5, 5, NULL);
-- Agregar características según sea necesario
-- Agregar espacios de conjuro para el nivel 14

INSERT INTO class_levels (class_id, level, proficiency_bonus, known_cantrips, features)
VALUES (2, 15, 5, 5, NULL);
-- Agregar características según sea necesario
-- Agregar espacios de conjuro para el nivel 15

INSERT INTO class_levels (class_id, level, proficiency_bonus, known_cantrips, features)
VALUES (2, 16, 5, 5, NULL);
-- Agregar características según sea necesario
-- Agregar espacios de conjuro para el nivel 16

INSERT INTO class_levels (class_id, level, proficiency_bonus, known_cantrips, features)
VALUES (2, 17, 6, 5, NULL);
-- Agregar características según sea necesario
-- Agregar espacios de conjuro para el nivel 17

INSERT INTO class_levels (class_id, level, proficiency_bonus, known_cantrips, features)
VALUES (2, 18, 6, 5, NULL);
-- Agregar características según sea necesario
-- Agregar espacios de conjuro para el nivel 18

INSERT INTO class_levels (class_id, level, proficiency_bonus, known_cantrips, features)
VALUES (2, 19, 6, 5, NULL);
-- Agregar características según sea necesario
-- Agregar espacios de conjuro para el nivel 19

INSERT INTO class_levels (class_id, level, proficiency_bonus, known_cantrips, features)
VALUES (2, 20, 6, 5, NULL); -- Agregar características según sea necesario

INSERT INTO source_books (title) VALUES
('Manual del Jugador'),
('Guía del Dungeon Master'),
('Manual de Monstruos'),
('El Caldero de Todo de Tasha'),
('Guía de Todo de Xanathar'),
('Guía de Monstruos de Volo'),
('Tomo de los Enemigos de Mordenkainen'),
('Guía de Aventuras de la Costa de la Espada'),
('Tesoro de Dragones de Fizban'),
('Fantasmas de Saltmarsh');