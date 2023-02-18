create table public.hibernate_sequences
(
    sequence_name varchar(255) not null
        primary key,
    next_val      bigint
);

alter table public.hibernate_sequences
    owner to root;

create table public.bubble
(
    id     bigserial
        primary key,
    result varchar(255)
);

alter table public.bubble
    owner to root;

create table public.element
(
    id        bigserial
        primary key,
    result    integer,
    bubble_id bigint
        constraint fkt9i0hskgjmklvt0v6u5n3gvt
            references public.bubble
);

alter table public.element
    owner to root;
