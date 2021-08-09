import "./App.css";
import {
  BrowserRouter as Router,
  Switch,
  Route
} from "react-router-dom";
import Subjects from "./pages/Subjects";
import Navbar from "./components/Navbar/Navbar";
import AddTask from "./pages/AddTask/AddTask";
import AddSubject from "./pages/AddSubject/AddSubject";
import Error from "./pages/Error";


function App() {
  return (
    <div className="App">
      <Router>
          <Navbar/>
          <Switch>
            <Route path="/addTask">
              <AddTask/>
            </Route>
            <Route path="/addSubject">
              <AddSubject/>
            </Route>
            <Route exact path="/error">
              <Error/>
            </Route>
            <Route path="/">
              <Subjects/>
            </Route>
          </Switch>

      </Router>
    </div>
  );
}

export default App;
