import classNames from 'classnames';
import React from 'react';

import './styles.css';

const ButtonComponent = (props) => {
  const { title, handlePress, style } = props;

  const buttonStyle = classNames('button', style);

  return (
    <button className={buttonStyle} onClick={handlePress}>
      {title}
    </button>
  );
};

export default ButtonComponent;
