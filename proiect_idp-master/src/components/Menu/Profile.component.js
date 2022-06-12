import React from 'react';
import TextComponent from '../Text/Text.component';

const ProfileComponent = () => {
  return (
    <div className="profile">
      <div className="profile-picture"></div>
      <TextComponent styleName="profile-name">Nume Prenume</TextComponent>
    </div>
  );
};

export default ProfileComponent;
