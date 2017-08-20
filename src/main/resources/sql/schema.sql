CREATE TABLE public.user_account
(
  id integer NOT NULL,
  login character varying(255),
  name character varying(255) NOT NULL,
  password character varying(255),
  CONSTRAINT user_account_pkey PRIMARY KEY (id)
);

CREATE TABLE public.authority
(
  id integer NOT NULL,
  name character varying(20) NOT NULL,
  CONSTRAINT authority_pkey PRIMARY KEY (id)
);

CREATE TABLE public.user_authority
(
  id_user_account integer NOT NULL,
  authority integer NOT NULL,
  CONSTRAINT user_authority_pkey PRIMARY KEY (id_user_account, authority),
  CONSTRAINT fk3odsunh03vw9546adkrvdfp79 FOREIGN KEY (authority)
      REFERENCES public.authority (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fkdixjtddqn2vgnmh2oh9suakfh FOREIGN KEY (id_user_account)
      REFERENCES public.user_account (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);