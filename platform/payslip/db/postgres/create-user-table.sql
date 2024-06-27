CREATE TABLE IF NOT EXISTS public.payslips
(
    id varchar NOT NULL,
    payslip_name VARCHAR(255) NOT NULL,
    period_mounth  DATE,
    employee_id VARCHAR(255) NOT NULL,
    CONSTRAINT payslip_pk PRIMARY KEY (id),
    CONSTRAINT payslip_empl_fk FOREIGN KEY (employee_id) REFERENCES public.employees (id)
    );