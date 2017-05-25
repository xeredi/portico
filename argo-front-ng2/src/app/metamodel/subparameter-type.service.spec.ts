import { TestBed, inject } from '@angular/core/testing';

import { SubparameterTypeService } from './subparameter-type.service';

describe('SubparameterTypeService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [SubparameterTypeService]
    });
  });

  it('should be created', inject([SubparameterTypeService], (service: SubparameterTypeService) => {
    expect(service).toBeTruthy();
  }));
});
