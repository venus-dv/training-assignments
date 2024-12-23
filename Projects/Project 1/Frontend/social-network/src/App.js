import './App.css';
import {AppBar} from "@mui/material";
import {Component} from "react";

class App extends Component {
    render() {
        return (
            <div>
                <AppBar color="primary" position="static">
                    <h1>ChitChat</h1>

                </AppBar>
            </div>
        )
    }
}

export default App;
