ALTER TABLE public.student ADD username varchar(64) NOT null;
ALTER TABLE public.student ADD "password" varchar(128) NOT null;
ALTER TABLE public.student ADD email varchar(64) NOT null;
ALTER TABLE public.student ADD contact_number varchar(20) NULL;
ALTER TABLE public.student ADD nickname varchar(64) NOT null;


ALTER TABLE public.teacher ADD username varchar(64) NOT null;
ALTER TABLE public.teacher ADD "password" varchar(128) NOT null;
ALTER TABLE public.teacher ADD email varchar(64) NOT null;
ALTER TABLE public.teacher ADD contact_number varchar(20) NULL;
ALTER TABLE public.teacher ADD nickname varchar(64) NOT null;

ALTER TABLE public.student ALTER COLUMN nickname DROP NOT NULL;
ALTER TABLE public.teacher ALTER COLUMN nickname DROP NOT NULL;
