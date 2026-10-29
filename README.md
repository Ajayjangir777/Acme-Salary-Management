# ACME Salary Management

Full-stack assessment starter: Spring Boot + H2 Database (ACTIVE - for local testing)  PostgreSQL + React/Vite + Material UI.

## Run
1. `docker compose up -d db`
2. `cd backend && mvn spring-boot:run`
3. In another terminal: `cd frontend && npm install && npm run dev`
4. Open `http://localhost:5173`. API docs: `http://localhost:8080/swagger-ui.html`.

Java 17+, Maven 3.9+, Node 20+ and Docker are recommended. The backend seeds 10,000 fictional employees on an empty database. Never use real salary data until authentication, authorization, auditing and security review are implemented.

See `docs/` for assessment artifacts. Deployment and demo recording still need to be completed and verified in your own accounts.
