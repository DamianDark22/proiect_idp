import classNames from 'classnames';
import React, { useCallback } from 'react';
import { useNavigate } from 'react-router-dom';
import ButtonComponent from '../Button/Button.component';
import { useAuth0 } from '@auth0/auth0-react';

const MenuItemComponent = (props) => {
  const { item } = props;

  const navigate = useNavigate();
  const { logout } = useAuth0();
  const menuItemButtonStyle = classNames('menu-item-button', {
    'menu-item-button-logout': item.id === 'logout'
  });

  const onPressItem = useCallback(() => {
    if (item.id == 'logout') {
      logout();
    } else {
      navigate(item.link);
    }
  }, [item, navigate]);

  return (
    <div className="menu-item">
      <ButtonComponent title={item.title} style={menuItemButtonStyle} handlePress={onPressItem} />
    </div>
  );
};

export default MenuItemComponent;
