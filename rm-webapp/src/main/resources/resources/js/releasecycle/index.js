function drawProjectsTable(projects){
$("#manageReleaseCycleTable").DataTable({
    "aoColumns": [
                    {"sTitle": "Project Name", "sType":"string", sWidth:"20%", "mData":"projectName"},
                    {"sTitle": "Release Cycle Name", "sType":"string", sWidth:"20%", "mData":"startDate"},
                    {"sTitle": "Environment", "sType":"string", sWidth:"20%", "mData":"endDate"},
                    {"sTitle": "Start Date", "sType":"string", sWidth:"20%", "mData":"startDate"},
                    {"sTitle": "End Date", "sType":"string", sWidth:"20%", "mData":"endDate"}

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
