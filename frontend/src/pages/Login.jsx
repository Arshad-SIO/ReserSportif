import { useState } from "react";
import { useNavigate } from "react-router-dom";
import api from "../services/api";

function Login() {
  const navigate = useNavigate();

  const [form, setForm] = useState({
    email: "",
    password: ""
  });

  const [message, setMessage] = useState("");

  const handleChange = (e) => {
    setForm({
      ...form,
      [e.target.name]: e.target.value
    });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const response = await api.post("/auth/login", form);

      localStorage.setItem("token", response.data.token);

      setMessage("Connexion réussie.");

      setTimeout(() => {
        navigate("/");
      }, 1000);

    } catch (error) {
      setMessage("Email ou mot de passe incorrect.");
      console.error(error);
    }
  };

  return (
    <main className="auth-page">
      <form className="auth-form" onSubmit={handleSubmit}>
        <h1>Connexion</h1>

        <input
          type="email"
          name="email"
          placeholder="Adresse email"
          value={form.email}
          onChange={handleChange}
          required
        />

        <input
          type="password"
          name="password"
          placeholder="Mot de passe"
          value={form.password}
          onChange={handleChange}
          required
        />

        <button className="btn" type="submit">Se connecter</button>

        {message && <p>{message}</p>}
        <p>Pas un compte ? Creez vous un nouveau compte<a href="/connexion">Se connecter</a></p>
      </form>
    </main>
  );
}

export default Login;