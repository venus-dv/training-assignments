import './App.css';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import SignupContainer from "./containers/SignupContainer";
import LandingPageContainer from "./containers/LandingPageContainer";
import LoginContainer from "./containers/LoginContainer";

const App = () => {
    return (
        <Router>
            <Routes>
                <Route path="/" element={<LandingPageContainer/>} />
                <Route path="/login" element={<LoginContainer/>} />
                <Route path="/signup" element={<SignupContainer/>} />

            </Routes>
        </Router>
    );
};

export default App;
