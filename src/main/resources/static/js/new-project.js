var postForm = function (url, data) {
    var $form = $('<form/>', {'action': url, 'method': 'post'});
    for (var key in data) {
        $form.append($('<input/>', {'type': 'hidden', 'name': key, 'value': data[key]}));
    }
    $form.appendTo(document.body);
    $form.submit();
};

$(document).ready(function () {
    var content =
        '<div style="padding-bottom:10px; height:40px;">' +
        '<div class="form-group">' +
        '<span class="col-sm-7">' +
        '<select class="form-control roles">' +
        '<option value="Admin">Admin</option>' +
        '<option value="Member">Member</option>' +
        '<option value="Dev">Dev</option>' +
        '<option value="DevL">DevL</option>' +
        '<option value="QA">QA</option>' +
        '<option value="QAL">QAL</option>' +
        '<option value="BSE/VN">BSE/VN</option>' +
        '<option value="BSE/JP">BSE/JP</option>' +
        '<option value="Comter">Comter</option>' +
        '<option value="JP Supporter">JP Supporter</option>' +
        '<option value="Sub BSE">Sub BSE</option>' +
        '<option value="PM">PM</option>' +
        '<option value="General Director">General Director</option>' +
        '<option value="Department Manager">Department Manager</option>' +
        '<option value="Division Manager">Division Manager</option>' +
        '<option value="Team Leader">Team Leader</option>' +
        '</select>' +
        '</span>' +
        '<span class="col-sm-4">' +
        '<input type="number" class="form-control numbers"/>' +
        '</span>' +
        '</div>' +
        '</div>';

    $("#btn_add").click(function () {
        $("#list_result").append(content);
    });

    $("#search").click(function (e) {
        e.preventDefault();
        const roleEls = $('.roles');
        const numberEls = $('.numbers');
        const roles = [];
        const numbers = [];
        for (var i = 0; i < roleEls.length; i++) {
            roles.push(roleEls[i].value);
        }
        for (var i = 0; i < roleEls.length; i++) {
            numbers.push(numberEls[i].valueAsNumber);
        }

        var data = {
            'role': roles[0],
            'roles': roles,
            'numbers': numbers,
            'employeeId': 0,
        };
        postForm('/index', data);
    });
});