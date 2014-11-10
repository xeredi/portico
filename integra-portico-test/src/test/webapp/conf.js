exports.config = {
    seleniumAddress : 'http://localhost:4444/wd/hub',
    capabilities : {
        'browserName' : 'chrome',
        "chromeOptions" : {
            binary : 'D:/proyectos/tools/portable/PortableApps/GoogleChromePortable/GoogleChromePortable.exe',
            args : [ '--test-type' ],
            extensions : [],
        }
    },
    specs : [ "*-spec.js" ],
    baseUrl : "http://localhost:8080/web/"
}
