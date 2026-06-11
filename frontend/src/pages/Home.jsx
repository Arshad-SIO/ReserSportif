import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import api from "../services/api";

function Home() {
  const [terrains, setTerrains] = useState([]);
  const [search, setSearch] = useState("");

  useEffect(() => {
    api.get("/terrains")
      .then(response => {
        setTerrains(response.data);
      })
      .catch(error => {
        console.error(error);
      });
  }, []);

  const terrainsFiltres = terrains.filter(terrain =>
    terrain.adresse.toLowerCase().includes(search.toLowerCase())
  );

  return (
    <main>
      <section className="hero">
        <h1>Réservez facilement vos terrains sportifs</h1>
        <p>Football, tennis, basketball : trouvez un terrain disponible en quelques clics.</p>
      </section>

      <section className="search-box">
        <input
          type="text"
          placeholder="Rechercher un terrain..."
          value={search}
          onChange={(e) => setSearch(e.target.value)}
        />
      </section>

      <section className="terrains-section">
        <h2>Terrains disponibles</h2>

        <div className="terrain-grid">
          {terrainsFiltres.map(terrain => (
            <div className="terrain-card" key={terrain.idTerrain}>
              <div className="terrain-image"></div>

              <h3>{terrain.adresse}</h3>
              <p>Horaire : {terrain.horaire}</p>
              <p>Disponibilité : {terrain.disponible ? "Disponible" : "Indisponible"}</p>
              <p>Tarif : {terrain.tarif} € / heure</p>

              <Link to={`/terrain/${terrain.idTerrain}`}>
                <button className="btn">Réserver</button>
              </Link>
            </div>
          ))}
        </div>
      </section>
    </main>
  );
}

export default Home;