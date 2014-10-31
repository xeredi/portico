var baseUrl = "http://xeredi.ddns.net/portico/index.html#";

describe('Metamodelo', function() {
    it('Tipos de Servicio', function() {
        browser.get(baseUrl + "/metamodelo/tpsr/grid");

        // element(by.model('todoText')).sendKeys('write a protractor test');
        // element(by.css('[value="add"]')).click();

        var entiList = element.all(by.repeater("enti in vm.entiList.list"));

        expect(entiList.count()).toEqual(9);
        // expect(entiList.get(2).getText()).toEqual('write a protractor test');

        // browser.get(baseUrl + "/metamodelo/tpsr/detail/" + entiList.get(0).id);
    });
});