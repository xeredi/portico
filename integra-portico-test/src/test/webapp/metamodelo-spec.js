describe('Metamodelo', function() {
    it('Tipos de Servicio', function() {
        browser.get("#/metamodelo/tpsr/grid");

        // element(by.model('todoText')).sendKeys('write a protractor test');
        // element(by.css('[value="add"]')).click();

        var entiList = element.all(by.repeater("enti in vm.entiList.list"));

        expect(entiList.count()).toEqual(9);

        var enti = entiList.get(0);

        console.log("entiList: ");
        console.log(entiList);
        console.log("enti: ");
        console.log(enti);

        browser.get("#/metamodelo/tpsr/detail/" + enti.getAttribute("id"));
    });
});