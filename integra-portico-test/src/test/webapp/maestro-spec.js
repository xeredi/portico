var baseUrl = "http://xeredi.ddns.net/portico/index.html#";

describe('Maestro', function() {
    it('Tipos de Maestro', function() {
        browser.get(baseUrl + "/maestro");

        var tpprList = element.all(by.repeater("tppr in vm.tpprList"));

        expect(tpprList.count()).toBeGreaterThan(0);

        // Buques
        browser.get(baseUrl + "/maestro/prmt/grid/20005");
    });
});
