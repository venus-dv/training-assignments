import './App.css';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import SignupContainer from "./containers/SignupContainer";

const App = () => {
    return (
        <Router>
            <Routes>
                <Route path="/" element={<SignupContainer/>} />

            </Routes>
        </Router>
    );
};

export default App;
