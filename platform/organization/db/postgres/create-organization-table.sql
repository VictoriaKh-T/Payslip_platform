-- organization table

CREATE TABLE IF NOT EXISTS public.organizations
(
                               id varchar NOT NULL,
                               name VARCHAR(255) NOT NULL,
                               address VARCHAR(255) NOT NULL,
                               kod_organization VARCHAR(255) NOTNULL,
                               contact_information VARCHAR(255),
                               description TEXT,
    CONSTRAINT organization_pk PRIMARY KEY (id)
);