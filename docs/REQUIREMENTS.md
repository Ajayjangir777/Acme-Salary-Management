# ACME Salary Management — Requirements

## Goal and user
Help ACME's HR Manager replace spreadsheet-based salary administration for 10,000 employees across multiple countries and answer basic compensation questions.

## MVP scope
- Paginated employee list, search by name/employee ID, filter by country and department.
- Create and update employee salary records with validation.
- Dashboard with employee count and salary totals/averages grouped by currency, country and department.
- Deterministic seed script for 10,000 fictional employees.
- REST API documentation, meaningful automated tests, setup guide and demo instructions.

## Deliberately excluded
- Payroll execution, bank transfers, taxes and statutory deductions: jurisdiction-specific and beyond salary record management.
- Employee self-service and external HR integrations: not needed for the first HR Manager workflow.
- Currency conversion: no exchange-rate source or valuation date was specified; unlike currencies must not be added together.
- Complex approval workflows: defer until core usage is validated.
- Production authentication, authorization and audit trail: must be added before real salary data is used.

## Acceptance criteria
Fresh setup works; 10,000 sample records seed on an empty database; UI supports employee search/filter/create/update; analytics do not mix currencies; invalid requests return useful errors; tests and engineering artifacts are committed; deployment and demo are verified before submission.

## Assumptions
Salary is annual gross salary in each employee's recorded currency. Data is fictional. Email and employee code are unique.
