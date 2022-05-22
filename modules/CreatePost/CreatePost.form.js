import React, { useCallback } from 'react';
import { useForm } from 'react-hook-form';
import {
  ButtonComponent,
  TextComponent,
  InputComponent,
  FormProviderComponent
} from '../../components';

import './styles.css';

const CreatePostForm = () => {
  const methods = useForm();
  const { handleSubmit } = methods;

  const onSubmitData = useCallback((data) => {
    // take data and add it to database
    console.log(data);
  }, []);

  return (
    <div className="form-container">
      <TextComponent styleName="container-title">CREARE ANUNT DONATIE</TextComponent>
      <div className="inputs-container">
        <FormProviderComponent methods={methods}>
          <InputComponent
            label="Titlu anunt"
            name="title"
            required
            containerStyle="container-input"
            inputStyle="form-input"
          />
          <InputComponent
            label="Tip anunt (suma de bani, produse, servicii, etc.)"
            name="postType"
            required
            containerStyle="container-input"
            inputStyle="form-input"
          />
          <InputComponent
            label="Cuvinte cheie"
            name="keyWords"
            required
            containerStyle="container-input"
            inputStyle="form-input"
          />
          <InputComponent
            label="Descriere completa"
            name="description"
            required
            containerStyle="container-input"
            inputStyle="form-input"
          />
        </FormProviderComponent>
        <ButtonComponent
          title="Creaza anunt"
          handlePress={handleSubmit(onSubmitData)}
          style="container-button"
        />
      </div>
    </div>
  );
};

export default CreatePostForm;
