import React from 'react';
import { TextComponent, Container, CenterLayout, MenuComponent } from '../../components';

const PostsView = () => {
  return (
    <Container>
      <MenuComponent />
      <CenterLayout>
        <TextComponent>Vizualizare postari</TextComponent>
      </CenterLayout>
    </Container>
  );
};

export default PostsView;
