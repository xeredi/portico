exports.config = {
    seleniumAddress : 'http://localhost:4444/wd/hub',
    capabilities : {
        'browserName' : 'chrome',
        "chromeOptions" : {
            binary : 'G:/tools/portableapps/PortableApps/GoogleChromePortable/GoogleChromePortable.exe',
            args : [ '--test-type' ],
            extensions : [],
        }
    },
    specs : [ "*-spec.js" ],
    baseUrl : "http://xeredi.ddns.net/portico/"
}
