import React, { useEffect } from 'react'
import { Card } from 'react-bootstrap'
import Table from 'react-bootstrap/Table'
import { retrieveUserApi } from '../../api/UserApiService'
import { useState } from 'react'
import editimg from "../img/edit.png"
import EditCard from '../editCards/EditCard'

const Profile = () => {

    const [user,setUser] = useState([])
    const [showModal,setShowModal] = useState(false)

    const getUser = ()=>{
        retrieveUserApi(localStorage.getItem("id"))
        .then((response)=>{setUser(response.data.data)})
    }

    const toggleModal = () => {
        setShowModal((show) => !show);
      };

    useEffect(() => {
        getUser();
      }, [showModal]);

    

  return (
    <div>
        <div style={{ columnCount: "6", marginTop: "40px", marginLeft: "50px" }}>
    <h6>Name</h6>
    <h6>Surname</h6>
    <h6>Phone Number</h6>
    <h6>E-mail</h6>
    <h6>Tax ID Number</h6>
    <h6>Actions</h6>
  </div>

          <Card style={{ border: "0", width: "1720px" ,marginLeft:"40px"}}>
            <Table className="usersTable" style={{marginTop:"10px"}} >
              <td style={{ border: "0", width: "326px",marginLeft:"30px" }}>
                {user.firstName}
              </td>
              <td style={{ border: "0", width: "310px" }}>
                {user.surname}
              </td>
              <td style={{ border: "0", width: "286px" }}>
                <div style={{ marginLeft: "50px" }}>{user.phoneNumber}</div>
              </td>
              <td style={{ border: "0", width: "286px" }}>{user.email}</td>
              <td style={{ border: "0", width: "288px" }}>
                <div style={{ marginLeft: "115px"}}>{user.tin}</div>
              </td>
              <td style={{ border: "0", width: "286px" }}>
                <button
                  style={{
                    marginLeft: "120px",
                    marginRight: "10px",
                    border: "0",
                    background: "white",
                  }}
                  onClick={toggleModal}
                >
                  <img src={editimg} alt="edit" />
                </button>
              </td>
              </Table>
              </Card>
              <EditCard showModal={showModal} toggleModal={toggleModal}/>
        </div>
  );
};
export default Profile
