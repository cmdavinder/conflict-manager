(function($) {
    $("#addProjectForm").on('submit', function(e){
        e.preventDefault();
        var data = $(this).serializeFormJSON();
        api = hybind(APPLICATION_CONTEXT);
        projects = [];
        api.$bind("projects", projects);
        projects.$load().then(function(){
            return projects.$create(data);
        });
    });
}(jQuery));