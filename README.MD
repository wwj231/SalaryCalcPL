SpringBoot Application for calculating components composing gross salary for employee contract in Poland, as for year 2021.
Provides REST API for service. 

Endpoints :

POST /salarycalcpl/breakdown-salary/

accepts json in form of (month, gross salary) map and three additional fields that influences calculation.
Check example_salary_input.json

POST /salarycalcpl/post-tax-contribution-settings 

Enables to change tax and contribution settings used during calculation. 

GET /salarycalcpl/get-tax-contribution-settings/

Displays tax and contribution settings used during calculation. 