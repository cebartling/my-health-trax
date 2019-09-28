import React from "react";
import {BrowserRouter, Route, Switch} from "react-router-dom";
import NavBar from "./components/NavBar";
import UserProfile from "./components/UserProfile";
import PrivateRoute from "./components/PrivateRoute";

function App() {
    return (
        <div className="App">
            {/* New - use BrowserRouter to provide access to /profile */}
            <BrowserRouter>
                <header>
                    <NavBar />
                </header>
                <Switch>
                    <Route path="/" exact />
                    <PrivateRoute path="/profile" component={UserProfile} />
                </Switch>
            </BrowserRouter>
        </div>
    );
}

export default App;
