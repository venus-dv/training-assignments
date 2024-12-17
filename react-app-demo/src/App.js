import './App.css';
import Hello from "./Hello";
import AxiosGetDemo from './components/axiosdemo/AxiosGetDemo';
import Navbar from './Navbar';
import ToDoList from './components/todolist/ToDoList';
import StateDemoComponent from './components/stateandevent/StateDemoComponent';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';

function App() {
  
  return (
    <Router>
      <div className='app'>
        <Navbar/>
      </div>
      <Routes>
        <Route exact path='/hello' element={<Hello/>}/>
        <Route path='/sdc' element={<StateDemoComponent/>}/>
        <Route path='/getposts' element={<AxiosGetDemo/>}/>
        <Route path='/todolist' element={<ToDoList/>}/>

      </Routes>
    </Router>
  );
}

export default App;
