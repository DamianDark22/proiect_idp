import React from 'react';
import { HashRouter, Routes, Route, Navigate } from 'react-router-dom';
import AccountView from './modules/Account/Account.view';
import CreatePostView from './modules/CreatePost/CreatePost.view';
import CreateRequestView from './modules/CreateRequest/CreateRequest.view';
import PostsView from './modules/Posts/Posts.view';

const App = () => {
  const content = (
    <Routes>
      <Route path="/" element={<Navigate to={'/account'} />} />
      <Route path="/account" element={<AccountView />} />
      <Route path="/posts" element={<PostsView />} />
      <Route path="/create-post" element={<CreatePostView />} />
      <Route path="/create-request" element={<CreateRequestView />} />
    </Routes>
  );

  return <HashRouter>{content}</HashRouter>;
};

export default App;
