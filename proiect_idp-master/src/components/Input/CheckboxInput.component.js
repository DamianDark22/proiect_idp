import React from 'react';
import TextComponent from '../Text/Text.component';

import './styles.css';

const CheckboxInputComponent = (props) => {
  const { children, label } = props;

  return (
    <div className="input-checkbox">
      {children}
      <TextComponent>{label}</TextComponent>
    </div>
  );
};

export default CheckboxInputComponent;
