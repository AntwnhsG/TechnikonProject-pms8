import "./ListOfUsers.css";
import down from "../img/down.png";
import sort from "../img/sort.png";
import filter from "../img/filter.png";
import plus from "../img/+.png";
import downloadimg from "../img/download.png";
import { useState } from "react";
import { useEffect } from "react";
import { Card, Table } from "react-bootstrap";
import {deleteUserApi,retrieveAllUsersApi,retrieveUserApi} from "../../api/UserApiService";
import deleteimg from "../img/delete.png";
import editimg from "../img/edit.png";
import { retrievePropertyApi } from "../../api/PropertyApiService";
import EditUser from "../admin/EditUser"

const ListOfUsers = () => {
  const [users, setUsers] = useState([]);
  const [userToDelete,setUserToDelete]= useState([]);
  const[showModalEdit,setShowModalEdit]=useState(false);
  const [userId,setUserid]=useState(localStorage.getItem("id"))
  const [loading,setLoading]=useState(false)

  const getUsers = () => {
    retrieveAllUsersApi().then((response) => {
      setUsers(response.data.data);
    });
  };

  const setId=(id)=>{
    setUserid(id)
    toggleModalEdit()
  }

  const toggleModalEdit = () => {

    setShowModalEdit((show) => !show);
    
  };

  const deactivateUser = (id) => {
      setLoading(true)
      deleteUserApi(id);
      setLoading(false)
  };

  useEffect(() => {
    getUsers();
  }, [setLoading]);

  return (
    <div>
      <div>
        <h5 style={{ color: "#0F46CE" }}>
          <b>List of users</b>
        </h5>
      </div>
      <div>
        <div style={{ columnCount: "1", marginTop: "20px" }}>
          <img src={down} alt="down" className="down" />
          <b className="all">ALL</b>
          <b className="filter">
            Filter:
            <img className="filterimg" src={filter} alt="filter"/>
          </b>
          <b className="az">
            <img className="azimg" src={down} />
            A-Z
          </b>
          <b className="sort">
            SORT:
            <img className="sortimg" src={sort} />
          </b>
        </div>
      </div>
      <div style={{ columnCount: "6", marginTop: "40px", marginLeft: "50px" }}>
        <h6>Name</h6>
        <h6>Surname</h6>
        <h6>Phone Number</h6>
        <h6>E-mail</h6>
        <h6>Tax ID Number</h6>
        <h6>Actions</h6>
      </div>
      <EditUser showModal={showModalEdit} toggleModal={toggleModalEdit} id={userId}/>
      <Table style={{ marginLeft: "45px" }}>
        {users.map((user) => {
          return (
            <div>
            
            <Table key={user.id}>
            
              <Card style={{ border: "0", width: "1720px" }}>
                <Table className="usersTable">
                  <td style={{ border: "0", width: "326px" }}>
                    {user.firstName}
                  </td>
                  <td style={{ border: "0", width: "310px" }}>
                    {user.surname}
                  </td>
                  <td style={{ border: "0", width: "286px" }}>
                    <div style={{ marginLeft: "10px" }}>{user.phoneNumber}</div>
                  </td>
                  <td style={{ border: "0", width: "286px" }}>{user.email}</td>
                  <td style={{ border: "0", width: "288px" }}>
                    <div style={{ marginLeft: "50px" }}>{user.tin}</div>
                  </td>
                  <td style={{ border: "0", width: "286px" }}>
                    <button
                    onClick={()=>setId(user.id)}
                      style={{
                        marginLeft: "50px",
                        marginRight: "10px",
                        border: "0",
                        background: "white",
                      }}
                    >
                      <img src={editimg} alt="edit" />
                    </button>
                    <button
                      onClick={() => deactivateUser(user.id)}
                      style={{
                        marginRight: "20px",
                        background: "white",
                        border: "0",
                      }}
                    >
                      <img
                        src={deleteimg}
                        alt="edit"
                        style={{ borderImage: "0" }}
                      />
                    </button>
                  </td>
                </Table>
              </Card>
            </Table>
            </div>
          );
        })}
      </Table>
      
    </div>
  );
};

export default ListOfUsers;
