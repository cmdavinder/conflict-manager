function drawReleaseCyclesTable(releaseCycles) {
    $("#manageReleaseCycleTable").DataTable({
        "aoColumns": [{
            "sTitle": "Project Name",
            "sType": "string",
            sWidth: "20%",
            "mData": "project.projectName"
        }, {
            "sTitle": "Release Cycle Name",
            "sType": "string",
            sWidth: "20%",
            "mData": "name"
        }, {
            "sTitle": "Environment",
            "sType": "string",
            sWidth: "20%",
            "mData": "environment.name"
        }, {
            "sTitle": "Start Date",
            "sType": "string",
            sWidth: "20%",
            "mData": "startDate"
        }, {
            "sTitle": "End Date",
            "sType": "string",
            sWidth: "20%",
            "mData": "endDate"
        }],
        "aaData": releaseCycles
    });
}

function loadReleaseCycles() {
    api = hybind(APPLICATION_CONTEXT);
    releaseCycles = [];
    api.$bind("releaseCycles", releaseCycles);
    releaseCycles.$load().then(function() {
        drawReleaseCyclesTable(releaseCycles);
    });
}

$('document').ready(function() {
    $("#createReleaseCycleBtn").on("click", function() {
        $("#addReleaseCycleContainer").modal('show');
        api = hybind(APPLICATION_CONTEXT);
        projects = [];
        api.$bind("projects", projects);
        projects.$load().then(function() {
            $.each(projects, function(i, project) {
                var option = $("<option>");
                option.val(project.projectName);
                option.text(project.projectName);
                option.attr("name", project.projectName);
                option.data("project", project);
                $('#projectSelectorMrc').append(option);
            });
        });

        environments = [];
        api.$bind("environments", environments);
        environments.$load().then(function() {
            $.each(environments, function(i, environment) {
                var option = $("<option>");
                option.val(environment.name);
                option.text(environment.name);
                option.attr("name", environment.name);
                option.data("environment", environment);
                $('#environmentSelector').append(option);
            });
        });
    });
    $("#createReleaseCycle").on("click", function(e) {
        e.preventDefault();
        $("#addReleaseCycleContainer").modal('hide');
        var data = $("#addReleaseCycleForm").serializeFormJSON();
        var project = $('#projectSelectorMrc').find(":selected").data("project");
        var environment = $('#environmentSelector').find(":selected").data("environment")
        data["project"] = project;
        data["environment"] = environment;
        api = hybind(APPLICATION_CONTEXT);
        releaseCycles = [];
        api.$bind("releaseCycles", releaseCycles);
        releaseCycles.$create(data);
    });

    $(".close").on("click", function() {
        $("#addReleaseCycleContainer").modal('hide');
    });
});
