import React from 'react';

import { FormProvider as RHProvider } from 'react-hook-form';

const FormProviderComponent = (props) => {
  const { methods, children } = props;

  return <RHProvider {...methods}>{children}</RHProvider>;
};

export default FormProviderComponent;
