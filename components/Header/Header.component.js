import React from 'react';
import logo2 from '../../assets/images/logo2.png';

import './styles.css';

const HeaderComponent = () => {
  return (
    <div className="header">
      <div className="header-top" />
      <div className="spacer">
        <img src={logo2} className="icon" />
      </div>
      <div className="header-bottom" />
    </div>
  );
};

export default HeaderComponent;
