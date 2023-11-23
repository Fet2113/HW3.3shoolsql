// Таблица employee с колонками name, department, salary.
// Вывести максимальную зарплату (salary) и среднюю зарплату (salary)
// по каждому отделу, имеющему больше одного сотрудника.
select avg(salary), max(salary) from employee
group by department having count(*) > 1;


