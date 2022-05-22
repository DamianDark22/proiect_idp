import React from 'react';
import { useToggle } from '../../core/hooks/useToggle';
import LoginView from './Login/Login.view';
import RegisterView from './Register/Register.view';

import './styles.css';

const AccountView = () => {
  const [showRegister, toggleRegister] = useToggle();

  return (
    <div className="account">
      {!showRegister ? (
        <LoginView handleSelectCreateAccount={toggleRegister} />
      ) : (
        <RegisterView handleSelectLogin={toggleRegister} />
      )}
    </div>
  );
};

export default AccountView;
