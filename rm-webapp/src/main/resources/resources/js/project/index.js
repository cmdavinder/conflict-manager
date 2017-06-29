function drawProjectsTable(projects){
$("#manageProjectsTable").DataTable({
    "aoColumns": [
                    {"sTitle": "Project Name", "sType":"string", sWidth:"50%", "mData":"projectName"},
                    {"sTitle": "Start Name", "sType":"string", sWidth:"25%", "mData":"startDate"},
                    {"sTitle": "End Date", "sType":"string", sWidth:"25%", "mData":"endDate"}
                    ],
    "aaData":projects
    });
}

function loadProjects(){
    api = hybind(APPLICATION_CONTEXT);
    projects = [];
    api.$bind("projects", projects);
    projects.$load().then(function(){
        drawProjectsTable(projects);
    });
}
 $('document').ready(function () {
 $("#addProjectBtn").on("click", function(){
      $("#addProjectContainer").modal('show');
 });

            $("#modalCloseBtn").on("click", function(){
               $("#addProjectContainer").modal('hide');
            });


            $("#createProjectBtn").on("click",function(e){
                e.preventDefault();
                $("#addProjectContainer").modal('hide');
                var data = $("#addProjectForm").serializeFormJSON();
                api = hybind(APPLICATION_CONTEXT);
                projects = [];
                api.$bind("projects", projects);
                projects.$create(data);
                });

});






