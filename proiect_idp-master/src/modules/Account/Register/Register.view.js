import React, { useCallback } from 'react';
import { useForm } from 'react-hook-form';
import {
  ButtonComponent,
  TextComponent,
  InputComponent,
  SpacerComponent,
  FormProviderComponent
} from '../../../components';

import '../styles.css';

const RegisterView = (props) => {
  const { handleSelectLogin } = props;

  const methods = useForm();
  const { handleSubmit } = methods;

  const handleRegister = useCallback((data) => {
    console.log(data);
    // to do - add user to database
  }, []);

  return (
    <div className="container">
      <TextComponent styleName="container-title">INREGISTRARE UTILIZATOR</TextComponent>
      <div>
        <FormProviderComponent methods={methods}>
          <InputComponent label="Nume" name="firstname" required />
          <InputComponent label="Prenume" name="lastname" required />
          <InputComponent label="Email" name="email" type="email" required />
          <InputComponent label="Numar de telefon" name="phone" required isPhone />
          <InputComponent label="Parola" name="password" type="password" required />
          <InputComponent
            type="checkbox"
            name="isVolunteer"
            value={false}
            label="Vrei sa fii voluntar?"
          />
        </FormProviderComponent>
      </div>
      <div className="container-buttons">
        <ButtonComponent title="Creare cont" handlePress={handleSubmit(handleRegister)} />
        <SpacerComponent horizontally />
        <ButtonComponent title="Am deja un cont" handlePress={handleSelectLogin} />
      </div>
    </div>
  );
};

export default RegisterView;
