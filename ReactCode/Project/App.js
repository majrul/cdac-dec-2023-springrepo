import './App.css';
import Login from './components/Login';
import { Route } from 'react-router-dom'
import Header from './components/Header';
import Footer from './components/Footer';
import Navbar from './components/Navbar';
import Dashboard from './components/Dashboard';
import Home from './components/Home';
import Register from './components/Register';
import Confirmation from './components/Confirmation';
import Profile from './components/Profile';
import EditProfile from './components/EditProfile';

function App() {
  return (
    <div>
      <Header />
      <Navbar />
      <div className="container">
        <Route exact path="/"><Home /></Route>
        <Route path="/login"><Login /></Route>
        <Route path="/register"><Register /></Route>
        <Route path="/dashboard"><Dashboard /></Route>
        <Route path="/confirmation"><Confirmation /></Route>
        <Route path="/profile/:id"><Profile /></Route>
        <Route path="/editprofile/:id"><EditProfile /></Route>
      </div>
      <Footer />
    </div>
  );
}

export default App;
