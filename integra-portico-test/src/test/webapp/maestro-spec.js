describe('Maestro', function() {
    it('Tipos de Maestro', function() {
        browser.get("#/maestro");

        var tpprList = element.all(by.repeater("tppr in vm.tpprList"));

        expect(tpprList.count()).toBeGreaterThan(0);

        // Buque
        browser.get("#/maestro/prmt/grid/20005");

        // Mercancia
        browser.get("#/maestro/prmt/grid/20049");

        // Organizacion
        browser.get("#/maestro/prmt/grid/20010");
    });
});
