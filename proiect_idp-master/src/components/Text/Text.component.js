import React from 'react';
import classNames from 'classnames';
import './styles.css';

const TextComponent = (props) => {
  const { children, styleName } = props;

  const textStyle = classNames('text', styleName);

  return <p className={textStyle}>{children}</p>;
};

export default TextComponent;
