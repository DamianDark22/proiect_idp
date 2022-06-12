import React from 'react';
import classNames from 'classnames';

import './styles.css';

const SpacerComponent = (props) => {
  const { horizontally = false } = props;

  const spacerStyle = classNames({
    'spacer-vertically': !horizontally,
    'spacer-horizontally': horizontally
  });

  return <div className={spacerStyle} />;
};

export default SpacerComponent;
