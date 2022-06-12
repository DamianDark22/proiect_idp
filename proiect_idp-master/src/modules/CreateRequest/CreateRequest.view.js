import React from 'react';
import { Container, CenterLayout, MenuComponent } from '../../components';
import CreateRequestForm from './CreateRequest.form';

const CreateRequestView = () => {
  return (
    <Container>
      <MenuComponent />
      <CenterLayout>
        <CreateRequestForm />
      </CenterLayout>
    </Container>
  );
};

export default CreateRequestView;
