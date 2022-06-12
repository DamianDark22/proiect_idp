import React, { useMemo } from 'react';
import MenuItemComponent from './MenuItem.component';
import ProfileComponent from './Profile.component';

import logo from '../../assets/images/logo.png';

import './styles.css';

const menuButtons = [
  { id: 'posts', title: 'Postari', link: '/posts' },
  { id: 'create-post', title: 'Creare anunt', link: '/create-post' },
  { id: 'create-request', title: 'Creare cerere', link: '/create-request' },
  { id: 'logout', title: 'Iesire din cont', link: '/account' }
];

const MenuComponent = () => {
  const menuItems = useMemo(() => {
    return menuButtons.map((button) => {
      return <MenuItemComponent key={button.id} item={button} />;
    });
  }, [menuButtons]);

  return (
    <div className="menu">
      <div className="logo">
        <img src={logo} />
      </div>
      <ProfileComponent />
      {menuItems}
    </div>
  );
};

export default MenuComponent;
