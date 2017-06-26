(function($) {
    $("#addProjectForm").on('submit', function(e){
        e.preventDefault();
        var data = $(this).serializeFormJSON();
        console.log(data);
        api = hybind("/rmweb");
        projects = [];
        api.$bind("projects", projects);
        projects.$load().then(function(){
            return projects.$create(data);
        });
    });
}(jQuery));