$(document).ready(function() {

$.ajax({
		url: "http://localhost:8080/cmweb/generateConflicts",
		dataType: "json",
		error:function(errorStatus) {
			alert("Failed to Load Table")
		},
		success: function(TABLE_DATA) {
		    drawConflictTable(TABLE_DATA);
		}
});
});

function drawConflictTable(TABLE_DATA){
console.log("draw");
$("#conflictsTable").DataTable({
"aoColumns": [
                {"sTitle": "CI Name", "sType":"string", sWidth:"10%", "mData":"ciName"},
                {"sTitle": "Environment Name", "sType":"string", sWidth:"20%", "mData":"environmentName"},
                {"sTitle": "Project Name", "sType":"string", sWidth:"20%", "mData":"projectName"},
                {"sTitle": "Release Cycle Name", "sType":"string", sWidth:"20%", "mData":"releaseCycleName"},
                {"sTitle": "Start Date", "sType":"string", sWidth:"15%", "mData":"releaseCycleStartDate"},
                {"sTitle": "End Date", "sType":"string", sWidth:"15%", "mData":"releaseCycleEndDate"}
                ],
"aaData":TABLE_DATA
});
}