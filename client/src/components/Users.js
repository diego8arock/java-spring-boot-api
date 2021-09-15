import React from "react";
import { Fragment } from "react";
import { Button, Col, Container, Row } from "reactstrap";
import axios from "axios";

export default class UsersComponent extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      emailValue: "",
    };
    this.addUser = this.addUser.bind(this);
  }

  updateEmailValue(evt) {
    this.setState({
      emailValue: evt.target.value,
    });
  }

  async addUser() {
    const user = { email: this.state.emailValue };
    const res = await axios.post(
      "https://do-mercadolibre-api.herokuapp.com/user",
      user
    );
    console.log(res);
  }

  render() {
    return (
      <Fragment>
        <Container>
          <Row>
            <Col>Agregar usuario</Col>
          </Row>
          <Row>
            <Col xs="3">
              <input
                id="email"
                type="email"
                placeholder="Ingresar correo"
                onChange={(evt) => this.updateEmailValue(evt)}
              ></input>
            </Col>
            <Col xs="3">
              <Button color="primary" onClick={this.addUser}>
                Agregar
              </Button>
            </Col>
          </Row>
        </Container>
        <Container>
          <Row>
            <Col>Usuarios</Col>
          </Row>
        </Container>
      </Fragment>
    );
  }
}
