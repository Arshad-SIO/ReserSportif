import { Link } from "react-router-dom";

function Navbar() {
  return (
    <nav className="navbar">
      <div className="logo">ReserSportif</div>

      <div className="nav-links">
        <Link to="/">Accueil</Link>
        <Link to="/reservations">Mes réservations</Link>
        <Link to="/connexion">Connexion</Link>
        <Link to="/inscription">Inscription</Link>
      </div>
    </nav>
  );
}

export default Navbar;