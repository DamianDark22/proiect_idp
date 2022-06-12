import React, { useCallback } from 'react';
import { useNavigate } from 'react-router-dom';
import { useForm } from 'react-hook-form';
import {
  ButtonComponent,
  TextComponent,
  InputComponent,
  SpacerComponent,
  FormProviderComponent
} from '../../../components';

import '../styles.css';

const LoginView = (props) => {
  const { handleSelectCreateAccount } = props;
  const navigate = useNavigate();

  const methods = useForm({
    defaultValues: {
      username: 'testtest',
      password: 'test'
    }
  });
  const { handleSubmit } = methods;

  const handleLogin = useCallback((data) => {
    console.log(data);
    navigate('/posts');
    // to do - check user with server and login
  }, []);

  return (
    <div className="container">
      <TextComponent styleName="container-title">AUTENTIFICARE</TextComponent>
      <div>
        <FormProviderComponent methods={methods}>
          <InputComponent label="Utilizator" name="username" type="email" required />
          <InputComponent label="Parola" name="password" type="password" required />
        </FormProviderComponent>
      </div>
      <div className="container-buttons">
        <ButtonComponent title="Autentificare" handlePress={handleSubmit(handleLogin)} />
        <SpacerComponent horizontally />
        <ButtonComponent title="Creare cont nou" handlePress={handleSelectCreateAccount} />
      </div>
    </div>
  );
};

export default LoginView;
