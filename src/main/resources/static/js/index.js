var postForm = function (url, data) {
    var $form = $('<form/>', {'action': url, 'method': 'post'});
    for (var key in data) {
        $form.append($('<input/>', {'type': 'hidden', 'name': key, 'value': data[key]}));
    }
    $form.appendTo(document.body);
    $form.submit();
};

$(document).ready(function () {
    $("#search").click(function (e) {
        e.preventDefault();
        const roleEls = $('.roles');
        const numberEls = $('.numbers');
        const searchEl = $('#search-role')[0];
        const employeesEls = $('.selected-employees');
        const employeeRolesEls = $('.selected-employees-roles');
        const roles = [];
        const numbers = [];
        const employees = [];
        const empRoles = [];
        for (var i = 0; i < roleEls.length; i++) {
            roles.push(roleEls[i].value);
        }
        for (var i = 0; i < roleEls.length; i++) {
            numbers.push(numberEls[i].valueAsNumber);
        }
        for (var i = 0; i < employeesEls.length; i++) {
            employees.push(employeesEls[i].valueAsNumber);
            empRoles.push(employeeRolesEls[i].value);
        }
        var data = {
            'role': searchEl.value,
            'roles': roles,
            'numbers': numbers,
            'employeeId': 0,
            'selectedEmployees': employees,
            'selectedEmployeeRoles': empRoles,
        };
        postForm('/index', data);
    });

    $(".details").each(function (i, t) {
        const id = parseInt(this.querySelector("div").innerText);
        $(this).click(function (e) {
            e.preventDefault();
            const roleEls = $('.roles');
            const numberEls = $('.numbers');
            const searchEl = $('#search-role')[0];
            const employeesEls = $('.selected-employees');
            const employeeRolesEls = $('.selected-employees-roles');
            const roles = [];
            const numbers = [];
            const employees = [];
            const empRoles = [];
            for (var i = 0; i < roleEls.length; i++) {
                roles.push(roleEls[i].value);
            }
            for (var i = 0; i < numberEls.length; i++) {
                numbers.push(numberEls[i].valueAsNumber);
            }
            for (var i = 0; i < employeesEls.length; i++) {
                employees.push(employeesEls[i].valueAsNumber);
                empRoles.push(employeeRolesEls[i].value);
            }

            var data = {
                'role': searchEl.value,
                'roles': roles,
                'numbers': numbers,
                'employeeId': id,
                'selectedEmployees': employees,
                'selectedEmployeeRoles': empRoles,
            };
            postForm('/index', data);
        });
    });

    $("#add-employee").click(function (e) {
        e.preventDefault();
        const roleEls = $('.roles');
        const numberEls = $('.numbers');
        const searchEl = $('#search-role')[0];
        const employeesEls = $('.selected-employees');
        const employeeRolesEls = $('.selected-employees-roles');
        const checkEls = $('.employee-checkbox:checked');
        const roles = [];
        const numbers = [];
        const employees = [];
        const empRoles = [];
        for (var i = 0; i < roleEls.length; i++) {
            roles.push(roleEls[i].value);
        }
        for (var i = 0; i < numberEls.length; i++) {
            numbers.push(numberEls[i].valueAsNumber);
        }
        for (var i = 0; i < checkEls.length; i++) {
            employees.push(parseInt(checkEls[i].value));
            empRoles.push(searchEl.value);
        }
        for (var i = 0; i < employeesEls.length; i++) {
            employees.push(employeesEls[i].valueAsNumber);
            empRoles.push(employeeRolesEls[i].value);
        }

        var data = {
            'role': searchEl.value,
            'roles': roles,
            'numbers': numbers,
            'employeeId': 0,
            'selectedEmployees': employees,
            'selectedEmployeeRoles': empRoles,
        };
        postForm('/index', data);
    });


    $("#create-project").click(function (e) {
        e.preventDefault();
        const employeesEls = $('.selected-employees');
        const employeeRolesEls = $('.selected-employees-roles');
        const employees = [];
        const empRoles = [];
        for (var i = 0; i < employeesEls.length; i++) {
            employees.push(employeesEls[i].valueAsNumber);
            empRoles.push(employeeRolesEls[i].value);
        }

        var m = moment;
        var data = {
            'projectName': 'new project',
            'startDate': m(new Date()).format('YYYY-MM-DD'),
            'endDate': m(new Date()).format('YYYY-MM-DD'),
            'employees': employees,
            'roles': empRoles,
        };
        postForm('/project-info', data);
    });
});