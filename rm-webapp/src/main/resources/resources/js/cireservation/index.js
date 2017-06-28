var GENERATE_CONFLICTS_URL ="/generateConflicts"


function drawConflictTable(conflicts){

    $("#conflictsTable").DataTable({
            "aoColumns": [
                            {"sTitle": "CI Name", "sType":"string", sWidth:"10%", "mData":"ciName"},
                            {"sTitle": "Environment Name", "sType":"string", sWidth:"20%", "mData":"environmentName"},
                            {"sTitle": "Project Name", "sType":"string", sWidth:"20%", "mData":"projectName"},
                            {"sTitle": "Release Cycle Name", "sType":"string", sWidth:"20%", "mData":"releaseCycleName"},
                            {"sTitle": "Start Date", "sType":"string", sWidth:"15%", "mData":"releaseCycleStartDate"},
                            {"sTitle": "End Date", "sType":"string", sWidth:"15%", "mData":"releaseCycleEndDate"}
                            ],
            "aaData":conflicts
            });
}

function loadConflictsTable(){
        $.ajax({
                url: APPLICATION_CONTEXT + GENERATE_CONFLICTS_URL,
                dataType: "json",
                error:function(error) {
                    console.log("Failed to load : "+ error);
                },
                success: function(conflicts) {
                    drawConflictTable(conflicts);
                }
        });
}