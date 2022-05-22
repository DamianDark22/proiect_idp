import React from 'react';
import { Container, CenterLayout, MenuComponent } from '../../components';
import CreatePostForm from './CreatePost.form';

const CreatePostView = () => {
  return (
    <Container>
      <MenuComponent />
      <CenterLayout>
        <CreatePostForm />
      </CenterLayout>
    </Container>
  );
};

export default CreatePostView;
