module.exports = function(grunt) {
    // Project configuration.
    grunt.initConfig({
        pkg : grunt.file.readJSON('package.json'),
        jshint : {
            foo : {
                src : 'src/main/webapp/modules/**/*.js',
            },
        },
        concat : {
            jsconcat : {
                src : [ 'src/main/webapp/app.js', // 'src/main/webapp/modules/common/crud_service.js',
                // 'src/main/webapp/modules/common/config.js',
                // 'src/main/webapp/modules/administracion/administracion_service.js',
                // 'src/main/webapp/modules/administracion/administracion_controller.js',
                // 'src/main/webapp/modules/facturacion/facturacion_service.js',
                // 'src/main/webapp/modules/facturacion/facturacion_controller.js',
                // 'src/main/webapp/modules/metamodelo/metamodelo_service.js',
                // 'src/main/webapp/modules/metamodelo/metamodelo_controller.js',
                // 'src/main/webapp/modules/proceso/proceso_service.js',
                // 'src/main/webapp/modules/proceso/proceso_controller.js',
                // 'src/main/webapp/modules/seguridad/seguridad_service.js',
                // 'src/main/webapp/modules/seguridad/seguridad_controller.js',
                // 'src/main/webapp/modules/entidad/item/item_service.js',
                // 'src/main/webapp/modules/entidad/item/item_controller.js',
                // 'src/main/webapp/modules/entidad/maestro/maestro_service.js',
                // 'src/main/webapp/modules/entidad/maestro/maestro_controller.js',
                // 'src/main/webapp/modules/entidad/servicio/servicio_service.js',
                // 'src/main/webapp/modules/entidad/servicio/servicio_controller.js',
                // 'src/main/webapp/modules/entidad/estadistica/estadistica_service.js',
                // 'src/main/webapp/modules/entidad/estadistica/estadistica_controller.js',

                ],
                dest : 'src/main/webapp/<%= pkg.name %>.js',
            },
            extjslibconcat : {
                src : [ '//ajax.googleapis.com/ajax/libs/angularjs/1.5.3/angular.min.js',
                        '//ajax.googleapis.com/ajax/libs/angularjs/1.5.3/angular-route.min.js', ],
                dest : 'src/main/webapp/argo_lib.js',
            }
        },
        uglify : {
            options : {
                banner : '/*! <%= pkg.name %> <%= grunt.template.today("yyyy-mm-dd") %> */\n'
            },
            build : {
                src : 'src/main/webapp/<%= pkg.name %>.js',
                dest : 'src/main/webapp/<%= pkg.name %>.min.js',
            }
        }
    });

    grunt.loadNpmTasks('grunt-contrib-uglify');
    grunt.loadNpmTasks('grunt-contrib-jshint');
    grunt.loadNpmTasks('grunt-contrib-concat');

    // Default task(s).
    grunt.registerTask('default', [ /* 'jshint', */'concat', 'uglify' ]);
};