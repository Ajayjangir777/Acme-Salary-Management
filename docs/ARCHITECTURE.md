# Architecture

React SPA -> Spring Boot REST controllers -> service layer -> Spring Data JPA -> PostgreSQL.

Employee records contain employeeCode, first/last name, email, country, department, job title, salary amount, currency code and timestamps. Listing is server-side paginated so the browser does not load 10,000 records at once. `BigDecimal` stores salaries. Aggregations are grouped by currency to avoid misleading cross-currency totals.

A production system additionally needs authentication/authorization, audit logging, schema migrations, monitoring, backups, secret management and security review.
