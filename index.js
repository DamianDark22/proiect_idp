import React from 'react';
import ReactDOM from 'react-dom/client';
import { ChakraProvider } from '@chakra-ui/react';
import App from './App';
import { Auth0Provider } from '@auth0/auth0-react';
const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <ChakraProvider>
      <Auth0Provider
        domain="donation-adver.eu.auth0.com"
        clientId="vkP6Ml2SFM2Y3dgmM5VgSmdNAsDQQ8Ez"
        redirectUri={window.location.origin}
        cacheLocation="localstorage"
        useRefreshTokens={true}>
        <App />
      </Auth0Provider>
    </ChakraProvider>
  </React.StrictMode>
);
