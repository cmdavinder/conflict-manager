var GENERATE_CONFLICTS_URL = "/generateConflicts"


function drawConflictTable(conflicts) {

    $("#conflictsTable").DataTable({
        "aoColumns": [{
            "sTitle": "CI Name",
            "sType": "string",
            sWidth: "10%",
            "mData": "ciName"
        }, {
            "sTitle": "Environment Name",
            "sType": "string",
            sWidth: "20%",
            "mData": "environmentName"
        }, {
            "sTitle": "Project Name",
            "sType": "string",
            sWidth: "20%",
            "mData": "projectName"
        }, {
            "sTitle": "Release Cycle Name",
            "sType": "string",
            sWidth: "20%",
            "mData": "releaseCycleName"
        }, {
            "sTitle": "Start Date",
            "sType": "string",
            sWidth: "15%",
            "mData": "releaseCycleStartDate"
        }, {
            "sTitle": "End Date",
            "sType": "string",
            sWidth: "15%",
            "mData": "releaseCycleEndDate"
        }],
        "aaData": conflicts
    });
}

function loadConflictsTable() {
    var filters = {};

    var projectId = $("#projectSelectorMcr").find(":selected").data("project").id;
    var releaseCycleId = $("#releaseCycleSelector").find(":selected").data("releaseCycle").id;;
    var ciId = $("#ciSelector").find(":selected").data("configurationItem").id;;

    filters["projectId"] = projectId;
    filters["releaseCycleId"] = releaseCycleId;
    filters["ciId"] = ciId;


    $.ajax({
        url: APPLICATION_CONTEXT + GENERATE_CONFLICTS_URL,
        data: JSON.stringify(filters),
        dataType: "json",
        type: "POST",
        error: function(error) {
            console.log("Failed to load : " + error);
        },
        success: function(conflicts) {
            drawConflictTable(conflicts);
        }
    });
}

$(document).ready(function() {
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
            $('#projectSelectorMcr').append(option);
        });
    });

    configurationItems = [];
    api.$bind("configurationItems", configurationItems);
    configurationItems.$load().then(function() {
        $.each(configurationItems, function(i, configurationItem) {
            var option = $("<option>");
            option.val(configurationItem.name);
            option.text(configurationItem.name);
            option.attr("name", configurationItem.name);
            option.data("configurationItem", configurationItem);
            $('#ciSelector').append(option);
        });
    });




    $("#projectSelectorMcr").on('change', function(e) {
        var optionSelected = $("option:selected", this);
        var project = optionSelected.data("project");
        api = hybind(APPLICATION_CONTEXT);
        releaseCycles = [];
        api.$bind("releaseCycles/search/findByProjectId?projectId=" + project.id, releaseCycles);
        releaseCycles.$load().then(function() {
            var releaseCycleSelector = $('#releaseCycleSelector');
            releaseCycleSelector.find('option').remove().end();
            $.each(releaseCycles, function(i, releaseCycle) {
                var option = $("<option>");
                option.val(releaseCycle.name);
                option.text(releaseCycle.name);
                option.attr("releaseCycle", releaseCycle);
                option.data("releaseCycle", releaseCycle);
                releaseCycleSelector.append(option);
            });
        });
    });
});
