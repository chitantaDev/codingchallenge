CREATE TABLE public.antragssteller (
    id bigint NOT NULL,
    vorname character varying,
    nachname character varying
);


ALTER TABLE public.antragssteller OWNER TO your_username;

--
-- Name: antragssteller_id_seq; Type: SEQUENCE; Schema: public; Owner: your_username
--

CREATE SEQUENCE public.antragssteller_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
CREATE TABLE public.nutzereingabe (
    id bigint NOT NULL,
    antragssteller_id bigint,
    kilometerleistung numeric(10,2),
    plz character varying,
    fahrzeugtyp character varying
);


ALTER TABLE public.nutzereingabe OWNER TO your_username;

--
-- Name: nutzereingabe_id_seq; Type: SEQUENCE; Schema: public; Owner: your_username
--

CREATE SEQUENCE public.nutzereingabe_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
--
CREATE TABLE public.versicherungspraemie (
    id bigint NOT NULL,
    antragssteller_id bigint,
    nutzereingabe_id bigint,
    praemie numeric(10,2)
);


ALTER TABLE public.versicherungspraemie OWNER TO your_username;

--
-- Name: versicherungspraemie_id_seq; Type: SEQUENCE; Schema: public; Owner: your_username
--

CREATE SEQUENCE public.versicherungspraemie_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;