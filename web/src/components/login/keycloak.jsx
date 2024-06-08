// import Keycloak from 'keycloak-js';
//
// const keycloak = new Keycloak({
//   url: 'http://127.0.0.1:8180/admin',
//   realm: 'master-realm',
//   clientId: 'my-frontend-app'
// });
//
// keycloak.init({ onLoad: 'login-required' }).then(authenticated => {
//   if (!authenticated) {
//     window.location.reload();
//   } else {
//     console.info("Authenticated");
//   }
// }).catch(console.error);
//
// export default keycloak;

// keycloak.js
// import Keycloak from 'keycloak-js';
//
// const keycloak = new Keycloak({
//   url: 'http://127.0.0.1:8180/', // Update this URL to your Keycloak instance
//   realm: 'master', // Update with your realm
//   clientId: 'front-end-app' // Update with your client ID
// });
//
// export default keycloak;

import Keycloak from 'keycloak-js';

const keycloak = new Keycloak({
  url: 'http://127.0.0.1:8180/', // Update this URL to your Keycloak instance
  realm: 'master', // Update with your realm
  clientId: 'front-end-app', // Update with your client ID
  // Add clientSecret if your client is configured as confidential
  // clientSecret: 'your-client-secret',
  // Add additional initialization options as needed
  // onLoad: 'login-required',
  // checkLoginIframe: false,
  // promiseType: 'native',
});

export default keycloak;

