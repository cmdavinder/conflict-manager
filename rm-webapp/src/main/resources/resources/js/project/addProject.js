(function($) {
    $("#addProjectForm").on('submit', function(e){
        e.preventDefault();
        var data = $(this).serializeFormJSON();
        console.log(data);
        api = hybind("/cmweb");
        projects = [];
        api.$bind("projects", projects);
        projects.$load().then(function(){
            return projects.$create(data);
        });
    });
}(jQuery));