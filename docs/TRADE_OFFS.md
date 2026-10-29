# Trade-offs

- Modular monolith over microservices: simpler to build and operate at this scope.
- PostgreSQL over SQLite: closer to multi-user production relational usage, but requires a database service.
- Server-side pagination: slightly more API complexity but bounded response sizes.
- BigDecimal for monetary precision.
- Currency-aware aggregates: no cross-currency total without an explicit conversion policy.
- Prototype omits auth/audit to keep demo setup small; this is not safe for real salary data.
