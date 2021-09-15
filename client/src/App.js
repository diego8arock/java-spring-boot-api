import logo from "./logo.svg";
import "./App.css";
import NavbarComponent from "./components/Navbar";
import React, { Fragment, useEffect } from "react";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import UsersComponent from "./components/Users";

function App() {
  return (
    <Router>
      <Fragment>
        <NavbarComponent />
        <section className="container">
          <Switch>
            <Route exact path="/users" component={UsersComponent} />
            <Route exact path="/items" component={UsersComponent} />
            <Route exact path="/favorites" component={UsersComponent} />
            <Route exact path="/coupons" component={UsersComponent} />
          </Switch>
        </section>
      </Fragment>
    </Router>
  );
}

export default App;
