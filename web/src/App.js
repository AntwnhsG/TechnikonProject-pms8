//import { Routes, Route } from "react-router-dom";
//import Layout from "./components/layout/Layout";
//import Login from "./components/login/Login";
//import ListOfUsers from "./components/listOfUsers/ListOfUsers";
//import PropertyCard from "./components/property/PropertyCard";
//import Reports from "./components/admin/Reports";
//import Home from "./components/home/Home";
//
//import Profile from "./components/tabMenuComponents/Profile";
//
//
//const App = () => {
//  return (
//    <div className="App">
//      <Routes>
//        <Route index element={<Login />} />
//        <Route path="/" element={<Layout />}>
//          <Route path="home" element={<Home />}></Route>
//          <Route path="properties" element={<PropertyCard />} />
//          <Route path="listofusers" element={<ListOfUsers />} />
//          <Route path="reports" element={<Reports />} />
//          <Route path="profile" element={<Profile />} />
//        </Route>
//      </Routes>
//    </div>
//  );
//};
//
//export default App;

//import React, { useEffect, useState } from 'react';
//import { Routes, Route, Navigate } from 'react-router-dom';
//import Layout from './components/layout/Layout';
//import Login from './components/login/Login';
//import ListOfUsers from './components/listOfUsers/ListOfUsers';
//import PropertyCard from './components/property/PropertyCard';
//import Reports from './components/admin/Reports';
//import Home from './components/home/Home';
//import Profile from './components/tabMenuComponents/Profile';
//import keycloak from './components/login/keycloak';
//
//const AuthenticatedApp = () => (
//  <Layout>
//    <Routes>
//      <Route path="home" element={<Home />} />
//      <Route path="properties" element={<PropertyCard />} />
//      <Route path="listofusers" element={<ListOfUsers />} />
//      <Route path="reports" element={<Reports />} />
//      <Route path="profile" element={<Profile />} />
//    </Routes>
//  </Layout>
//);
//
//const UnauthenticatedApp = () => <Login />;
//
//const App = () => {
//  const [isAuthenticated, setIsAuthenticated] = useState(false);
//
//  useEffect(() => {
//    const initializeKeycloak = async () => {
//      try {
//        const authenticated = await keycloak.init({ onLoad: 'login-required' });
//        setIsAuthenticated(authenticated);
//      } catch (error) {
//        console.error('Keycloak initialization failed', error);
//      }
//    };
//
//    initializeKeycloak();
//  }, []);
//
//  return (
//    <div className="App">
//      {isAuthenticated ? <AuthenticatedApp /> : <UnauthenticatedApp />}
//    </div>
//  );
//};
//
//export default App;

//import React, { useEffect, useState } from 'react';
//import { Routes, Route } from 'react-router-dom';
//import Layout from './components/layout/Layout';
//import ListOfUsers from './components/listOfUsers/ListOfUsers';
//import PropertyCard from './components/property/PropertyCard';
//import Reports from './components/admin/Reports';
//import Home from './components/home/Home';
//import Profile from './components/tabMenuComponents/Profile';
//import keycloak from './components/login/keycloak';
//
//const AuthenticatedApp = () => (
//  <Layout>
//    <Routes>
//      <Route path="home" element={<Home />} />
//      <Route path="properties" element={<PropertyCard />} />
//      <Route path="listofusers" element={<ListOfUsers />} />
//      <Route path="reports" element={<Reports />} />
//      <Route path="profile" element={<Profile />} />
//    </Routes>
//  </Layout>
//);
//
//const App = () => {
//  const [isAuthenticated, setIsAuthenticated] = useState(false);
//
//  useEffect(() => {
//    const initializeKeycloak = async () => {
//      try {
//        const authenticated = await keycloak.init({ onLoad: 'login-required' });
//        setIsAuthenticated(authenticated);
//      } catch (error) {
//        console.error('Keycloak initialization failed', error);
//      }
//    };
//
//    initializeKeycloak();
//  }, []);
//
//  return (
//    <div className="App">
//      {isAuthenticated ? <AuthenticatedApp /> : <div>Loading...</div>}
//    </div>
//  );
//};
//
//export default App;

import React, { useEffect, useState } from 'react';
import { Routes, Route } from 'react-router-dom';
import Layout from './components/layout/Layout';
import ListOfUsers from './components/listOfUsers/ListOfUsers';
import PropertyCard from './components/property/PropertyCard';
import Reports from './components/admin/Reports';
import Home from './components/home/Home';
import Profile from './components/tabMenuComponents/Profile';
import keycloak from './components/login/keycloak';

const AuthenticatedApp = () => (
    <div className="App">
      <Routes>
        <Route index element={<Login />} />
        <Route path="/" element={<Layout />}>
          <Route path="home" element={<Home />}></Route>
          <Route path="properties" element={<PropertyCard />} />
          <Route path="listofusers" element={<ListOfUsers />} />
          <Route path="reports" element={<Reports />} />
          <Route path="profile" element={<Profile />} />
        </Route>
      </Routes>
    </div>
);

const App = () => {
  const [isAuthenticated, setIsAuthenticated] = useState(false);
  const [keycloakInitialized, setKeycloakInitialized] = useState(false);

  useEffect(() => {
    const initializeKeycloak = async () => {
      try {
        const authenticated = await keycloak.init({ onLoad: 'login-required' });
        console.log('Keycloak initialized:', authenticated);
        setIsAuthenticated(authenticated);
      } catch (error) {
        console.error('Keycloak initialization failed:', error);
      } finally {
        setKeycloakInitialized(true);
      }
    };

    initializeKeycloak();
  }, []);

  if (!keycloakInitialized) {
    return <div>Loading...</div>;
  }

  return (
    <div className="App">
      {isAuthenticated ? <AuthenticatedApp /> : <div>Loading...</div>}
    </div>
  );
};

export default App;



