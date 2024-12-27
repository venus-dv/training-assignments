import './App.css';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import SignupContainer from "./containers/SignupContainer";
import LandingPageContainer from "./containers/LandingPageContainer";
import HomepageContainer from "./containers/HomepageContainer";
import LoginPage from "./containers/LoginPage";
import SessionManager from "./components/SessionManager";
import LoginForm from "./components/LoginForm";
import ProfileContainer from "./containers/ProfileContainer";

const App = () => {
    return (
        <Router>
            <Routes>
                <Route path="/" element={<LandingPageContainer/>} />
                <Route path="/home" element={<HomepageContainer />} />
                <Route path="/login" element={<LoginPage/>} />
                <Route path="/signup" element={<SignupContainer/>} />
                <Route path="/profile" element={<ProfileContainer/>} />
                <Route path="/session" element={<SessionManager/>} />


            </Routes>
        </Router>
    );
};

export default App;
