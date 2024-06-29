CREATE TABLE IF NOT EXISTS public.employees
(
    id varchar NOT NULL,
    full_name VARCHAR(255) NOT NULL,
    empl_date DATE,
    dis_date DATE,
    user_id VARCHAR,
    CONSTRAINT employee_pk PRIMARY KEY (id),
    CONSTRAINT employee_user_fk FOREIGN KEY (user_id) REFERENCES public.users (id)
    );