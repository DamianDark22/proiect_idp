import classNames from 'classnames';
import React from 'react';
import { useController } from 'react-hook-form';
import TextComponent from '../Text/Text.component';
import CheckboxInputComponent from './CheckboxInput.component';

import './styles.css';

const InputComponent = (props) => {
  const {
    name,
    label,
    type,
    placeholder,
    required = false,
    value: defaultValue,
    isPhone = false,
    containerStyle,
    inputStyle
  } = props;

  const { field, fieldState } = useController({
    name,
    rules: { required: required },
    defaultValue: defaultValue
  });
  const { onChange, value, ref } = field;
  const { error } = fieldState;

  const errorMessage =
    error?.type === 'required' ? (
      <TextComponent styleName="input-error">{'*'}Acest camp este obligatoriu.</TextComponent>
    ) : undefined;

  const inputContainerStyle = classNames('input-container', containerStyle);
  const styleInput = classNames('input', inputStyle);

  return type === 'checkbox' ? (
    <CheckboxInputComponent label={label}>
      <input
        name={name}
        onChange={onChange}
        placeholder={placeholder}
        value={value}
        type={type}
        ref={ref}
        maxLength={isPhone ? 10 : undefined}
      />
    </CheckboxInputComponent>
  ) : (
    <div className={inputContainerStyle}>
      <div className="input-label">
        <TextComponent>{label}</TextComponent>
        {required && <TextComponent styleName="input-required">*</TextComponent>}
      </div>
      <input
        className={styleInput}
        name={name}
        onChange={onChange}
        placeholder={placeholder}
        value={value}
        type={type}
        ref={ref}
        maxLength={isPhone ? 10 : undefined}
      />
      {errorMessage}
    </div>
  );
};

export default InputComponent;
