function drawReleaseCyclesTable(releaseCycles){
$("#manageReleaseCycleTable").DataTable({
    "aoColumns": [
                    {"sTitle": "Project Name", "sType":"string", sWidth:"20%", "mData":"project.projectName"},
                    {"sTitle": "Release Cycle Name", "sType":"string", sWidth:"20%", "mData":"name"},
                    {"sTitle": "Environment", "sType":"string", sWidth:"20%", "mData":"environment.name"},
                    {"sTitle": "Start Date", "sType":"string", sWidth:"20%", "mData":"startDate"},
                    {"sTitle": "End Date", "sType":"string", sWidth:"20%", "mData":"endDate"}
                    ],
    "aaData":releaseCycles
    });
}

function loadReleaseCycles(){
    api = hybind(APPLICATION_CONTEXT);
    releaseCycles = [];
    api.$bind("releaseCycles", releaseCycles);
    releaseCycles.$load().then(function(){
        drawReleaseCyclesTable(releaseCycles);
    });
}

 $('document').ready(function () {
     $("#createReleaseCycleBtn").on("click", function(){
          $("#addReleaseCycleContainer").modal('show');
          api = hybind(APPLICATION_CONTEXT);
            projects = [];
            api.$bind("projects", projects);
            projects.$load().then(function(){
                    $.each(projects, function (i, project) {
                        $('#projectSelector').append($('<option>', {
                            value: project.projectName,
                            text : project.projectName,
                            id:project.id,
                            name:project.id
                        }));
                    });
            });

                environments =[];
                api.$bind("environments",environments);
                environments.$load().then(function(){
                            $.each(environments, function (i, environment) {
                            $('#environmentSelector').append($('<option>', {
                                value: environment.name,
                                text : environment.name,
                                id:environment.id,
                                name:environment.id
                            }));
                        });
                });




 });

            $("#createReleaseCycle").on("click",function(e){
                e.preventDefault();
                $("#addReleaseCycleContainer").modal('hide');
                var data = $("#addReleaseCycleForm").serializeFormJSON();
                var projectId = $('#projectSelector').find(":selected").attr("name");
                var environmentId = $('#environmentSelector').find(":selected").attr("name");

                 var links = {};
                 links["project"] =APPLICATION_CONTEXT+"/projects/"+projectId;
                 links["environment"]  = APPLICATION_CONTEXT+"/environments/"+environmentId;

                  data["_links"] = links;
                 //var json = JSON.stringify(data)
                api = hybind(APPLICATION_CONTEXT);
                releaseCycles = [];
                api.$bind("releaseCycles", releaseCycles);
                projects.$create(data);
                });

                $(".close").on("click", function(){
                   $("#addReleaseCycleContainer").modal('hide');
                });
});


