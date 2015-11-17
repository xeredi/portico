package xeredi.integra.http.page;

import java.util.Map;

import org.fluentlenium.core.FluentPage;

public abstract class BaseFluentPage extends FluentPage {

    public void fillSelect(final String css, final String value) {
        fillSelect(css).withValue("string:" + value);
    }

    public void fillSelect(final String css, final Number value) {
        fillSelect(css).withValue("number:" + value);
    }

    public void fillI18nMap(final Map<String, String> map) {
        for (final String key : map.keySet()) {
            fill("input[ng-model='vm.i18nMap[default_language].text']").with(map.get(key));
        }
    }

    public void search() {
        click("button[data-ng-click='vm.search(1);$hide()']");
    }

    public void openFilter() {
        click("button[data-ng-click=\"vm.filter('lg')\"]");
    }

    public void closeFilter() {
        click("button[data-ng-click='$hide()']");
    }

    public void save() {
        click("button[data-ng-click='vm.save()']").await().atMost(1000);
    }

    public void cancel() {
        click("button[data-ng-click='vm.cancel()']");
    }

    public void remove() {
        click("button[data-ng-click='vm.remove()']");
    }

    public void back() {
        executeScript("history.back();");
    }

}
