import React from 'react';

import './styles.css';

const CenterLayoutComponent = (props) => {
  const { children } = props;

  return <div className="center-layout">{children}</div>;
};

export default CenterLayoutComponent;
