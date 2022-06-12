import React from 'react';
import HeaderComponent from '../Header/Header.component';

import './styles.css';

const ContainerComponent = (props) => {
  const { children } = props;

  return (
    <div className="container-layout">
      <HeaderComponent />
      {children}
    </div>
  );
};

export default ContainerComponent;
