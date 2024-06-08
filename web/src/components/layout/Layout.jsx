import { Outlet } from "react-router-dom";
import "./Layout.css";
import TabMenu from "../listOfUsers/user/TabMenu";
import TabMenuAdmin from "../admin/TabMenuAdmin";
import Navbar from "../listOfUsers/user/navbar";
import NavBarAdmin from "../admin/navbarAdmin"
import { useNavigate } from "react-router-dom";
import { useEffect } from "react";

const Layout = (props) => {
  const navigate = useNavigate();
  const { keycloak } = props;
  const role = null;

  if (keycloak.authenticated) {
    const token = keycloak.token;

  // Decode the token to extract user information
    const decodedToken = keycloak.tokenParsed;

  // Extract user roles from the decoded token
    const resourceAccess = decodedToken.resource_access;

  // Assuming you have a specific client ID for your application
    const role = resourceAccess['front-end-app'].roles[0];
  console.log('User Role:', role);
}

  //const role = localStorage.getItem("role");
  //console.log(role);

  useEffect(() => {
    if (role) {
      navigate("/");
    }
  }, []);

  console.log(localStorage.getItem("tin"));
  //if (localStorage.getItem("tin") != null) {
    if (role === "user") {
      return (
        <div className="Layout">
          <Navbar />
          <TabMenu />
          <main>
          
            <Outlet />
          </main>
        </div>
      );
    }else{
      return (
        <div className="Layout">
          <NavBarAdmin />
          <TabMenuAdmin />
          <main>
            <Outlet />
          </main>
        </div>
      );
    }
  //}
};

export default Layout;
