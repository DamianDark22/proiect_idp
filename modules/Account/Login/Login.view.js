import React, { useCallback, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import { useForm } from 'react-hook-form';
import {
  ButtonComponent,
  TextComponent,
  InputComponent,
  SpacerComponent,
  FormProviderComponent
} from '../../../components';
import { useAuth0 } from '@auth0/auth0-react';
import '../styles.css';

const LoginView = (props) => {
  const base = 'http://localhost:8080/';
  const { handleSelectCreateAccount } = props;
  const navigate = useNavigate();
  const methods = useForm({
    defaultValues: {
      username: 'testtest',
      password: 'test'
    }
  });
  const { handleSubmit } = methods;
  const { isLoading, error, loginWithRedirect, isAuthenticated } = useAuth0();
  async function myFunction() {
    await loginWithRedirect();
  }
  const handleLogin = useCallback((data) => {
    console.log(data);
    myFunction();
    // to do - check user with server and login
  }, []);
  useEffect(() => {
    if (isAuthenticated) {
      navigate('/posts');
    }
  }, []);
  return (
    <div className="container">
      <TextComponent styleName="container-title">Bun venit!</TextComponent>
      <div className="container-buttons">
        <ButtonComponent title="Login" handlePress={handleSubmit(handleLogin)} />
        <SpacerComponent horizontally />
      </div>
    </div>
  );
};

export default LoginView;
