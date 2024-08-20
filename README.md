# Project Name: HRM and Payroll Platform

# First part: Payslips



## Docker resources

Postgres DB:

```
docker run --name postgresDb -e POSTGRES_PASSWORD=admin -p5432:5432 -d postgres:alpine3.19
```

For connection to DB via IDE use next credentials:

host - `localhost`

port - `5432`

database - `postgres`

URL - `jdbc:postgresql://localhost:5432/postgres`

username - `admin`

password - `admin`
