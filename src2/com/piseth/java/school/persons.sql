--
-- PostgreSQL database dump
--

--
-- TOC entry 3317 (class 0 OID 24700)
-- Dependencies: 212
-- Data for Name: pets; Type: TABLE DATA; Schema: public; Owner: village_adm
--

INSERT INTO public.pets (id, type) VALUES (1, 'Cat');
INSERT INTO public.pets (id, type) VALUES (2, 'Dog');
INSERT INTO public.pets (id, type) VALUES (3, 'Bird');
INSERT INTO public.pets (id, type) VALUES (4, 'Fish');
INSERT INTO public.pets (id, type) VALUES (5, 'Rabbit');


--
-- TOC entry 3315 (class 0 OID 24694)
-- Dependencies: 210
-- Data for Name: villagers; Type: TABLE DATA; Schema: public; Owner: village_adm
--

INSERT INTO public.villagers (name, gender, age, pet_id) VALUES ('Dara', 'Male', 18, 1);
INSERT INTO public.villagers (name, gender, age, pet_id) VALUES ('Thida', 'Female', 17, 2);
INSERT INTO public.villagers (name, gender, age, pet_id) VALUES ('Dalin', 'Female', 19, 1);
INSERT INTO public.villagers (name, gender, age, pet_id) VALUES ('Dalin', 'Female', 19, 2);
INSERT INTO public.villagers (name, gender, age, pet_id) VALUES ('Veasna', 'Male', 16, NULL);
INSERT INTO public.villagers (name, gender, age, pet_id) VALUES ('Sopheak', 'Female', 17, 4);
INSERT INTO public.villagers (name, gender, age, pet_id) VALUES ('Vannda', 'Male', 21, 3);
INSERT INTO public.villagers (name, gender, age, pet_id) VALUES ('Nary', 'Female', 23, 1);
INSERT INTO public.villagers (name, gender, age, pet_id) VALUES ('Nary', 'Female', 23, 2);
INSERT INTO public.villagers (name, gender, age, pet_id) VALUES ('Nary', 'Female', 23, 3);
INSERT INTO public.villagers (name, gender, age, pet_id) VALUES ('Pisey', 'Female', 19, 1);
INSERT INTO public.villagers (name, gender, age, pet_id) VALUES ('Pisey', 'Female', 19, 5);
INSERT INTO public.villagers (name, gender, age, pet_id) VALUES ('Sovann', 'Male', 18, 1);
INSERT INTO public.villagers (name, gender, age, pet_id) VALUES ('Vannary', 'Female', 20, 4);


--
-- TOC entry 3325 (class 0 OID 0)
-- Dependencies: 211
-- Name: pets_id_seq; Type: SEQUENCE SET; Schema: public; Owner: village_adm
--

SELECT pg_catalog.setval('public.pets_id_seq', 5, true);


-- Completed on 2022-10-19 10:05:18

--
-- PostgreSQL database dump complete
--

