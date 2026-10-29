# Deployment checklist

1. Provision managed PostgreSQL and configure credentials as hosting environment variables.
2. Deploy backend; set DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD, APP_SEED_ENABLED and FRONTEND_ORIGIN.
3. Build/deploy frontend with `VITE_API_BASE_URL` set to the backend public URL plus `/api`.
4. Configure CORS to the exact frontend origin.
5. Verify seed count, CRUD, analytics and API docs.
6. Record demo using `DEMO_SCRIPT.md`.

The source bundle is not itself a deployed application. Deployment must be completed and tested using your own hosting accounts.
