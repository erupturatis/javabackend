--
-- PostgreSQL database dump
--

-- Dumped from database version 14.11 (Ubuntu 14.11-0ubuntu0.22.04.1)
-- Dumped by pg_dump version 14.11 (Ubuntu 14.11-0ubuntu0.22.04.1)

-- Started on 2024-05-26 08:53:58 EEST

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 3 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA public;


ALTER SCHEMA public OWNER TO postgres;

--
-- TOC entry 3441 (class 0 OID 0)
-- Dependencies: 3
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA public IS 'standard public schema';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 210 (class 1259 OID 16721)
-- Name: admin; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.admin (
    id integer NOT NULL,
    username character varying(50) NOT NULL,
    password character varying(255) NOT NULL
);


ALTER TABLE public.admin OWNER TO postgres;

--
-- TOC entry 209 (class 1259 OID 16720)
-- Name: admin_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.admin_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.admin_id_seq OWNER TO postgres;

--
-- TOC entry 3442 (class 0 OID 0)
-- Dependencies: 209
-- Name: admin_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.admin_id_seq OWNED BY public.admin.id;


--
-- TOC entry 222 (class 1259 OID 16801)
-- Name: application; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.application (
    id integer NOT NULL,
    project_id integer NOT NULL,
    name character varying(100) NOT NULL,
    motivation text
);


ALTER TABLE public.application OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 16800)
-- Name: application_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.application_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.application_id_seq OWNER TO postgres;

--
-- TOC entry 3443 (class 0 OID 0)
-- Dependencies: 221
-- Name: application_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.application_id_seq OWNED BY public.application.id;


--
-- TOC entry 223 (class 1259 OID 16814)
-- Name: application_skill; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.application_skill (
    application_id integer NOT NULL,
    skill_id integer NOT NULL
);


ALTER TABLE public.application_skill OWNER TO postgres;

--
-- TOC entry 212 (class 1259 OID 16730)
-- Name: department; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.department (
    id integer NOT NULL,
    name character varying(100) NOT NULL,
    description text
);


ALTER TABLE public.department OWNER TO postgres;

--
-- TOC entry 211 (class 1259 OID 16729)
-- Name: department_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.department_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.department_id_seq OWNER TO postgres;

--
-- TOC entry 3444 (class 0 OID 0)
-- Dependencies: 211
-- Name: department_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.department_id_seq OWNED BY public.department.id;


--
-- TOC entry 216 (class 1259 OID 16753)
-- Name: member; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.member (
    id integer NOT NULL,
    name character varying(100) NOT NULL,
    email character varying(100) NOT NULL
);


ALTER TABLE public.member OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 16752)
-- Name: member_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.member_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.member_id_seq OWNER TO postgres;

--
-- TOC entry 3445 (class 0 OID 0)
-- Dependencies: 215
-- Name: member_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.member_id_seq OWNED BY public.member.id;


--
-- TOC entry 220 (class 1259 OID 16785)
-- Name: member_skill; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.member_skill (
    member_id integer NOT NULL,
    skill_id integer NOT NULL
);


ALTER TABLE public.member_skill OWNER TO postgres;

--
-- TOC entry 214 (class 1259 OID 16739)
-- Name: project; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.project (
    id integer NOT NULL,
    name character varying(100) NOT NULL,
    description text,
    department_id integer NOT NULL
);


ALTER TABLE public.project OWNER TO postgres;

--
-- TOC entry 213 (class 1259 OID 16738)
-- Name: project_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.project_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.project_id_seq OWNER TO postgres;

--
-- TOC entry 3446 (class 0 OID 0)
-- Dependencies: 213
-- Name: project_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.project_id_seq OWNED BY public.project.id;


--
-- TOC entry 217 (class 1259 OID 16761)
-- Name: project_member; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.project_member (
    project_id integer NOT NULL,
    member_id integer NOT NULL
);


ALTER TABLE public.project_member OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 16777)
-- Name: skill; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.skill (
    id integer NOT NULL,
    name character varying(100) NOT NULL
);


ALTER TABLE public.skill OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 16776)
-- Name: skill_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.skill_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.skill_id_seq OWNER TO postgres;

--
-- TOC entry 3447 (class 0 OID 0)
-- Dependencies: 218
-- Name: skill_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.skill_id_seq OWNED BY public.skill.id;


--
-- TOC entry 3244 (class 2604 OID 16724)
-- Name: admin id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.admin ALTER COLUMN id SET DEFAULT nextval('public.admin_id_seq'::regclass);


--
-- TOC entry 3249 (class 2604 OID 16804)
-- Name: application id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.application ALTER COLUMN id SET DEFAULT nextval('public.application_id_seq'::regclass);


--
-- TOC entry 3245 (class 2604 OID 16733)
-- Name: department id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.department ALTER COLUMN id SET DEFAULT nextval('public.department_id_seq'::regclass);


--
-- TOC entry 3247 (class 2604 OID 16756)
-- Name: member id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.member ALTER COLUMN id SET DEFAULT nextval('public.member_id_seq'::regclass);


--
-- TOC entry 3246 (class 2604 OID 16742)
-- Name: project id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.project ALTER COLUMN id SET DEFAULT nextval('public.project_id_seq'::regclass);


--
-- TOC entry 3248 (class 2604 OID 16780)
-- Name: skill id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.skill ALTER COLUMN id SET DEFAULT nextval('public.skill_id_seq'::regclass);


--
-- TOC entry 3422 (class 0 OID 16721)
-- Dependencies: 210
-- Data for Name: admin; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.admin (id, username, password) FROM stdin;
1	admin1	password1
2	admin2	password2
3	admin3	password3
\.


--
-- TOC entry 3434 (class 0 OID 16801)
-- Dependencies: 222
-- Data for Name: application; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.application (id, project_id, name, motivation) FROM stdin;
1	1	Michael Scott	I love web development
2	1	Pam Beesly	Passionate about front-end development
3	2	Jim Halpert	Experienced in mobile app development
4	2	Dwight Schrute	Strong backend skills
5	3	Angela Martin	Expert in social media strategies
6	3	Oscar Martinez	Data-driven marketing specialist
7	4	Kevin Malone	SEO enthusiast
8	4	Toby Flenderson	Interested in optimizing search rankings
9	5	Ryan Howard	Eager to help with recruitment efforts
10	5	Stanley Hudson	Experienced in HR practices
\.


--
-- TOC entry 3435 (class 0 OID 16814)
-- Dependencies: 223
-- Data for Name: application_skill; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.application_skill (application_id, skill_id) FROM stdin;
1	1
1	3
2	3
2	4
3	2
3	5
4	1
4	2
5	6
5	7
6	7
6	8
7	6
7	9
8	8
8	10
9	9
9	10
10	1
10	2
\.


--
-- TOC entry 3424 (class 0 OID 16730)
-- Dependencies: 212
-- Data for Name: department; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.department (id, name, description) FROM stdin;
1	Software Engineering	Handles software development projects
2	Marketing	Handles marketing campaigns and projects
3	Human Resources	Manages employee relations and recruitment
\.


--
-- TOC entry 3428 (class 0 OID 16753)
-- Dependencies: 216
-- Data for Name: member; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.member (id, name, email) FROM stdin;
1	Alice Johnson	alice.johnson@example.com
2	Bob Smith	bob.smith@example.com
3	Charlie Brown	charlie.brown@example.com
4	David Wilson	david.wilson@example.com
5	Eve Davis	eve.davis@example.com
6	Frank Moore	frank.moore@example.com
7	Grace Lee	grace.lee@example.com
8	Hank Taylor	hank.taylor@example.com
9	Ivy Walker	ivy.walker@example.com
10	Jack White	jack.white@example.com
11	Karen Harris	karen.harris@example.com
\.


--
-- TOC entry 3432 (class 0 OID 16785)
-- Dependencies: 220
-- Data for Name: member_skill; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.member_skill (member_id, skill_id) FROM stdin;
1	1
1	2
1	3
2	1
2	4
2	5
3	2
3	3
3	4
4	5
4	6
4	7
5	8
5	9
5	10
6	6
6	7
6	8
7	9
7	10
7	1
8	2
8	3
8	4
9	5
9	6
9	7
10	8
10	9
10	10
11	1
11	2
11	3
\.


--
-- TOC entry 3426 (class 0 OID 16739)
-- Dependencies: 214
-- Data for Name: project; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.project (id, name, description, department_id) FROM stdin;
1	Web Application Development	Developing a web application	1
2	Mobile App Development	Creating a mobile application	1
3	Social Media Campaign	Running a social media marketing campaign	2
4	SEO Optimization	Improving search engine ranking	2
5	Recruitment Drive	Recruiting new employees	3
\.


--
-- TOC entry 3429 (class 0 OID 16761)
-- Dependencies: 217
-- Data for Name: project_member; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.project_member (project_id, member_id) FROM stdin;
1	1
1	2
1	3
2	3
2	4
2	5
3	6
3	7
3	8
4	8
4	9
4	10
5	10
5	11
5	1
\.


--
-- TOC entry 3431 (class 0 OID 16777)
-- Dependencies: 219
-- Data for Name: skill; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.skill (id, name) FROM stdin;
1	Java
2	Python
3	JavaScript
4	HTML
5	CSS
6	Marketing Strategy
7	SEO
8	Recruitment
9	Communication
10	Project Management
\.


--
-- TOC entry 3448 (class 0 OID 0)
-- Dependencies: 209
-- Name: admin_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.admin_id_seq', 3, true);


--
-- TOC entry 3449 (class 0 OID 0)
-- Dependencies: 221
-- Name: application_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.application_id_seq', 10, true);


--
-- TOC entry 3450 (class 0 OID 0)
-- Dependencies: 211
-- Name: department_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.department_id_seq', 6, true);


--
-- TOC entry 3451 (class 0 OID 0)
-- Dependencies: 215
-- Name: member_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.member_id_seq', 33, true);


--
-- TOC entry 3452 (class 0 OID 0)
-- Dependencies: 213
-- Name: project_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.project_id_seq', 15, true);


--
-- TOC entry 3453 (class 0 OID 0)
-- Dependencies: 218
-- Name: skill_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.skill_id_seq', 30, true);


--
-- TOC entry 3251 (class 2606 OID 16726)
-- Name: admin admin_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.admin
    ADD CONSTRAINT admin_pkey PRIMARY KEY (id);


--
-- TOC entry 3253 (class 2606 OID 16728)
-- Name: admin admin_username_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.admin
    ADD CONSTRAINT admin_username_key UNIQUE (username);


--
-- TOC entry 3271 (class 2606 OID 16808)
-- Name: application application_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.application
    ADD CONSTRAINT application_pkey PRIMARY KEY (id);


--
-- TOC entry 3273 (class 2606 OID 16818)
-- Name: application_skill application_skill_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.application_skill
    ADD CONSTRAINT application_skill_pkey PRIMARY KEY (application_id, skill_id);


--
-- TOC entry 3255 (class 2606 OID 16737)
-- Name: department department_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.department
    ADD CONSTRAINT department_pkey PRIMARY KEY (id);


--
-- TOC entry 3259 (class 2606 OID 16760)
-- Name: member member_email_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.member
    ADD CONSTRAINT member_email_key UNIQUE (email);


--
-- TOC entry 3261 (class 2606 OID 16758)
-- Name: member member_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.member
    ADD CONSTRAINT member_pkey PRIMARY KEY (id);


--
-- TOC entry 3269 (class 2606 OID 16789)
-- Name: member_skill member_skill_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.member_skill
    ADD CONSTRAINT member_skill_pkey PRIMARY KEY (member_id, skill_id);


--
-- TOC entry 3263 (class 2606 OID 16765)
-- Name: project_member project_member_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.project_member
    ADD CONSTRAINT project_member_pkey PRIMARY KEY (project_id, member_id);


--
-- TOC entry 3257 (class 2606 OID 16746)
-- Name: project project_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.project
    ADD CONSTRAINT project_pkey PRIMARY KEY (id);


--
-- TOC entry 3265 (class 2606 OID 16784)
-- Name: skill skill_name_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.skill
    ADD CONSTRAINT skill_name_key UNIQUE (name);


--
-- TOC entry 3267 (class 2606 OID 16782)
-- Name: skill skill_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.skill
    ADD CONSTRAINT skill_pkey PRIMARY KEY (id);


--
-- TOC entry 3279 (class 2606 OID 16809)
-- Name: application application_project_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.application
    ADD CONSTRAINT application_project_id_fkey FOREIGN KEY (project_id) REFERENCES public.project(id);


--
-- TOC entry 3280 (class 2606 OID 16819)
-- Name: application_skill application_skill_application_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.application_skill
    ADD CONSTRAINT application_skill_application_id_fkey FOREIGN KEY (application_id) REFERENCES public.application(id);


--
-- TOC entry 3281 (class 2606 OID 16824)
-- Name: application_skill application_skill_skill_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.application_skill
    ADD CONSTRAINT application_skill_skill_id_fkey FOREIGN KEY (skill_id) REFERENCES public.skill(id);


--
-- TOC entry 3277 (class 2606 OID 16790)
-- Name: member_skill member_skill_member_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.member_skill
    ADD CONSTRAINT member_skill_member_id_fkey FOREIGN KEY (member_id) REFERENCES public.member(id);


--
-- TOC entry 3278 (class 2606 OID 16795)
-- Name: member_skill member_skill_skill_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.member_skill
    ADD CONSTRAINT member_skill_skill_id_fkey FOREIGN KEY (skill_id) REFERENCES public.skill(id);


--
-- TOC entry 3274 (class 2606 OID 16747)
-- Name: project project_department_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.project
    ADD CONSTRAINT project_department_id_fkey FOREIGN KEY (department_id) REFERENCES public.department(id);


--
-- TOC entry 3276 (class 2606 OID 16771)
-- Name: project_member project_member_member_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.project_member
    ADD CONSTRAINT project_member_member_id_fkey FOREIGN KEY (member_id) REFERENCES public.member(id);


--
-- TOC entry 3275 (class 2606 OID 16766)
-- Name: project_member project_member_project_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.project_member
    ADD CONSTRAINT project_member_project_id_fkey FOREIGN KEY (project_id) REFERENCES public.project(id);


-- Completed on 2024-05-26 08:53:59 EEST

--
-- PostgreSQL database dump complete
--

