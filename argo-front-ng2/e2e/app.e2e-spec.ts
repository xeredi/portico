import { ArgoFrontNg2Page } from './app.po';

describe('argo-front-ng2 App', () => {
  let page: ArgoFrontNg2Page;

  beforeEach(() => {
    page = new ArgoFrontNg2Page();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
