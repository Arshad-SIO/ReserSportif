import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import api from "../services/api";

function TerrainDetail() {
  const { id } = useParams();
  const [terrain, setTerrain] = useState(null);

  useEffect(() => {
    api.get(`/terrains/${id}`)
      .then(response => {
        setTerrain(response.data);
      })
      .catch(error => {
        console.error(error);
      });
  }, [id]);

  if (!terrain) {
    return <p style={{ padding: "40px" }}>Chargement du terrain...</p>;
  }

  return (
    <main className="detail-page">
      <section className="detail-card">
        <div className="detail-image"></div>

        <div className="detail-info">
          <h1>{terrain.adresse}</h1>

          <p><strong>Horaire :</strong> {terrain.horaire}</p>
          <p>
            <strong>Disponibilité :</strong>{" "}
            {terrain.disponible ? "Disponible" : "Indisponible"}
          </p>
          <p><strong>Tarif :</strong> {terrain.tarif} € / heure</p>

          <button className="btn">Réserver ce terrain</button>
        </div>
      </section>
    </main>
  );
}

export default TerrainDetail;